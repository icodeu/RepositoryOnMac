import java.util.Map;


public class MainTest {

	private static final String KEY = "designpattern";
	
	public static void main(String[] args) {
		
		PropertiesReader reader = PropertiesReader.getInstance();
		Map<String, String> map = reader.getProperties();
		System.out.println(map);
		
		System.out.println(map.get(KEY));
	}

}
