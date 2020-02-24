package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePageBeforeLogin {
    @FindBy(css = "a[href='/accounts/login/']")
    public WebElement loginButton;

    @FindBy(css = "a[href='/accounts/signup/']")
    public WebElement signupButton;

    public HomePageBeforeLogin() {
        PageFactory.initElements(Driver.get(), this);
    }
//
//    public WebElement loginButton;
//    public WebElement signupButton;
//
//    public HomePageBeforeLogin() {
//        loginButton = Driver.get().findElement(By.cssSelector("a[href='/accounts/login/']"));
//        signupButton = Driver.get().findElement(By.cssSelector(""));
//    }
}