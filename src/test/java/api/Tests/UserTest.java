package api.Tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.EndPoints.UserEndpoints;
import api.Payloads.UserPayLoad;
import io.restassured.response.Response;
import net.datafaker.Faker;

public class UserTest {
	
	public Faker fakeData;
	public UserPayLoad userPayload;
	
	@BeforeClass
	public void setup() {
		
		fakeData = new Faker();
		userPayload = new UserPayLoad();
		
		userPayload.setId(fakeData.number().numberBetween(1, 1000));
		
		userPayload.setUsername(fakeData.name().username());
		userPayload.setFirstName(fakeData.name().firstName());
		userPayload.setLastName(fakeData.name().lastName());
		
		userPayload.setEmail(fakeData.internet().emailAddress());
		userPayload.setPassword(fakeData.internet().password());
		userPayload.setPhone(fakeData.phoneNumber().cellPhone());
		userPayload.setUserStatus(1);
	}
	
	@Test(priority=1)
	void postUserValidation() {
		
		Response res = UserEndpoints.post_User(userPayload);
		//res.then().statusCode(200);
		
		//Validating the status code and the type of the response.
		String type = res.jsonPath().getString("type");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(type,"unknown");
	}
	
	@Test(priority=2)
	void getUserValidation() {
		
		Response res = UserEndpoints.get_User(userPayload.getUsername());
		res.then().statusCode(200);
		
		//Validating the response body.
		JSONObject resBody = new JSONObject(res.asString());
		
		Assert.assertEquals(resBody.getInt("id"), userPayload.getId());
		Assert.assertEquals(resBody.getString("username"), userPayload.getUsername());
		Assert.assertEquals(resBody.getString("firstName"), userPayload.getFirstName());
		Assert.assertEquals(resBody.getString("lastName"), userPayload.getLastName());
		Assert.assertEquals(resBody.getString("email"), userPayload.getEmail());
		Assert.assertEquals(resBody.getString("password"), userPayload.getPassword());
		Assert.assertEquals(resBody.getString("phone"), userPayload.getPhone());
	}
	
	@Test(priority=3)
	void updateUserValidation() {
		
		//updating the user details
		userPayload.setEmail(fakeData.internet().emailAddress());
		userPayload.setPassword(fakeData.internet().password());
		
		Response res = UserEndpoints.update_User(userPayload, userPayload.getUsername());
		
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	void deleteUserValidation() {
		
		Response res = UserEndpoints.delete_User(userPayload.getUsername());
		
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
