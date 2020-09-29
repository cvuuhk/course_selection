package edu.hhuc.course_selection.exception.student_exception;

public class CourseNotSelectionException extends RuntimeException {
  public CourseNotSelectionException() {
    super();
  }

  public CourseNotSelectionException(String message) {
    super(message);
  }

  public CourseNotSelectionException(String message, Throwable cause) {
    super(message, cause);
  }

  public CourseNotSelectionException(Throwable cause) {
    super(cause);
  }

  protected CourseNotSelectionException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
