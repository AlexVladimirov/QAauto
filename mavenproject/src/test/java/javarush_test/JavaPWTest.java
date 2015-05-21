package javarush_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;

public class JavaPWTest {

	WebDriver driver;
	
	public String genPW, genPW1, genPW2, genPW3;
	
	@BeforeClass
	public void startup()
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\automation\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://angel.net/~nic/passwd.current.html");
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void PWTest() throws InterruptedException
	{
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mynewfbpw");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("fb.com");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1250);		
		genPW = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
		Thread.sleep(1250);
				
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).clear();
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mynewfbpw");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("fb.com");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1250);		
		genPW = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
		Thread.sleep(1250);
				
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).clear();
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mynewfbpw1");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("fb.com");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1250);
		genPW2 = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
		Thread.sleep(1250);
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).clear();
				
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mynewfbpw2");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("fb2.com");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1250);
		genPW3 = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
		Thread.sleep(1250);
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).clear();
	}
		@Test
		public void PWTest2() throws InterruptedException
		{
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mynewfbpw");
		Thread.sleep(1250);		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("fb.com");
		Thread.sleep(1250);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1250);
		genPW = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
		Thread.sleep(1250);
		
		Assert.assertEquals(genPW.substring(genPW.length()-3, genPW.length()), "@1a");
		Thread.sleep(1250);
	}

	@Test
	public void PWTest3() throws InterruptedException
	{
		Assert.assertEquals(genPW, genPW1);
		Assert.assertEquals((!genPW2.equals("genPW")), true);
		Assert.assertEquals((!genPW3.equals("genPW")), true);
		
		Thread.sleep(1250);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();		
	}

}
