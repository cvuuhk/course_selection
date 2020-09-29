package edu.hhuc.course_selection.exception.student_exception;
// 课程数量不足
public class CourseInsufficientException extends RuntimeException {
  public CourseInsufficientException() {}

  public CourseInsufficientException(String message) {
    super(message);
  }

  public CourseInsufficientException(String message, Throwable cause) {
    super(message, cause);
  }

  public CourseInsufficientException(Throwable cause) {
    super(cause);
  }

  public CourseInsufficientException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
