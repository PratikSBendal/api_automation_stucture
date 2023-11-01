package post_utr_update;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jiffy_config.JiffyConfig;

public class UtrUpdate extends  JiffyConfig{
JiffyConfig config= new JiffyConfig();

public void utUpdate(String custid, String transid)
{
	RestAssured.baseURI = baseUrl;
	System.out.println(RestAssured.baseURI);
	RequestSpecification httpRequesthttpRequest = RestAssured.given().headers(config.authFunc()); 
	
	JSONObject requestParam = new JSONObject();
	requestParam.put("customerId", custid);
	requestParam.put("loanId", transid);
	requestParam.put("utr", "UTR1234");
	
	httpRequesthttpRequest.header("Content-Type","application/json");
	httpRequesthttpRequest.body(requestParam.toJSONString());
	Response response = httpRequesthttpRequest.request(Method.POST,"end point url");
	ResponseBody body =response.getBody();
	String convertjsonstring =body.asString();
	System.out.println(convertjsonstring);
}
}
