package edu.hhuc.course_selection.config;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException{
        for(GrantedAuthority authority : authentication.getAuthorities()){
            switch(authority.getAuthority()){
                case "ROLE_STUDENT" -> {
                    response.sendRedirect("/student/"+authentication.getName());
                    return;
                }
                case "ROLE_TEACHER" -> {
                    response.sendRedirect("/teacher/"+authentication.getName());
                    return;
                }
                case "ROLE_ADMIN" -> {
                    response.sendRedirect("/admin/"+authentication.getName());
                    return;
                }
                default -> response.sendRedirect("/");
            }
        }
    }
}
