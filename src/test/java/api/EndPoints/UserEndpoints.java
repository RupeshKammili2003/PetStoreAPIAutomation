package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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

public class UserEndpoints {
	
	
	@Test	
	public static Response post_User(UserPayLoad userPay) {
		
		Response res = given()
			.accept("application/json")
			.contentType("application/json")
			.body(userPay)
		
		.when()
			.post(Routes.post_URI);
		
		return res;
	}
	
	@Test	
	public static Response get_User(String user) {
		
		Response res = given()
				.pathParam("username", user)
		
		.when()
			.get(Routes.get_URI);
		
		return res;
	}
	
	@Test	
	public static Response update_User(UserPayLoad userPay, String user) {
		
		Response res = given()
			.accept("application/json")
			.contentType("application/json")
			.body(userPay)
			.pathParam("username", user)
		
		.when()
			.put(Routes.put_URI);
		
		return res;
	}
	
	@Test	
	public static Response delete_User(String user) {
		
		Response res = given()
				.pathParam("username", user)
		
		.when()
			.delete(Routes.delete_URI);
		
		return res;
	}
	
	
}	
