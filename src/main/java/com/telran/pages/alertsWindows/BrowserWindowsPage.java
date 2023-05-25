package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "tabButton")
    WebElement tabButton;

    public BrowserWindowsPage clickOnNewTabButton() {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }


    @FindBy (id = "sampleHeading")
    WebElement sampleHeading;

    public String getTextNewTab() {
        return sampleHeading.getText();
    }

    @FindBy (id = "windowButton")
    WebElement windowButton;

    public BrowserWindowsPage clickOnNewWindowButton() {
        click(windowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

    @FindBy (id = "sampleHeading")
    WebElement sampleHeadingWindow;

    public String getTextNewWindow() {
        return sampleHeadingWindow.getText();
    }
}
