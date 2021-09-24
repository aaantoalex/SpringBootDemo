package com.psv.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.psv.students.dataaccess.DepartmentRepository;
import com.psv.students.model.Departments;

@Controller
@RequestMapping("/Department")
public class Department {
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@RequestMapping("/index")
	public ModelAndView getDepartmentList()
	{
		ModelAndView mv=new ModelAndView("DepartmentList.html");
		List<Departments> departmentList=departmentRepo.findAll();
		mv.addObject("departments", departmentList);
		//return "DepartmentList.html";
		return mv;
	}
	
	/*@RequestMapping("/create")
	public String createDepartment()
	{
		return "CreateDepartment.html";
	}*/
	
	@GetMapping(value="/create")
	public ModelAndView createDepartment(Departments department) {
		ModelAndView mv=new ModelAndView("CreateDepartment.html");
		mv.addObject("department", department);
	    return mv;
	}
	
	  @PostMapping("/add")
	    public String addDepartment(@Validated Departments department, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "CreateDepartment.html";
	        }
	        
	        departmentRepo.save(department);
	        return "redirect:/Department/index";
	    }
	  
	  @GetMapping("/edit/{id}")
	  public ModelAndView showUpdateForm(@PathVariable("id") long id) {
		  Departments department = departmentRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Department Id:" + id));
	      
			ModelAndView mv=new ModelAndView("UpdateDepartment.html");
			mv.addObject("department", department);
		    return mv;
	  }
	  
	  @PostMapping("/update/{id}")
	  public String updateUser(@PathVariable("id") long id, @Validated Departments department, 
	    BindingResult result, Model model) {
	      if (result.hasErrors()) {
	    	  department.setDepartmentID(id);
	          return "UpdateDepartment.html";
	      }
	      department.setDepartmentID(id);
	      departmentRepo.save(department);
	     return "redirect:/Department/index";
	  }
	  
	  @GetMapping("/delete/{id}")
	  public String deleteDepartment(@PathVariable("id") long id, Model model) {
	      Departments department = departmentRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Department Id:" + id));
	      departmentRepo.delete(department);
	      return "redirect:/Department/index";
	  }
}
