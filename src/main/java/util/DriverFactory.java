package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static ThreadLocal<AndroidDriver<MobileElement>> tlDriverAndroid = new ThreadLocal<>();

    public WebDriver init_driver_android(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String platformName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformName");
        String platformVersion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformVersion");
        String deviceName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("deviceName");
        String app = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("app");
        String androidUrl = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("androidUrl");
        if (browser.equals("android-app")) {
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("app", app);
            tlDriverAndroid.set(new AndroidDriver<MobileElement>(new URL(androidUrl), capabilities));
        }
        return getDriverAndroid();
    }

    public static synchronized AndroidDriver<MobileElement> getDriverAndroid() {
        return tlDriverAndroid.get();
    }
}
