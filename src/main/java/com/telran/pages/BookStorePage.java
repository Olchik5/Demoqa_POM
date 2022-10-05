package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends BasePage {
    public BookStorePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return  new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;
    
    public BookStorePage typeInSearchBookInput(String bookName) {
        type(searchInput,bookName);
        return this;

    }

    @FindBy (xpath = "//*[text()='Git Pocket Guide']")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }

    public BookStorePage clickOnBookTitleLink() {
        click(nameOfBook);
        return this;
    }

    @FindBy(xpath = "//*[text()='Add To Your Collection']")
    WebElement addToCollectionButton;

    public BookStorePage clickOnAddBookButton() {
        clickWithJSExecutor(addToCollectionButton, 0, 300);
        pause(500);
        return this;
    }


}

//xpath //*[text()='Add To Your Collection']

//CSS .text-right.fullButton