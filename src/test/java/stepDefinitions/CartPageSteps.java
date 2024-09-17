package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utility.ConfigReader;

import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class CartPageSteps {
    private CartPage cartPage;
    private final Properties prop;


    public CartPageSteps(){
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validUserLogin();
         HomePage homePage = new HomePage(driver);
         homePage.cartPageLinkClick();
    }

    @When("User is on the cart page")
    public void UserIsOnTheCartPage() {
        cartPage = new CartPage(driver);
        String ExpectedUrl = prop.getProperty("cartPageUrl");
        Assert.assertEquals(cartPage.cartPageUrl(),ExpectedUrl);
    }

    @Then("cart empty image along with cart empty heading and shop now button should be displayed")
    public void cartEmptyImageAlongWithCartEmptyHeadingAndShopNowButtonShouldBeDisplayed() {
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartEmptyImgDisplayed());
        Assert.assertTrue(cartPage.isCartEmptyHeadingDisplayed());
        Assert.assertTrue(cartPage.isShopNowButtonDisplayed());
    }

    @When("the user clicks on the Shop Now button")
    public void theUserClicksOnShopNowButton() {
        cartPage = new CartPage(driver);
        cartPage.shopNowButtonClick();
    }

    @Then("the user is redirected to the products page")
    public void theUserIsRedirectedToTheProductsPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        String ExpectedUrl = prop.getProperty("productsPageUrl");
        Assert.assertEquals(productsPage.productsPageUrl(),ExpectedUrl);
    }

    @And("the user searches for a product titled {string}")
    public void theUserSearchesForAProductTitled(String title) throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.searchForAProduct(title);
    }

    @When("the user selects the product with a specified quantity and added to cart")
    public void theUserSelectsTheProductWithASpecifiedQuantityAndAddedToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addAProductToCartPage();
    }

    @Then("the total number of products in the cart page should match the cart icon count")
    public void theTotalNumberOfProductsInTheCartPageShouldMatchTheCartIconCount() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(productsPage.cartCountBadge(),cartPage.cartPage_allProductsListCount());
    }

    @When("the user clicks on the RemoveAll button in the cart page")
    public void theUserClicksOnTheRemoveAllButtonInTheCartPage() {
        CartPage cartPage = new CartPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        cartPage.shopNowButtonClick();
        productsPage.addAProductToCartPage();
        cartPage.removeAllButtonClick();
    }

    @Then("empty cart heading should be displayed")
    public void emptyCartHeadingShouldBeDisplayed() {
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartEmptyHeadingDisplayed());
    }
}