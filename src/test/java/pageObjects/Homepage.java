package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
    List<WebElement> locationSuggestions;


    //Calendar
    @FindBy(xpath = "//div[@id='search-booking-form']//div[@class='checkin-checkout-input bookingdate-desktop']")
    WebElement calendar;

    @FindBy(xpath = "//div[@class='calendar left']//th[@class='month']")
    WebElement current_date;

    @FindBy(xpath = "//th[@class='next available']")
    WebElement next_month;

    @FindBy(xpath = "//div[@class='calendar left']//tbody/tr/td")
    List<WebElement> date;

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


    // === Actions====

    public void banner()
    {
        app_banner.click();
    }

    public  void cookie_banner ()
    {
        cookies.click();
    }

    public void enterLocation(String locationName)
    {
        search.sendKeys(locationName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(locationSuggestions.get(0)));

        List<WebElement> options= locationSuggestions;
        for(WebElement suggestion: locationSuggestions)
        {
            if (suggestion.getText().contains(locationName))
            {
                System.out.println("Destination:"  + " " + suggestion.getText());
                suggestion.click();
                return;
            }
        }
        Assert.fail("Location not found in suggestion list: " + locationName);
    }


    public void date(String month_Year, String check_in, String check_out )
    {
        calendar.click();

        while(true)
        {
            String currentMonth=current_date.getText();  //take latest date
            if(currentMonth.equals(month_Year))
            {
                    break;
            }
            next_month.click();
        }

        //Checkin date
        List<WebElement> checkIn= date;
        for(WebElement startDate: date)
        {
            if(startDate.getText().equals(check_in))
            {
                System.out.println("Check_in: " + startDate.getText() +" " +month_Year);
                startDate.click();
                break;
            }
        }

        //Checkout date
        List<WebElement> checkOut= date;
        for(WebElement endDate: date)
        {
            if(endDate.getText().equals(check_out))
            {
                System.out.println("Check_out: " + endDate.getText() +" " +month_Year);
                endDate.click();
                break;
            }
        }
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
