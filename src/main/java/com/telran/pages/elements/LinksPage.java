package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public LinksPage checkAllLinks() {
        System.out.println("Total links on the Webpage:" + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkLinksIsNotBroken() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);

        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
        URL url = new URL(linkUrl);
        HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
        httpURLConnect.setConnectTimeout(3000);
        httpURLConnect.connect();

        if (httpURLConnect.getResponseCode() >= 400) {
            System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
        } else {
            System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
        }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + "is a broken link");
        }
    }
}
