package org.o7planning.sbresfulclient.put;


import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.o7planning.sbrestfulclient.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PutWithExchangeExample {

	 public static final String USER_NAME = "tom";
	    public static final String PASSWORD = "123";
	    
	static final String URL_UPDATE_EMPLOYEE = "http://localhost:8082/employee";
    static final String URL_EMPLOYEE_PREFIX = "http://localhost:8082/employee";
 
    public static void main(String[] args) {
 
        String empNo = "E01";
 
        Employee updateInfo = new Employee(empNo, "Aissata", "Diallo");
 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
 
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
        HttpEntity<Employee> requestBody = new HttpEntity<>(updateInfo, headers);
 
        // Send request with PUT method.
        restTemplate.exchange(URL_UPDATE_EMPLOYEE, HttpMethod.PUT, requestBody, Void.class);
 
        /*String resourceUrl = URL_EMPLOYEE_PREFIX + "/" + empNo;
 
        Employee e = restTemplate.getForObject(resourceUrl, Employee.class);
 
        if (e != null) {
            System.out.println("(Client side) Employee after update: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
        }*/
    }
	
	
	
}
