package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.IStudentDao;
import com.app.domain.Student;

@Controller
public class StudentController {
	@Autowired
	private IStudentDao dao;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute("student") Student student) {
		try {
			if (dao.getStudentById(student.getStudId()) != null)
				;
			dao.update(student);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("inside catch");
			dao.insert(student);
		}
		return new ModelAndView("redirect:/student");
	}

	@RequestMapping(value = "/delete/{studId}")
	public ModelAndView delete(@ModelAttribute("student") Student student, @PathVariable("studId") int studId) {
		dao.delete(studId);

		return new ModelAndView("redirect:/students");
	}

	@RequestMapping(value = "/edit/{studId}")
	public ModelAndView editstudent(@ModelAttribute("student") Student student, @PathVariable("studId") int studId) {
		ModelAndView model = new ModelAndView("employees");

		student = dao.getStudentById(studId);
		List studentList = dao.getStudents();

		model.addObject("student", student);
		model.addObject("studentList", studentList);

		return model;
	}

	@RequestMapping(value = "/students")
	public ModelAndView listEmployees(@ModelAttribute("student") Student student) {
		ModelAndView model = new ModelAndView("students");

		List studentList = dao.getStudents();
		System.out.println(studentList);
		model.addObject("studentList", studentList);

		return model;
	}

}
