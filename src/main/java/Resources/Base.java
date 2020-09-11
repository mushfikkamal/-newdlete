package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

//		DesiredCapabilities ds = new DesiredCapabilities();
//		ds.setBrowserName("chrome");
//		ds.setPlatform(Platform.WINDOWS);
//		driver = new RemoteWebDriver(new URL("http://192.168.40.113:4444/wd/hub"), ds);

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\SeleniumTest\\AnandTest\\Applestock\\AppleStock\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Selenium\\" + result + "screendshot.png"));

	}
}
