package Helper;



import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSelecter {
	
	static WebDriver driver;
	
	public  static WebDriver selectBrowser(String BrowserName,String Url)
	{
		
		if(BrowserName.equalsIgnoreCase("ie"))
		{
			//DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.out.println(driver);
			System.out.println(BrowserName + " " +Url);
			System.setProperty("webdriver.chrome.driver", "C:/Users/sivap5/workspace/DailyCheckSites/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(driver);
		}
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			
			String PROXY = "proxy2.wipro.com:8080";
			String noProxy = "outlook.office365.com,*.outlook.com,*.office365.com,*im.wipro.com,*https://tagfarm*,*dld07web.na.bestbuy.com*,*im.wipro.com,tagfarm,168*,localhost,127.0.0.1,*im.wipro.com,BLR-LCS-HS01.WIPRO.COM,*im.wipro.com,http://drc.na.bestbuy.com*,https://drc.na.bestbuy.com*,http://192.168.*,http://168.94.71.68,ds*,itgweb,pvcsweb.bestbuy.com,http://172.16.*,inet.eds.bestbuy.com,http://drc.na.*,https://dld07web.na.*,http://dld07web.na.*,https://drc.na.*,localhost,127.0.0.1,http://168.94.*,168.94.11.70,167.209.237.12,168.94.26.138,drc*,*sp.bestbuy.com,*tagfarm*,*mywipro.wipro.com*,*bestbuy.com,*im.wipro.com,tagfarm,dld07web,localhost,127.0.0.1,dld07web.na.bestbuy.com,localhost,*im.wipro.com,168.*,*im.wipro.com,BLR-LCS-HS01.WIPRO.COM,168.94.198.25,168.94.26.138*,168.94.112.67*,168.94.11.*,167.209.237.*,168.94.26.*,168.94.112.*,drc*,168.94.123.*,168.94.71.*,*.local,sp.bestbuy.com,http://tagfarm*,dsd2netw.na.bestbuy.com,168.94.112.141,bbyatk,*drc-pl.na.bestbuy.com*,*bbfb*,*dtw01hqcap001.na.bestbuy.com*,localhost" ;
			  
			  Proxy proxy = new Proxy();
			  proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY)
			    .setSocksProxy(PROXY).setNoProxy(noProxy);
			  DesiredCapabilities cap = new DesiredCapabilities();
			  cap.setCapability(CapabilityType.PROXY, proxy);
			  
			  driver = new FirefoxDriver(cap);
			 
		
		}
		/*if(BrowserName.equalsIgnoreCase("phantom"))
		{
			String PROXY = "proxy2.wipro.com:8080";
			String noProxy = "outlook.office365.com,*.outlook.com,*.office365.com,*im.wipro.com,*https://tagfarm*,*dld07web.na.bestbuy.com*,*im.wipro.com,tagfarm,168*,localhost,127.0.0.1,*im.wipro.com,BLR-LCS-HS01.WIPRO.COM,*im.wipro.com,http://drc.na.bestbuy.com*,https://drc.na.bestbuy.com*,http://192.168.*,http://168.94.71.68,ds*,itgweb,pvcsweb.bestbuy.com,http://172.16.*,inet.eds.bestbuy.com,http://drc.na.*,https://dld07web.na.*,http://dld07web.na.*,https://drc.na.*,localhost,127.0.0.1,http://168.94.*,168.94.11.70,167.209.237.12,168.94.26.138,drc*,*sp.bestbuy.com,*tagfarm*,*mywipro.wipro.com*,*bestbuy.com,*im.wipro.com,tagfarm,dld07web,localhost,127.0.0.1,dld07web.na.bestbuy.com,localhost,*im.wipro.com,168.*,*im.wipro.com,BLR-LCS-HS01.WIPRO.COM,168.94.198.25,168.94.26.138*,168.94.112.67*,168.94.11.*,167.209.237.*,168.94.26.*,168.94.112.*,drc*,168.94.123.*,168.94.71.*,*.local,sp.bestbuy.com,http://tagfarm*,dsd2netw.na.bestbuy.com,168.94.112.141,bbyatk,*drc-pl.na.bestbuy.com*,*bbfb*,*dtw01hqcap001.na.bestbuy.com*,localhost" ;
			  
			  Proxy proxy = new Proxy();
			  proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY)
			    .setSocksProxy(PROXY).setNoProxy(noProxy);
			  DesiredCapabilities cap = new DesiredCapabilities();
			  cap.setCapability(CapabilityType.PROXY, proxy);
			//File src = new File("C:/Users/sivap5/workspace/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
			System.setProperty("phantomjs.binary.path", "./phantomjs.exe");
			  driver = new PhantomJSDriver(cap);
		}*/
		driver.get(Url);
		return driver;
	}

}
