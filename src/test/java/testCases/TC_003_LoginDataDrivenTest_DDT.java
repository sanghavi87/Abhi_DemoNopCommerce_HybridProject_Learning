package testCases;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.B_HomePage;
import pageObjects.D_LoginPage;
import pageObjects.E_MyAccountPage;
import testBase.A_BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest_DDT extends A_BaseClass
{

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) //we need to call from "DataProviders" class
    public void test_loginDDT(String email, String password, String expResult)  //we passed here parameter email and password because our dataProviders pass this 2 information

    {
        try {


            logger.info("*** Starting TC_003_LoginDataDrivenTest DDT ***");

            B_HomePage hp = new B_HomePage(driver);  //for login we get data from "B_HomePage" first
            hp.setClickOnLogin();
            logger.info("*** Clicked on Login Link ***");


            D_LoginPage lp = new D_LoginPage(driver);  //for login we get data from "D_LoginPage" 2nd
            logger.info("*** Providing Login Details ***");
            lp.setEnterEmail(email);   //valid/invalid email we are getting from "DataProviders" file now.
            lp.setEnterPassword(password);  //valid/invalid password we are getting from "DataProviders" file now.
            lp.setClickOnLoginBtn();
            logger.info("*** Clicked on Login Button ***");


            E_MyAccountPage map=new E_MyAccountPage(driver); //we need to validate the page after successful login which is "MyAccount"
            boolean targetpage= map.isMyAccountPageExist();

            //logic:1
            //********
            if (expResult.equals("valid"))   //if we have valid data in excel sheet (check result column) then we should successfully login and should get targetPage
            {
                if(targetpage==true)         //then we should get our targetpage means (AccountPage) should appear/display
                {
                    map.setClickOnLogoutBtn();    //because we need to logout and enter again new data
                    Assert.assertTrue(true); //so with valid data - make my test get pass
                }
            }
            else
            {
                Assert.assertTrue(false);  //if with valid data if i am unable to login then else part will execute - means my test will get failed
            }

            //logic:2
            //********
            if(expResult.equals("invalid")) //if your data is invalid
            {
                if(targetpage==true)       //and still if you get your target page
                {
                    map.setClickOnLogoutBtn();  //because you get target page with invalid data - you need to get logout to test next data
                   Assert.assertTrue(false); // mean your test case should get failed
                }
                else
                {
                    Assert.assertTrue(true); //with invalid data if you don't able to get login then else part will execute- means your test is pass
                                                     //in that case you don't get targetpage and you need need to logout so we don't need logout method here
                }

            }


            }catch (Exception e)
            {
                Assert.fail();
            }


        logger.info("*** Finished TC_003_LoginDataDrivenTest DDT ***");






    }


}
