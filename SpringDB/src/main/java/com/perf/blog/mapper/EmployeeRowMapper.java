package com.perf.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.perf.blog.model.Employee;

@SuppressWarnings("rawtypes")
public class EmployeeRowMapper implements RowMapper	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getInt("ID"));
			employee.setName(rs.getString("NAME"));
			employee.setAge(rs.getInt("AGE"));
			return employee;
		}
}
