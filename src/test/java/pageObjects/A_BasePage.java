package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class A_BasePage
{
   public WebDriver driver;

// 1) Create Constructor :-           //we create constructor in BasePage , so we can call this constructor in every pageObject class so we don't need to create in each pageObject class constructor everytime. we can call this constructor to there
//****************************
    public A_BasePage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



}
