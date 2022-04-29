package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDrag {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//Finding dragable element:
		
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		/*int x = draggable.getLocation().getX();
		int y = draggable.getLocation().getY();*/
		
//Drag Around:
		Actions builder = new Actions(driver);
		builder.clickAndHold(draggable).dragAndDropBy(draggable, 50, 50).perform();
		

	}

}
