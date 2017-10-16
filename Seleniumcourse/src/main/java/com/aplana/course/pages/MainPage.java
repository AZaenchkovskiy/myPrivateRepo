package com.aplana.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-id=\"market\"]")
    private WebElement маркет;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = "http://www.yandex.ru";

    }

    @Override
    public void selectElements(String selection, List<String> strings) {

    }

    @Override
    public int getResultNumber() {
        return 0;
    }
}
