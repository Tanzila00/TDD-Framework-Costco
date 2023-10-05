package utils;

import java.io.IOException;
import java.util.Properties;
import constants.KeyConfig;

public class ReadConfig {// This is the method to read Key values !!
	//Properties properties;// declared
Properties	properties = new Properties();

	public ReadConfig() {
		loadProperties();
	}

	public void loadProperties() {

		//properties = new Properties();
		try {// to get access to config properties below is the method!!
			properties.load(getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(KeyConfig key) {
		return properties.getProperty(key.toString());//ENUM
	

	}
}
