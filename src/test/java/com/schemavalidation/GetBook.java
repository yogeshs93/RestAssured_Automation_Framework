package com.schemavalidation;

import java.io.File;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.requestbuilder.RequestBuilder;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBook {
	
	
	@Test
	public void GetBook1() {
		
		RequestSpecification requestspecification =
		RequestBuilder.buildRequestForGetCalls();
		
		
		//ExtentLogger.logRequest(requestspecification);
		Response response = requestspecification
		.get("/Library/GetBook.php?ID=CDS3356376");
		
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		//System.out.println(response.asPrettyString());
		response.prettyPrint();
		//ExtentLogger.logResponse(response.asPrettyString());
		//validate the schema
		
		response.then().body(JsonSchemaValidator
				.matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/test/resources/schemas/GETBOOK.json")));
		

	}

}
