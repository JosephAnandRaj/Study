package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
        if (driver == null) {

			String browser = ConfigReader.get("browser");
			String incognitoSetting = ConfigReader.get("incognito");
			boolean incognito = incognitoSetting.equalsIgnoreCase("true");
	
	
			switch(browser.toLowerCase()) {
				case "firefox":
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					if (incognito) {
						firefoxOptions.addArguments("--private-window");
						firefoxOptions.setAcceptInsecureCerts(true);
					}
					driver = new FirefoxDriver(firefoxOptions);
					break;
					
				case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions();
					if (incognito) {
						chromeOptions.addArguments("--incognito");
						chromeOptions.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
						chromeOptions.addArguments("--allow-running-insecure-content"); // Allow HTTP content
					}
					driver = new ChromeDriver(chromeOptions);
					break;
					
				case "edge":
					EdgeOptions edgeOptions = new EdgeOptions();
					if (incognito) {
						edgeOptions.addArguments("-inprivate");
						edgeOptions.addArguments("--ignore-certificate-errors"); // Ignore SSL warnings
						edgeOptions.addArguments("--allow-running-insecure-content"); // Allow HTTP content

					}
					driver = new EdgeDriver(edgeOptions);
					break;
					
				default:
					driver = new ChromeDriver();
					break;
				}
			driver.manage().window().maximize();
        }
		return driver;
		
	}
		public static void quitDriver() {
	        if (driver != null) {

				driver.quit();
				driver = null;
	        }
		}

}
