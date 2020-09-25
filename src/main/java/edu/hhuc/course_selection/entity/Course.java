package edu.hhuc.course_selection.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程信息表
 */
@Entity
@Table(name = "course")
public class Course{
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "char(10)")
    private String id;
    
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private String name;
    
    @JsonIgnore
    @Column(name = "remaining", nullable = false, columnDefinition = "tinyint unsigned")
    private Integer remaining;
    
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
    
    public Course(){}
    public Course(String id, String name, Integer remaining){
        this.id = id;
        this.name = name;
        this.remaining = remaining;
    }
    public void setId(String id){ this.id = id; }
    public String getId(){ return id; }
    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    public void setRemaining(Integer remaining){ this.remaining = remaining; }
    public Integer getRemaining(){ return remaining; }
    @JsonIgnore
    public List<Student> getStudents(){ return students; }
    
    @Override
    public String toString(){
        return "Course{"+
                "id="+id+'\''+
                "name="+name+'\''+
                "remaining="+remaining+'\''+
                '}';
    }
}
