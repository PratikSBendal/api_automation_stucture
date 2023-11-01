package post_drawdown;

import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jiffy_config.JiffyConfig;

public class DrawDown extends  JiffyConfig{
	JiffyConfig config= new JiffyConfig();
public void drawDownApi(String custid)
{
	RestAssured.baseURI = baseUrl;
	System.out.println(RestAssured.baseURI);
	RequestSpecification httpRequesthttpRequest = RestAssured.given().headers(config.authFunc()); 
	

	
	JSONObject requestParamlat = new JSONObject();
	System.out.println(custid);
	requestParamlat.put("customerId", custid);
	requestParamlat.put("drawdownRequestDate", "2023-04-25 12:45:33");
	requestParamlat.put("drawdownAmount", 7000);
	requestParamlat.put("dateOfRepayment", "2023-05-05 12:45:33");
	
	JSONObject requestParamfeeArray = new JSONObject();
	requestParamfeeArray.put("type","processing_fee");
	requestParamfeeArray.put("amount",500);
	requestParamfeeArray.put("gst",0);
	
	JSONArray arrData = new JSONArray();
	arrData.add(requestParamfeeArray);
	
	requestParamlat.put("fees",arrData);
	
	requestParamlat.put("pocAtJify", "Bendal");
	requestParamlat.put("dateOfDisbursal", "2023-04-17 12:45:33");
	requestParamlat.put("amountToBeDisbursed", 500);

	httpRequesthttpRequest.header("Content-Type","application/json");
	httpRequesthttpRequest.body(requestParamlat.toJSONString());
	Response response = httpRequesthttpRequest.request(Method.POST,"end point url");
	ResponseBody body =response.getBody();
	String convertjsonstring =body.asString();
	System.out.println(convertjsonstring);
	JsonPath getresponse = response.jsonPath();

	Map<String,String> transactionid   =getresponse.getJsonObject("data");
//  String str = customerid.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining(""));
	transactionidpass = transactionid.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining(""));
	
	
	
}
public String transactionidPassfunc()
{
	System.out.println(transactionidpass);
	return transactionidpass;
}
}
