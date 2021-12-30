package com.tests;

import java.lang.reflect.Method;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotations;
import com.constants.FrameworkConstants;
import com.requestbuilder.RequestBuilder;
import com.utils.APIUtils;
import com.utils.RandomUtils;

import io.restassured.response.Response;

public class AddBookUsingExternalFiles {
	
	@Test
	@FrameworkAnnotations(author = "yogesh", category="Regression")
	public void addBook(Method method) {
		String resource=APIUtils.readJsonAndGetAsString(FrameworkConstants.getREQUEST_JSON_FOLDER_PATH()+method.getName()+".json")
				.replace("randomstring", RandomUtils.getFirstname())
				.replace("randomnumber", String.valueOf(RandomUtils.getID()));
		Response response=
		RequestBuilder.buildRequestForPostCalls()
		              .body(resource)
		              .post("/Library/Addbook.php");
		response.prettyPrint();
		
		APIUtils.storesStringAsJsonFile(FrameworkConstants.getRESPONSE_JSON_FOLDER_PATH()+method.getName()+"response.json",response);
		   
		Assertions.assertThat(response.getStatusCode())
		          .isEqualTo(200);
	}

}
