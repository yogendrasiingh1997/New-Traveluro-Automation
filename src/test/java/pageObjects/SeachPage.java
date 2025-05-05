package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeachPage extends Basepage
{
    public SeachPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='sprites bg-close-icon-white alert-close']")
    WebElement alert;

    @FindBy(xpath = "//ul[@class='nav navbar filter-navbar']//li[@class='dropdown']")
    WebElement filter;

    @FindBy(xpath = "//li[@class='dropdown open']//li[3]")
    WebElement low;

    @FindBy(xpath = "//div[@class='row']//div[@class='col-xs-3 secondary-details-contnet']//a[normalize-space()='View']")
    WebElement view;

    @FindBy(xpath = "//div[@class='ng-progress-bar -active']")
    WebElement bar;


    public void login_alert()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(alert));
        alert.click();
    }

    public void sortBy() throws InterruptedException
    {

        Thread.sleep(5000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOf(bar));
        filter.click();

        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(low));
        low.click();
    }

    public void viewBtn()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(view));
        view.click();
    }
}
