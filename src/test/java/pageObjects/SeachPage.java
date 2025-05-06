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
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(alert));
        alert.click();
    }

    public void sortBy() throws InterruptedException
    {

        Thread.sleep(5000);
        new WebDriverWait(driver, Duration.ofSeconds(70)).until(ExpectedConditions.invisibilityOf(bar));
        filter.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(low));
        low.click();
    }

    public void viewBtn()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(view));
        view.click();
    }
}
