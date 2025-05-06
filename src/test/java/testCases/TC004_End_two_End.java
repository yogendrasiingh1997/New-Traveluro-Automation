package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.Base_Class;

import java.time.Duration;

public class TC004_End_two_End extends Base_Class
{

    @Test
    public void Sanity() throws InterruptedException {

        Homepage hp= new Homepage(driver);
        SeachPage hac=new SeachPage(driver);
        BAPage ba= new BAPage(driver);
        paymentPage pp= new paymentPage(driver);
        confirmationPage cp= new confirmationPage(driver);


        hp.banner();
        hp.cookie_banner();
        hp.enterLocation(p.getProperty("location"));
        hp.date(p.getProperty("month_Year"),p.getProperty("checkIn"),p.getProperty("checkOut"));
        hp.Go();


        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        hac.login_alert();
        //hac.sortBy();
        hac.viewBtn();



        ba.switchwindow();
        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
        ba.baPageLoader();
        ba.showBtn();
        ba.freeCancellationDeal();

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='90%'");

        pp.loderIcon();
        pp.fillPersonalDetails("Yogendra"+ randomString(),
                "Singh",
                "yogendra@holisto.com",
                "yogendra@holisto.com",
                "2154567890",
                "45456",
                "test trip");


        pp.tipSelection();
        pp.vipSelect();
        pp.creditCardSelection();

        pp.enterCardDetails(
                "5555555555554444",
                "12",
                "2026",
                "123");
        pp.roomBookBtn();


        cp.loderIcon();
        cp.confirmationURL();
        cp.tripNumber();

        capturescreen("Confirmation page");

    }


}
