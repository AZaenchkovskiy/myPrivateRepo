package com.aplana.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MarketPage extends AbstractPage {

    @FindBy(xpath = "(//*[@class=\"n-navigation-horizontal__inner\"]/div/a[text()=\"Электроника\"]) | (//li/a[text()=\"Электроника\"]) | (//span[text()=\"Электроника\"])")
    private WebElement электроника;
    @FindBy(xpath = "//button//*[text()=\"Все категории\"]")
    private WebElement всеКатегории;

    public MarketPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = "https://market.yandex.ru";
    }

    @Override
    public void selectElements(String selection, List<String> strings) {

    }

    @Override
    public int getResultNumber() {
        return 0;
    }

}
