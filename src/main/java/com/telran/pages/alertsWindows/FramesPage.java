package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (tagName = "iframe")
    List <WebElement> frames;

    public FramesPage returnListOfFrames() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of frames are " + numberOfFrames);
        System.out.println("Number of frames are " + frames.size());
        return this;


    }

    @FindBy (tagName = "body")
    WebElement body;

    public FramesPage switchToFrameByIndexTest(int index) {
        driver.switchTo().frame(index);
       // body.getText();
        System.out.println(body.toString());
        return this;
    }

    @FindBy (id = "frame1")
    WebElement frame1;

    @FindBy (id = "sampleHeading")
    WebElement sampleHeading;

    public FramesPage switchToFrameById() {
        driver.switchTo().frame(frame1);
        String frameText = sampleHeading.getText();
        System.out.println("Text of the frame1 is " + frameText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy (tagName = "body")
    WebElement body1;

    public String isTextFramePresent() {
        driver.switchTo().frame(frame1);
        return body1.getText();

    }

    @FindBy (id = "frame2")
    WebElement frame2;

    public String isFramePresent() {
        driver.switchTo().frame(frame2);
        return body.getText();
    }

    public String isIndexOfFramePresent() {
        driver.switchTo().frame(1);
        return body.getText();
    }
}
