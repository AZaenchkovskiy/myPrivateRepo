package com.aplana.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElectronicPage extends AbstractPage {

    @FindBy(xpath = "//a[text()=\"Телевизоры\"][contains(@class, \"catalog\")]")
    private WebElement телевизоры;

    public ElectronicPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void selectElements(String selection, List<String> strings) {

    }

    @Override
    public int getResultNumber() {
        return 0;
    }
}
