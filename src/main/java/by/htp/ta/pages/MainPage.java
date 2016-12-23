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
public class MainPage extends Page {
    private static final Logger logger = LogManager.getLogger(MainPage.class);
    private final String BASE_URL = "http://www.quizful.net/";

    @FindBy(xpath = ".//*[@id='user-panel']/li[1]/a")
    private WebElement buttonSignIn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSignInButton() {
        logger.info("Transition to the Login page");
        buttonSignIn.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main Page opened");
    }

}
