package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {
	
	private FakerUtils() {
	}
	
	private static final Faker faker = new Faker();

	 static int getNumber(int startvalue,int endvalue) {
		return faker.number().numberBetween(startvalue, endvalue);
	}
	
	 static String getFirstname() {
		return faker.name().firstName();
	}
}
