package HandlingScreenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAD {
	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		File file=new File("D:\\Automation_file\\uBlock-Origin-Chrome-Web-Store.crx");
		options.addExtensions(file);
	WebDriver driver=new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://text-compare.com");
	driver.manage().window().maximize();
	
}
}
