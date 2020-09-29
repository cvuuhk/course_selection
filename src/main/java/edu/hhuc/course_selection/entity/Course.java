package edu.hhuc.course_selection.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/** 课程信息表 */
@Entity
@Table(name = "course")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "selections"})
public class Course {
  @Id
  @Column(name = "id", nullable = false, columnDefinition = "char(10)")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "remaining", nullable = false, columnDefinition = "tinyint unsigned")
  private Integer remaining;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private final Set<Selection> selections = new HashSet<>();

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getRemaining() {
    return remaining;
  }

  public Set<Selection> getSelections() {
    return selections;
  }

  public Course setName(String name) {
    this.name = name;
    return this;
  }

  public Course setRemaining(Integer remaining) {
    this.remaining = remaining;
    return this;
  }

  public Course addSelection(Selection selection) {
    if (selection == null) {
      throw new IllegalArgumentException("参数 selection 为空！");
    }
    selection.setCourse(this);
    selections.add(selection);
    return this;
  }

  @Override
  public String toString() {
    return "{ 课程号：" + id + "，课程名：" + name + "，课余量：" + remaining + " }";
  }
}
