package com.perf.blog.dao;

import com.perf.blog.model.Employee;

public interface EmployeeDAO {

		public void insert(Employee employee);
		public Employee findById(int id);
}
