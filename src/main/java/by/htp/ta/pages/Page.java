package by.htp.ta.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Ark on 22.12.2016.
 */
public abstract class Page
{
    protected WebDriver driver;

    public abstract void openPage();

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
