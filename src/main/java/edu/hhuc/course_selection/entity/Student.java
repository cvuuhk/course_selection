package edu.hhuc.course_selection.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息表
 */
@Entity
@Table(name = "student")
public class Student{
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "char(10)")
    private String id;
    
    @Column(name = "name", nullable = false, columnDefinition = "varchar(10)")
    private String name;
    
    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    private List<Course> courses = new ArrayList<>();
    
    public Student(){}
    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }
    public void setId(String id){ this.id = id; }
    public String getId(){ return id; }
    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    @JsonIgnore
    public List<Course> getCourses(){ return courses; }
    
    @Override
    public String toString(){
        return "Student{"+
                "id="+id+'\''+
                "name="+name+'\''+
                '}';
    }
}
