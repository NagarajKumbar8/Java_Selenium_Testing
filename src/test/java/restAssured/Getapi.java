package restAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



public class Getapi {

	
	@Test
	public void getapi()
	{
		RestAssured.baseURI="https://fake-json-api.mock.beeceptor.com";
		
		String response=given().
		when()
		.get("/users")
		.then()
		.log().all()
		.statusCode(200)
		.assertThat().statusCode(200)
		.extract().response().toString();
		
		//Json body and validates using jsom path 
		
		
		//JsonPath js=(response);
					
				
		
	}
	
	@Test
	public void postapi()
	{
		// Create and populate the Product and ProductData objects
      
		
		RestAssured.baseURI= "https://api.restful-api.dev";
		
		 given().body(Product.jsonbody()) 
		 
		.when()
		.post("/objects")
		.then().log().all()
		.statusCode(200)
		.assertThat().statusCode(200)
		.extract().response().toString();
		
		
	}
	
//	// POJO for the inner 'data' structure
//	public class ProductData {
//	    private int year;
//	    private double price;
//	    private String cpuModel;
//	    private String hardDiskSize;
//
//	    // Getters and Setters
//	    public int getYear() {
//	        return year;
//	    }
//
//	    public void setYear(int year) {
//	        this.year = year;
//	    }
//
//	    public double getPrice() {
//	        return price;
//	    }
//
//	    public void setPrice(double price) {
//	        this.price = price;
//	    }
//
//	    public String getCpuModel() {
//	        return cpuModel;
//	    }
//
//	    public void setCpuModel(String cpuModel) {
//	        this.cpuModel = cpuModel;
//	    }
//
//	    public String getHardDiskSize() {
//	        return hardDiskSize;
//	    }
//
//	    public void setHardDiskSize(String hardDiskSize) {
//	        this.hardDiskSize = hardDiskSize;
//	    }
//	}
//
//	// POJO for the outer 'Product' structure
//	public class Product {
//	    private String name;
//	    private ProductData data;
//
//	    // Getters and Setters
//	    public String getName() {
//	        return name;
//	    }
//
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//
//	    public ProductData getData() {
//	        return data;
//	    }
//
//	    public void setData(ProductData data) {
//	        this.data = data;
//	    }
//	}
//

	
	
}
