package edu.hhuc.course_selection.service;

import edu.hhuc.course_selection.dao.CourseRepository;
import edu.hhuc.course_selection.dao.SelectionRepository;
import edu.hhuc.course_selection.dao.StudentRepository;
import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Selection;
import edu.hhuc.course_selection.entity.Student;
import edu.hhuc.course_selection.exception.student_exception.CourseInsufficientException;
import edu.hhuc.course_selection.exception.student_exception.CourseNotSelectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class StudentService {
  @Resource StudentRepository studentRepository;
  @Resource CourseRepository courseRepository;
  @Resource SelectionRepository selectionRepository;

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  public Student getStudentById(String studentId) {
    return studentRepository.getOne(studentId);
  }

  public Set<Selection> getSelectionsByStudentId(String studentId) {
    return studentRepository.getOne(studentId).getSelections();
  }

  @Transactional
  public void select(String studentId, String courseId) {
    Course course = courseRepository.findCourseByIdWithLock(courseId);
    if (course.getRemaining() == 0) {
      throw new CourseInsufficientException("课余量不足。");
    }
    Student student = studentRepository.getOne(studentId);
    Selection selection = new Selection(student, course);

    course.setRemaining(course.getRemaining() - 1);

    courseRepository.save(course);
    selectionRepository.save(selection);
  }

  @Transactional
  public void delete(String studentId, String courseId) {
    Student student = studentRepository.getOne(studentId);
    Course course = courseRepository.findCourseByIdWithLock(courseId);
    Selection selection = selectionRepository.findSelectionByStudentAndCourse(student, course);
    if (selection != null) {
      course.setRemaining(course.getRemaining() + 1);

      courseRepository.save(course);
      selectionRepository.delete(selection);
    } else {
      throw new CourseNotSelectionException("你没有选这门课。");
    }
  }
}
