package testCases;


import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.B_HomePage;
import pageObjects.C_AccountRegistrationPage;
import testBase.A_BaseClass;

import static junit.framework.Assert.fail;

public class TC_001_AccountRegistrationTest extends A_BaseClass

{


    @Test(groups = {"Regression","Master"})
   public void test_account_Registration() throws InterruptedException     //here when you write any method - remember always start with "test" keyword because it's naming convention
    {

    // first we need to work with current testcase- we need to have access on "PageObject" diff. classes
    // here we require to access on "HomePage" and "AccountRegistrationPage" so for that first we need to create object for both here


        logger.info("***** TC_001_AccountRegistrationTest *****"); //before we start to run our testcase we need to call logger variable to record all the event of the class
        logger.debug("application logs......");

        try
    {

        B_HomePage hp=new B_HomePage(driver);   //now we can access all the methods of "B_HomePage"
       //*******************************************
        hp.clickRegister();
        logger.info("Clicked on register link");


        C_AccountRegistrationPage regpage=new C_AccountRegistrationPage(driver);  //now we can access all the methods of "C_AccountRegistrationPage"
      //***************************************************************************
        logger.info("Providing customer data");
        regpage.setSelectGender();
        regpage.setFirstName("Magan");  //toUpperCase()-  this is is convert your firstname into uppercase- just for understanding
        regpage.setLastName("patel");
        regpage.setDateOfBirthday("14");
        regpage.setDateOfBirthMonth("July");
        regpage.setDateOfBirthYear("1987");
        regpage.setEnterEmail(randomeString()+"@gmail.com");// randomly generated the email
        regpage.setEnterCompanyName(randomeString());
        regpage.setClickOnNewsletter();


        String password=randomAlphaNumeric(); //for password and confirm password is same so that's why we have created object called "password" and pass it's value into the both- because random method create diff. data every single statement
        regpage.setEnterPassword(password);
        regpage.setConfirmPassword(password);

        Thread.sleep(1000);
        regpage.setClickOnRegister_Btn();
        logger.info("Clicked on Register button");

       String confirmmsg=regpage.getConfirmationMsg();
        logger.info("Validating expected message");
       Assert.assertEquals(confirmmsg, "Your registration completed");

    }catch (Exception e)
    {
        logger.error("test failed");
        Assert.fail();      // WE HAVE PUT TRY-CATCH exception because incase any test get failed during execution , our full test will run
    }
        logger.info("***  Finished TC_001_AccountRegistrationTest ***");



    }



}
