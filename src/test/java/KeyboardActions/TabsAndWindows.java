package KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.switchTo().newWindow(WindowType.TAB);
driver.get("https://demo.nopcommerce.com/");

	}
	}