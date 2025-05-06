package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Signup;
import testBase.Base_Class;

public class TC002_Signup_Test extends Base_Class {



    @Test(groups = {"Regression", "Master"})
    public  void signup() throws InterruptedException
    {
        try {
            Homepage hp = new Homepage(driver);
            hp.login();
            Thread.sleep(2000);
            hp.signUp();

            Signup su = new Signup(driver);
            Thread.sleep(2000);

            String fullName= randomString() + " " + randomString();
            String email= randomString() + "@gmail.com";
            String password = randomAlphanumeric();

            su.personalDetails(fullName,email, password, password);
            su.create();
//
//            su.name(randomString() + " " + randomString());// dynamic
//            su.user_email(randomString() + "@gmail.com"); //dynamic
//
//            String password = randomAlphanumeric(); // pw store in variable
//            su.pass(password);
//            su.con_pass(password);
//            su.pp();
//            su.tc();
//            su.create();


            //Login verification

            if (su.logoutDisplayed())
            {
                Assert.assertTrue(su.logoutDisplayed());
                System.out.println("✅ Login successful");
                su.logout_click();
            }
            else
            {
                System.out.println("❌ Login failed");
                Assert.fail();
            }

            //Logout verification
            if(hp.login_verification())
            {
                Assert.assertTrue(hp.login_verification());
                System.out.println("✅ Logout successful");
            }
            else
            {
                System.out.println("❌ Logout failed");
                Assert.fail();
            }
        }
        catch (Exception e)
        {
            logger.error("test failed");
            logger.debug("debug log");
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }




    }


}
