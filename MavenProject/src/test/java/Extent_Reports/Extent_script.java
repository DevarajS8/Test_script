package Extent_Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_script 
{
	@Test
	public void script()
	{
		ExtentHtmlReporter rep=new ExtentHtmlReporter("./Extent_Report/Extentfile.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(rep);
		ExtentTest test = reports.createTest("Extent Test");
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		test.log(Status.INFO, "firefox is launched");
		driver.get("https://wwww.youtube.com");
		test.log(Status.INFO, "Application is launched");
		String title = driver.getTitle();
		if(title.equals("YouTube"))
		{
			test.log(Status.INFO, "Home page is displyaed");
		}
		else
		{
			test.log(Status.FAIL, "Home page is not displayed");
		}
		driver.close();
		test.log(Status.INFO, "App is close");
		reports.flush();
		
		
		
		
		
		
	}

}
