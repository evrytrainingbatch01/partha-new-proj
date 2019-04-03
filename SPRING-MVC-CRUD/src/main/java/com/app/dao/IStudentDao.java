package com.app.dao;

import java.util.List;

import com.app.domain.Student;

public interface IStudentDao {
	public int insert(Student stud);

	public int update(Student stud);

	public int delete(int studId);

	public Student getStudentById(int studId);

	public List<Student> getStudents();

}
