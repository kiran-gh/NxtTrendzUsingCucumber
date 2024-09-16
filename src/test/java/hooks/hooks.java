package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ConfigReader;

import java.io.FileNotFoundException;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class hooks {


    @Before
    public void startUp() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/webDriverFactory/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}