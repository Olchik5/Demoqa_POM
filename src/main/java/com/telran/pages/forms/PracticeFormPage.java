package com.telran.pages.forms;

import com.telran.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//label[@for='gender-radio-1']")
    WebElement male;

    @FindBy (xpath = "//label[@for='gender-radio-2']")
    WebElement female;

    @FindBy (xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            clickWithJSExecutor(male,0,200);
        } else if (gender.equals("Female")) {
            clickWithJSExecutor(female,0,200);
        }else {
            clickWithJSExecutor(other, 0, 200);
        }
        return this;
    }

    @FindBy (id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String bDay) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));

            }
        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy (id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null){
                type(subjectsInput,subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy (xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy (xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy (xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;
    
    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")){
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy (id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }


    @FindBy (xpath = "//*[text()='Select State']")
    WebElement stateSelect;

    public PracticeFormPage enterState(String state) {
        clickWithJSExecutor(stateSelect, 0, 800);
        pause(3000);
        driver.findElement(By.xpath(String.format("//div[text()='%s']", state))).click();
        return this;

    }

//    @FindBy (xpath = "//*[text()='Select City']")
//    WebElement selectCity;
//
//    public PracticeFormPage enterCity(String city) {
//        clickWithJSExecutor(selectCity,0,600);
//        driver.findElement(By.xpath(String.format("//div[text()='%s']", city))).click();
//        return this;
//
//    }


    @FindBy (id = "firstName")
    WebElement enterFirstName;

    @FindBy (id = "lastName")
    WebElement enterLastName;

    @FindBy (id = "userEmail")
    WebElement userEmail;

    @FindBy (id = "userNumber")
    WebElement userNumber;

    @FindBy (id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email, String phone) {
       type(enterFirstName,firstName);
       type(enterLastName,lastName);
       type(userEmail, email);
       type(userNumber, phone);
       //typeWithExecutor(currentAddress, address, 0, 300);
       return this;
    }

    public PracticeFormPage hideIframes() {
        hideAdd();
        hideFooter();
        return this;
    }

    @FindBy (id = "city")
    WebElement idCity;

    @FindBy (id = "react-select-4-input")
    WebElement city;

    public PracticeFormPage enterCity(String c) {
        click(idCity);
        city.sendKeys(c);
        city.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        clickWithRectangle(submit,2,3);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement title;

    public String getModalTitle() {
        return title.getText();
    }

    @FindBy(id = "closeLargeModal")
    WebElement close;

    public PracticeFormPage closeModalDialog() {
        closeBanner();
        clickWithJSExecutor(close,0,700);
        return this;
    }

    @FindBy (css = ".react-datepicker__month-select")
    WebElement month;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage chooseDate(String m, String y, String day) {
        click(dateOfBirthInput);
        //HTML <select> tag
        Select select =new Select(month);
        select.selectByVisibleText(m);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();

        return this;
    }

    public PracticeFormPage addAddress(String address) {
        typeWithExecutor(currentAddress, address, 0, 300);
        return this;
    }
}
