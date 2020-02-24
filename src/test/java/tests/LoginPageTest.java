package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePageBeforeLogin;
import pages.LoginPage;
import pages.SignupPage;
import pojo.User;
import utils.Driver;

public class LoginPageTest {
    private HomePageBeforeLogin homeBeforeLogin;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private WebDriver driver;

    @BeforeTest
    public void tearUp() {
        homeBeforeLogin = new HomePageBeforeLogin();
        loginPage = new LoginPage();
        signupPage = new SignupPage();
        driver = Driver.get();
        driver.get("https://blogger.life/");
    }

    @Test
    public void testLogin() throws InterruptedException {
        homeBeforeLogin.loginButton.click();
        loginPage.login("mucahitaktepe@gmail.com", "root1234");
    }

    @Test
    public void testSignUp() throws InterruptedException {
        homeBeforeLogin.signupButton.click();
        User user = new User();
        user.email = "onur@gmail.com";
        user.firstName = "Onur";
        user.lastName = "Kasaburi";

        signupPage.signUp(user);
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        Driver.close();
    }
}
