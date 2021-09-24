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

import com.psv.students.dataaccess.StudentRepository;
import com.psv.students.model.Departments;
import com.psv.students.model.Students;

@Controller
@RequestMapping("/Student")
public class Student {
	
	@Autowired
	StudentRepository studentRepo;
	@RequestMapping("/index")
	public ModelAndView getStudentList()
	{
		ModelAndView mv=new ModelAndView("StudentList.html");
		List<Students> studentList=studentRepo.findAll();
		
		mv.addObject("students", studentList);
		//return "StudentList.html";
		return mv;
	}

	@GetMapping(value="/create")
	public ModelAndView createStudent(Students student) {
		ModelAndView mv=new ModelAndView("CreateStudent.html");
		mv.addObject("student", student);
	    return mv;
}

	  @PostMapping("/add")
	    public String addStudent(@Validated Students student, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "CreateStudent.html";
	        }
	        studentRepo.save(student);
	        return "redirect:/Student/index";
	    }
	  @GetMapping("/edit/{id}")
	  public ModelAndView showUpdateForm(@PathVariable("id") long id) {
		  Students student = studentRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + id));
	      
			ModelAndView mv=new ModelAndView("UpdateStudent.html");
			mv.addObject("student", student);
		    return mv;
}
	  @PostMapping("/update/{id}")
	  public String updateStudent(@PathVariable("id") long id, @Validated Students student, 
	    BindingResult result, Model model) {
	      if (result.hasErrors()) {
	    	  student.setStudentId(id);
	          return "UpdateStudent.html";
	      }
	      student.setStudentId(id);
	      studentRepo.save(student);
	     return "redirect:/Student/index";
	  }
	  @GetMapping("/delete/{id}")
	  public String deleteStudent(@PathVariable("id") long id, Model model) {
	      Students student = studentRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + id));
	      studentRepo.delete(student);
	      return "redirect:/Student/index";
	  }
}
