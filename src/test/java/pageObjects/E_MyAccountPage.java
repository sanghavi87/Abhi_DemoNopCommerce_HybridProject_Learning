package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class E_MyAccountPage extends A_BasePage
{
// 1) We Create Constructor here first :-
//*******************************************
    public E_MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

// 2) Elements:-
//*******************
    @FindBy(xpath = "//a[@class='ico-account']")  //myAccount page heading
    WebElement myAccountPage;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement ClickOnLogoutBtn;


// 3) Action Methods:-
//*************************
    public boolean isMyAccountPageExist()       //we are validating after successful login
    {
        try {
            return (myAccountPage.isDisplayed());
        }catch (Exception e)
        {
            return (false);
        }

    }

    public void setClickOnLogoutBtn()
    {
        ClickOnLogoutBtn.click();
    }







}
