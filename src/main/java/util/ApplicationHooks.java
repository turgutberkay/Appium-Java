package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.Reporter;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;


    @Before(order = 0)
    public void launchBrowser() {
        String browserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        if (browserName.equals("android-app")) {
            try {
                driverFactory = new DriverFactory();
                driver = driverFactory.init_driver_android(browserName);
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}
