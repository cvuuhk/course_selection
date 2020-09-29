package edu.hhuc.course_selection.dao;

import edu.hhuc.course_selection.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface CourseRepository
    extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course> {
  Course findCourseById(String courseId);

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("select course from Course course where course.id=?1")
  Course findCourseByIdWithLock(String courseId);
}
