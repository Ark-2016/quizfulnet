package by.htp.ta.steps;

import by.htp.ta.driver.DriverSingleton;
import by.htp.ta.pages.LoginPage;
import by.htp.ta.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ark on 22.12.2016.
 */
public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getLogger(Steps.class);

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public void enterLoginPage() {
        MainPage mainePage = new MainPage(driver);
        mainePage.openPage();
        mainePage.clickOnSignInButton();
    }

    public void hackLoginPage() {
        LoginPage page = new LoginPage(driver);
        page.openPage();
    }

    public void loginQuizfulNet(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username.toLowerCase()));
    }

}
