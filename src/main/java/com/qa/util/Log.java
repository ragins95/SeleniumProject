package com.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Log {

	private static  Logger log = LogManager.getLogger(Log.class);

	public static void startTestCase(String sTestCaseName) {
		Log.info("--------------------------------------------------------------");
		Log.info("---------------------"+sTestCaseName+"-----------------------------");
		Log.info("--------------------------------------------------------------");

	}

	public static void info(String message) {
		log.info( message);
	}
	public static void error(String message) {
		log.error( message );
	}
	
	
	
}
