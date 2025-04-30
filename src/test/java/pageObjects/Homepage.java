package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

    public Homepage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//img[@src='/assets/images/close-icon.svg']")
    WebElement app_banner;

    @FindBy(xpath = "//span[@class='close-btn-img']")
    WebElement cookies;

    //Search
    @FindBy(xpath = "//input[@id='myInput']")
    WebElement search;

    @FindBy(xpath = "//ul[@id='searchInputAutocompleteList']/li/a")
    WebElement location_list;


    //Calendar
    @FindBy(xpath = "//div[@id='search-booking-form']//div[@class='checkin-checkout-input bookingdate-desktop']")
    WebElement calendar;

    @FindBy(xpath = "//div[@class='calendar left']//th[@class='month']")
    WebElement current_date;

    @FindBy(xpath = "//th[@class='next available']")
    WebElement next_month;

    @FindBy(xpath = "//body[1]/div[5]/div[1]/div[2]/table[1]/tbody[1]/tr/td")
    WebElement date;

//    @FindBy(xpath = "//button[@id='btnGuestDropDown']")
//    WebElement guest;

    //Go button
    @FindBy(xpath = "//div[@id='search-booking-form']//div[@class='btn-effect go-btn']")
    WebElement go_btn;

    //Login
    @FindBy(xpath = "//a[@class='clickable'][normalize-space()='Login']")
    WebElement login_btn;

    //SignUp
    @FindBy(xpath = "//div[@id='myModalNorm']//div[@class='signup-text']")
    WebElement newUser;




    public void banner()
    {
        app_banner.click();
    }

    public  void cookie_banner ()
    {
        cookies.click();
    }

    public void locationName(String locationName)
    {
        search.sendKeys(locationName);
    }

    public void placeList()
    {
        location_list.click();
    }

    public void date()
    {
        calendar.click();
    }

    public void currentYear()
    {
        current_date.getText();
    }

    public void nextMonth()
    {
        next_month.click();
    }

    public  void startDate()
    {
        date.click();
    }

    public void endDate()
    {
        date.click();
    }


    public void Go()
    {
        go_btn.click();
    }

    public void login ()
    {
        login_btn.click();
    }

    public void signUp()
    {
       newUser.click();
    }

    public boolean login_verification()
    {
        try
        {
            return (login_btn.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
