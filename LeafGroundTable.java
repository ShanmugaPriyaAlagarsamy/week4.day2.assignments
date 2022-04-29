package week4.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		
//Get the count of number of columns:
		
		List<WebElement> listofColoumn = driver.findElements(By.tagName("th"));
		System.out.println("The number of column in the table is: " + listofColoumn.size());
		
		
//Get the count of number of rows:
		List<WebElement> listofrows = driver.findElements(By.tagName("tr"));
		System.out.println("The numner of rows in the table is: " + listofrows.size() );
		
//Get the progress value of 'Learn to interact with Elements'
		
		List<WebElement> learnToInteractEles = driver.findElements(By.xpath("//font[contains(text(),'Learn to interact with')]"));
				
		for ( int i=2; i <= learnToInteractEles.size()+1;i++) 
		{
			String value = learnToInteractEles.get(i-2).getText();
			if(value.equals("Learn to interact with Elements"))
			{
					
				String progressValue = driver.findElement(By.xpath("(//tr)[" + (i + 1) + "]/td[2]/font")).getText();
				System.out.println("The progress value of Learn to interact with element is:" + progressValue);
			}
					
		}
		
// Check the vital task for the least completed progress.
		
		List<Integer> progressValues = new ArrayList<Integer>();
		
		for(int i=2; i<=6; i++)
		{

			String progressValueEachRow = driver.findElement(By.xpath("//tr[" + i + "]/td[2]/font")).getText();
			
			int value = Integer.parseInt(progressValueEachRow.substring(0, progressValueEachRow.length() - 1));
			
			progressValues.add(value);
			
					}
		
		Collections.sort(progressValues);
		int leastValue = progressValues.get(0);
		
		for(int i=2; i<=6; i++)
		{

			String progressValueofEachRow = driver.findElement(By.xpath("//tr[" + i + "]/td[2]/font")).getText();
			if(progressValueofEachRow.contains(Integer.toString(leastValue)))
			{
				
				driver.findElement(By.xpath("//tr[" + i + "]//input[@name='vital']")).click();
				String topic = driver.findElement(By.xpath("//tr[" + i + "]/td[1]/font")).getText();
				
			System.out.println("The least progress slenium topic is " +topic + "with progress value of" + leastValue);
				
			}
			
		}
		
			
	
		
		
		
		
		
		
		
	}

}
