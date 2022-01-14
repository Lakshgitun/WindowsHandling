package org.windows.handling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlings {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmipathy\\Desktop\\makemytripproject\\WindowsHandling\\driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Window.html");
		//It has starting windows IDs
		String oldWindow = driver.getWindowHandle();//cntrl 1st window
		
		
		
		WebElement clkHome = driver.findElement(By.id("home"));
		
		clkHome.click();
		
		
		//it has starting page & clkHome (windows IDs)
		Set<String> handles = driver.getWindowHandles();//cntrl muliple window
		
		for (String newWindow : handles) {
			driver.switchTo().window(newWindow);  //changing cntrl to new window
			
		}
		WebElement editBoc = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
		editBoc.click();
		
		driver.close();
		
		driver.switchTo().window(oldWindow);//Swifting to contrl to new window
		
		WebElement openMuliple = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		
		openMuliple.click();
		
		int noOfWindow=driver.getWindowHandles().size();//finding the no of windows
		
		System.out.println("number of wind opens"+noOfWindow);
		
		WebElement dontCloce = driver.findElement(By.id("color"));
		
		dontCloce.click();
		
		Set<String> newwindowHandles = driver.getWindowHandles();
		
		for (String allWindows : newwindowHandles) {
			if(!allWindows.equals(oldWindow)) {
					driver.switchTo().window(allWindows);
			        driver.close();
			
		}
			driver.quit();
		}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		
		
		
	


