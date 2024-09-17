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

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Properties prop;

    //Locators for the login page
    @FindBy(id = "username")
    WebElement  usernameInputEle;

    @FindBy(id = "password")
    WebElement passwordInputEle;

    @FindBy(className = "login-button")
    WebElement loginButtonEle;

    @FindBy(className = "error-message")
    WebElement errorMessageEle;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        PageFactory.initElements(driver,this);
    }

    public void loginPageUrl(){
            driver.get(prop.getProperty("loginPageUrl"));
    }

    public void enterUserName(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInputEle));
        usernameInputEle.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordInputEle.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButtonEle.click();
    }
    public String errorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessageEle));
        return errorMessageEle.getText();
    }

    public void validUserLogin() {
        loginPageUrl();
        enterUserName((prop.getProperty("userName")));
        enterPassword((prop.getProperty("password")));
        loginButtonEle.click();
    }
}