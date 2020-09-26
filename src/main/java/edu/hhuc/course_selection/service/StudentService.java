package edu.hhuc.course_selection.service;
import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Student;
import edu.hhuc.course_selection.exception.student_exception.CourseInsufficientException;
import edu.hhuc.course_selection.repository.CourseRepository;
import edu.hhuc.course_selection.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentService{
    @Resource
    StudentRepository studentRepository;
    
    @Resource
    CourseRepository courseRepository;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public Student getStudentById(String studentId){
        return studentRepository.findStudentById(studentId);
    }
    
    public List<Course> getCoursesByStudentId(String studentId){
        return studentRepository.findStudentById(studentId).getCourses();
    }
    
    @Transactional
    public void select(String studentId, String courseId){
        Course course = courseRepository.findCourseById(courseId);
        if(course.getRemaining() == 0){
            throw new CourseInsufficientException("课程数量不足，等待其他同学退课再选吧！");
        }
        Student student = studentRepository.findStudentById(studentId);
        student.getCourses().add(course);
        course.setRemaining(course.getRemaining()-1);
        courseRepository.saveAndFlush(course);
        studentRepository.save(student);
        
        log.info("学生 "+studentId+" 选课 "+courseId+" 成功！");
    }
    
    @Transactional
    public void delete(String studentId, String courseId){
        Student student = studentRepository.findStudentById(studentId);
        Course  course  = courseRepository.findCourseById(courseId);
        student.getCourses().remove(course);
        course.setRemaining(course.getRemaining()+1);
        studentRepository.save(student);
    }
}
