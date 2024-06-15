package Runner;


import StepDefinitions.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import java.util.List;

@CucumberOptions(
        features = "src/test/java/feature", // Path to your feature file(s)
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/testcases.html",
                "json:target/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test/output",
                "rerun:target/failed_senarios.txt"

        },
        monochrome = true,
        tags = "not @Regression"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
