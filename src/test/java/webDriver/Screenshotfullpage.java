package webDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshotfullpage {

	public static void main(String[] args) throws IOException {
		//WebDriverManager.firefoxdriver().setup();
		////a[@id='nav-link-accountList']
		WebDriver driver =new FirefoxDriver();
		//WebDriver driver =new ChromeDriver();
		//FirefoxDriver driver =new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		WebElement xpathse = driver.findElement(By.xpath("//input[@type='text']"));
		xpathse.sendKeys("Datacard");
		WebElement scree = driver.findElement(By.xpath("//div[@id='nav-search']"));
		File src = scree.getScreenshotAs(OutputType.FILE);
		String Fi = "./Screen/webelement.png";
		File dest = new File(Fi);
		FileUtils.copyFile(src, dest);
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./Screen/veiwpageonly.png"));
		File src2 = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("./Screen/Fullpage.png"));
		driver.quit();
		

	}

}
