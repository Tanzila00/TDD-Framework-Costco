package unit;

import org.testng.annotations.Test;

import constants.KeyConfig;
import utils.ReadConfig;


public class ReadConfigUnitTest {
	@Test
	public void getPropertiesTest() {
		ReadConfig config=new ReadConfig();
		String urlString=config.getValue(KeyConfig.url);
		System.out.println(urlString);
		
		
	}

}
