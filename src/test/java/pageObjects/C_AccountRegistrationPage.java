package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class C_AccountRegistrationPage extends A_BasePage
{

    // 1) We Create Constructor here first :-
//******************************************
    public C_AccountRegistrationPage(WebDriver driver)
    {
        super(driver);   //we are here invoking parent class (A_BasePage) properties so super keyword we can use to call parent class's variables, methods and also constructor
    }


// 2) Elements:-
//*****************

    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement selectGender;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthday;

    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    WebElement enterEmail;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement enterCompanyName;

    @FindBy(xpath = "//input[@id='Newsletter']")
    WebElement clickOnNewsletter;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement enterPassword;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickOnRegister_Btn;

    @FindBy(xpath = "//div[@class='result']")  //we need to validate this confirmation "your registration completed"
    WebElement msgConfirmation;


// 3) Action Methods:-
//***********************

    public void setSelectGender()
    {
        selectGender.click();
    }

    public void setFirstName(String firstName)
    {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName)
    {
        this.lastName.sendKeys(lastName);
    }

    public void setDateOfBirthday(String dateOfBirthday)
    {
        this.dateOfBirthday.sendKeys(dateOfBirthday);
    }

    public void setDateOfBirthMonth(String dateOfBirthMonth)
    {
        this.dateOfBirthMonth.sendKeys(dateOfBirthMonth);
    }

    public void setDateOfBirthYear(String dateOfBirthYear)
    {
        this.dateOfBirthYear.sendKeys(dateOfBirthYear);
    }

    public void setEnterEmail(String enterEmail)
    {
        this.enterEmail.sendKeys(enterEmail);
    }

    public void setEnterCompanyName(String enterCompanyName)
    {
        this.enterCompanyName.sendKeys(enterCompanyName);
    }

    public void setClickOnNewsletter()
    {
        this.clickOnNewsletter.click();
    }

    public void setEnterPassword(String enterPassword)
    {
        this.enterPassword.sendKeys(enterPassword);
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void setClickOnRegister_Btn()
    {
        this.clickOnRegister_Btn.click();
    }


  /*  public String getConfirmationMsg()    //We are validating that we are successfully register by validating the confirmation message - check message above in method
    {
           String status=msgConfirmation.getText();  //we are getting the text message here and return the the value
           return status;

    }*/

                            //OR

      //     OR We can put this in try and catch too so incase if is it not validate your test run till the end
      //**************************************************************************************************************
    public String getConfirmationMsg()    //We are validating that we are successfully register by validating the confirmation message - check message above in method
    {
        try
        {
            return (msgConfirmation.getText());    //we are getting the text message here and return the the value
        }
        catch (Exception e)
        {
            return (e.getMessage());

        }


    }
}
