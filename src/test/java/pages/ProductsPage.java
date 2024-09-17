package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Properties prop;

    @FindBy(className = "primedeals-list-heading")
    WebElement primeDealsListHeadingEle;

    @FindBy(xpath = "(//ul[@class=\"products-list\"])[1]//li[@class=\"product-item\"]")
    List<WebElement> primeDealsSection_ListOfItemsEle;

    @FindBy(className = "search-input")
    WebElement searchInputEle;

    @FindBy(className = "category-heading")
    WebElement categoryHeadingEle;

    @FindBy(xpath = "(//ul[@class=\"categories-list\"])[1]//li[@class=\"category-item\"]")
    List<WebElement> categorySection_listOfCategoriesEle;

    @FindBy(className = "rating-heading")
    WebElement ratingHeadingEle;

    @FindBy(xpath = "//img[@alt=\"rating 4\"]")
    WebElement rating4Ele;

    @FindBy(xpath = "(//ul[@class=\"ratings-list\"])[1]//li[@class=\"rating-item\"]")
    List<WebElement> ratingSection_listOfRatingsEle;

    @FindBy(className = "clear-filters-btn")
    WebElement clearFiltersBtnEle;

    @FindBy(className = "products-list-heading")
    WebElement productsListHeadingEle;

    @FindBy(xpath ="(//ul[@class=\"products-list\"])[2]//li[@class=\"product-item\"]")
    List<WebElement> allProductsListSection_listOfItemsEle;

    @FindBy(xpath = "//button[@testid=\"plus\"]")
    WebElement plusBtnEle;

    @FindBy(xpath = "//button[@testid=\"minus\"]")
    WebElement minusBtnEle;

    @FindBy(xpath = "//button[normalize-space()=\"ADD TO CART\"]")
    WebElement addToCartBtnEle;

    @FindBy(xpath = "(//span[@class=\"cart-count-badge\"])[1]")
    WebElement cartCountBadgeEle;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        PageFactory.initElements(driver, this);
    }


    public String productsPageUrl() {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
        wait.until(ExpectedConditions.visibilityOf(clearFiltersBtnEle));
        clearFiltersBtnEle.click();
        return driver.getCurrentUrl();
    }

    public boolean primeDealsListHeading() {
        wait.until(ExpectedConditions.visibilityOf(primeDealsListHeadingEle));
        return primeDealsListHeadingEle.isDisplayed();
    }

    public boolean primeDealsSectionElementsStatus() {
        List<WebElement> primeDealsSectionElements = primeDealsSection_ListOfItemsEle;
        for (WebElement element : primeDealsSectionElements) {
            return primeDealsSectionElements.stream().allMatch(WebElement::isDisplayed);
        }
        return false;
    }

    public boolean categoryHeading() {
        wait.until(ExpectedConditions.visibilityOf(categoryHeadingEle));
        return categoryHeadingEle.isDisplayed();
    }

    public boolean categorySectionElementsStatus() {
        List<WebElement> categorySectionElements = categorySection_listOfCategoriesEle;
        for (WebElement element : categorySectionElements) {
            return categorySectionElements.stream().allMatch(WebElement::isDisplayed);
        }
        return false;
    }
    public boolean ratingHeading(){
        wait.until(ExpectedConditions.visibilityOf(ratingHeadingEle));
        return ratingHeadingEle.isDisplayed();
    }
    public boolean ratingSectionElementsStatus(){
        List<WebElement> ratingSectionElements = ratingSection_listOfRatingsEle;
        for (WebElement element : ratingSectionElements){
            return ratingSectionElements.stream().allMatch(WebElement::isDisplayed);
        }
        return false;
    }
    public void clearFiltersBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clearFiltersBtnEle));
        clearFiltersBtnEle.click();
    }
    public boolean allProductsListHeading(){
        wait.until(ExpectedConditions.visibilityOf(productsListHeadingEle));
        return productsListHeadingEle.isDisplayed();
    }
    public boolean allProductsListSectionElementsStatus(){
        List<WebElement> allProductsListSectionElements = allProductsListSection_listOfItemsEle;
        for (WebElement element : allProductsListSectionElements){
            return allProductsListSectionElements.stream().allMatch(WebElement::isDisplayed);
        }
        return false;
    }
    public void searchForAProduct(String productName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchInputEle));
        searchInputEle.sendKeys(productName);
        Thread.sleep(3000);
        searchInputEle.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsListSection_listOfItemsEle));
    }
    public boolean getSearchedProductTitle(String productName) {
//        searchForAProduct(productName);
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsListSection_listOfItemsEle));
        List<WebElement> allProductsListSectionElements = allProductsListSection_listOfItemsEle;
        return allProductsListSectionElements.stream().anyMatch(webElement -> webElement.getText().contains(productName));
       }

    public void clickOnASpecificRating(){
        clearFiltersBtn();
        wait.until(ExpectedConditions.elementToBeClickable(rating4Ele));
        rating4Ele.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsListSection_listOfItemsEle));
    }
    public boolean listOfSpecificRatingProductsStatus(){
        rating4Ele.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsListSection_listOfItemsEle));
        List<WebElement> allProductsListSectionElements = allProductsListSection_listOfItemsEle;
        for(WebElement element : allProductsListSectionElements){
            return allProductsListSectionElements.stream().allMatch(WebElement::isDisplayed);
        }
        return false;
    }
    public int cartCountBadge(){
        return Integer.parseInt(cartCountBadgeEle.getText());
    }


//    The following methods are used in cart page
    public void addAProductToCartPage(){
//        clearFiltersBtn();
//        searchForAProduct(productName);
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsListSection_listOfItemsEle));
        Actions actions = new Actions(driver);
        WebElement targetWebElement = driver.findElement(By.xpath("(//ul[@class=\"products-list\"])[2]//li"));
        actions.moveToElement(targetWebElement).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(plusBtnEle));
        plusBtnEle.click();
        addToCartBtnEle.click();
        cartCountBadgeEle.click();
    }




}