package edu.hhuc.course_selection.dao;

import edu.hhuc.course_selection.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository
    extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {}
