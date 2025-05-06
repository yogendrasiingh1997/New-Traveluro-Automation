package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Signup extends Basepage{

    public Actions act= new Actions(driver);

    public Signup(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='registerFName']")
    WebElement full_name;

    @FindBy(xpath ="//input[@id='registerEmail']" )
    WebElement email;

    @FindBy(xpath = "//input[@id='registerPassword']")
    WebElement password;

    @FindBy(xpath = "//input[@id='registerConfirmPassword']")
    WebElement confirm_password;

    @FindBy(xpath ="//input[@id='IAgree']" )
    WebElement terms;

    @FindBy(xpath = "//label[@for='privacy']")
    WebElement privacy;

    @FindBy(xpath = "//div[@id='myModalRegister']//div[@class='modal-dialog modal-signup modal-dialog-secondary']//div[@class='modal-content']//div[@class='modal-body overflow-scroll']//form[@role='form']//div//button[@type='submit'][normalize-space()='Create account']")
    WebElement create_acc;

    @FindBy(xpath = "//a[contains(@class, 'logout-menu')]")
    WebElement logout_btn;

    @FindBy(xpath = "//a[@id='sm-15236008200698604-3']")
    WebElement hower;


    public void personalDetails (String name,String user_email,String pass, String confPass)
    {
        full_name.sendKeys(name);
        email.sendKeys(user_email);
        password.sendKeys(pass);
        confirm_password.sendKeys(pass);
        privacy.click();
        terms.click();
    }

//    public void name(String name)
//    {
//        full_name.sendKeys(name);
//    }
//
//    public void user_email(String user_email)
//    {
//     email.sendKeys(user_email);
//    }
//
//    public void pass(String pass)
//    {
//        password.sendKeys(pass);
//    }
//
//    public void  con_pass(String pass)
//    {
//        confirm_password.sendKeys(pass);
//    }
//
//    public void tc()
//    {
//        terms.click();
//    }
//
//    public void pp()
//    {
//        privacy.click();
//    }

    public void create()
    {
        create_acc.click();
    }

    public boolean logoutDisplayed()
    {
        try
        {
            act = new Actions(driver);
            act.moveToElement(hower).perform();
            Thread.sleep(2000);
            return logout_btn.isDisplayed(); // single call, inside try
        }
        catch (Exception e)
        {
            System.out.println("❌ Logout button not displayed: " + e.getMessage());
            return false;
        }
    }

    public void logout_click()
    {
        logout_btn.click();
    }
}
