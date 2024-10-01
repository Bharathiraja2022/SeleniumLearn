package KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {
	public static void main(String[] args) throws InterruptedException
	{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://text-compare.com/");
	driver.manage().window().maximize();
driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("welcome");

Actions act=new Actions(driver);
act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

}
}
