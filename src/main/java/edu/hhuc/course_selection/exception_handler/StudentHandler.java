package edu.hhuc.course_selection.exception_handler;
import edu.hhuc.course_selection.exception.student_exception.CourseInsufficientException;
import edu.hhuc.course_selection.exception.student_exception.CourseNotSelectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
@ResponseBody
public class StudentHandler{
    @ExceptionHandler(value = CourseInsufficientException.class)
    public String courseInsufficient(CourseInsufficientException e){
        return "选课失败："+e.getMessage();
    }
    @ExceptionHandler(value = CourseNotSelectionException.class)
    public String courseNotSelection(CourseNotSelectionException e){
        return "退课失败："+e.getMessage();
    }
}
