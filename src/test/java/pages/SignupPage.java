package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.User;
import utils.Driver;

public class SignupPage {
    @FindBy ( name = "email")
    WebElement email;

    @FindBy (name = "first_name")
    WebElement firstName;

    @FindBy ( name = "last_name")
    WebElement lastName;

    @FindBy ( name = "password1")
    WebElement password;

    @FindBy ( name = "password2")
    WebElement passwordConfirm;

    @FindBy ( name = "phone")
    WebElement phone;

    @FindBy ( name = "gender")
    WebElement gender;

    @FindBy ( name = "is_own_writer")
    WebElement isOwn;

    @FindBy ( name = "is_seozeo_writer")
    WebElement isSeoZeo;

    @FindBy (css = "button.btn.btn-primary.btn-block")
    WebElement button;

    public void signUp(User user) {
        email.sendKeys(user.email);
        firstName.sendKeys(user.firstName);
        lastName.sendKeys(user.lastName);
        button.click();
    }

    public SignupPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
