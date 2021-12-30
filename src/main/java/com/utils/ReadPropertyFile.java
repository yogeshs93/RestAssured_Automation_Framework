package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstants;

import enums.PropertiesType;

public final class ReadPropertyFile {
	
	private ReadPropertyFile() {
	}
	
	private static Properties properties= new Properties();
	private static Map<String,String> map = new HashMap<>();
	
	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getPropertyFilePath())){
			properties.load(file);
		}
		
		catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		properties.entrySet().forEach(e->map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
	}
	public static String get(PropertiesType key)  {
		return map.get(key.name().toLowerCase());
	}


}
