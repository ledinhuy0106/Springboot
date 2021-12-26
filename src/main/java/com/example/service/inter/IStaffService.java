package com.example.service.inter;

import com.example.model.Staff;

public interface IStaffService extends IGeneralService<Staff> {
//    Iterable<Staff> findByName(String name);
    Iterable<Staff> findAllBySalaryGreaterThan1200();
    Iterable<Staff> findAllByOrderBySalaryAsc();
    Iterable<Staff> findByNameContaining(String name);
}
