package com.utils;

public final class RandomUtils {
	
	private RandomUtils() {
	}
	
	public static int  getID() {
		return FakerUtils.getNumber(1000, 10000);
	}
	
	public static String getFirstname() {
		return FakerUtils.getFirstname().toLowerCase();
	}

}
