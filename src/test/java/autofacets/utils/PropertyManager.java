package autofacets.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author niravpatel
 */

public class PropertyManager {

	public Properties getResourceBundle;

	public PropertyManager() {
		try {
			File baseSrc = new File("./env/default/base.properties");
			FileInputStream baseFIS = new FileInputStream(baseSrc);
			getResourceBundle = new Properties();
			getResourceBundle.load(baseFIS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Print all key value pairs
	 */

	public void printKeyValue() {
		@SuppressWarnings("rawtypes")
		Enumeration KeyValues = getResourceBundle.keys();
		while (KeyValues.hasMoreElements()) {
			String key = (String) KeyValues.nextElement();
			String value = getResourceBundle.getProperty(key);
			System.out.println(key + ":- " + value);
		}
	}
}
