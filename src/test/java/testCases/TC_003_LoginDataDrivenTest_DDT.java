package testCases;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.B_HomePage;
import pageObjects.D_LoginPage;
import testBase.A_BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest_DDT extends A_BaseClass
{

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) //we need to call from "DataProviders" class
    public void test_loginDDT(String email, String password, String result)  //we passed here parameter email and password because our dataProviders pass this 2 information

    {
        try {


            logger.info("*** Starting TC_LoginDataDrivenTest DDT ***");

            B_HomePage hp = new B_HomePage(driver);  //for login we get data from "B_HomePage" first
            hp.setClickOnLogin();
            logger.info("*** Clicked on Login Link ***");


            D_LoginPage lp = new D_LoginPage(driver);  //for login we get data from "D_LoginPage" 2nd
            logger.info("*** Providing Login Details ***");
            lp.setEnterEmail(email);   //valid/invalid email we are getting from "DataProviders" file now.
            lp.setEnterPassword(password);  //valid/invalid password we are getting from "DataProviders" file now.
            lp.setClickOnLoginBtn();
            logger.info("*** Clicked on Login Button ***");
            lp.setClickOnLogoutBtn();
            logger.info("*** Clicked on Logout Button ***");



            }catch (Exception e)
            {
                Assert.fail();
            }


        logger.info("*** Finished TC_LoginDataDrivenTest DDT ***");






    }


}
