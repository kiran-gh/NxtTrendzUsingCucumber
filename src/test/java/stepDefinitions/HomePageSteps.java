package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;

import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class HomePageSteps {
    private HomePage homePage;
    private final Properties prop;


    public HomePageSteps(){
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validUserLogin();
    }

    @When("the user is redirected home page.")
    public void theUserIsRedirectedHomePage() {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.homePageUrl(),prop.getProperty("homePageUrl"));
    }

    @Then("home page heading along with description and shopNow button should be displayed.")
    public void homePageHeadingAlongWithDescriptionAndShopNowButtonShouldBeDisplayed() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.homePageHeading());
        Assert.assertTrue(homePage.homePageDescription());
        Assert.assertTrue(homePage.homePageShopNowBtn());
    }

    @And("navigation buttons \\(Home,Products,Carts,Logout) should be displayed.")
    public void navigationButtonsHomeProductsCartsLogoutShouldBeDisplayed() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.homePageLink());
        Assert.assertTrue(homePage.productsPageLink());
        Assert.assertTrue(homePage.cartPageLink());
        Assert.assertTrue(homePage.logoutPageLink());
    }

    @And("user clicks on products button in the navbar.")
    public void user_clicks_on_products_button_in_the_navbar() {
        homePage.productsPageLinkClick();
    }

    @Then("user should be able to navigate to products page.")
    public void user_should_be_able_to_navigate_to_products_page() {
        Assert.assertEquals(driver.getCurrentUrl(),homePage.productsPageUrl());
    }

    @And("user clicks on cart button in the navbar.")
    public void user_clicks_on_cart_button_in_the_navbar() {
        homePage.cartPageLinkClick();
    }

    @Then("user should be able to navigate to cart page.")
    public void user_should_be_able_to_navigate_to_cart_page() {
        Assert.assertEquals(driver.getCurrentUrl(),homePage.cartPageUrl());
    }

    @When("user clicks on logout button.")
    public void user_clicks_on_logout_button() {
        homePage.logoutPageLinkClick();
    }

    @Then("user should be able to navigate to login page.")
    public void user_should_be_able_to_navigate_to_login_page() {
        Assert.assertEquals(driver.getCurrentUrl(),homePage.logoutPageUrl());
    }



}