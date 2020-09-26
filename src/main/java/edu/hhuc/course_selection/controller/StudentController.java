package edu.hhuc.course_selection.controller;
import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Student;
import edu.hhuc.course_selection.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping(value = "/student")
public class StudentController{
    @Resource
    StudentService service;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping(value = "/")
    public Student getStudentInfo(Authentication authentication){
        String studentId = authentication.getName();
        return service.getStudentById(studentId);
    }
    
    @GetMapping(value = "/courses")
    public List<Course> view(Authentication authentication){
        String studentId = authentication.getName();
        return service.getCoursesByStudentId(studentId);
    }
    
    @PostMapping(value = "/select")
    public String select(@RequestBody List<String> courseIds, Authentication authentication){
        String studentId = authentication.getName();
        for(String courseId : courseIds){
            service.select(studentId, courseId);
            log.info("学生 "+studentId+" 选课 "+courseId+" 成功！");
        }
        return "选课成功！";
    }
    
    @PostMapping(value = "/delete")
    public String delete(@RequestBody List<String> courseIds, Authentication authentication){
        String studentId = authentication.getName();
        for(String courseId : courseIds){
            service.delete(studentId, courseId);
            log.info("学生 "+studentId+" 退课 "+courseId+" 成功！");
        }
        return "退课成功！";
    }
}