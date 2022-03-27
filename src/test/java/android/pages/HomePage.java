package android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementUtil;


public class HomePage {

    private AndroidDriver<MobileElement> driver;
    private ElementUtil elementUtil;
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverAndroid(), 10);

    private final By productRecyclerView = By.id("com.faladdin.app:id/productRecyclerView");
    private final By accountTab = By.id("com.faladdin.app:id/rlAccount");
    private final By coffeeReading= MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.faladdin.app:id/productRecyclerView\").childSelector(new UiSelector().text(\"Coffee Reading\"))");

    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void checkHomeScreen(){
        Assert.assertTrue(elementUtil.checkElementExist(productRecyclerView));
    }

    public void clickOnAccountTab(){
        elementUtil.click(accountTab);
    }

    public void clickOnCoffeeReading(){
        elementUtil.scrollDown(0.6, 0.0);
        elementUtil.click(coffeeReading);
    }

}
