package HandlingDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		WebElement clickDropdown=driver.findElement(By.xpath("//select[@id='country']"));
		clickDropdown.click();
		Select drop=new Select(clickDropdown);
		drop.selectByIndex(2);
		
		List<WebElement>total=drop.getOptions();
		System.out.println(total.size());
		for(int i=0;i<total.size();i++)
		{
			total.get(i).getText();
		}
		
		for(WebElement op:total)
		{
			System.out.println(op.getText());
		}
	}
}
