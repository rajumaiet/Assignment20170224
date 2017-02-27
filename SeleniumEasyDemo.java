package seleniumEasyDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class SeleniumEasyDemo {
	
	public static void main(String[] args) throws InterruptedException
	{
		//set the system property for chrome driver as:
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
		
		//defining a reference variable(driver)
		WebDriver driver=new ChromeDriver();
		
		//Maximize the chrome browser
		driver.manage().window().maximize();
		
		//Open Google URL on Chrome browser
		driver.get("http://www.seleniumeasy.com/test/");
		
		//Click 'Start Practising' button
		driver.findElement(By.cssSelector("a[id='btn_basic_example']")).click();
		
		Thread.sleep(2000);
		
		//Click on Simple Form Demo link
		driver.findElement(By.cssSelector("a[class='list-group-item'][href*='first-form-demo']")).click();
		
	//Exercise single input field
		
		//Enter Message
		driver.findElement(By.cssSelector("input[id='user-message']")).sendKeys("ABCD");
		
		//Click on Show message button
		driver.findElement(By.cssSelector("button[class='btn btn-default'][onclick='showInput();']")).click();
		
		//Verify the out put message
		WebElement el=driver.findElement(By.cssSelector("span[id='display']"));
		String St= el.getText();
		Assert.assertTrue(St.contains(St));
		
		System.out.println("Message Verified");
		
	//Exercise two input Fields
		//Enter A
		driver.findElement(By.cssSelector("input[id='sum1']")).sendKeys("10");
		
		//Enter B
		driver.findElement(By.cssSelector("input[id='sum2']")).sendKeys("20");
		
		//Click on Get Total Message
		driver.findElement(By.cssSelector("button[class='btn btn-default'][onclick='return total()']")).click();
		
		//Verify that result
		WebElement el1=driver.findElement(By.cssSelector("span[id='displayvalue']"));
		String St1= el1.getText();
		Assert.assertEquals("30", St1);
		System.out.println(St1);
		
		//Go back to previous page
		driver.navigate().back();
		
		//Again click 'Start Practising' button
		driver.findElement(By.cssSelector("a[id='btn_basic_example']")).click();
		
		Thread.sleep(2000);
		
		//Click on Check box Demo link
		driver.findElement(By.cssSelector("a[class='list-group-item'][href*='checkbox-demo.html']")).click();
		
		//Click on single check box
		driver.findElement(By.cssSelector("input[id='isAgeSelected']")).click();
		
		//Verify the checkbox will display a success message
		WebElement message =driver.findElement(By.cssSelector("div[id='txtAge']"));
		
		String mess= message.getText();
		
		Assert.assertEquals("Success - Check box is checked", mess);
		
		System.out.println(mess);
		
		//Click on 'Check All' to check all checkboxes at once.
		driver.findElement(By.cssSelector("input[value='Check All']")).click();
		
		//Verify that button name should change to 'Uncheck All'
		WebElement uncheck = driver.findElement(By.cssSelector("input[value='Uncheck All']"));
		boolean s=uncheck.isEnabled();
		System.out.println("Button name getting changed to Uncheck All: "+s);
		
		//check multiple checkbox, button will change to 'Check All'
		driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
		driver.findElement(By.xpath("(//input[@value=''])[3]")).click();
		WebElement uncheck1 = driver.findElement(By.cssSelector("input[value='Check All']"));
		boolean s1=uncheck1.isEnabled();
		System.out.println("Button name getting changed to Check All: "+s1);
		
		//Go back to previous page
		driver.navigate().back();
		
		//Again click 'Start Practising' button
		driver.findElement(By.cssSelector("a[id='btn_basic_example']")).click();
		Thread.sleep(2000);
		
		//Open Radio Button Demo
		driver.findElement(By.cssSelector("a[class='list-group-item'][href*='radiobutton-demo.html']")).click();
		Thread.sleep(2000);
		
		//Select Male checkbox
		driver.findElement(By.cssSelector("input[value='Male'][name='optradio']")).click();
		
		//Click on Get checked value to verify the selected value
		driver.findElement(By.cssSelector("button[id='buttoncheck']")).click();
		
		WebElement rButton=driver.findElement(By.cssSelector("p[class='radiobutton']"));
		String rText= rButton.getText();
		Assert.assertTrue(rText.contains("Male"));
		System.out.println(rText);
		
		//Select Female checkbox
		driver.findElement(By.cssSelector("input[value='Female'][name='optradio']")).click();
		
		//Click on Get checked value to verify the selected value
		driver.findElement(By.cssSelector("button[id='buttoncheck']")).click();
		
		WebElement r1Button=driver.findElement(By.cssSelector("p[class='radiobutton']"));
		String r1Text= r1Button.getText();
		Assert.assertTrue(r1Text.contains("Female"));
		System.out.println(r1Text);
		
		//Verified to get the selected values from Group Sex and Age group
		driver.findElement(By.xpath("(//input[@name='gender'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='ageGroup'])[1]")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		
		WebElement fcombination=driver.findElement(By.cssSelector("p[class='groupradiobutton']"));
		String f1Text= fcombination.getText();
		Assert.assertTrue(f1Text.contains("Male"));
		System.out.println(f1Text);
		
		//Go back to previous page
		driver.navigate().back();
		
		//Again click 'Start Practising' button
		driver.findElement(By.cssSelector("a[id='btn_basic_example']")).click();
		Thread.sleep(2000);
		
		//Open Radio Button Demo
		driver.findElement(By.cssSelector("a[class='list-group-item'][href*='dropdown-demo.html']")).click();
		Thread.sleep(2000);
		
		//Select a day
		WebElement Se=driver.findElement(By.cssSelector("select[id='select-demo']"));
		Select day=new Select(Se);
		day.selectByValue("Monday");
		
		//Verify tha selected day
		WebElement Se1=driver.findElement(By.cssSelector("p[class='selected-value']"));
		String sValue= Se1.getText();
		Assert.assertTrue(sValue.contains("Monday"));
		System.out.println(sValue);
		
		//Select List demo value
		WebElement Multi_Select=driver.findElement(By.cssSelector("select[id='multi-select']"));
		Select window=new Select(Multi_Select);
		window.selectByValue("Florida");
		
		//Verified that First selected value:
		driver.findElement(By.cssSelector("button[id='printMe']")).click();
		WebElement fs=driver.findElement(By.cssSelector("p[class='getall-selected']"));
		
		String fselected= fs.getText();
		Assert.assertTrue(fselected.contains("Florida"));
		System.out.println(fselected);
		
		//Select multiple value from multiselect section
		WebElement Multi_Select1=driver.findElement(By.cssSelector("select[id='multi-select']"));
		Select window1=new Select(Multi_Select1);
		window1.deselectByValue("Florida");
		window1.selectByValue("New Jersey");
		window1.selectByValue("New York");
		
		//Verify tha multi select value
		driver.findElement(By.cssSelector("button[id='printAll']")).click();
		WebElement pAll=driver.findElement(By.cssSelector("p[class='getall-selected']"));
		
		String printAll= pAll.getText();
		Assert.assertTrue(printAll.contains("New"));
		System.out.println(printAll);
	
		//Kill the browser
		driver.quit();
		
	}
}
														
										
		

		

