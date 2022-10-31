package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition () {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectLinks();
    }

    @Test
    public void checkLinks() {
        new LinksPage(driver).checkAllLinks().checkLinksIsNotBroken();
        Assert.assertTrue(new LinksPage(driver).getTextMoved().contains("Permanently"));
    }

}
