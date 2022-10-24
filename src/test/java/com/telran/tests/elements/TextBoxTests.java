package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.tests.TestBase;
import com.telran.util.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addTextBoxForm")
    public void textBoxTestWithDataProviderTest(String fullName, String email, String currentAddress, String permAddress){
        new TextBoxPage(driver)
                .enterUserDataTest1(fullName, email, currentAddress, permAddress)
                .submit();
        Assert.assertTrue(new TextBoxPage(driver).getOutputText().contains("Email"));

    }
}
