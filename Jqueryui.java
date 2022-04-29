package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jqueryui {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disabled-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Finding Frame
		driver.switchTo().frame(0);
		
		//Finding resizable element
		WebElement resizable = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		int x = resizable.getLocation().getX();
		int y = resizable.getLocation().getY();
		
		
		//Dragging the element
		Actions builder = new Actions(driver);
		builder.clickAndHold(resizable).moveByOffset(x+10, y+10).release().build().perform();
		
		
		
		
		
		

	}

}
