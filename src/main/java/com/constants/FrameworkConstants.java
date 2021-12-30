package com.constants;


import com.utils.ReadPropertyFile;

import enums.PropertiesType;
import lombok.Getter;

public class FrameworkConstants {

	private static @Getter final String REQUEST_JSON_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/resources/jsons/";
	private static @Getter final String RESPONSE_JSON_FOLDER_PATH=System.getProperty("user.dir")+"/output/";
	private static @Getter final String PropertyFilePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/index.html";
	private static String extentReportFilePath = "";



	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}


	private static String createReportPath() throws Exception {
		if(ReadPropertyFile.get(PropertiesType.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
}
