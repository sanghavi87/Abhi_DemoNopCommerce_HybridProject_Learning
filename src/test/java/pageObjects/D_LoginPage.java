package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class D_LoginPage extends A_BasePage
{
    // 1) We Create Constructor here first :-
//*******************************************
    public D_LoginPage(WebDriver driver)
    {
        super(driver);        //we are here invoking parent class (A_BasePage) properties so super keyword we can use to call parent class's variables, methods and also constructor
    }



// 2) Elements:-
//*******************

    @FindBy(id="Email")
    WebElement EnterEmail;

    @FindBy(className = "passwor")
    WebElement EnterPassword;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement ClickOnLoginBtn;

    //we need to add here validation , once the website work fine


    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement ClickOnLogoutBtn;



// 3) Action Methods:-
//*************************

   public void setEnterEmail(String email)
   {
       EnterEmail.sendKeys();
   }

   public void setEnterPassword(String password)
   {
       EnterPassword.sendKeys();
   }

   public void setClickOnLoginBtn()
   {
       ClickOnLoginBtn.click();
   }

   //we need to add here validation , once the website work fine




    public void setClickOnLogoutBtn()
    {
        ClickOnLogoutBtn.click();
    }



















}
