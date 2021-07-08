package org.o7planning.sbrestfulclient.get;

import org.o7planning.sbrestfulclient.model.Employee;
import org.springframework.web.client.RestTemplate;


public class SimplestGetPOJOExample {

	
	 static final String URL_EMPLOYEES = "http://localhost:8082/employees";
	 
	    static final String URL_EMPLOYEES_XML = "http://localhost:8082/employees.xml";
	    static final String URL_EMPLOYEES_JSON = "http://localhost:8082/employees.json";
	 
	    public static void main(String[] args) {
	 
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // Send request with GET method and default Headers.
	        Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);
	 
	        if (list != null) {
	            for (Employee e : list) {
	                System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName() + " - " + e.getEmpNo());
	            }
	        }
	 
	    }
	
	
}
