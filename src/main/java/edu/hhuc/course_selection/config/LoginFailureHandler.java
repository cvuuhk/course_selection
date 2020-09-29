package edu.hhuc.course_selection.config;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    if (e instanceof LockedException) {
      writer.write("账户被锁定，请联系管理员!");
    } else if (e instanceof CredentialsExpiredException) {
      writer.write("密码过期，请联系管理员!");
    } else if (e instanceof AccountExpiredException) {
      writer.write("账户过期，请联系管理员!");
    } else if (e instanceof DisabledException) {
      writer.write("账户被禁用，请联系管理员!");
    } else if (e instanceof BadCredentialsException) {
      writer.write("账户或密码错误");
    } else {
      writer.write("登录失败");
    }
    writer.flush();
    writer.close();
  }
}
