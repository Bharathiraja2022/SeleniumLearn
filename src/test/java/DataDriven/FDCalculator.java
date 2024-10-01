package DataDriven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

//	
		
	public static void main(String[] args) throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		File file=new File("D:\\Automation_file\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		options.addArguments("--disable-notifications");
		
	WebDriver driver=new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	driver.manage().window().maximize();
	String filepath=System.getProperty("user.dir")+"\\testData\\testData.xlsx";
	int rows=ExcelUtils.getRowCount(filepath,"Sheet1");
	// read data from excel
	
	for(int i=1;i<rows;i++)
	{
	String prin=ExcelUtils.getCelldata(filepath, "Sheet1", i, 0);
	String Rate=ExcelUtils.getCelldata(filepath, "Sheet1", i, 1);
	String per1=ExcelUtils.getCelldata(filepath, "Sheet1", i, 2);
	String per2=ExcelUtils.getCelldata(filepath, "Sheet1", i, 3);
	String freq=ExcelUtils.getCelldata(filepath, "Sheet1", i, 4);
	String expected_value=ExcelUtils.getCelldata(filepath, "Sheet1", i, 5);
	
	//pass above data into application
	WebElement principal=driver.findElement(By.xpath("//*[@id=\"principal\"]"));
	principal.sendKeys(prin);
	WebElement rateOfInt=driver.findElement(By.xpath("//input[@name=\"interest\"]"));
	rateOfInt.sendKeys(Rate);
	WebElement period1=driver.findElement(By.xpath("//*[@id=\"tenure\"]"));
	period1.sendKeys(per1);
	WebElement period2=driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]"));
	Select select=new Select(period2);
	select.selectByVisibleText(per2);
	
	WebElement freq1=driver.findElement(By.xpath("//select[@id='frequency']"));
	Select select1=new Select(freq1);
	select1.selectByVisibleText(freq);
	driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).click();
	//driver.switchTo().alert().accept();
	String actual_value=driver.findElement(By.xpath("//span[@name='resp_matval']//strong")).getText();
	
	//validation
	if(Double.parseDouble(actual_value)==Double.parseDouble(expected_value))
	{
		System.out.println("Test Passed");
		ExcelUtils.setCelldata(filepath, "Sheet1", i, 7, "passed");
		ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);	
	}
	else
	{
		System.out.println("Test Failed");
		ExcelUtils.setCelldata(filepath, "Sheet1", i, 7, "failed");
		ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);	
	}
	driver.findElement(By.xpath("//a[@onclick='javascript:reset_fdcalcfrm();']//img")).click();
	
	}
}
}