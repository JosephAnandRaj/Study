	package utilities;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	
	public class ConfigReader {
		
		static Properties properties = new Properties();
		
		static {
			try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
				properties.load(file);
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		public static String get(String Key) {
			return properties.getProperty(Key);
		}
	
	}
