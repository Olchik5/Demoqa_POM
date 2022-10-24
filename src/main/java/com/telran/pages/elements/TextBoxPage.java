package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
