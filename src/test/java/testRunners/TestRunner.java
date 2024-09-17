package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/AppFeatures"},
        glue = {"stepDefinitions","hooks"},
//        tags = "@Second",
       plugin = {"pretty",
               "json:target/MyReports/report.json",
               "json:target/MyReports/report.xml"},
        publish = true,
        monochrome = true
)
public class TestRunner {

/*    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) { // Loop to run the tests 5 times
            System.out.println("Running test iteration: " + (i + 1));
            Result result = JUnitCore.runClasses(TestRunner.class); // Your Cucumber test runner class
            if (!result.wasSuccessful()) {
                System.out.println("Test failed in iteration: " + (i + 1));
            }
        }
    }


   The above commented code is used for running the test cases multiple times. It is for observation purpose only not
the actual code.*/
}