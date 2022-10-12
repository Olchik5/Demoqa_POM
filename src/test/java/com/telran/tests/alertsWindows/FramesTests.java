package com.telran.tests.alertsWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alertsWindows.AlertsPage;
import com.telran.pages.alertsWindows.FramesPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectFrame();
    }

    @Test
    public void framesTest () {
        new FramesPage(driver).returnListOfFrames();
    }

    @Test
    public void switchToFrameByIndex() {
        new FramesPage(driver).switchToFrameByIndexTest(1);

    }

    @Test
    public void switchToFrameByIdTest() {
        new FramesPage(driver).switchToFrameById();
        Assert.assertTrue(new FramesPage(driver).switchToFrameById().contains("This"));

    }
}
