package com.requestbuilder;

import static io.restassured.RestAssured.*;

import com.utils.ReadPropertyFile;

import enums.PropertiesType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {
	
	private RequestBuilder() {
	}
	
	public static RequestSpecification buildRequestForGetCalls() {
		try {
			return given().baseUri(ReadPropertyFile.get(PropertiesType.BASEURL)).log().all();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static RequestSpecification buildRequestForPostCalls() {
		return buildRequestForGetCalls()
				.header("Content-Type","application/json");
	}

}
