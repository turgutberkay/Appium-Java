package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverAndroid(), 10);
    private Actions action;
    private TouchAction actions;

    public ElementUtil(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.actions = new TouchAction(driver);
    }

    public void sendKey(By byElement, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
            action.moveToElement(element).perform();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Could not enter text value for element");
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void click(By byElement) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
            action.moveToElement(element).perform();
            element.click();
        } catch (Exception e) {
            System.out.println("Element could not be clicked");
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void clickElementEqualText(By by, String text) {
        boolean check = false;
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))");
                element.click();
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public String elementGetText(By by) {
        String text = null;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            text = driver.findElement(by).getText();

        } catch (Exception e) {
            System.out.println("Could not get text of element");
            e.printStackTrace();
            Assert.fail();
        }
        return text;
    }

    public boolean checkElementExist(By by) {
        boolean check = false;
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            if (elements.size() != 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Element not exist. Other elements will be checked");
            Assert.fail();
        }
        return check;
    }

    public void clickFirstElementOnElements(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            driver.findElements(by).get(1).click();
        } catch (Exception e) {
            System.out.println("Could not click first element");
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void scrollDown(double start, double end) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            int ScrollStart = (int) (dimension.getHeight() * start);
            int ScrollEnd = (int) (dimension.getHeight() * end);
            actions.press(PointOption.point(0, ScrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
                    .moveTo(PointOption.point(0, ScrollEnd))
                    .release().perform();
        } catch (Exception e) {
            System.out.println("Could not scroll down");
            e.printStackTrace();
            Assert.fail();
        }
    }
}
