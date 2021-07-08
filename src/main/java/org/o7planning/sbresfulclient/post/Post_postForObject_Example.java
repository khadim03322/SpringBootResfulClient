package org.o7planning.sbresfulclient.post;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.o7planning.sbrestfulclient.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Post_postForObject_Example {

	 public static final String USER_NAME = "tom";
	    public static final String PASSWORD = "123";
	static final String URL_CREATE_EMPLOYEE = "http://localhost:8082/employee";
	 
	   public static void main(String[] args) {
	 
		
		   
	      String empNo = "E11";
	 
	      Employee newEmployee = new Employee(empNo, "Tom", "Cleck");
	 
	      HttpHeaders headers = new HttpHeaders();
	      headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
	      headers.setContentType(MediaType.APPLICATION_XML);
	      
	      //debut
	      
	       //Debut Authentication
	        
	        String auth = USER_NAME + ":" + PASSWORD;
	        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	        String authHeader = "Basic " + new String(encodedAuth);
	        headers.set("Authorization", authHeader);
	        // 
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("my_other_key", "my_other_value");
	      
	       //Fin  Authentication
	      
	      RestTemplate restTemplate = new RestTemplate();
	 
	      // Data attached to the request.
	      HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);
	 
	      // Send request with POST method.
	      Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, Employee.class);
	 
	      if (e != null && e.getEmpNo() != null) {
	 
	         System.out.println("Employee created: " + e.getEmpNo());
	      } else {
	         System.out.println("Something error!");
	      }
	 
	   }
	
	
}
