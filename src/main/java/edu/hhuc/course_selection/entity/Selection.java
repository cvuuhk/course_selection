package edu.hhuc.course_selection.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "selection")
public class Selection {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, columnDefinition = "bigint unsigned")
  private Long id;

  @Column(name = "select_time", nullable = false)
  private LocalDateTime selectTime = LocalDateTime.now();

  @Column(name = "score", columnDefinition = "tinyint unsigned")
  private Integer score = 0;

  @ManyToOne(targetEntity = Student.class)
  @JoinColumn(name = "student_id", referencedColumnName = "id")
  private Student student;

  @ManyToOne(targetEntity = Course.class)
  @JoinColumn(name = "course_id", referencedColumnName = "id")
  private Course course;

  public Selection() {}

  public Selection(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getSelectTime() {
    return selectTime;
  }

  public Integer getScore() {
    return score;
  }

  public Student getStudent() {
    return student;
  }

  public Course getCourse() {
    return course;
  }

  public Selection setSelectTime(LocalDateTime selectTime) {
    this.selectTime = selectTime;
    return this;
  }

  public Selection setScore(Integer score) {
    this.score = score;
    return this;
  }

  public Selection setStudent(Student student) {
    this.student = student;
    return this;
  }

  public Selection setCourse(Course course) {
    this.course = course;
    return this;
  }

  @Override
  public String toString() {
    return "{ 选课学生："
        + student.getName()
        + "，课程名："
        + course.getName()
        + "，得分："
        + score
        + "，选课时间："
        + selectTime
        + " }";
  }
}
