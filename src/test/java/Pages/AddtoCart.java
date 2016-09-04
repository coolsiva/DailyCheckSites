package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddtoCart {
	
	@FindBy(how = How.XPATH , using = "//*[contains(text(),'Create new cart')]" )
	WebElement x_homePageClickCreateNewCart;
	
	@FindBy(how = How.XPATH , using = "//*[@valign = 'middle']//*[contains(@name,'quickOrder')]" )
	WebElement x_cartPageProductTextBox;
	
	@FindBy(how = How.XPATH , using = "//*[@valign = 'middle']//*[contains(@src,'bt_add')]" )
	WebElement x_cartPageAddButton;
	
	public void clickCreateNewCart()
	{
		x_homePageClickCreateNewCart.click();
	}
	
	public void AddNewProductToCart(String SKU)
	{
		x_cartPageProductTextBox.sendKeys(SKU);
		x_cartPageAddButton.click();
	}

}
