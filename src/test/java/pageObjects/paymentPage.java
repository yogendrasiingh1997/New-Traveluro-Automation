package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class paymentPage extends Basepage {

    public paymentPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='EmailConfirm']")
    WebElement confirmEmail;

    @FindBy(xpath = "//input[@id='ZipCode']")
    WebElement zipCode;

    @FindBy(xpath = "//textarea[@id='SpecialRequest']")
    WebElement special;

    @FindBy(xpath = "//input[@id='PhoneNumber']")
    WebElement number;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement coninue;

    @FindBy(xpath = "//span[@class='basic-services-text text-black d-block']")
    WebElement vip;

    @FindBy(xpath = "//li[@class='clearfix']/div[@class='non-cancelation clearfix']")
    WebElement nonRefText;

    @FindBy(xpath = "//label[contains(text(),'No thanks, I’ll risk it')]")
    WebElement cgDecline;

    @FindBy(xpath = "//div[@class='trip-protection-section position-relative']//a[@class='btn-effect btn-lg btn-payment-continue btn-block text-center']")
    WebElement cgContinue;

    @FindBy(xpath = "//button[@id='No_Tip']")
    WebElement tip;

    @FindBy(xpath = "//a[contains(@class,'payment-method payment-method-credit-card')]")
    WebElement cardOption;

    @FindBy(xpath = "//input[@id='CardNumber']")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@id='MonthPaymentPage']")
    WebElement month;

    @FindBy(xpath = "//input[@id='YearPaymentPage']")
    WebElement year;

    @FindBy(xpath = "//input[@id='CVV']")
    WebElement cvv;

    @FindBy(xpath = "//button[@id='book-room']")
    WebElement bookButton;

    @FindBy(xpath = "//img[@src='/assets/images/Wheel-only-transparent-reapet.gif']")
    WebElement loader;



    public void loderIcon() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        Thread.sleep(5000);
    }


    public void fName(String fName)
    {
        firstName.sendKeys(fName);
    }

    public void lName(String lName)
    {
        lastName.sendKeys(lName);
    }

    public void emailAddress (String emailAddress)
    {
        email.sendKeys(emailAddress);
    }

    public void confirmEmailAddress (String confirmEmailAddress)
    {
        confirmEmail.sendKeys(confirmEmailAddress);
    }

    public void setZipCode(String setZipCode)
    {
        zipCode.sendKeys(setZipCode);
    }

    public void setSpecialRequest(String setSpecialRequest)
    {
        special.sendKeys(setSpecialRequest);
    }

    public void setNumber(String setNumber)
    {
        number.sendKeys(setNumber);
    }

    public void continueBtn()
    {
        coninue.click();
    }

    public void vipSelect()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(vip));
        vip.click();
    }

    public void insurance()
    {
        if(nonRefText.isDisplayed())
        {
            cgDecline.click();
            cgContinue.click();
        }
        else
        {
            System.out.println("No insurance is presnt");

        }
    }


    public void tipSelection()
    {
        tip.click();
    }

    public void creditCardSelection()
    {
        cardOption.click();
    }

    public void setCardNumber(String  setCardNumber)
    {
        cardNumber.sendKeys(setCardNumber);
    }

    public void setMonth(String setMonth)
    {
        month.sendKeys(setMonth);
    }

    public void setYear(String setYear)
    {
       year.sendKeys(setYear);
    }

    public void setCvv(String setCvv)
    {
        cvv.sendKeys(setCvv);
    }

    public void roomBookBtn()
    {
        bookButton.click();
    }




}
