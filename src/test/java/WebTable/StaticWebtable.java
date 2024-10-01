package WebTable;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class StaticWebtable {
	public static void main(String[] args) 
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1200)","");
int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

System.out.println(rows);



int colums=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();

System.out.println(colums);
for(int r=2;r<=rows;r++)
{
	for(int c=1;c<=colums;c++)
	{
		String tab=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
		System.out.println(tab+"\t");
	}
	System.out.println();
}

//total price of all book
//table[@name='BookTable']//tr[2]//td[4]
WebElement price=driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[4]"));
int total=0;
for(int r=2;r<=rows;r++)
{
		String tab=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		System.out.println(tab);
		total=total+Integer.parseInt(tab);
}


	}
}