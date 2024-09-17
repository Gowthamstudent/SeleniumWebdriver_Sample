package webDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		driver.manage().window().maximize();
		List<WebElement> pagniations = driver.findElements(By.xpath("//div[@id='dtBasicExample_paginate']/descendant::a"));
		int pagesize = pagniations.size();
		System.out.println("Pagination Size:"+pagesize);
		List<WebElement> tablerowname;
		WebElement nextelement;
		if(pagesize>0) {
			do { 
				tablerowname= driver.findElements(By.className("sorting_1"));
				//tablerowname = driver.findElements(By.xpath("//table[@id='dtBasicExample']/child::tbody//tr//td"));
				int size = tablerowname.size();
				System.out.println("New Page Table rowsize:"+" "+size);
				for (WebElement rowname : tablerowname) {
					String text = rowname.getText();
					System.out.println(text); }
				nextelement =driver.findElement(By.id("dtBasicExample_next")); 
				String nextidentfier =nextelement.getAttribute("class");
				if(!nextidentfier.contains("disabled")) {
					nextelement.click(); 
				} 
				else { 
					break; } 
			} 
			while(true);

			/*
			 * while(!nextidentfier.contains("disabled")) { nextelement=
			 * driver.findElement(By.id("dtBasicExample_next")); nextidentfier
			 * =nextelement.getAttribute("class"); nextelement.click(); }
			 */
		}
		else {
			System.out.println("No pagination Here");
			tablerowname= driver.findElements(By.className("sorting_1"));
			for (WebElement rowname : tablerowname) {
				String text = rowname.getText();
				System.out.println(text); }
		} 
		driver.quit();
	}
}
