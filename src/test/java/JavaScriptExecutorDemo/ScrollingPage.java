package JavaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.nopcommerce.com/en/demo");
driver.manage().window().maximize();
JavascriptExecutor js=(JavascriptExecutor)driver;
/*js.executeScript("window.scrollBy(0,1200)","");
System.out.println(js.executeScript("return window.pageYOffset;"));
*/
//h2[normalize-space()='The Perfect Solution!']
WebElement h1=driver.findElement(By.xpath("//h2[normalize-space()='The Perfect Solution!']"));
//js.executeScript("arguments[0].scrollIntoView();",h1);
js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
}