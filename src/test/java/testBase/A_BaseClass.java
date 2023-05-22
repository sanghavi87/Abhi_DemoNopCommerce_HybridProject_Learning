package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;  //logging - we need to import from only org.apache //we have already add apache dependency
import org.testng.annotations.Parameters;

/*
- BaseClass contains reusable methods - remember this
- The Testcases which require some common methods eg. Setup method(opening browser) , TearDown method (closing browser) etc. which require everywhere
- ....so in that case we create those methods in "BaseClass" and extend this class to different Testcases's class to use this methods
 */





public class A_BaseClass
{
    public static WebDriver driver;
    public Logger logger;     //we need to declare this logger variable for creating logfiles - mean whatever work you carry through your project , you need to record all

    public  ResourceBundle rb;  // this class variable we created here to get the data from "config.properties" file for that we use

    //Approach-1 :- by using xml file and pass the browser through parameter:-
    //***********************************************************************

    @BeforeClass
    @Parameters("browser") //we pass here "browser" from the xml parameter to call diff browser
    public void setup(String br) //we create "br" variable to call diff. browser  //we create setup method for every test
    {

        rb=ResourceBundle.getBundle("config"); //this is method we use to load config.properties file data

        logger = LogManager.getLogger(this.getClass());//for logging.   //this.getClass()  -  this method for all the testcase class will record the logs, //so we don't need to separately for each testcase class

        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

       // driver.get("https://demo.nopcommerce.com/");
        //OR we want to call url from config.properties file
        //*****************************************************
       driver.get(rb.getString("url")); //BY usiing "rb" we use the method call getString and use the keyword "appURL" Which we menthoed in config.properties file



        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


         /* when you want to run through xml file :-
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">


            <suite name="my suit">
                <test name="my test">
                    <parameter name="browser" value="edge"></parameter>   //you need to pass the parameter here
                    <classes>
                        <class name="testCases.TC_001_AccountRegistrationTest"></class>  //you need to pass the class here which you want to run
                    </classes>
                </test>
            </suite>
         */
    }



    //Approach-2 :- //OR Normal way we create setup method to open browser:-
    //**************************************************************************


//
//        @BeforeClass
//    public void setup()   //we create setup method for every test
//    {
//        logger= LogManager.getLogger(this.getClass());//for logging.   //this.getClass()  -  this method for all the testcase class will record the logs, //so we don't need to separately for each testcase class



    //**************************************************************************************************************
    //Bottom 4 line code we write here just for your knowledge. Eg. when we run the program  we see that it's controlled by automation... message on the top header
    //so when you want run your program like normal site without that message your browser, in that case you use this bottom codes

       /* ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);  */
    //********************************************************************************************************


//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://demo.nopcommerce.com/");
//
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

//    }


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

    //Method to use the take the failed testcase screenshot :-
    //**********************************************************
    public String captureScreen(String tname) throws IOException
    {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try
        {
            FileUtils.copyFile(source, new File(destination));
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return destination;

    }







}
