package com.aplana.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllFiltersPage extends AbstractPage {

    private final String SELECTION_PATTERN = "//span[text()=\"%s\"]";
    private final String CHECKBOX_PATTERN = SELECTION_PATTERN + "/ancestor::div[1]/following-sibling::div//*[contains(@class, \"checkbox\")][text()=\"%s\"]";

    @FindBy(xpath = "//*[@id=\"glf-pricefrom-var\"]")
    private WebElement ценаОт;

    @FindBy(xpath = "//span[text()=\"Показать подходящие\"]/parent::a")
    private WebElement показатьПодходящие;

    private WebElement selection;

    public AllFiltersPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void selectElements(String selection, List<String> boxes) {
        for (String checkboxName : boxes){
            webDriver.findElement(By.xpath(String.format(CHECKBOX_PATTERN, selection, checkboxName))).click();
        }
    }

    @Override
    public int getResultNumber() {
        return 0;
    }

}
