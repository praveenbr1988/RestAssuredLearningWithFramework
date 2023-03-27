package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(User payLoad){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payLoad)
		.when()
			.post(Routes.post_url);
		return response;
	}
	
	public static Response readUser(String userName){
		
		Response response = given()
			.pathParam("username", userName)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url);
		System.out.println("URL Is- "+Routes.get_url);
		return response;
	}
	
	public static Response updateUser(String userName, User payLoad){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payLoad)
		.when()
			.put(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		Response response = given()
				.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
		return response;
	}
	
}
