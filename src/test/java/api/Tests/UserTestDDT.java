package api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.EndPoints.UserEndpoints;
import api.Payloads.UserPayLoad;
import api.utilites.DataProviderTest;
import api.utilites.LoggerUtil;
import io.restassured.response.Response;

public class UserTestDDT {

	public UserPayLoad userPayload;

	@Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviderTest.class)
	void postUserValidation(String ID, String username, String firstName, String lastName, String email, String password,
			String phone, String userStatus) {
		
		LoggerUtil.info("Starting the postUserValidation");

		userPayload = new UserPayLoad();

		userPayload.setId(Integer.parseInt(ID));

		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);

		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		userPayload.setUserStatus(Integer.parseInt(userStatus));

		Response res = UserEndpoints.post_User(userPayload);
		// res.then().statusCode(200);

		// Validating the status code and the type of the response.
		String type = res.jsonPath().getString("type");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(type, "unknown");
		
		LoggerUtil.info("finished the postUserValidation");
	}

	
	@Test(priority=2, dataProvider = "userName", dataProviderClass = DataProviderTest.class)
	void getUserValidation(String username) {
		
		LoggerUtil.info("Starting the getUserValidation");
		
		Response res = UserEndpoints.get_User(username);
		res.then().statusCode(200);
		
		LoggerUtil.info("finished the getUserValidation");
		
	}
	
	
	@Test(priority=3, dataProvider = "userName", dataProviderClass = DataProviderTest.class)
	void deleteUserValidation(String username) {
		
		LoggerUtil.info("Starting the deleteUserValidation");
		
		Response res = UserEndpoints.delete_User(username);
		
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		LoggerUtil.debug("done");
		LoggerUtil.info("finished the deleteUserValidation");
		
	}
	 

}
