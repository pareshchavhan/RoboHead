/**
 *
 * Copyright: Copyright (c) 2018 by AQUENT, L.L.C.
 * Company: AQUENT, L.L.C.
 *  
 * @created 17-April-2018
 * @version 1.0
 *
 */
package com.aquent.rambo.autotest.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorProperties {
	
	private final static Properties properties = new Properties();
	static {
		
		try {
			FileInputStream in = new FileInputStream("properties/locator.properties");
			properties.load(in);
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		
		return properties.getProperty(key);
	}
}
