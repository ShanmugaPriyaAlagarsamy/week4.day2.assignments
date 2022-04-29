package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDrop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/drop.html");
		
// Finding draggable Element:
		
		WebElement draggableEle = driver.findElement(By.id("draggable"));

// Finding droppable Target:
		
		WebElement dropTarget = driver.findElement(By.id("droppable"));
// Actions:
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggableEle, dropTarget).perform();
		


		
		
		
		
		
		

	}

}
