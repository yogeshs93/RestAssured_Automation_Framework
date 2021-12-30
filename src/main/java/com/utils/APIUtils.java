package com.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import lombok.SneakyThrows;

public final class APIUtils {
	
	private APIUtils() {
	}
	
	@SneakyThrows
	public static String readJsonAndGetAsString(String filepath) {
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	@SneakyThrows
	public static void storesStringAsJsonFile(String filepath, Response response) {
		Files.write(Paths.get(filepath), response.asByteArray());
	}

}
