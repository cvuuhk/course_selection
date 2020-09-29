package edu.hhuc.course_selection.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/** 学生信息表 */
@Entity
@Table(name = "student")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "selections"})
public class Student {
  @Id
  @Column(name = "id", nullable = false, columnDefinition = "char(10)")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private final Set<Selection> selections = new HashSet<>();

  public Student() {}

  public Student(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Selection> getSelections() {
    return selections;
  }

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public Student addSelection(Selection selection) {
    if (selection == null) {
      throw new IllegalArgumentException("参数 selection 为空！");
    }
    selections.add(selection);
    selection.setStudent(this);
    return this;
  }

  @Override
  public String toString() {
    return "{ 学号：" + id + "，姓名：" + name + " }";
  }
}
