package WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {
	public static void main(String[] args) 
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demo3x.opencartreports.com/admin/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\'input-username\']")).sendKeys("demo");
	driver.findElement(By.xpath("//*[@id=\'input-password\']")).sendKeys("demo");
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")).click();
	
	}
}