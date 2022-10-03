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

}

// xpath //*[text()='Book Store Application']
//   //h5[text()='Book Store Application']
//   //h*[.='Book Store Application']