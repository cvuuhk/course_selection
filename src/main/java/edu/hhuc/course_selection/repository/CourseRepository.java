package edu.hhuc.course_selection.repository;

import edu.hhuc.course_selection.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course>{
    Course findCourseById(String id);

}