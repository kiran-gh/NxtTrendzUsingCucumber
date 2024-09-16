package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;


public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    Properties prop;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "name")
    WebElement userNameInputELe;

    @FindBy(name = "email")
    WebElement emailInputELe;

    @FindBy(name = "password")
    WebElement passwordInputELe;

    @FindBy(id = "male")
    WebElement radioMaleELe;

    @FindBy(id = "female")
    WebElement radioFemaleELe;

    @FindBy(id = "country")
    WebElement selectCountryELe;

    @FindBy(id = "terms")
    WebElement termsCheckBoxELe;

    @FindBy(id = "submitBtn")
    WebElement submitButtonELe;

    @FindBy(id = "error")
    WebElement errorMessageELe;

    @FindBy(tagName = "h2")
    WebElement successMessageELe;

    @FindBy(linkText = "Log in")
    WebElement loginLinkELe;

    public void registrationPageUrl(){
        driver.get(prop.getProperty("registrationPageUrl"));
    }
//throws InterruptedException
    public void registerDetails(String name,String email,String password, String gender,String country )  {
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("registrationPageUrl")));
        userNameInputELe.sendKeys(name);
        emailInputELe.sendKeys(email);
        passwordInputELe.sendKeys(password);
        if (gender.equalsIgnoreCase("male")) {
            radioMaleELe.click();
        } else {
            radioFemaleELe.click();
        }
        Select select = new Select(selectCountryELe);
        switch (country) {
            case "India":
                select.selectByVisibleText("India");
                break;
            case "USA":
                select.selectByVisibleText("USA");
                break;
            case "UK":
                select.selectByVisibleText("UK");
                break;
            case "Australia":
                select.selectByVisibleText("Australia");
                break;
            case "Japan":
                select.selectByVisibleText("Japan");
                break;
            case "Russia":
                select.selectByVisibleText("Russia");
                break;
            default:
                select.selectByVisibleText("Select Country");
        }
    }
    public void acceptTerms(){
        termsCheckBoxELe.click();
    }
    public void submitRegistration(){
        submitButtonELe.click();
    }
    public String successfulRegistration(){
        wait.until(ExpectedConditions.visibilityOf(successMessageELe));
       return successMessageELe.getText();
    }
//throws InterruptedException
    public void multipleUsersRegistration(String name,String email,String password, String gender,String country)  {
        registerDetails(name,email,password, gender,country );
        acceptTerms();
        submitRegistration();
        wait.until(ExpectedConditions.visibilityOf(loginLinkELe));
        loginLinkELe.click();
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageUrl")));
    }

}