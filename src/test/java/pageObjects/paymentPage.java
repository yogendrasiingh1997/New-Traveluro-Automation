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
    WebElement specialRequest;

    @FindBy(xpath = "//input[@id='PhoneNumber']")
    WebElement phoneNumber;

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


    public void loderIcon() throws InterruptedException
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        Thread.sleep(5000);
    }

    public void fillPersonalDetails(String fName, String lName, String emailAddr, String confirmEmailAddr,
                                    String phone, String zip, String request) {

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(emailAddr);
        confirmEmail.sendKeys(confirmEmailAddr);
        phoneNumber.sendKeys(phone);
        zipCode.sendKeys(zip);
        specialRequest.sendKeys(request);
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

    public void enterCardDetails(String number, String expMonth, String expYear, String securityCode)
    {
        cardNumber.sendKeys(number);
        month.sendKeys(expMonth);
        year.sendKeys(expYear);
        cvv.sendKeys(securityCode);
    }

    public void roomBookBtn()
    {
        bookButton.click();
    }




}
