package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import testBase.Base_Class;
import utilities.dataProvider;

public class tc003Loginddt extends Base_Class

{
    @Test(dataProvider = "LoginData", dataProviderClass = dataProvider.class)


    public void login_verify(String Username, String Password, String exp) {
       try {
           logger.info("*** Test is Starting ***");
           Homepage hp = new Homepage(driver); //homepage pom enable
           logger.info("Click on login button");
           hp.login();

           //Login page
           logger.info("Enter Valid login details");
           LoginPage lp = new LoginPage(driver); //login page pom enable
           lp.email(Username);
           lp.password(Password);
           lp.submit();
           driver.navigate().refresh();
           Thread.sleep(2000);
           hp.login();


           //login validation
           logger.info("Validtion for login");
           boolean target = lp.logout();


           if (exp.equalsIgnoreCase("valid")) {
               if (target) {
                   lp.logoutClick();
                   Assert.assertTrue(true);
               } else {
                   Assert.fail();
               }
           }
           if (exp.equalsIgnoreCase("invalid")) {
               if (target) {
                   lp.logoutClick();
                   Assert.assertTrue(true);
               } else {
                   Assert.fail();
               }
           }
       } catch (Exception e)
       {
           Assert.fail();
       }

    }

}
