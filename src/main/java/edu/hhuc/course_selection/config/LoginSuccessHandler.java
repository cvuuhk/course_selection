package edu.hhuc.course_selection.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        
        Logger logger = LoggerFactory.getLogger(this.getClass());
        for(GrantedAuthority authority : authentication.getAuthorities()){
            switch(authority.getAuthority()){
                case "ROLE_STUDENT" -> {
                    logger.info("学生 "+authentication.getName()+" 登录成功");
                    response.sendRedirect("/student/");
                    return;
                }
                case "ROLE_TEACHER" -> {
                    response.sendRedirect("/teacher/");
                    return;
                }
                case "ROLE_ADMIN" -> {
                    response.sendRedirect("/admin/");
                    return;
                }
                default -> response.sendRedirect("/");
            }
        }
    }
}
