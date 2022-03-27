package android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementUtil;

public class CoffeeReadingPage {

    private AndroidDriver<MobileElement> driver;
    private ElementUtil elementUtil;
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverAndroid(), 10);

    private final By choiceBar = By.id("com.faladdin.app:id/md_content_layout");
    private final By voteNo = By.id("com.faladdin.app:id/btnDrinkForMe");
    private final By continueButton = By.id("com.faladdin.app:id/btnContinue");
    private final By readingTopicOptions = By.id("com.faladdin.app:id/layout");
    private final By sendButton = By.id("com.faladdin.app:id/btnSend");
    private final By snackBarRequestCoffeeReading = By.id("com.faladdin.app:id/snackbar_text");

    public CoffeeReadingPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void checkChoiceTurkishCoffee() {
        elementUtil.checkElementExist(choiceBar);
    }

    public void clickOnChoiceTurkishCoffee() {
        elementUtil.click(voteNo);
    }

    public void clickOnContinueButton() {
        elementUtil.click(continueButton);
    }

    public void readingTopicIsSelected() {
        elementUtil.clickFirstElementOnElements(readingTopicOptions);
    }

    public void clickOnSendButton() {
        elementUtil.click(sendButton);
    }

    public void coffeeReadingRequestVerified() {
        Assert.assertEquals(elementUtil.elementGetText(snackBarRequestCoffeeReading), "Your reading will be ready in 10 minutes!");
    }

}
