package workouts;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor; 


public class Locators {
	
	WebDriver driver;
	
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().deleteAllCookies();
	}
	
	public void elements() {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Elements']")));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			
		} catch(Exception e){
			System.out.println("Error message is: "+e.getMessage());
		}}
		
		/*	try {
	
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofMillis(500))
		.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver) {
		 return driver.findElement(By.partialLinkText("Elements"));
		}
		});		

	}*/
	
	
	
	public void quitDriver() {
		driver.quit();
	}
	

	public static void main(String[] args) {
		Locators l = new Locators();
		l.launch();
		l.elements();
		l.quitDriver();

	}

}
