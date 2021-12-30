package com.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {
	
	private ExtentLogger() {
		
	}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);

	}
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void logResponse(String message) {
		ExtentManager.getExtentTest().pass(MarkupHelper.createCodeBlock(message,CodeLanguage.JSON));
	}

	public static void logRequest(RequestSpecification requestspecification) {
		QueryableRequestSpecification query=SpecificationQuerier.query(requestspecification);
		info("Request Details Below");
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(query.getBody(),CodeLanguage.JSON));
		for(Header header:query.getHeaders()) {
			info(header.getName()+" "+header.getValue());
		}
		
		
	}
}
