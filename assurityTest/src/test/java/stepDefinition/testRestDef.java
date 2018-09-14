package stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import utility.RestClient;

public class testRestDef {

	RestClient restClient = new RestClient();
	Response response;
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

	@Given("I perform GET request for URI {string}")
	public void i_perform_GET_request_for_URI(String uri) {
		System.out.println(uri);

		response = restClient.performGetHttpRequest(uri);

	}

	@Then("I should see response contains parameter {string} with value {string}")
	public void i_should_see_response_contains_parameter_with_value(String key, String expectedValue) {

		String value = response.jsonPath().getJsonObject(key);

		Assert.assertEquals(value, expectedValue);

	}

	@Then("I should see response contains parameter {string} with value {string} from list with primary key is {string} with {string}")
	public void i_should_see_response_contains_parameter_with_value_list(String key, String expectedValue,
			String primaryKey, String primaryValue) {

		List<Map<String, String>> test = response.jsonPath().getList("$");

		boolean flag = false;

		for (Map m : test) {

			if (m.get(primaryKey).equals(Integer.valueOf(primaryValue)) && m.get(key).equals(expectedValue)) {

				Assert.assertTrue(true);

				flag = true;
			}
		}

		if (flag == false) {
			Assert.assertFalse(true);
		}

	}

}
