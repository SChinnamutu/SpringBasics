package com.javacodegeeks.snippets.enterprise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perf.blog.dao.JDBCEmployeeDAO;
import com.perf.blog.model.Employee;

public class App {

	public static void main(String[] args) {
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context.getBean("jdbcEmployeeDAO");
	        new App().doProcess(jdbcEmployeeDAO);
			context.close();
	}
	
	private  void doProcess(JDBCEmployeeDAO jdbcEmployeeDAO) {
		System.out.println("-----------Start-----------");
		save(jdbcEmployeeDAO);
		findAll(jdbcEmployeeDAO);
		findById(jdbcEmployeeDAO);
		update(jdbcEmployeeDAO);
		System.out.println("-----------End-----------");
	}

	public void save(JDBCEmployeeDAO jdbcEmployeeDAO){
			Employee emplNew1 = new Employee(23, "John", 23);
	        Employee emplNew2 = new Employee(223, "Mark", 43);
	        List<Employee> employeesN = new ArrayList<Employee>();
	        employeesN.add(emplNew1);
	        employeesN.add(emplNew2);
	        jdbcEmployeeDAO.insertBatch1(employeesN);
	        System.out.println(" inserted rows: " + employeesN);
	}
	
	public void findAll(JDBCEmployeeDAO jdbcEmployeeDAO){
		List<Employee> employees = jdbcEmployeeDAO.findAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	
	public void findById(JDBCEmployeeDAO jdbcEmployeeDAO){
		Employee employee = jdbcEmployeeDAO.findById(23);
		System.out.println(employee);
	}
	
	public void update(JDBCEmployeeDAO jdbcEmployeeDAO){
		Employee employee = jdbcEmployeeDAO.findById(23);
		employee.setId(10);
		employee.setName("Messi");
		jdbcEmployeeDAO.update(employee);
	}
	
}
