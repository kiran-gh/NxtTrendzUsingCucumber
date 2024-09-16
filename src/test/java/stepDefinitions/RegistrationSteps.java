package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utility.ConfigReader;

import java.util.List;
import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class RegistrationSteps {
    Properties prop;
    RegistrationPage registrationPage;

    public RegistrationSteps() {
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Given("User is on NxtTrendz application registration page")
    public void userIsOnNxtTrendzApplicationRegistrationPage() {
        // Initialize the RegistrationPage object and navigate to the registration page URL
        registrationPage = new RegistrationPage(driver);
        registrationPage.registrationPageUrl(); // Navigates to the registration page

        // Get the current URL and assert that it matches the expected registration page URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("User is not on the expected registration page.",
                prop.getProperty("registrationPageUrl"), currentUrl);
    }

    @When("the user enters the following details for registration")
    public void theUserEntersTheFollowingDetailsForRegistration(DataTable dataTable) throws InterruptedException {
        // Retrieve the registration details from the DataTable and fill in the registration form
        List<List<String>> data = dataTable.asLists(String.class);
        // Loop through the DataTable and register each set of details
        for (List<String> row : data) {
            // Ensure that the correct index is used for the password (row.get(2))
            registrationPage.registerDetails(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
        }
    }

    @Then("checks the terms and conditions checkbox")
    public void checksTheTermsAndConditionsCheckbox() {
        // Check the terms and conditions checkbox on the registration page
        registrationPage.acceptTerms();
    }

    @And("clicks on the register button")
    public void clicksOnTheRegisterButton() {
        // Submit the registration form by clicking the register button
        registrationPage.submitRegistration();
    }

    @Then("User should be able to see the registration success message")
    public void userShouldBeAbleToSeeTheRegistrationSuccessMessage() {
        // Verify that the registration was successful by checking the success message
        String successMessage = registrationPage.successfulRegistration();
        Assert.assertTrue("Registration success message is not displayed or incorrect.",
                successMessage.contains("Registration Successful")); // Replace with the actual success message
    }

    @When("the user enters {string} {string} {string} {string} {string} details for registration")
    public void theUserEntersDetailsForRegistration(String username, String email, String password, String gender, String country) throws InterruptedException {
        // Register a user by entering details directly through parameters
        registrationPage.registerDetails(username, email, password, gender, country);
    }


}