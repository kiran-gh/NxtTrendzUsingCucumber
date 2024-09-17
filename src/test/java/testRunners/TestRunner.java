package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/AppFeatures"},
        glue = {"stepDefinitions","hooks"},
//        tags = "@Third",
       plugin = {"pretty",
                "json:target/MyReports/report.json",
                "json:target/MyReports/report.xml"}
)
public class TestRunner {
}