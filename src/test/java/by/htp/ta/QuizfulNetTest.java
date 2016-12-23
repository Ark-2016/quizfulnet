package by.htp.ta;

import by.htp.ta.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Ark on 22.12.2016.
 */
public class QuizfulNetTest {

    private Steps steps;
    private final String USERNAME = "Ark2016";
    private final String PASSWORD = "parol_quizful2016";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to QuizfulNet")
    public void flowLoginQuizfulNet() {
        steps.enterLoginPage();
        steps.loginQuizfulNet(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Hack login to QuizfulNet")
    public void hackLoginQuizfulNet() {
        steps.hackLoginPage();
        steps.loginQuizfulNet(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

}
