package testCases;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.B_HomePage;
import pageObjects.D_LoginPage;
import pageObjects.E_MyAccountPage;
import testBase.A_BaseClass;

public class TC_002_LoginTest extends A_BaseClass
{

    @Test(groups = {"Sanity","Master"})

    public void test_login()
    {
        try {
            logger.info("*** Starting TC_002_LoginTest ****");

            B_HomePage hp = new B_HomePage(driver);  //for login we get data from "B_HomePage" first
            hp.setClickOnLogin();
            logger.info("*** Clicked on Login Link ***");
            System.out.println("login test");


            D_LoginPage lp = new D_LoginPage(driver);  //for login we get data from "D_LoginPage" 2nd
            logger.info("*** Providing Login Details ***");
            lp.setEnterEmail(rb.getString("email"));   //valid email we are getting from "config.properties" file by using "rb" variable which we have created in "BaseClass"
            lp.setEnterPassword(rb.getString("password")); //valid password we are getting from "config.properties" file by using "rb" variable which we have created in "BaseClass"
            lp.setClickOnLoginBtn();
            logger.info("*** Clicked on Login Button ***");


            E_MyAccountPage map=new E_MyAccountPage(driver); //after successful login validate my account page
            logger.info("*** Validate MyAccountPage after successful login ***");
           boolean targetpage= map.isMyAccountPageExist();
           Assert.assertEquals(targetpage,true);

        }
        catch (Exception e)     //if anything is failed and throw any exception then in that case my catch block will perform
        {
           Assert.fail();
        }

        logger.info("*** Finished TC_002_Login ***");


    }









}
