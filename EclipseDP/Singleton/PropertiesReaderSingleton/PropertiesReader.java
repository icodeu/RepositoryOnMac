import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesReader {
	
	private static final String PROPS_NAME = "type.properties";
	
	private PropertiesReader(){}
	
	private static class HolderClass{
		private static final PropertiesReader instance = new PropertiesReader();
	}
	
	public static PropertiesReader getInstance(){
		return HolderClass.instance;
	}
	
	public Map<String, String> getProperties(){
		Map<String, String> map = new HashMap<String, String>();
		Properties properties = new Properties();
		
		try {
			InputStream is = getClass().getResourceAsStream(PROPS_NAME);
			properties.load(is);
			Enumeration en = properties.propertyNames();
			while (en.hasMoreElements()){
				String key = (String) en.nextElement();
				String value = properties.getProperty(key);
				map.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	

}
