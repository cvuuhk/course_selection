package edu.hhuc.course_selection.repository;
import edu.hhuc.course_selection.entity.login.StudentLogin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentLoginRepository extends JpaRepository<StudentLogin, String>{
    StudentLogin findStudentLoginByUsername(String username);
}
