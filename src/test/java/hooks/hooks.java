package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ConfigReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class hooks {


    @Before
    public void startUp() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/webDriverFactory/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @After(order = 0)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            try {
                // Specify the screenshot folder path (create it if it doesn't exist)
                String screenshotFolder = System.getProperty("user.dir") + "/screenshots/";

                // Create the directory if not exists
                Files.createDirectories(Paths.get(screenshotFolder));

                // Create screenshot file with scenario name and timestamp
                File destinationFile = new File(screenshotFolder + scenario.getName() + "_" + System.currentTimeMillis() + ".png");

                // Copy the screenshot to the destination
                Files.copy(sourceFile.toPath(), destinationFile.toPath());

                System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}