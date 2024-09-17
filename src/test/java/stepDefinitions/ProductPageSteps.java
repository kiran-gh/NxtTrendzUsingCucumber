package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utility.ConfigReader;

import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class ProductPageSteps {
    ProductsPage productsPage;
    private final Properties prop;

    public ProductPageSteps(){
        ConfigReader configReader =new ConfigReader();
        prop = configReader.init_prop();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validUserLogin();
        HomePage homePage = new HomePage(driver);
        homePage.productsPageLinkClick();
        productsPage = new ProductsPage(driver);
    }

    @When("user is on products page")
    public void user_is_on_products_page() {
        String ExpectedUrl = prop.getProperty("productsPageUrl");
        Assert.assertEquals(productsPage.productsPageUrl(),ExpectedUrl);
    }

    @Then("user exclusive prime deals heading should be displayed")
    public void user_exclusive_prime_deals_heading_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.primeDealsListHeading());
    }

    @And("all products under exclusive prime deals should be displayed.")
    public void all_products_under_exclusive_prime_deals_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.primeDealsSectionElementsStatus());
    }

    @Then("category heading should be displayed")
    public void category_heading_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.categoryHeading());
    }

    @And("all categories under category section should be displayed.")
    public void all_categories_under_category_section_should_be_displayed(){
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.categorySectionElementsStatus());
    }

    @Then("ratings heading should be displayed")
    public void ratings_heading_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.ratingHeading());
    }

    @And("all ratings under ratings section should be displayed")
    public void all_ratings_under_ratings_section_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.ratingSectionElementsStatus());
    }

    @Then("all products main heading element should be displayed")
    public void all_products_main_heading_element_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.allProductsListHeading());
    }

    @And("all products under All products section should be displayed")
    public void all_products_under_all_products_section_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.allProductsListSectionElementsStatus());
    }

    @And("searches for a specific product with {string}")
    public void searches_for_a_specific_product_with(String title) {
        productsPage.searchForAProduct(title);
    }

    @Then("the product with the searched {string} should be present in the list of items.")
    public void theProductWithTheSearchedShouldBePresentInTheListOfItems(String title) {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.getSearchedProductTitle(title));
    }

    @And("clicks on any specific rating under category list")
    public void clicks_on_any_specific_rating_under_category_list() {
        productsPage = new ProductsPage(driver);
        productsPage.clickOnASpecificRating();
    }

    @Then("all the products with specified rating should be displayed.")
    public void all_the_products_with_specified_rating_should_be_displayed() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.listOfSpecificRatingProductsStatus());
    }


}