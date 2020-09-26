package edu.hhuc.course_selection.repository;

import edu.hhuc.course_selection.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface CourseRepository extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Course findCourseById(String id);
}