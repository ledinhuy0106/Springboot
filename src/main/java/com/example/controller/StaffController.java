package com.example.controller;


import com.example.model.Departments;
import com.example.model.Staff;
import com.example.service.inter.IDepartmentService;
import com.example.service.inter.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    IDepartmentService departmentService;
    @Autowired
    IStaffService staffService;


    @ModelAttribute("departments")
    public Iterable<Departments> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/find")
    public String listStaff(Model model, String name) {
        Iterable<Staff> staff;
        if (name != null) {
            staff = staffService.findByNameContaining(name);
        }
        else {
            staff = staffService.findAll();
        }
        model.addAttribute("staffs", staff);
        return "/staff/list";
    }
    @PostMapping("/asc")
    public String salaryAsc (Model model){
        Iterable<Staff> staffList;
        staffList=staffService.findAllByOrderBySalaryAsc();
        model.addAttribute("staffs",staffList);
        return "/staff/list";
    }

    @GetMapping("/edit-staff/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        if (staff.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/staff/edit");
            modelAndView.addObject("staffs", staff.get());
            return modelAndView;
        }
        return null;
    }

    @PostMapping("/edit-staff")
    public ModelAndView updateStaff(@ModelAttribute("staffs") Staff staff) {
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("/staff/edit");
        modelAndView.addObject("staffs", staff);
        modelAndView.addObject("message", "Staff updated successfully");
        return modelAndView;
    }
    @PostMapping("/salary")
    public String salary1200 (Model model){
        Iterable<Staff> staffList;
        staffList=  staffService.findAllBySalaryGreaterThan1200();
        model.addAttribute("staffs",staffList);
        return "/staff/list";
    }

    @GetMapping("/create-staff")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/staff/create");
        modelAndView.addObject("staffs", new Staff());
        return modelAndView;
    }

    @PostMapping("/create-staff")
    public ModelAndView saveStaff(@ModelAttribute("Staffs") Staff staff) {
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("/staff/create");
        modelAndView.addObject("staffs", new Staff());
        modelAndView.addObject("message", "New staff created successfully");
        return modelAndView;
    }
    @GetMapping("/delete-staff/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/staff/delete");
            modelAndView.addObject("staffs", staff.get());
            return modelAndView;
    }

    @PostMapping("/delete-staff")
    public String deleteStaff(@ModelAttribute("staffs") Staff staff) {
        staffService.remove(staff.getId());
        return "redirect:/staffs/find";
    }

}
