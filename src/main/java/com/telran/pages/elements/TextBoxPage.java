package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "userName")
    WebElement enterFullName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage enterUserDataTest1(String fullName, String email, String address, String permAddress) {
        hideAdd();
        type(enterFullName, fullName);
        type(userEmail, email);
        type(currentAddress, address);
        typeWithExecutor(permanentAddress, permAddress, 0, 300);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage submit() {
        click(submit);
        return this;
    }

    @FindBy(id = "output")
    WebElement output;

    public String getOutputText() {
        return output.getText();
    }

    public TextBoxPage keyBoardEvent() {
        //enter username
        type(enterFullName, "Nick Green");
        //enter email
        type(userEmail, "nick@gmail.com");
        //enter current address
        type(currentAddress, "Baustrasse, 12, Berlin");
        //create object of the Action class
        Actions actions = new Actions(driver);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press the tab Key to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past the current address in the permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        //System.out.println(currentAddress.getAttribute("value"));
        //System.out.println(permanentAddress.getAttribute("value"));
        return this;
    }

    public String getAttribute() {
        return permanentAddress.getAttribute("value");
    }
}
