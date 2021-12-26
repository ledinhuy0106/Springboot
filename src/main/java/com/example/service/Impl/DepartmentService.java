package com.example.service.Impl;

import com.example.model.Departments;
import com.example.repository.IDepartmentRepository;
import com.example.service.inter.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    IDepartmentRepository departmentRepository;


    @Override
    public Iterable<Departments> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Departments> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void save(Departments departments) {
        departmentRepository.save(departments);
    }

    @Override
    public void remove(Long id) {
        departmentRepository.deleteById(id);
    }
}
