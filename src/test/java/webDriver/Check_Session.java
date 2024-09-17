package webDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Check_Session {
	WebDriver driver;
	Set<Cookie> allcookies;
@Test (priority=1)
	public  void sessioncookies() throws InterruptedException {
	 driver =new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	Thread.sleep(2000);
	WebElement Loginbt = driver.findElement(By.id("username"));
	Loginbt.sendKeys("DemoSalesManager");
	//Loginbt.click();
	WebElement email = driver.findElement(By.id("password"));
	email.sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Aravind24");
	//driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	allcookies = driver.manage().getCookies();
	for (Cookie cookie : allcookies) {
		System.out.println("All cookies: "+cookie );
	}
	Thread.sleep(2000);
	driver.quit();
}
	
	@Test(priority=2)
	public  void sessioncookies2() throws InterruptedException {
	driver =new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	Thread.sleep(2000);
	for (Cookie cookie1 : allcookies) {
		driver.manage().addCookie(cookie1);
	}
	driver.navigate().to("http://leaftaps.com/opentaps/control/login");
	
		
	}	
}
