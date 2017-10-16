package com.aplana.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TVPage extends AbstractPage {

    private final String child = "//div[contains(@class, \"title\")]/a";

    @FindBy(xpath = "//a[text()=\"Перейти ко всем фильтрам\"]")
    private WebElement всеФильтры;

    @FindBy(xpath = "//div[contains(@data-id,\"model\")]")
    private List<WebElement> найденные;

    public TVPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void selectElements(String selection, List<String> strings) {

    }

    @Override
    public int getResultNumber() {
        return найденные.size();
    }

    public void saveElement(int index, String variableName){
        WebElement elementForSearch = найденные.get(index).findElement(By.xpath(child));
        saveVariable(variableName, elementForSearch.getText());
    }
}
