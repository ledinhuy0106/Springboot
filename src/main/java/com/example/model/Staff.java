package com.example.model;
import javax.persistence.*;
@Table
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

    public Staff(Long id, String name, double salary, Staff staff) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Staff(Long id, String name, double salary, Departments departments) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departments = departments;
    }

    public Staff(String name, double salary, Departments departments) {
        this.name = name;
        this.salary = salary;
        this.departments = departments;
    }

    public Staff(){}

    public Staff(String name, double salary, Staff staff) {
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, name='%s', salary='%d']", id, name, salary);
    }
}
