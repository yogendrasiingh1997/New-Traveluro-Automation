package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ContactUS extends Basepage
{
    Actions act= new Actions(driver);
    public ContactUS(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='clickable has-submenu']")
    WebElement support;

    @FindBy(xpath = "//ul[@class='support-dropdown']/li[1]")
    WebElement contactus;

    @FindBy(xpath = "//div[@class='box']")
    WebElement supportTeam;

    @FindBy(xpath = "//div[@class='form-group']//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//div[@class='form-group form-group-lg']//input[@id='bookingnumber']")
    WebElement trip_id;

    @FindBy(xpath = "//button[@class='btn-effect btn travelStoryPopup mt-40']")
    WebElement findMyBooking;

    @FindBy(xpath = "//option[@value='0']")
    WebElement cancelbookingoption;

    @FindBy(xpath = "//select[@id='Reason']")
    WebElement clickevent;

    @FindBy(xpath = "//a[normalize-space()='Manage my booking']")
    WebElement manageBooking;

    @FindBy(xpath = "//strong[@class='bold']")
    WebElement trip;

    public void setContactus()
    {
      act.moveToElement(support).moveToElement(contactus).click().perform();
    }

    public void details(String emailid, String tripId)
    {
        supportTeam.click();
        email.sendKeys(emailid);
        trip_id.sendKeys(tripId);
        findMyBooking.click();
        clickevent.click();
        cancelbookingoption.click();
        manageBooking.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(trip));

    }
}
