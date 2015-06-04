package Pagefactory1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordForm {
	private WebDriver driver;

	@FindBy(xpath = "//td[text()='Your master password']/following::input[1]")
	private WebElement masterPassElement;

	@FindBy(xpath="//td[text()='Site name']/following::input[1]")
	private WebElement siteElement;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath="//td[text()='Generated password']/following::input[1]")
	private WebElement genpasswordElement;

	public void typeMaster(String value) {
		masterPassElement.sendKeys(value);
	}

	public void typeSite(String siteName) {
		siteElement.sendKeys(siteName);
	}

	public void Generate() {
		submitButton.click();
		try {
			driver.wait(1000);
		} catch (Exception ex) {
		}
	}

	public String getPassword() {
		return genpasswordElement.getAttribute("value");
	}

	 
	public void cleanSite() {
siteElement.clear();
 }

 public void cleanMaster() {
 masterPassElement.clear();
  }
 
 public void cleanGeneratedPass() {
	 genpasswordElement.clear();
 }
 
 public void cleanAll() {
		siteElement.clear();
		masterPassElement.clear();
		genpasswordElement.clear();
	}
}
