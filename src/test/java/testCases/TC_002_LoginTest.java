package testCases;

import junit.framework.Assert;
import pageObjects.B_HomePage;
import pageObjects.D_LoginPage;
import testBase.A_BaseClass;

public class TC_002_LoginTest extends A_BaseClass
{

    public void test_login()
    {
        try {
            logger.info("*** Starting TC_002_LoginTest ****");

            B_HomePage hp = new B_HomePage(driver);  //for login we get data from "B_HomePage" first
            hp.setClickOnLogin();
            logger.info("*** Clicked on Login Link ***");


            D_LoginPage lp = new D_LoginPage(driver);  //for login we get data from "D_LoginPage" 2nd
            logger.info("*** Providing Login Details ***");
            lp.setEnterEmail(rb.getString("email"));   //valid email we are getting from "config.properties" file by using "rb" variable which we have created in "BaseClass"
            lp.setEnterPassword(rb.getString("password")); //valid password we are getting from "config.properties" file by using "rb" variable which we have created in "BaseClass"
            lp.setClickOnLoginBtn();
            logger.info("*** Clicked on Login Button ***");







        }
        catch (Exception e)
        {
            Assert.fail();
        }

        logger.info("*** Finished TC_002_Login ***");


    }









}
