package com.telran.pages;

import com.telran.pages.alertsWindows.AlertsPage;
import com.telran.pages.alertsWindows.BrowserWindowsPage;
import com.telran.pages.alertsWindows.FramesPage;
import com.telran.pages.alertsWindows.NestedFramesPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.pages.elements.*;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.pages.widgets.MenuPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//*[text()='Browser Windows']")
    WebElement browserWindowsButton;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindowsButton,0,200);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//*[text()='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons, 0,500);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//*[text()='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenu,0,600);
        return new SelectMenuPage(driver);
    }


    @FindBy (xpath = "//span[text()='Frames']")
    WebElement frames;

    public FramesPage selectFrame() {
        clickWithJSExecutor(frames, 0, 300);
        return new FramesPage(driver);
    }

    @FindBy (xpath = "//span[text()='Nested Frames']")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames,0,300);
        return new NestedFramesPage(driver);
    }

    @FindBy (xpath = "//span[text()='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy (xpath = "//span[text()='Droppable']")
    WebElement droppable;

    public DragAndDropPage selectDroppable() {
        clickWithJSExecutor(droppable,0,500);
        return new DragAndDropPage(driver);
    }

    @FindBy (xpath = "//span[text()='Menu']")
    WebElement menu;

    public MenuPage selectMenuItem() {
        clickWithJSExecutor(menu,0,500);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[text()='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJSExecutor(slider,0,500);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        clickWithJSExecutor(textBox,0,300);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImages, 0, 500);
        return new BrokenLinksImagesPage(driver);
    }


    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public LinksPage selectLinks() {
        clickWithJSExecutor(links,0 ,500);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownload;

    public UploadAndDownloadPage selectUploadAndDownload() {
        clickWithJSExecutor(uploadAndDownload, 0, 500);
        return new UploadAndDownloadPage(driver);
    }
}
// //*[text()='Profile']
// .show #item-3
//  //span[.='Alerts']