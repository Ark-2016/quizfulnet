package by.htp.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ark on 22.12.2016.
 */
public class LoginPage extends Page {
//    private final Logger logger = LogManager.getRootLogger();

    private final Logger logger = LogManager.getLogger(LoginPage.class);
    private final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";

    @FindBy(id = "login")
    private WebElement inputLogin;

    @FindBy(name = "loginForm.password")
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@id='login-form']/div[3]/form/p/input")
    private WebElement buttonSubmit;

    @FindBy(className = "rememberMe")
    private WebElement checkBoxUncheck;

    @FindBy(xpath = ".//*[@id='user-panel']/li[1]/b/a")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
        driver.navigate().to(BASE_URL);
        logger.info("Directly opened Login page");
    }

    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        checkBoxUncheck.click();
        buttonSubmit.click();
        logger.debug("Login performed");
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }

}
