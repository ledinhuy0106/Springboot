package com.example.service.Impl;

import com.example.model.Staff;
import com.example.repository.IStaffRepository;
import com.example.service.inter.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService implements IStaffService {
    @Autowired
    IStaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        staffRepository.deleteById(id);
    }

//    @Override
//    public Iterable<Staff> findByName(String name) {
//        return staffRepository.findByName(name);
//    }

    @Override
    public Iterable<Staff> findAllBySalaryGreaterThan1200() {
        return staffRepository.findAllBySalaryGreaterThan(1200);
    }

    @Override
    public Iterable<Staff> findAllByOrderBySalaryAsc() {
        return staffRepository.findAllByOrderBySalaryAsc();
    }

    @Override
    public Iterable<Staff> findByNameContaining(String name) {
        return staffRepository.findByNameContaining("%"+name+"%");
    }
}
