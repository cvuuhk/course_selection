package edu.hhuc.course_selection.dao;

import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Selection;
import edu.hhuc.course_selection.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface SelectionRepository
    extends JpaRepository<Selection, Long>, JpaSpecificationExecutor<Selection> {
  Selection findSelectionByStudentAndCourse(Student student, Course course);

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query(
      "select selection from Selection selection where selection.student=?1 and selection.course=?2")
  Selection findSelectionByStudentAndCourseWithLock(Student student, Course course);
}
