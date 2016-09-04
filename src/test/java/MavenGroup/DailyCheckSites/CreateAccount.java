package MavenGroup.DailyCheckSites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Helper.BrowserSelecter;
import Helper.ExcelConfig;
import Pages.AddtoCart;
import Pages.CreateAccountPage;
import Pages.LoginPage;
import TestNGListeners.TestNGITestListner;

@Listeners(TestNGITestListner.class)
public class CreateAccount {
		
		static public WebDriver driver;
		
		
		@Test(enabled=false)// (dataProvider="EnvTest")
		public void CreateAccountInternal(String baseUrl,String uname, String password)
		{
	
			driver = BrowserSelecter.selectBrowser("firefox", baseUrl);
			System.out.println(driver);
			TestNGITestListner.loginfo("Browser launched");
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.loginInternalSite(uname, password);
			TestNGITestListner.loginfo("user name and password entered");
			CreateAccountPage createAccount = PageFactory.initElements(driver, CreateAccountPage.class);
			TestNGITestListner.loginfo("We are in create account page");
			String Email = createAccount.generateEmail(20);
			createAccount.createAccount(Email, "Siva#123");
			
				
		}
		
		@Test(enabled=false)//(dataProvider="EnvTest")
		public void AddTocart(String baseUrl,String uname, String password)
		{
	
			driver = BrowserSelecter.selectBrowser("firefox", baseUrl);
			TestNGITestListner.loginfo("Browser launched");
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.loginInternalSite(uname, password);
			AddtoCart cart = PageFactory.initElements(driver, AddtoCart.class);
			cart.clickCreateNewCart();
			cart.AddNewProductToCart("BB10919109");
			driver.findElement(By.xpath("//*[@valign = 'middle']//*[contains(@name,'quickOrder')]")).sendKeys("BB10919109");
			driver.findElement(By.xpath("//*[@valign = 'middle']//*[contains(@src,'bt_add')]")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println(alert);
			
		}
		
		@Test
		public void sampleAlert()
		{
	
			driver = BrowserSelecter.selectBrowser("firefox", "http://www.ksrtc.in/");
			driver.findElement(By.xpath(".//a[@class='button1 redbtn']")).click();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Alert alert = driver.switchTo().alert();
			System.out.println(driver.switchTo().alert().getText());
			alert.dismiss();
			driver.findElement(By.xpath(".//input[@id='matchStartPlace']")).sendKeys("hello");
			/*String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
			driver.findElement(By.xpath(".//a[@class='button1 redbtn']")).sendKeys(selectLinkOpeninNewTab);*/
			driver.findElement(By.xpath(".//a[@class='button1 redbtn']")).sendKeys(Keys.chord(Keys.CONTROL,"t"));
			driver.navigate().to("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://www.yahoo.com");
			driver.navigate().back();
			String gmail = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).getText();
			System.out.println(gmail);
		
			driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).sendKeys(Keys.chord(Keys.CONTROL,Keys.PAGE_UP));
			driver.navigate().refresh();
			driver.findElement(By.xpath(".//input[@id='matchStartPlace']")).sendKeys(gmail);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		
		@Test(enabled=false)
		public void getGoogle()
		{
			driver= BrowserSelecter.selectBrowser("phantom", "http://www.google.com");
			System.out.println(driver);
			TestNGITestListner.loginfo("Browser launched");
			//driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
			TestNGITestListner.loginfo("Gmail clicked");
			TestNGITestListner.loginfo("Test done");
		}
		
		@Test(enabled=false)
		public void getYahoo()
		{
			driver= BrowserSelecter.selectBrowser("phantom", "http://www.yahoo.com");
			TestNGITestListner.loginfo("Browser launched");
	
		}
		@AfterMethod
		public void teardown()
		{
			driver.close();
		}
		
		@DataProvider(name = "EnvTest")
		public Object[][] DataInternal()
		{
			ExcelConfig config = new ExcelConfig("C:/Users/sivap5/workspace/DailyCheckSites/TestData/Test.xlsx");
			int rows = config.getlastRow(0);
			int colnum = config.getlastCol(0);
			System.out.println(rows +"               " +colnum);
			Object[][] data = new Object[rows][colnum];
			
			for (int i =0 ; i<rows ; i++)
				{
					for(int j = 0 ; j<colnum; j++)
						{
						data [i][j] = config.getExcelDate(0, i, j);
	
						}
				}
		
			return data;
		}
		
		public static WebDriver getDriver()
		{
			return driver;
		}
		
}
