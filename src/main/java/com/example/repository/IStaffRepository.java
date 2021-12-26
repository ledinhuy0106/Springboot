package com.example.repository;

import com.example.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IStaffRepository extends JpaRepository<Staff,Long> {
//    Iterable<Staff> findByName(String name);
    Iterable<Staff> findAllBySalaryGreaterThan(double salary);
    Iterable<Staff> findAllByOrderBySalaryAsc();
    Iterable<Staff> findByNameContaining(String name);
}
