package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class LoginPageSteps {
    LoginPage loginPage;
    WebDriverWait wait;
    Properties prop;


    public LoginPageSteps(){
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.loginPageUrl();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }


    @When("I enter username and password")
    public void iEnterUsernameAndPassword(DataTable dataTable) {
        List<List<String>> details = dataTable.asLists(String.class);
        for(List<String> detail : details){
        loginPage.enterUserName(detail.get(0));
        loginPage.enterPassword(detail.get(1));
        }

    }



    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageUrl")));
        String expectedUrl = prop.getProperty("homePageUrl");
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }



    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String expectedErrorMessage = loginPage.errorMessage();
        Assert.assertEquals(loginPage.errorMessage(),expectedErrorMessage);
    }

    @When("I enter {string} and {string}")
    public void iEnterAnd(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }
}