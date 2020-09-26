package edu.hhuc.course_selection.controller;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GlobalController{
    @GetMapping(value = "/teacher/")
    public String init(Authentication authentication){
        return authentication.getName();
    }
}
