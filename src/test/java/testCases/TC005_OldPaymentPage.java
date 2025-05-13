package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.Base_Class;

import java.time.Duration;

public class TC005_OldPaymentPage extends Base_Class
{
    @Test
    public void oldSanity() throws InterruptedException
    {

        Homepage hp = new Homepage(driver);
        SeachPage hac = new SeachPage(driver);
        BAPage ba = new BAPage(driver);
        pageObjects.OldPaymentPage old= new pageObjects.OldPaymentPage(driver);
        confirmationPage cp = new confirmationPage(driver);


        hp.banner();
        hp.cookie_banner();
        hp.enterLocation(p.getProperty("location"));
        hp.date(p.getProperty("month_Year"), p.getProperty("checkIn"), p.getProperty("checkOut"));
        hp.Go();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        hac.login_alert();
        //hac.sortBy();
        hac.viewBtn();


        ba.switchwindow();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        ba.baPageLoader();
        ba.showBtn();
        ba.freeCancellationDeal();

        old.loderIcon();
        old.fillPersonalDetails("Yogendra"+ randomString(),
                "Singh",
                "yogendra@holisto.com",
                "yogendra@holisto.com",
                "2154567890",
                "45456",
                "test trip");

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        old.tipSelection();
        old.vipSelect();
        old.creditCardSelection();

        old.enterCardDetails(
                "5555555555554444",
                "12",
                "2026",
                "123");
        old.roomBookBtn();


        cp.loderIcon();
        cp.confirmationURL();
        cp.tripNumber();

        capturescreen("Confirmation page");


    }
}
