package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage (WebDriver ldriver)
	
	{
		this.driver = ldriver;
		
	}
	final String x_home_button = ".//*[@alt=' Home ']";
	@FindBy(xpath=x_home_button) 
	WebElement homebutton;
	
	final String x_HomePageUserNameTextBox = "//*[contains(@name,'login')]";
	@FindBy(how =How.XPATH , using =x_HomePageUserNameTextBox)
	WebElement HomePageUserNameTextBox;
	
	@FindBy(how =How.XPATH , using ="//*[contains(@name,'passwd')]")
	WebElement x_homePagePasswordTextBox;
	
	@FindBy(how =How.XPATH , using ="//input[contains(@src,'bt_sign')]")
	WebElement x_homePageLoginButton;
	
	public void loginInternalSite(String username, String password)
	{
		homebutton.click();
		HomePageUserNameTextBox.sendKeys(username);
		x_homePagePasswordTextBox.sendKeys(password);
		x_homePageLoginButton.click();
	}
	
}
