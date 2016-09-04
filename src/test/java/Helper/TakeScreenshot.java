package Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	static String projectPath = System.getProperty("user.dir");
	public static String TakeAscreenShot(WebDriver driver , String screenshotname)
	{
		String dest = projectPath +"/target/Screenshot/" + screenshotname + ".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File(dest);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dest;
	}

}
