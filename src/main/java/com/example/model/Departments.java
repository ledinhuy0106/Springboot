package com.example.model;
import javax.persistence.*;
@Table
@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String department;

    public Departments(String department) {
        this.department = department;
    }

    public Departments(Long id, String department) {
        this.id = id;
        this.department = department;
    }

    public Departments() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
