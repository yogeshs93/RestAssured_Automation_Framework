package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotations;
import com.requestbuilder.RequestBuilder;

import io.restassured.response.Response;

public class GetBook {
	
	@Test
	@FrameworkAnnotations(author = "yogesh", category="smoke")
	public void getBook() {
		Response response=
		RequestBuilder.buildRequestForGetCalls()
		.get("/Library/GetBook.php?ID=CDS3356376");
		
		response.prettyPrint();
		Assertions.assertThat(response.getStatusCode())
		          .isEqualTo(200);
		
		
	}

}
