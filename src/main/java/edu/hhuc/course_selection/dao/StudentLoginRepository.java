package edu.hhuc.course_selection.dao;
import edu.hhuc.course_selection.entity.StudentLogin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentLoginRepository extends JpaRepository<StudentLogin, String>{
    StudentLogin findStudentLoginByUsername(String username);
}
