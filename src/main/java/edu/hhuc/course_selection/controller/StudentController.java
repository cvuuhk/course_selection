package edu.hhuc.course_selection.controller;
import edu.hhuc.course_selection.entity.Course;
import edu.hhuc.course_selection.entity.Student;
import edu.hhuc.course_selection.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping(value = "/student")
public class StudentController{
    @Resource
    StudentService service;
    
    @GetMapping(value = "/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        return service.getStudentById(studentId);
    }
    
    @GetMapping(value = "/courses")
    public List<Course> view(){
        String studentId = "1762810233";
        return service.getCoursesByStudentId(studentId);
    }
    
    @PostMapping(value = "/select")
    public String select(@RequestBody List<String> courseIds){
        String studentId = "1762810233";
        for(String courseId : courseIds){
            service.select(studentId, courseId);
        }
        return "选课成功！";
    }
    
    @PostMapping(value = "/delete")
    public String delete(@RequestBody List<String> courseIds){
        String studentId = "1762810233";
        for(String courseId : courseIds){
            service.delete(studentId, courseId);
        }
        return "退课成功！";
    }
}