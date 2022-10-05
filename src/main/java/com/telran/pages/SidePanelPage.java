package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SidePanelPage extends BasePage {

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[text()='Profile']")
    WebElement profileButton;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profileButton, 0, 500);
        return new ProfilePage(driver);
    }


    @FindBy(xpath = "//*[text()='Alerts']")
    WebElement alertsButton;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alertsButton, 0, 300);
        return new AlertsPage(driver);
    }
}
// //*[text()='Profile']

// .show #item-3


//
//  //span[.='Alerts']