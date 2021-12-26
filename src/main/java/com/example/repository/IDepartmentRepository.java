package com.example.repository;

import com.example.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDepartmentRepository extends JpaRepository<Departments,Long> {
}
