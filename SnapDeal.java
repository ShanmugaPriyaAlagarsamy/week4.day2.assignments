 package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disabled-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//1. Launch https://www.snapdeal.com/
		
		driver.get("https://www.snapdeal.com/");
		
//2. Go to Mens Fashion
       
		driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]")).click();

//3. Go to Sports Shoes
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
//4. Get the count of the sports shoes
		
		String sportShoesCount = driver.findElement(By.xpath("//h1[@category='Sports Shoes for Men']/following-sibling::span")).getText();
		
		System.out.println("The number of the sport shoes under Men's Fashion is: " + sportShoesCount.substring(2,6));
		
		Thread.sleep(2000);

//5. Click Training shoes
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		Thread.sleep(3000);
		
//6.Sort by Low to High
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
//7. Check if the items displayed are sorted correctly
		
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		String firstPrdPrice = priceList.get(0).getAttribute("data-price");
		String lastPrdPrice = priceList.get(priceList.size()-1).getAttribute("data-price");
		
		if(Integer.parseInt(firstPrdPrice) < Integer.parseInt(lastPrdPrice))
		{
			System.out.println("The Items displayed are Sorted with Price Low To High");
		}		
		
		else
		{
			System.out.println("The Items displayed are not Sorted in Correct Order");
		}
		
		Thread.sleep(2000);
	
		
//8.Select the price range (900-1200):
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		
//9.Filter with color Navy:
		
		driver.findElement(By.xpath("//div[@data-name='Color_s']/following-sibling::button")).click();
		Thread.sleep(3000);
		
		WebElement navyColorChkbx = driver.findElement(By.xpath("//input[@value='Navy']"));
		
		boolean navyChkbx = navyColorChkbx.isEnabled();
		
		System.out.println(navyChkbx);
		
		if (navyChkbx) {
			
			driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		} 
			else {
			
			System.out.println("Navy Color is Disabled, So Navy color cannot be selected for filter.");
		}
		
//10 verify the all applied filters 
		
		String priceFilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[1]")).getText();
		String colorFilter = driver.findElement(By.xpath("(//div[@class='filters']//div)[2]/a")).getText();
		
		if((priceFilter.equals("Rs. 900 - Rs. 1200")) && (colorFilter.equals("Navy") || navyChkbx==false)) 
		{
			System.out.println("The filters are applied as expected");
					}
		
		else
		{
			System.out.println("The filters are not applied as expected ");
					}
	
//11. Mouse Hover on first resulting Training shoes
		
		WebElement firstResltngShoe = driver.findElement(By.xpath("//picture[@class='picture-elem']/img"));
		Actions builder = new Actions(driver);
		builder.moveToElement(firstResltngShoe).perform();

//12. click QuickView button
		
	 driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
				
//13. Print the cost and the discount percentage
	 
	 String shoeCost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	 String discountPercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	 Thread.sleep(3000);
	 System.out.println("The cost of the shoe is : Rs." + shoeCost.substring(0, 5)+ " and " + "its discount percentage is: " + discountPercentage);
	 
//14. Take the snapshot of the shoes.
	 
	 File source = driver.getScreenshotAs(OutputType.FILE);
	 File destination = new File("./shoescreenshot/shoe.png");
	 FileUtils.copyFile(source, destination);
	 
	 
//15. Close the current window
	 
	 driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();
	 
//16. Close the main window
	 
	 driver.close();
		
		
		
		
		


		
		

	}

}
