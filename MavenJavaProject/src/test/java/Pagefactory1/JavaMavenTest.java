package Pagefactory1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Pagefactory1.PasswordForm;

public class JavaMavenTest {
	private WebDriver driver;
	private PasswordForm passwordForm;

	@BeforeClass
	public void start_up() {
		driver = new FirefoxDriver();
		driver.get("http://oxogamestudio.com/passwd.current3.htm");
		
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("master")));
		
		passwordForm = PageFactory.initElements(driver, PasswordForm.class);
	}

	@Test
	public void testPaswordGeneratedCorrectly() throws InterruptedException{
		passwordForm.typeMaster("GLHF");
		passwordForm.typeSite("GetRekt.com");
		passwordForm.Generate();
		Thread.sleep(2000);

		String password = passwordForm.getPassword();
		Assert.assertEquals(password, passwordForm.getPassword());
	}

	@Test
	public void testTwoGeneratedPasswordsAreEqual() throws InterruptedException{
		passwordForm.cleanAll();
		passwordForm.typeMaster("GLHF");
		passwordForm.typeSite("GetRekt.com");
		passwordForm.Generate();
		driver.wait(1000);
		
		String firstPassword = passwordForm.getPassword();
		passwordForm.cleanAll();
		passwordForm.typeMaster("GLHF");
		passwordForm.typeSite("GetRekt.com");
		passwordForm.Generate();
		
		String secondPassword = passwordForm.getPassword();

		Assert.assertEquals(firstPassword, secondPassword);
		passwordForm.cleanAll();	
	}
	
	@Test
	public void testTreeGeneratedCorrectly () throws InterruptedException{
		passwordForm.cleanAll();
		passwordForm.typeMaster("LALALALLA");
		passwordForm.typeSite("TRYHARD");
		passwordForm.Generate();
		
		String password = passwordForm.getPassword();
		
		String lastPasswordCharacters = password.substring(password.length() -3 , password.length());
		Assert.assertEquals(lastPasswordCharacters, "@1a");
	}

	@AfterClass
	public void close() {
		//driver.quit();
		driver.close();
	}
}

