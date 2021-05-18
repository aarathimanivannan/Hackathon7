package Logs;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	
	//Creating Logger Methods
	public static void info(String Message) {
		System.out.println("**************Logger Info**************");
		Log.info(Message);
	}
	
	public static void error(String Message) {
		System.out.println("**************Logger Error**************");
		Log.error(Message);
	}

	public static void warn(String Message) {
		System.out.println("**************Logger Warn**************");
		Log.warn(Message);
	}
	
	public static void debug(String Message) {
		System.out.println("**************Logger Debug**************");
		Log.debug(Message);
	}
}
