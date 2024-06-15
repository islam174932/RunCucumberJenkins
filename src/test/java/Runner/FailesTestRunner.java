package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/failed_senarios.txt", // Path to your feature file(s)
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
public class FailesTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
