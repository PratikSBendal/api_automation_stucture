package jiffy_config;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;

public class JiffyConfig {
  
	protected final String baseUrl ="base url";
	protected final Map<String,String> requestHeaders = new HashMap<>();
	protected String customeridpass;
	protected String transactionidpass;
	protected int statuscode;
	protected String messagecheck;
	protected String clientid;
	protected String clientsecret;

	
	public void env ()
	{
		 Dotenv dotenv = null;
	        dotenv = Dotenv.configure().directory("server dir load env file").load();
	        clientid= dotenv.get("X-Client-Id");
	        clientsecret=dotenv.get("X-Client-Secret");
	        


	}
	
	public Map<String,String> authFunc()
	{
		env();
		requestHeaders.put("X-Client-Id",clientid);
		requestHeaders.put("X-Client-Secret",clientsecret);
	    return requestHeaders;
	}	


}
