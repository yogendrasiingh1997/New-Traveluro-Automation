package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Basepage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (xpath = "//div[@id='myModalNorm']//input[@id='email']")
    WebElement email_txt;

    @FindBy (xpath = "//div[@id='myModalNorm']//input[@id='password']")
    WebElement pwd_txt;

    @FindBy (xpath = "//div[@id='myModalNorm']//button[@type='submit'][normalize-space()='Login']")
    WebElement submit_btn;

    @FindBy(xpath = "//a[contains(@class, 'logout-menu')]")
    WebElement logout_btn;

    @FindBy(xpath = "//a[@id='sm-15236008200698604-3']")
    WebElement hower;

                            // === Actions ===

    public void email(String email)
    {
        email_txt.sendKeys(email);
    }

    public void password(String password)
    {
        pwd_txt.sendKeys(password);
    }

    public void submit()
    {
        submit_btn.click();
    }

    public boolean logout() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", hower);
            js.executeScript("arguments[0].click();", hower); // If needed to trigger dropdown

            return logout_btn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void logoutClick()
    {
        logout_btn.click();
    }
}
