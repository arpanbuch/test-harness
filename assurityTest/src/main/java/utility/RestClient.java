package utility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	public Response postHttpRequest(Object requestJson, String uri) {

		Response response = RestAssured.given().contentType("application/json").body(requestJson).when().log().all()
				.post(uri);

		response.prettyPrint();

		return response;
	}
	
	public Response performGetHttpRequest(String uri) {

		Response response = RestAssured.given().contentType("application/json").when().log().all()
				.get(uri);

		
		response.prettyPrint();

		return response;
	}

	

	/*
	 * public Response executeHttpGetMethod(String URI) throws Exception {
	 * 
	 * RestAssured.baseURI = URI; RequestSpecification httpRequest =
	 * RestAssured.given(); Response response;
	 * 
	 * try { response = httpRequest.request(Method.GET); if (response != null) {
	 * response.prettyPrint(); // Prints the Http Response on return response; //
	 * console } else { System.out.println("http Response Object is null"); throw
	 * new NullPointerException(); } } catch (Exception ex) {
	 * System.out.println("Error in creating client protocol" + ex.getMessage());
	 * throw new Exception(ex.getMessage()); } }
	 */

}
