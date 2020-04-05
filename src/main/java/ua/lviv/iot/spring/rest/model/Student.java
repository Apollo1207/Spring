package ua.lviv.iot.spring.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private String firstStudent;
    private String secondStudent;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("students")
    private Group group;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getFirstStudent().equals(student.getFirstStudent()) &&
                getSecondStudent().equals(student.getSecondStudent()) &&
                getId().equals(student.getId()) &&
                getGroup().equals(student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstStudent(), getSecondStudent(), getId(), getGroup());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstStudent='" + firstStudent + '\'' +
                ", secondStudent='" + secondStudent + '\'' +
                ", id=" + id +
                ", group=" + group +
                '}';
    }
}