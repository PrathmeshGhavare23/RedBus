package UtilsLayer;

import java.io.FileInputStream;
import java.util.Properties;

import BaseLayer.BaseClass;

public class PropertiesHelper extends BaseClass {
	public static String getProperty(String KeyName,String Filename) {
		Properties property = new Properties();
		String destinationPath = System.getProperty("user.dir") + "//src//main//java//ConfigLayer//" + Filename;

		try {
			FileInputStream fis = new FileInputStream(destinationPath);
			property = new Properties();
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return property.getProperty(KeyName);
	}
}
