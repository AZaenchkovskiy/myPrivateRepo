package com.aplana.course.steps;

import com.aplana.course.pages.AbstractPage;
import com.aplana.course.pages.PageMapper;
import com.aplana.course.pages.SearchResultPage;
import com.aplana.course.pages.TVPage;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.junit.Assert.*;

public class StepHolder extends AbstractStep {

    private AbstractPage currentPage;

    @Step
    public void openPage(String pageName){
        currentPage = PageMapper.getPageByName(pageName, webDriver).open();
        assertNotNull("Страница " + pageName + " не была загружена", currentPage);
    }

    @Step
    public void clickOn(String fieldName) {
        currentPage.clickOn(fieldName);
    }

    @Step
    public void loadPage(String pageName){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentPage = PageMapper.getPageByName(pageName, webDriver);
        isPageOpen(pageName);
    }

    @Step
    public void isPageOpen(String pageName){
        assertEquals("Открыта не " + pageName + " страница", pageName, PageMapper.getPageName(currentPage.getClass()));
    }

    @Step
    public void fillField(String fieldName, String value) {
        WebElement inputText = currentPage.getField(fieldName);
        inputText.clear();
        inputText.sendKeys(value);
    }

    @Step
    public void selectCheckbox(String selection, List<String> strings) {
        currentPage.selectElements(selection, strings);
    }

    @Step
    public void isSearchResultNumber(int count) {
        assertEquals("Количество элементов не совпадает", count, currentPage.getResultNumber());
    }

    @Step
    public void saveElement(int index, String variableName){
        ((TVPage)currentPage).saveElement(index, variableName);
    }

    @Step
    public void searchElement(String elementName){
        String searchString = currentPage.getVariable(elementName);
        currentPage.search(searchString);
    }

    @Step
    public void compareResult(String variableName) {
        String expected = currentPage.getVariable(variableName);
        String actual = ((SearchResultPage)currentPage).getResult();
        assertEquals("Результат " + expected + " не совпадает с " + actual, expected, actual);
    }
}
