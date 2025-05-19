package testCases;

import org.testng.annotations.Test;
import pageObjects.ContactUS;
import pageObjects.Homepage;
import testBase.Base_Class;

public class TC005_FindMyBooking extends Base_Class
{
    @Test
    public void findMyBooking()
    {
        Homepage hp= new Homepage(driver);
        ContactUS cu= new ContactUS(driver);

        hp.banner();
        hp.cookie_banner();
        cu.setContactus();
        cu.details("yogendra@holisto.com" , "10697370");
    }
}
