package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import testBase.Base_Class;

public class TC001_Login_Test extends Base_Class {


    @Test(groups = {"Sanity", "Master"})
    public void login() throws InterruptedException
    {
        try {
            //Homepage
            logger.info("*** Test is Starting ***");
            Homepage hp = new Homepage(driver); //homepage pom enable
            logger.info("Click on login button");
            hp.login();


            //Login page
            logger.info("Enter Valid login details");
            LoginPage lp = new LoginPage(driver); //login page pom enable
            lp.email(p.getProperty("email"));
            Thread.sleep(1000);
            lp.password(p.getProperty("password"));
            lp.submit();

            Thread.sleep(2000);

            //login validation
            logger.info("Validation for login");

            if (lp.logout())
            {
                System.out.println("✅ Login successful");
                lp.logoutClick();
            }
            else
            {
                System.out.println("❌ Login failed");
                Assert.fail("Login was not successful — logout element not found.");
            }
        }
        catch (Exception e)
        {
           return;
        }

        logger.info("*** test is finish ***");

    }
}
