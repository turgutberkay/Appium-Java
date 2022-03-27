package android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementUtil;

public class LoginPage {

    private AndroidDriver<MobileElement> driver;
    private ElementUtil elementUtil;
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverAndroid(), 10);

    private final By contunieWithEmailButton = By.id("com.faladdin.app:id/btnMail");
    private final By contunieWithEmailScreenText = By.id("com.faladdin.app:id/textViewTitle");
    private final By emailTextBox = By.id("com.faladdin.app:id/editTextEmail");
    private final By sendButton = By.id("com.faladdin.app:id/btnSend");
    private final By openEmailAppButton = By.id("com.faladdin.app:id/btnOpenEmail");
    private final By continueScreenTvTerm = By.id("com.faladdin.app:id/tvTerm");
    private final By invalidErrorMessage = By.id("com.faladdin.app:id/snackbar_text");
    private final By emailInGoogle = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.gm:id/thread_list_view\").childSelector(new UiSelector().index(1))");
    private final By emailContanier = By.id("com.google.android.gm:id/conversation_container");
    private final By showQuetedText = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.gm:id/conversation_container\").childSelector(new UiSelector().text(\"Show quoted text\"))");
    private final By returnAppLink = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.gm:id/conversation_container\").childSelector(new UiSelector().text(\"Let The Truth Unfold\"))");

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void checkLoginScreen() {
        elementUtil.checkElementExist(continueScreenTvTerm);
    }

    public void clickOnContinueWithEMail() {
        elementUtil.click(contunieWithEmailButton);
    }

    public void checkContunieWithEmailScreen() {
        elementUtil.checkElementExist(contunieWithEmailScreenText);
    }

    public void enterTheEmail(String email) {
        elementUtil.sendKey(emailTextBox, email);
    }

    public void clickOnSendButton() {
        elementUtil.click(sendButton);
    }

    public void passToGoogleSteps() {
        elementUtil.click(openEmailAppButton);
        elementUtil.click(emailInGoogle);
        elementUtil.checkElementExist(emailContanier);
        elementUtil.click(showQuetedText);
        elementUtil.scrollDown(0.5,0.2);
        elementUtil.click(returnAppLink);
    }

    public void checkInvalidErrorMessage() {
        Assert.assertEquals("Email address is not valid.", elementUtil.elementGetText(invalidErrorMessage));
    }


}
