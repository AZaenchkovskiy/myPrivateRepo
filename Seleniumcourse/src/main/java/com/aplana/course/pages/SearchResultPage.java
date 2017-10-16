package com.aplana.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//h1")
    private WebElement result;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void selectElements(String selection, List<String> strings) {

    }

    @Override
    public int getResultNumber() {
        return 0;
    }


    public String getResult() {
        return result.getText();
    }
}
