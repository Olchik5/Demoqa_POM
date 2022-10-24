package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//*[.='SUB SUB LIST »']")
    WebElement suSubList;

    @FindBy(xpath = "//li[.='Sub Sub Item 2']")
    WebElement suSubItem2;

    public MenuPage selectSubMenu() {
        Actions actions = new Actions(driver);
        //mouse hover menu optoins 'Main item 2'
        actions.moveToElement(mainItem2).perform();
        //mouse hover menu 'SUB SUB LIST'
        actions.moveToElement(suSubList).perform();

        actions.moveToElement(suSubItem2).perform();
        //click(suSubItem2);
        return this;
    }
}

//xpath //*[text()='Main Item 2']
//  //*[.='SUB SUB LIST »']
// //li[.='Sub Sub Item 2']
