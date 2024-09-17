package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Properties prop;


    //    HomePage locators
    @FindBy(linkText = "Home")
    WebElement homeButtonEle;

    @FindBy(linkText = "Products")
    WebElement productsButtonEle;

    @FindBy(linkText = "Cart")
    WebElement cartButtonEle;

    @FindBy(className = "logout-desktop-btn")
    WebElement logoutBtnEle;

    @FindBy(className = "home-heading")
    WebElement homePageHeadingEle;

    @FindBy(className = "home-description")
    WebElement homePageDescriptionEle;

    @FindBy(className = "shop-now-button")
    WebElement shopNowBtnEle;

    //    HomePage constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        PageFactory.initElements(driver, this);
    }

    public String  homePageUrl() {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageUrl")));
        return driver.getCurrentUrl();
    }
    public boolean homePageHeading() {
        return homePageHeadingEle.isDisplayed();
    }
    public boolean homePageDescription() {
        return homePageDescriptionEle.isDisplayed();
    }
    public boolean homePageShopNowBtn() {
        return shopNowBtnEle.isDisplayed();
    }
    public boolean homePageLink(){
        return homeButtonEle.isDisplayed();
    }
    public boolean productsPageLink(){
        return productsButtonEle.isDisplayed();
    }
    public boolean cartPageLink(){
        return cartButtonEle.isDisplayed();
    }
    public boolean logoutPageLink(){
        return logoutBtnEle.isDisplayed();
    }
    public void productsPageLinkClick(){
        wait.until(ExpectedConditions.elementToBeClickable(productsButtonEle));
        productsButtonEle.click();
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
    }
    public String  productsPageUrl(){
        return driver.getCurrentUrl();
    }
    public void cartPageLinkClick(){
        wait.until(ExpectedConditions.visibilityOf(cartButtonEle));
        cartButtonEle.click();
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("cartPageUrl")));
    }
    public String cartPageUrl(){
        return driver.getCurrentUrl();
    }
    public void logoutPageLinkClick(){
        logoutBtnEle.click();
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("loginPageUrl")));
    }
    public String logoutPageUrl(){
        return driver.getCurrentUrl();
    }
}