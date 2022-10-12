package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectWidgets();
        new SidePanelPage(driver).getSelectMenu();
    }

    @Test
    public void oldStyleSelectTest (){
        new SelectMenuPage(driver).selectOldStyle("Blue");

    }

    @Test
    public void  clickOnMultiSelectDropDownTest () {
        new SelectMenuPage(driver).clickOnMultiSelectDropDown("Green").deselect();
                //.clickOnMultiSelectDropDown1("Red", "Blue" ,"Green");
    }

    @Test
    public void standartMultiSelectTest() {
        new SelectMenuPage(driver).clickStandardMultiSelect();
    }

    @Test
    public  void  selectValueTest() {
        new SelectMenuPage(driver).clickOnSelectOption("Group 2, option 1");
    }

    @Test
    public  void  selectOneTest() {
        new SelectMenuPage(driver).clickOnSelectTitle("Mr.");
        Assert.assertTrue(new SelectMenuPage(driver).getTextTitle().contains("Mr."));
    }

}
