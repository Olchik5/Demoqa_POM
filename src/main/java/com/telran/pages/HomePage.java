package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage{
    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[text()='Book Store Application']")
    WebElement bookStoreAppTitle;

    public BookStorePage selectBookStoreApp() {
        clickWithJSExecutor(bookStoreAppTitle, 0, 600);
        return new BookStorePage(driver);

    }

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindow;

    public SidePanelPage selectAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindow, 0, 300);
        return new SidePanelPage(driver);
    }
}

// xpath //*[text()='Book Store Application']
//  xpath //h5[text()='Book Store Application']
//  xpath //h*[.='Book Store Application']

// //div[@class='category-cards']/div[3] or //*[@class='category-cards']/*[3]