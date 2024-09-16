package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures"},
        glue = {"stepDefinitions","hooks"},
        tags = "@homepage",
       plugin = {"pretty",
                "json:target/MyReports/report.json",
                "json:target/MyReports/report.xml"}
)
public class TestRunner {
}