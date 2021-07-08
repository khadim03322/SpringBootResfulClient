package org.o7planning.sbresfulclient.delete;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.o7planning.sbrestfulclient.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class DeleteSimpleExample {

	public static final String USER_NAME = "tom";
    public static final String PASSWORD = "123";
    
	public static void main(String[] args) {
		 
        RestTemplate restTemplate = new RestTemplate();
 
        // empNo="E01"
        String resourceUrl = "http://localhost:8082/employee/E01";
 
        
         //Debut Authentication
        
          HttpHeaders headers = new HttpHeaders();
	      headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
	      headers.setContentType(MediaType.APPLICATION_XML);
	      
	     
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
        
	        // Data attached to the request.
	        HttpEntity<Employee> requestBody = new HttpEntity<>(null, headers);
        
        // Send request with DELETE method.
        //restTemplate.delete(resourceUrl,requestBody);
	        
	        restTemplate.exchange(resourceUrl, HttpMethod.DELETE, requestBody, Void.class);
 
        
        // Get 
        /*Employee e = restTemplate.getForObject(resourceUrl, Employee.class);
 
        if (e != null) {
            System.out.println("(Client side) Employee after delete: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
        } else {
            System.out.println("Employee not found!");
        }*/
    }
	
	
}
