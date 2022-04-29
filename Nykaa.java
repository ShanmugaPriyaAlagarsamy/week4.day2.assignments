package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brandsElement = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brandsElement).perform();
		WebElement brandSearchEle = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		builder.moveToElement(brandSearchEle).click().sendKeys("L'Oreal Paris").perform();
		driver.findElement(By.xpath("(//div/a[contains(text(),'Oreal Paris')])[1]")).click();
		String pageTitle = driver.getTitle();
		System.out.println("The current page title is: "+ pageTitle);
		
		if(pageTitle.contains("L'Oreal Paris"))
		{
			System.out.println("The title of the current page contains L'Oreal Paris and so landed on the right page");
			
		}
		
		else
		{
			System.out.println("The title of the current page does not contains L'Oreal Paris and so the page is not required page");
		}
		
		driver.findElement(By.xpath("//div[@id='filter-sort']//div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id = 'radio_customer top rated_undefined']/following::div[@class='control-value']/following-sibling::div)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Shampoo']/following::div)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[1]")).click();
		Thread.sleep(2000);
		String filterValue = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println(filterValue);
		if(filterValue.equalsIgnoreCase("Shampoo"))
		{
			System.out.println("The filter is applied with Shanmpoo");
		}
		else 
		{
			System.out.println("The filter is not applied with shampoo");
					}
		
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowHandlesList = new ArrayList<String>(windowHandles);
	driver.switchTo().window(windowHandlesList.get(1));
	WebElement sizeDD = driver.findElement(By.xpath("//select[@title='SIZE']"));
	Select dd = new Select(sizeDD);
	dd.selectByVisibleText("175ml");
	String mrp = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
	System.out.println("The MRP: of 175ml Loreal paris shampoo is: "+ mrp.substring(1));
	driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
	Thread.sleep(2000);
	WebElement frameEle = driver.findElement(By.xpath("//div[@id='portal-root']//iframe"));
	driver.switchTo().frame(frameEle);
	String grandTotal1 = driver.findElement(By.xpath("//div[@class='name medium-strong']/following-sibling::div")).getText();
	System.out.println("The grand total is: Rs." + grandTotal1.substring(1));
	String grandTotal = grandTotal1.substring(1);
	driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	Thread.sleep(2000);
	String grandTotalFinal= driver.findElement(By.xpath("(//div[text()='Grand Total']/following::span)[1]")).getText();
	
	
	System.out.println("The grand total on final payment is:"+grandTotalFinal);
	
	if(grandTotal.equals(grandTotalFinal))
{
	System.out.println("The grand total amount displayed on final payment page is same as the total amount shown earlier");
	}
else
{
	System.out.println("The grand total amount displayed on final payment page is same as the total amount shown earlier");
	}
			
	//driver.switchTo().window(windowHandlesList.get(0));
	//driver.close();
	
	driver.quit();
	
	
}	


}
