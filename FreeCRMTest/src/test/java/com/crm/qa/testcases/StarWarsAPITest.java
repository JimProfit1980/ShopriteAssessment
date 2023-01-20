package com.crm.qa.testcases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.testdata.StarWarsAPI;



public class StarWarsAPITest extends TestBase {

	@Test
	public void HeroValidation() {
		RestAssured.baseURI = baseURI().concat(StarWarsAPI.peopleEndpoint());
		String response = given()
		.when().get()
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath jsonResponse = new JsonPath(response);
		String name = jsonResponse.getString(StarWarsAPI.namePath());
		String skinColor = jsonResponse.getString(StarWarsAPI.skinColorPath());
		Assert.assertEquals(StarWarsAPI.heroName(),name,"Could not validate our hero's name");	
		Assert.assertEquals(StarWarsAPI.heroSkinColor(), skinColor,"Could not validate the hero's Skin Color");		
	}
	

}
