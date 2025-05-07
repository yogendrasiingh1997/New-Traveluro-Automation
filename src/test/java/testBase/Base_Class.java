package testBase;

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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class Base_Class {

    public static WebDriver driver;
    public Logger logger; //log4j
    public Properties p;

    @Parameters({"os","browser"})
    @BeforeClass(groups = {"Sanity", "Master", "Regression"})


    public void setup( String os, String browser) throws IOException

    {
        FileReader file= new FileReader("C://Users//ADMIN//IdeaProjects//New Traveluro Automation//src//test//resource//config.properties");
        p= new Properties();
        p.load(file);

        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities dc= new DesiredCapabilities();

            //os
            if(os.equalsIgnoreCase("windows"))
            {
                dc.setPlatform(Platform.WIN11);
            }
            else if (os.equalsIgnoreCase("mac"))
            {
                dc.setPlatform(Platform.MAC);
            }
            else if (os.equalsIgnoreCase("Linux"))
            {
                dc.setPlatform(Platform.LINUX);
            }
            else
            {
                System.out.println("no matching os");
                return;
            }


            //browser
            switch (browser.toLowerCase())  //run through xml file
            {
                case "chrome" : dc.setBrowserName("chrome"); break;
                case "edge" : dc.setBrowserName("MicrosoftEdge"); break;
                case "firefox" : dc.setBrowserName("firefox"); break;
                default: System.out.println("Invalid browser name"); return;
            }

            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

        }


        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
            switch (browser.toLowerCase())  //run through xml file
            {
                case "chrome" : driver= new ChromeDriver(); break;
                case "firefox" : driver= new FirefoxDriver(); break;
                case "edge" : driver= new EdgeDriver(); break;
                default: System.out.println("Invalid browser name"); return;
            }

        }

        logger= LogManager.getLogger(this.getClass());

        driver.get(p.getProperty("websiteURl"));  //reading url from properties
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    private boolean isUrlReachable(String url)
    {
        return false;
    }

    @AfterClass (groups = {"Sanity", "Master", "Regression"})
    public void tearDown()
    {
        driver.quit();
    }


    public String randomString()
    {
        String generatingEmail= RandomStringUtils.randomAlphabetic(3);
        return generatingEmail;
    }

    public String randomNumber()
    {
        String generatingNumbers= RandomStringUtils.randomAlphanumeric(10);
        return generatingNumbers;
    }

    public String randomAlphanumeric()
    {
        String ramdomString1= RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String ramdomString= RandomStringUtils.randomAlphabetic(5);
        String ramdomNumbers= RandomStringUtils.randomNumeric(3);
        return(ramdomString1+ramdomString+"@"+ ramdomNumbers);

    }

    public String capturescreen(String tname)
    {

        String timestamp= new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        String Targetfilepath= "C://Users//ADMIN//IdeaProjects//New Traveluro Automation//screenshot/" +tname+ "_"+ timestamp+ ".png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        File sourceFile= ts.getScreenshotAs(OutputType.FILE);
        File  Targetfile= new File(Targetfilepath);

        sourceFile.renameTo(Targetfile);
        return Targetfilepath;
    }
}
