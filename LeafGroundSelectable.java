package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSelectable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		
		//Finding selectable elements:
		
				WebElement item4 = driver.findElement(By.xpath("//ol/li[text()='Item 4']"));
				WebElement item5 = driver.findElement(By.xpath("//ol/li[text()='Item 5']"));
				WebElement item6 = driver.findElement(By.xpath("//ol/li[text()='Item 6']"));
				
		//Actions:
				
				Actions builder = new Actions(driver);
				builder.clickAndHold(item4).moveToElement(item5).moveToElement(item6).perform();
			
		
	}

}
