package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightClickDemo {
	public static void main(String[] args) throws InterruptedException
	{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	driver.manage().window().maximize();

	
	
	WebElement rightClick=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
	Actions act=new Actions(driver);
	act.contextClick(rightClick).perform();
	
	WebElement ClickCopy=driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"));
	ClickCopy.click();
	driver.switchTo().alert().accept();
	}
}