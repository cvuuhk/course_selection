package edu.hhuc.course_selection.service;
import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Student;
import edu.hhuc.course_selection.repository.CourseRepository;
import edu.hhuc.course_selection.repository.StudentRepository;
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
    
    public Student getStudentById(String studentId){
        return studentRepository.findStudentById(studentId);
    }
    
    public List<Course> getCoursesByStudentId(String studentId){
        return studentRepository.findStudentById(studentId).getCourses();
    }
    
    @Transactional
    public void select(String studentId, String courseId){
        Student student = studentRepository.findStudentById(studentId);
        Course  course  = courseRepository.findCourseById(courseId);
        student.getCourses().add(course);
        course.setRemaining(course.getRemaining()-1);
        courseRepository.save(course);
        studentRepository.save(student);
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
