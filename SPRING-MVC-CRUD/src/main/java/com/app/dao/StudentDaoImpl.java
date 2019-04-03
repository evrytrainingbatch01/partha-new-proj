package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.app.domain.Student;

public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int insert(Student stud) {
		String sql = "insert into STUDENT_DETAILS(studId,studName,studAge) values(" + stud.getStudId() + " , "
				+ stud.getStudName() + " , " + stud.getStudAge() + "')";
		return jt.update(sql);
	}

	public int update(Student stud) {
		String sql = "update STUDENT_DETAILS set studId='" + stud.getStudId() + "', studName=" + stud.getStudName()
				+ ",studAge='" + stud.getStudAge();
		return jt.update(sql);
	}

	public int delete(int studId) {
		String sql = "delete from STUDENT_DETAILS where studId=" + studId + "";
		return jt.update(sql);
	}

	public Student getStudentById(int studId) {
		String sql = "select * from STUDENT_DETAILS where studId=?";
		return jt.queryForObject(sql, new Object[] { studId }, new BeanPropertyRowMapper<Student>(Student.class));

	}

	public List<Student> getStudents() {
		String sql = "select * from STUDENT_DETAILS";

		List<Student> studentlist = jt.query(sql, new ResultSetExtractor<List<Student>>() {
			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Student> list = new ArrayList<Student>();
				while (rs.next()) {
					Student student = new Student();
					/*
					 * employee.setId(rs.getInt(1)); employee.setAge(rs.getInt(2));
					 * employee.setDept(rs.getString(3)); employee.setName(rs.getString(4));
					 */
					student.setStudId(rs.getInt(1));
					student.setStudName(rs.getString(2));
					student.setStudAge(rs.getInt(3));
					list.add(student);
				}
				return list;
			}

		});
		return studentlist;
	}

}
