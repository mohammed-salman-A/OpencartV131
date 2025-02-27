package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass{
	public static WebDriver driver;
	
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups={"Master","sanity","regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("environment_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("Invalid Operating System");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("Invalid browser"); return;

			}
			driver = new RemoteWebDriver(new URL("http://192.168.30.182:4444/wd/hub"),capabilities);
			
		}
		
		if(p.getProperty("environment_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default:System.out.println("invlalid browser"); return;
			}
		}
		
		
		
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.print(p.getProperty("appURL"));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups="Master")
	public void tearDown() {
		driver.quit();
	}
	
	public String randomAlphabetic() {
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	public String randomNumeric() {
		String generatestring = RandomStringUtils.randomAlphanumeric(10);
		return generatestring;
	}
	public String randomAlphaNumric() {
		String generatestring = RandomStringUtils.randomAlphabetic(10);
		String generatenum = RandomStringUtils.randomAlphanumeric(10);
		return (generatestring+generatenum);
	}
	
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}

