package org.bimserver.custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties propertyLoad() {
		Properties props = new Properties();
		try
		{
	File configDir = new File(System.getProperty("catalina.base"), "conf");
	File configFile = new File(configDir, "Bimsql.properties");
	InputStream stream = new FileInputStream(configFile);
	props.load(stream);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	return props;
	}
}
