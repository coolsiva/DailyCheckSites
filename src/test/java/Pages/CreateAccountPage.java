package Pages;


import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPage {
	WebDriver driver;
	
	public CreateAccountPage (WebDriver ldriver)
	
	{
		this.driver = ldriver;
		
	}
	
	final String createAccountButton= "//img[@alt = ' Create Account ']";
	@FindBy(how = How.XPATH , using=createAccountButton) 
	WebElement x_createAccountButton;
	
	final String clickCABussinessButton= "//input[@type='radio' and contains(@onclick,'Business')]";
	@FindBy(how =How.XPATH , using =clickCABussinessButton)
	WebElement x_clickCABussinessButton;
	
	@FindBy(how =How.XPATH , using ="//input[@name='UserEmailAddress']")
	WebElement CAEmailText;
	
	@FindBy(how =How.XPATH , using ="//input[@name='Password1']")
	WebElement CAPasswordText;
	
	@FindBy(how =How.XPATH , using ="//input[@name='Password2']")
	WebElement CARePasswordText;
	
	@FindBy(how =How.XPATH , using ="//*[@id='numberOfEmployeesOne']")
	WebElement CAEmpOneToFourRadio;
	
	@FindBy(how =How.XPATH , using ="//select[@name='industry']")
	WebElement CAIndustryDrpDown;
	
	@FindBy(how =How.XPATH , using ="//select[@name='teamIndicator']")
	WebElement CATerritoryDesignDrpDown;
	
	@FindBy(how =How.XPATH , using ="//select[@name='initiativeIndicator']")
	WebElement CAInitiativeDrpDown;
	
	@FindBy(how =How.XPATH , using ="//select[@name = 'identifiedReseller']")
	WebElement CAResellerDrpDown;
	
	@FindBy(how =How.XPATH , using ="//select[@name= 'identifiedChannelType']")
	WebElement CAChannelTypeDrpDown;
	
	
	@FindBy(how =How.XPATH , using ="(//input[@id= 'accountType'])[1]")
	WebElement CAB2BRadio;
	
	@FindBy(how =How.XPATH , using ="//input[@name='SoldToFirstName']")
	WebElement CASToAFirstNameText;
	
	@FindBy(how =How.XPATH , using ="//input[@name='SoldToLastName']")
	WebElement CASToALastNameText;
	
	
	@FindBy(how =How.XPATH , using ="//input[@name='SoldToCompanyName']")
	WebElement CASToACompanyText;
	
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToAddress1']")
	WebElement CASToAAddress1Text;
	
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToCity']")
	WebElement CASToACityText;
	
	@FindBy(how =How.XPATH , using ="//select[@name = 'SoldToState']")
	WebElement CASToAStateDrpDown;
	
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToPostalCode']")
	WebElement CASToAZipText;
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToPhoneAreaCode']")
	WebElement CASToAPhoneAreaText;
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToPhonePrefix']")
	WebElement CASToAPhonePrefixText;
	
	@FindBy(how =How.XPATH , using ="//input[@name = 'SoldToPhoneSuffix']")
	WebElement CASToAPhoneSuffixText;
	
	@FindBy(how =How.XPATH , using ="//input[@name='same_as_SoldTo']")
	WebElement CASToABillToAdsressRadio;
	
	@FindBy(how =How.XPATH , using ="//input[@name='same_as_BillTo']")
	WebElement CASToAShipToAdsressRadio;
	
	
	public void createAccount(String Email, String password)
	{
		x_createAccountButton.click();
		x_clickCABussinessButton.click();
		CAEmailText.sendKeys(Email);
		CAPasswordText.sendKeys(password);
		CARePasswordText.sendKeys(password);
		CAEmpOneToFourRadio.click();
		CAIndustryDrpDown.sendKeys("Accommodation");
		CATerritoryDesignDrpDown.sendKeys("Corporate");
		CAInitiativeDrpDown.sendKeys("Automative");
		CAResellerDrpDown.sendKeys("No");
		CAChannelTypeDrpDown.sendKeys("Market");
		CAB2BRadio.click();
		CASToAFirstNameText.sendKeys("siva");
		CASToALastNameText.sendKeys("ram");
		CASToACompanyText.sendKeys(generateCompanyName(10));
		CASToAAddress1Text.sendKeys("7601 knox ave");
		CASToACityText.sendKeys("richfield");
		CASToAStateDrpDown.sendKeys("Minn");
		CASToAZipText.sendKeys("55423");
		CASToAPhoneAreaText.sendKeys("456");
		CASToAPhonePrefixText.sendKeys("456");
		CASToAPhoneSuffixText.sendKeys("4567");
		CASToABillToAdsressRadio.click();
		CASToAShipToAdsressRadio.click();
	}
	
	public String generateEmail(int length) {
		return "random-" + UUID.randomUUID().toString() + "@example.com";
	}
	
	public String generateCompanyName(int length) {
		return "random-" + UUID.randomUUID().toString();
	}
	
}
