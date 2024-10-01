package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleClickDemo {
	public static void main(String[] args) throws InterruptedException
	{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://testautomationpractice.blogspot.com");
	driver.manage().window().maximize();
	//input[@id='field1']
		//input[@id='field2']
		//button[normalize-space()='Copy Text']
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		box1.clear();
		box1.sendKeys("raja");
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement ClickButton=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Thread.sleep(2000);
	Actions act=new Actions(driver);
	act.doubleClick(ClickButton).perform();
	String text=box2.getAttribute("value");
	if(text.equalsIgnoreCase("raja"))
	{
		System.out.println("text copied");
	}
	else
	{
		System.out.println("text is not copied");
	}
	
}
}
