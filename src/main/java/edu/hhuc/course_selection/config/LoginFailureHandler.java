package edu.hhuc.course_selection.config;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginFailureHandler implements AuthenticationFailureHandler{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if(exception instanceof UsernameNotFoundException){
            writer.write("没有此用户");
        }
        else if(exception instanceof BadCredentialsException){
            writer.write("账户或密码错误");
        }
        else{
            writer.write("登录失败");
        }
        writer.close();
    }
}
