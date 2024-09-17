package comIRCTC;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC_WebElement {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Integer> contentSetting = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		contentSetting.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSetting);
		prefs.put("profile", profile);
		
		option.setExperimentalOption("prefs", prefs);
		
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		
		
		  WebElement flight =
		  driver.findElement(By.xpath("//li[@class='menu-list header-icon-menu']/child::a[text()=' FLIGHTS ']"));
		  WebElement Bus = driver.findElement(By.
		  xpath("//li[@class='menu-list header-icon-menu']/child::a[text()=' BUSES ']")
		 ); WebElement Hotel = driver.findElement(By.
		  xpath("//li[@class='menu-list header-icon-menu']/child::a[text()=' HOTELS ']"
		  ));
		 int Busvalue = Bus.getLocation().getX();
		 int flightvalue = flight.getLocation().getX();
		 int Hotelvalue = Hotel.getLocation().getX();
		 System.out.println("Buspostion: "+Busvalue +" "+"FlightPostion: " +flightvalue +" " +"Hotelpostion: "+ Hotelvalue);
		 
		  if(Busvalue < flightvalue &&
				  flightvalue < Hotelvalue) {
		  System.out.println("Placement is corect");
		  
		 } else { System.out.println("Placement is not correct"); }
		 
		driver.quit();

	}

}
