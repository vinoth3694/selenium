package seleniumlocators;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Program1 {
		
	@Test
	public void testSet() throws Exception {
				// Launch a browser
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().deleteAllCookies();
	
			// Launch the url
			d.get("https://jqueryui.com/");
			
			//click on datepicker
			d.findElement(By.xpath("//a[contains(text(),'Datepicker')]")).click();
			
			//verify the title of page 
			assertEquals(d.getTitle(),"Datepicker | jQuery UI");
			
			//switching focus to inside frame
			WebElement stringFrame =d.findElement(By.className("demo-frame"));
			d.switchTo().frame(stringFrame);
			
			//Click on Date field
			WebElement dateField = d.findElement(By.xpath("//input[@id='datepicker']"));
			dateField.click();
			
			//Click on next icon to change the current month to next month
			d.findElement(By.xpath("//a[@data-handler='next']")).click();
			
			//Click on date 22 in the calender pop-up
			WebElement date22 = d.findElement(By.xpath("//a[@data-date='22']"));
			date22.click();
			
			//printing the selected date by getting attribute
			String selectedDate = dateField.getAttribute("value");
			
			System.out.println("The Selected Date is: "+ selectedDate);
			
		//Close the browser	
		d.quit();
	}
}





