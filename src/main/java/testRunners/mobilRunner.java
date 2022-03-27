package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

public class mobilRunner {
    @CucumberOptions(
            features = {"src/test/java/android/features"},
            tags = "@LoginPage",
            glue = {"android/stepDefinations", "util"},
            plugin = {
                    "summary", "pretty", "html:Reports/CucumberReport/Reports.html",
                    "json:Reports/CucumberReport/Report",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            }
    )
    public class MobilRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider()
        public Object[][] scenarios() {
            return super.scenarios();
        }

    }
}