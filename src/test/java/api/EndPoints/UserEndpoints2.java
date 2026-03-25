package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api.Payloads.UserPayLoad;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 * This class contains all the API endPoints for the USER MODULE.
 * 
 * Means it contains all the methods which will return the API endPoints for the USER MODULE.
 * upto when we will be using the API endPoints in our test cases, we will call the 
 * methods of this class to get the endPoints.
 * 
 */

public class UserEndpoints2 {
	
	static ResourceBundle getURI() {
		
		ResourceBundle rb = ResourceBundle.getBundle("routes");
		return rb;
	}
	
	
	@Test	
	public static Response post_User(UserPayLoad userPay) {
		
		 String post_URI = getURI().getString("post_URI");
		
		Response res = given()
			.accept("application/json")
			.contentType("application/json")
			.body(userPay)
		
		.when()
			.post(post_URI);
		
		return res;
	}
	
	@Test	
	public static Response get_User(String user) {
		
		String get_URI = getURI().getString("get_URI");
		
		Response res = given()
				.pathParam("username", user)
		
		.when()
			.get(get_URI);
		
		return res;
	}
	
	@Test	
	public static Response update_User(UserPayLoad userPay, String user) {
		
		String put_URI = getURI().getString("put_URI");
		
		Response res = given()
			.accept("application/json")
			.contentType("application/json")
			.body(userPay)
			.pathParam("username", user)
		
		.when()
			.put(put_URI);
		
		return res;
	}
	
	@Test	
	public static Response delete_User(String user) {
		
		String delete_URI = getURI().getString("delete_URI");
		
		Response res = given()
				.pathParam("username", user)
		
		.when()
			.delete(delete_URI);
		
		return res;
	}
	
	
}	
