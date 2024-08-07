package test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibs.Implementation.APIInvoker;
import CommonLibs.Implementation.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Refund_API extends Base{
	
	@DataProvider(name = "data-provider")
	public JSONObject[] dataProviderMethod() {
		return APIInvoker.getJsonData(".\\src\\test\\resources\\Test Data\\RefundAPI.txt", "refundRequest");
	}

	@SuppressWarnings("unchecked")
	@Test (dataProvider = "data-provider")
//	@Test
	public void apirefund(JSONObject object) {
//		Map<String, String> parameters = new HashMap<String, String>();
//		 parameters.put("queryRequest", "zDjRtS9nHgK730VphtNyWneNHP82bFbBbVb78YCI5y1rSjfMadRq7ko28HyM3m52");
//		 parameters.put("merchantId" , "1000003");
//		 parameters.put("aggregatorId", "SBIEPAY");

//		 System.out.println(object);
//		JSONObject[] arr = APIInvoker.getJsonData("C:\\Users\\Admin\\git\\repository\\SBIePay\\src\\test\\resources\\Test Data\\RefundAPI.txt", "refundRequest");
//		 System.out.println(arr[0]);
//		 
//		startTest("API", "get");
		Response res = RestAssured.given().auth().none().contentType("application/x-www-form-urlencoded; charset=utf-8")
//				.formParam("queryRequest", "zDjRtS9nHgK730VphtNyWneNHP82bFbBbVb78YCI5y1rSjfMadRq7ko28HyM3m52")
//				.formParam("merchantId", 1000003)
//				.formParam("aggregatorId", "SBIEPAY")
				.params(object)
				.when().post("https://uat.sbiepay.sbi/payagg/RefundMISReport/refundEnquiryAPI");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
		String body = res.getBody().asPrettyString();
		
//		encryptionJSP.enc(body);
		
//		APIInvoker.getMethod("https://uat.sbiepay.sbi/secure/getEncryptDecryptChecksumString.jsp");
//		driver.close();
	}
}