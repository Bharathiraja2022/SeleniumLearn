package KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	public static void main(String[] args) throws InterruptedException
	{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
	driver.manage().window().maximize();
	Actions act=new Actions(driver);
	//Min slider
WebElement min=driver.findElement(By.xpath("//div[@class='price-range-block']//div[2]//span[1]"));
System.out.println("Default location of the min_slider"+min.getLocation());//59,288
act.dragAndDropBy(min, 100,288).perform();

//Max slider
WebElement max_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//div[2]//span[2]"));
System.out.println("Default location of the min_slider"+min.getLocation());//59,288
act.dragAndDropBy(min, -100,288).perform();
}
}