package android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementUtil;

public class WelcomePage {

    private AndroidDriver<MobileElement> driver;
    private ElementUtil elementUtil;
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverAndroid(), 10);

    private final By explorerButton = By.id("com.faladdin.app:id/getStartedButton");

    public WelcomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void clickOnExplorerButton(){
        elementUtil.click(explorerButton);
    }

}
