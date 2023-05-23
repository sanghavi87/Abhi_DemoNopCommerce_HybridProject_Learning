package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*  Remember:-
   **************
- Page Object Class always contain 3 things
1) Constructor
2) Web Elements
3) Action Method



 */
public class B_HomePage extends A_BasePage
{

// 1) We Create Constructor here first :-
//*******************************************
    public B_HomePage(WebDriver driver)
    {
        super(driver);        //we are here invoking parent class (A_BasePage) properties so super keyword we can use to call parent class's variables, methods and also constructor
    }




// 2) Elements:-
//*******************

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement ClickOnLogin;





// 3) Action Methods:-
//*************************

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void setClickOnLogin()
    {
        ClickOnLogin.click();
    }

}
