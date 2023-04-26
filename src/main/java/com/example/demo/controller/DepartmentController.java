package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.models.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import com.example.demo.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private static final String DEPARTMENT_VIEW = "departments";
    private static final String FORM_VIEW = "formDepartment";

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    // Mostrar profesores
    @GetMapping("/listDepartments")
    public ModelAndView listDepartments() {
        ModelAndView mav = new ModelAndView(DEPARTMENT_VIEW);
        mav.addObject("departments", departmentService.listAllDepartments());
        return mav;
    }

    @PostMapping("/addDepartment")
    public String addDepartment(@Valid @ModelAttribute("department") DepartmentDTO department, BindingResult bindingResult,
                          RedirectAttributes flash, Model model) {
        departmentService.addAppointment(department);
        flash.addFlashAttribute("success", "Department updated successfully");
        return "redirect:/departments/listDepartments";

    }

    @GetMapping(value = { "/formDepartment", "/formDepartment/{id}" })
    public String formDepartment(@PathVariable(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("department", departmentService.findDepartmentById(id));

        } else {
            model.addAttribute("department", new Department());
        }

        return FORM_VIEW;
    }

    // Metodo para borrar
    @GetMapping("/deleteDepartment/{id}")
    public String removeUser(@PathVariable("id") int id, RedirectAttributes flash) {
        Department d = departmentService.findDepartmentById(id);
        try {
            departmentService.removeDepartment(d.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        flash.addFlashAttribute("success", "Department deleted successfully");

        return "redirect:/departments/listDepartments";
    }
}
