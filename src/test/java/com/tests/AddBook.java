package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotations;
import com.pojo.AddBookpojo;
import com.reports.ExtentLogger;
import com.requestbuilder.RequestBuilder;
import com.utils.RandomUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class AddBook {
	
	private AddBook() {
	}
	
	@Test
	@FrameworkAnnotations(author = "yogesh", category="smoke")
	public void addBook() {
		AddBookpojo addbook= AddBookpojo
		.builder()
		.setName("automation testing")
		.setIsbn(RandomUtils.getFirstname())
		.setAisle(String.valueOf(RandomUtils.getID()))
		.setAuthor("rahul")
		.build();
		RequestSpecification requestspecification=
				RequestBuilder.buildRequestForPostCalls()
		       .body(addbook);
		       
		       ExtentLogger.logRequest(requestspecification);
		       Response response=requestspecification .post("/Library/Addbook.php");
		
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
			   
		Assertions.assertThat(response.getStatusCode())
		          .isEqualTo(200);
	}

}
