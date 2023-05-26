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

    @FindBy(xpath="//input[@id='Email']")
    WebElement EnterEmail;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement EnterPassword;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement ClickOnLoginBtn;





// 3) Action Methods:-
//*************************

   public void setEnterEmail(String email)
   {
       EnterEmail.sendKeys(email);
   }

   public void setEnterPassword(String password)
   {
       EnterPassword.sendKeys(password);
   }

   public void setClickOnLoginBtn()
   {
       ClickOnLoginBtn.click();
   }





















}
