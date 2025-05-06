package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class confirmationPage extends Basepage{

    public confirmationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//img[@src='/assets/images/Wheel-only-transparent-reapet.gif']")
    WebElement loader;

    @FindBy(xpath = "//strong[@class='bold']")
    WebElement trip;

    @FindBy(xpath = "//img[@class='d-block']")
    WebElement confirmationLoader;

    public void loderIcon()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(loader));
    }

    public void confirmationURL()
    {
        System.out.println("Confirmation_URL: " +driver.getCurrentUrl());
    }

    public void tripNumber()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(confirmationLoader));
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='67%'");
        System.out.println("Trip_number: " +trip.getText());
    }
}
