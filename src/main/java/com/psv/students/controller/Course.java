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

import com.psv.students.dataaccess.CourseRepository;
import com.psv.students.model.Courses;


@Controller
@RequestMapping("/Course")
public class Course {
	@Autowired
	CourseRepository courseRepo;
     
	@RequestMapping("/index")
	public ModelAndView getCourseList()
	{ 
		ModelAndView mv=new ModelAndView("CourseList.html");
		List<Courses> courseList=courseRepo.findAll();
		mv.addObject("courses", courseList);
		//return "DepartmentList.html";
		return mv;
		
	}
	
	@GetMapping(value="/create")
	public ModelAndView createCourse(Courses course) {
		ModelAndView mv=new ModelAndView("CreateCourse.html");
		mv.addObject("course", course);
	    return mv;
}
	
	 @PostMapping("/add")
	    public String addCourse(@Validated Courses course, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "CreateCourse.html";
	        }
	        
	        courseRepo.save(course);
	        return "redirect:/Course/index";
	    }
	 
	 @GetMapping("/edit/{id}")
	  public ModelAndView showUpdateForm(@PathVariable("id") long id) {
		  Courses course = courseRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + id));
	      
			ModelAndView mv=new ModelAndView("UpdateCourse.html");
			mv.addObject("course", course);
		    return mv;
	  }
	 
	 @PostMapping("/update/{id}")
	  public String updateUser(@PathVariable("id") long id, @Validated Courses course, 
	    BindingResult result, Model model) {
	      if (result.hasErrors()) {
	    	  course.setCourseID(id);
	          return "UpdateCourse.html";
	      }
	      course.setCourseID(id);
	      courseRepo.save(course);
	     return "redirect:/Course/index";
	  }
	 
	 @GetMapping("/delete/{id}")
	  public String deleteCourse(@PathVariable("id") long id, Model model) {
	      Courses course = courseRepo.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + id));
	      courseRepo.delete(course);
	      return "redirect:/Course/index";
	  }
}