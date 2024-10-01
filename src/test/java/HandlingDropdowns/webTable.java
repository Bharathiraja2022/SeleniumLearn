package HandlingDropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTable {
	public static void main(String[] args)
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://testautomationpractice.blogspot.com");
	driver.manage().window().maximize();
	int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
	System.out.println(rows);
	}
}