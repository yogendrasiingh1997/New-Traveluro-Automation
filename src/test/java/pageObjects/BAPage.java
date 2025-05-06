package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BAPage extends Basepage
{
    public BAPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//img[@src='/assets/images/Wheel-only-transparent-reapet.gif']")
    WebElement loader;

    @FindBy(xpath = "//a[@class='showmore-btn']")
    List<WebElement> show;

    @FindBy(xpath = "//div[@class='room-book-now']/div")
    List<WebElement> freeCancellation;

//    @FindBy(xpath = "//div[@class='room-choices-details']//div[@class='col-sm-12']//div[@class='row']")
//    List<WebElement> freeCancellation;

    @FindBy(className = "book-now-col")
    WebElement bookBtn;

    public void switchwindow()
    {
        //Switch window
        String parentWindow=driver.getWindowHandle();
        Set<String> windowIDs=driver.getWindowHandles();

        for(String window: windowIDs)
        {
            if(!window.equals(parentWindow))
            {
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println("HotelName: " +driver.getTitle());
    }

    public void baPageLoader()
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(loader));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='67%'");
    }

    public void showBtn()
    {
        if(!show.isEmpty() && show.get(0).isDisplayed())
        {
            try
            {
                show.get(0).click();
            }
            catch (Exception e)
            {
                System.out.println("Unable to click 'Show More'. Possibly only one deal is present.");
            }
        }
    }

    public void freeCancellationDeal()
    {
        try
        {
            List<WebElement> getDeals=freeCancellation;
            for(WebElement deal: getDeals)
            {
                if(deal.getText().contains("Free Cancellation By"))
                {
                   WebElement bookButton= deal.findElement(By.className("book-now-col"));
                   bookButton.click();
                   System.out.println("✅ Free cancellation deal selected.");
                   return;
                }
                System.out.println("⚠️ No free cancellation deal found. Only non-refundable deals available.");
            }
        }
        catch (Exception e)
        {
            System.out.println("❌ Error while selecting free cancellation deal: " + e.getMessage());
        }
    }

}
