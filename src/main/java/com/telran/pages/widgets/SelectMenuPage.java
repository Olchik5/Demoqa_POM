package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage {




    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String text) {

        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
        System.out.println(select.getFirstSelectedOption().getText() + " <---It is first");

        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size() ; i++) {

            System.out.println(options.get(i).getText());
        }

        return this;
    }

    @FindBy (xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectDropDown;

    @FindBy (xpath = "//html")
    WebElement space;


    public SelectMenuPage clickOnMultiSelectDropDown(String text) {
        clickWithJSExecutor(multiSelectDropDown,0,500);
        driver.findElement(By.xpath(String.format("//div[text()='%s']", text))).click();
        pause(2000);
        click(space);
        return this;
    }

    @FindBy(css = ".css-xb97g8")
    WebElement deselect;

    public SelectMenuPage deselect() {
        click(deselect);
        return this;

    }

    @FindBy (id = "react-select-4-input")
    WebElement selectInput;

    public SelectMenuPage clickOnMultiSelectDropDown1(String text, String text1, String text2) {
        selectInput.sendKeys(text);
        selectInput.sendKeys(Keys.ENTER);
        selectInput.sendKeys(text1);
        selectInput.sendKeys(Keys.ENTER);
        selectInput.sendKeys(text2);
        selectInput.sendKeys(Keys.ENTER);
        click(space);
        return this;
    }


    @FindBy (id = "cars")
    WebElement cars;

    public SelectMenuPage clickStandardMultiSelect() {
        Select multi = new Select(cars);
        if (multi.isMultiple()) {
            multi.selectByIndex(0);
            multi.selectByIndex(1);
            multi.selectByIndex(2);
            multi.selectByIndex(3);
        }

        List<WebElement> options = multi.getAllSelectedOptions();

        for (WebElement el: options) {
            System.out.println(el.getText() + "<---multi");
        }
        return this;
    }

    @FindBy (xpath = "//*[text()='Select Option']")
    WebElement selectValue;

    public SelectMenuPage clickOnSelectOption(String text) {
        clickWithJSExecutor(selectValue,0, 200);
        driver.findElement(By.xpath(String.format("//div[text()='%s']", text))).click();
        return this;
    }

    @FindBy (id = "selectOne")
    WebElement selectTitle;

    public SelectMenuPage clickOnSelectTitle(String text) {
        clickWithJSExecutor(selectTitle, 0, 200);
        driver.findElement(By.xpath(String.format("//div[text()='%s']", text))).click();
        return this;
    }

    @FindBy (xpath = "//*[text()='Mr.']")
    WebElement title;
    public String getTextTitle(){
        return title.getText();

    }

    // %s - string
    // %d - int
}
