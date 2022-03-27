package android.stepDefinations;

import android.pages.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;

public class LoginPageSteps {

    AndroidDriver<MobileElement> driver = DriverFactory.getDriverAndroid();
    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);
    public WelcomePage welcomePage = new WelcomePage(driver);
    public CoffeeReadingPage coffeeReadingPage = new CoffeeReadingPage(driver);

    @Given("Click on continue with e-mail")
    public void clickOnContinueWithEMail() {
        welcomePage.clickOnExplorerButton();
        homePage.checkHomeScreen();
        homePage.clickOnAccountTab();
        loginPage.checkLoginScreen();
        loginPage.clickOnContinueWithEMail();
        loginPage.checkContunieWithEmailScreen();
    }

    @Given("Login with {string} via continue with e-mail")
    public void loginWithVia(String email) {
        welcomePage.clickOnExplorerButton();
        homePage.checkHomeScreen();
        homePage.clickOnAccountTab();
        loginPage.clickOnContinueWithEMail();
        loginPage.checkContunieWithEmailScreen();
        loginPage.enterTheEmail(email);
        loginPage.clickOnSendButton();
        loginPage.passToGoogleSteps();
        homePage.checkHomeScreen();
    }

    @When("^E mail entered (.*)$")
    public void eMailEnteredEmail(String email) {
        loginPage.enterTheEmail(email);
        loginPage.clickOnSendButton();
    }

    @When("E mail {string} entered and google step pass")
    public void eMailEnteredAndGoogleStepPass(String email) {
        loginPage.enterTheEmail(email);
        loginPage.clickOnSendButton();
        loginPage.passToGoogleSteps();
    }

    @Then("Check invalid error message")
    public void checkInvalidErrorMessage() {
        loginPage.checkInvalidErrorMessage();
    }


    @Then("Check successful login")
    public void checkSuccessfulLogin() {
        homePage.checkHomeScreen();
    }

    @When("Looking coffee reading")
    public void lookingCoffeeReading() {
        homePage.clickOnCoffeeReading();
        coffeeReadingPage.checkChoiceTurkishCoffee();
        coffeeReadingPage.clickOnChoiceTurkishCoffee();
        coffeeReadingPage.clickOnContinueButton();
        coffeeReadingPage.readingTopicIsSelected();
        coffeeReadingPage.clickOnSendButton();
    }

    @Then("Coffee reading request verified")
    public void coffeeReadingRequestVerified() {
        coffeeReadingPage.coffeeReadingRequestVerified();
    }
}
