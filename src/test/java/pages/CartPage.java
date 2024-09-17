package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Properties;


public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Properties prop;

    //    CartPage constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart-empty-img")
    WebElement cartEmptyImgEle;

    @FindBy(className = "cart-empty-heading")
    WebElement cartEmptyHeadingEle;

    @FindBy(className = "shop-now-btn")
    WebElement shopNowBtnEle;

    @FindBy(xpath = "//ul[@class=\"cart-list\"]//li")
    List<WebElement> cartPage_allProductsListEle;

    @FindBy(xpath = "//button[@class=\"remove-all-btn\"]")
    WebElement removeAllBtnEle;


    public String cartPageUrl() {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("cartPageUrl")));
        return driver.getCurrentUrl();
    }

    public boolean isCartEmptyImgDisplayed() {
        return cartEmptyImgEle.isDisplayed();
    }
    public boolean isCartEmptyHeadingDisplayed() {
        return cartEmptyHeadingEle.isDisplayed();
    }
    public boolean isShopNowButtonDisplayed() {
        return shopNowBtnEle.isDisplayed();
    }
    public void shopNowButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(shopNowBtnEle));
        shopNowBtnEle.click();
    }
    public int cartPage_allProductsListCount() {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("cartPageUrl")));
        List<WebElement> ItemsAddedToCart = cartPage_allProductsListEle;
        return ItemsAddedToCart.size();
    }

    public void removeAllButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(removeAllBtnEle));
        removeAllBtnEle.click();
    }





}