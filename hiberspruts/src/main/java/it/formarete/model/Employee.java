package it.formarete.model;

import it.formarete.service.EmployeeDAO;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.opensymphony.xwork2.ActionSupport;

public class Employee extends ActionSupport {
	private static final long serialVersionUID = -3637288302808865450L;

	private int id;
	private String name;
	private float salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String execute() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		EmployeeDAO dao = (EmployeeDAO) factory.getBean("employee");
		dao.save(this);
		return SUCCESS;
	}
}