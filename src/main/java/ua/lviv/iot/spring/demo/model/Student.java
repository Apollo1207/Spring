package ua.lviv.iot.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    private String firstStudent;
    private String secondStudent;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Student() {
    }

    public Student(String firstStudent, String secondStudent) {
        this.firstStudent = firstStudent;
        this.secondStudent = secondStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstStudent() {
        return firstStudent;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

    public String getSecondStudent() {
        return secondStudent;
    }

    public void setSecondStudent(String secondStudent) {
        this.secondStudent = secondStudent;
    }


}