package maven_java_framework.java_selenium_examples;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiTest {

	@Test
	public static void main(String[] args) {
		// Base URL for the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Replace with your API endpoint

		// Create the JSON body for the POST request
		String jsonBody = "{\n" + "    \"title\": \"foo\",\n" + "    \"body\": \"bar\",\n" + "    \"userId\": 1\n"
				+ "}";

		// Sending the POST request
		Response response = given().contentType(ContentType.JSON) // Set content type to JSON
				.body(jsonBody) // Attach the JSON body
				.when().post("/posts") // Specify the endpoint
				.then().statusCode(201) // Validate response status code
				.extract().response(); // Extract the response

		// Print the response
		System.out.println("Response Body: " + response.asString());
		System.out.println("Response Code: " + response.getStatusCode());

	}
}
