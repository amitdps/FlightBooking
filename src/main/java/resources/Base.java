package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;

	public WebDriver initializedriver() throws IOException {

		Properties p = new Properties();
		File prop = new File("src/main/java/resources/Test.properties");
		File cd = new File("src/main/java/resources/chromedriver.exe");
		String chromeDriver = cd.getAbsoluteFile().toString();

		String propFile = prop.getAbsolutePath().toString();
		System.out.println(propFile);
		FileInputStream fis = new FileInputStream(propFile);
		p.load(fis);
		String browser = p.getProperty("browser");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromeDriver);
			driver = new ChromeDriver();

		}

		else if (browser.equals("firefox")) {

			// initialization for firefox and so on for other browsers

		}

		return driver;

	}

}
