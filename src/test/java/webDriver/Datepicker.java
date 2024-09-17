package webDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker {
	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("second_date_picker")).click();
		Datepicker dfp= new Datepicker();
		dfp.datepick("30-Dec-2025", "dd-MMM-yyyy");
	}
public void datepick(String DateA, String DateFormat ) throws Exception {
	
	Calendar calender = Calendar.getInstance();
	//String TDate ="30-Nov-2025";
	SimpleDateFormat formatdate = new SimpleDateFormat(DateFormat);
	formatdate.setLenient(false);
	Date finalformat;
	try {
		finalformat = formatdate.parse(DateA);
		//System.out.println(finalformat);
		calender.setTime(finalformat);
		int targetday = calender.get(Calendar.DAY_OF_MONTH); 
		int targetmonth=calender.get(Calendar.MONTH); 
		int targeyyear = calender.get(Calendar.YEAR);

		
		String ActualMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
		SimpleDateFormat actualmon= new SimpleDateFormat("MMM yyyy"); 
		Date actualmonandyear = actualmon.parse(ActualMonth);
		calender.setTime(actualmonandyear);
		int actualmonth = calender.get(Calendar.MONTH);
		int actualyear = calender.get(Calendar.YEAR);

		while(targetmonth < actualmonth ||targeyyear < actualyear) {
			driver.findElement(By.className("ui-datepicker-prev")).click();
			ActualMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
			actualmon= new SimpleDateFormat("MMM yyyy"); 
			actualmonandyear = actualmon.parse(ActualMonth);
			calender.setTime(actualmonandyear);
			actualmonth = calender.get(Calendar.MONTH);
			actualyear = calender.get(Calendar.YEAR);
		}
		while(targetmonth > actualmonth ||targeyyear > actualyear) {
			driver.findElement(By.className("ui-datepicker-next")).click(); ActualMonth =
					driver.findElement(By.className("ui-datepicker-title")).getText(); actualmon=
					new SimpleDateFormat("MMM yyyy"); actualmonandyear =
					actualmon.parse(ActualMonth); calender.setTime(actualmonandyear); actualmonth
					= calender.get(Calendar.MONTH); actualyear = calender.get(Calendar.YEAR);

		}

		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()="+targetday+"]")).click();


	} catch (ParseException e) {
		throw new Exception  ("Type Valid date da punda");
		//e.printStackTrace();
	}




}
	
}
