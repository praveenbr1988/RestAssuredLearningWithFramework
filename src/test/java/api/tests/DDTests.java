package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	User userPayLoad;
	
	@Test(priority=1, dataProvider="AllData",dataProviderClass = DataProviders.class )
	public void testPostUser(String uId, String uName, String fName, String lName, String uEmail, String pwd, String ph){
		
		userPayLoad = new User();
		userPayLoad.setId(Integer.parseInt(uId));
		userPayLoad.setUserName(uName);
		userPayLoad.setFirstName(fName);
		userPayLoad.setLastName(lName);
		userPayLoad.setEmail(uEmail);
		userPayLoad.setPassword(pwd);
		userPayLoad.setPhone(ph);			
		
		Response response = UserEndpoints.createUser(userPayLoad);
		response.then().log().all();
		System.out.println("UserName is: "+this.userPayLoad.getUserName());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("tests passed success***");
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass = DataProviders.class )
	public void testGetUserByName(String uName){
		
		Response response = UserEndpoints.readUser(uName);
		System.out.println("UserName is: "+this.userPayLoad.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}
