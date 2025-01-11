package baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.netty.handler.timeout.TimeoutException;

public class intializemethods {
	public WebDriver driver;

	public void takescreenshot() throws IOException {
		if (driver != null) {
			try {
				String filepath = System.getProperty("user.dir") + "//screenshots//" + generatescreenshotname();
				File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshotfile, new File(filepath));
			} catch (TimeoutException e) {
				System.out.println("failed to capture screenshot");
			}
		} else {
			System.out.println("screenshot  method not working ");
		}

	}

	public String generatescreenshotname() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String date = dateformat.format(new Date());
		String Filename = date + ".png";

		return Filename;

	}
	@BeforeMethod
	public void openpage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1");
	}

	@AfterMethod
	public void closepage() {
		driver.quit();
	}

}
