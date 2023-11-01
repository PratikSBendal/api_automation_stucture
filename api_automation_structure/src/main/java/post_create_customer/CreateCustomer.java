package post_create_customer;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import java.util.stream.Collectors;
//import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jiffy_config.JiffyConfig;

public class CreateCustomer extends  JiffyConfig {

	JiffyConfig config= new JiffyConfig();
	public void crateCustoimerApi ()
	{	
//		 ObjectMapper objectMapper = new ObjectMapper();
		RestAssured.baseURI = baseUrl;
		System.out.println(RestAssured.baseURI);
		RequestSpecification httpRequesthttpRequest = RestAssured.given().headers(config.authFunc()); 
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("firstName", "Credit");
		requestParam.put("middleName", "test");
		requestParam.put("lastName", "script");
		requestParam.put("phoneNumber", "3264352626");
		requestParam.put("kycId", "1252");
		requestParam.put("panNumber", "MKSPS9336K");
		requestParam.put("dateOfBirth", "1985-07-21");
		requestParam.put("address", "H-62reserve Bank Officers Colony Nayapallibhubaneswar Urban");
		requestParam.put("state", "MH");
		requestParam.put("postalCode", "400001");
		requestParam.put("city", "mumbai");
		requestParam.put("ifscCode", "abc12330");
		requestParam.put("bankName", "SBI BANK");
		requestParam.put("bankAccountNumber", "8264826394423");
		requestParam.put("companyName", "credit fair capital");
		requestParam.put("monthlyIncome", "50000");
		requestParam.put("doj", "2021-03-15");
		requestParam.put("gender", "1");
		requestParam.put("employeeId", "987");
		requestParam.put("creditLimit", "25000");

		
		httpRequesthttpRequest.header("Content-Type","application/json");
		httpRequesthttpRequest.body(requestParam.toJSONString());
		Response response = httpRequesthttpRequest.request(Method.POST,"end point url");
		
		//Assertion start 
		
		statuscode =response.getStatusCode();
		long time =response.getTime();
		System.out.println(time);
		System.out.println(statuscode);
		
		messagecheck ="";
		
		ResponseBody body =response.getBody();
		String convertjsonstring =body.asString();
		System.out.println(convertjsonstring);
		JsonPath getresponse = response.jsonPath();
		messagecheck =getresponse.getJsonObject("message");
		System.out.println("test"+messagecheck);
        if(messagecheck.contains("Customer already exists"))
        {
        	System.out.println("Customer already exists");
            
        }
        else 
        {
        	Map<String,String> getcustomerid   =getresponse.getJsonObject("data");
//          String str = customerid.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining(""));
            customeridpass = getcustomerid.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining(""));
        }
	
       
	}
	public String customeridPassfunc()
	{
		System.out.println(customeridpass);
		return customeridpass;
	}
	
}
