package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;  //logging - we need to import from only org.apache //we have already add apache dependency

/*
- BaseClass contains reusable methods - remember this
- The Testcases which require some common methods eg. Setup method(opening browser) , TearDown method (closing browser) etc. which require everywhere
- ....so in that case we create those methods in "BaseClass" and extend this class to different Testcases's class to use this methods
 */





public class A_BaseClass
{
    public WebDriver driver;
    public Logger logger;     //we need to declare this logger variable for creating logfiles - mean whatever work you carry through your project , you need to record all


    @BeforeClass
    public void setup()   //we create setup method for every test
    {
        logger= LogManager.getLogger(this.getClass());//for logging.   //this.getClass()  -  this method for all the testcase class will record the logs, //so we don't need to separately for each testcase class



    //**************************************************************************************************************
    //Bottom 4 line code we write here just for your knowledge. Eg. when we run the program  we see that it's controlled by automation... message on the top header
    //so when you want run your program like normal site without that message your browser, in that case you use this bottom codes

       /* ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);  */
    //********************************************************************************************************


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown()       //we create tearDown method for every test
    {
        driver.quit();

    }


    // we have create some Java methods here for random data to pass into our testcases. eg. firstname, lastname, email, phoneNo. etc.
    // so for that we create some random methods here to pass the data
    // because it's java methods we don't need Annotation before the method name
    public String randomeString()  //randomString method will generate every single time new string randomly between AtoZ letter upto 5 character- as we have mentioned below . we can change this no. like 10 or 15 or 20
                                  //so our data will not be duplicated and throw any error
                                  //so when you call this method , it will give you 5 string character
    {
        String generatedString = RandomStringUtils.randomAlphabetic(5);  //we can change this no. as per we want
        return (generatedString);
    }



    public String randomeNumber()  //this is again same like above but it's generate different numbers everytime you execute.
    {
        String generatedString2 = RandomStringUtils.randomNumeric(2);
        return (generatedString2);
    }



    public String randomAlphaNumeric() //this is when you pass combination of alphabetic and numbers you can use this
    {
        String st = RandomStringUtils.randomAlphabetic(4);
        String num = RandomStringUtils.randomNumeric(3);

        return (st+"@"+num);
    }







}
