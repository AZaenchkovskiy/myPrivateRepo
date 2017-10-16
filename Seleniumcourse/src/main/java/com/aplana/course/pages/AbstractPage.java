package com.aplana.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected String baseUrl;

    protected static Map<String, String> variables = new HashMap<>();

    @FindBy(xpath = "//input[@id=\"header-search\"]")
    private WebElement inputSearch;

    AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public AbstractPage open() {
        webDriver.get(baseUrl);
        return this;
    }

    public void saveVariable(String name, String value){
        variables.put(name, value);
    }

    public String getVariable(String name){
        return variables.get(name);
    }

    public WebElement getField(String fieldName) {
        Field[] fields = getClass().getDeclaredFields();
        WebElement element = null;
        for(Field field :  fields){
            if (field.getName().toUpperCase().equals(fieldName.replace(" ", "").toUpperCase())){
                try {
                    field.setAccessible(true);
                    element = (WebElement)field.get(this);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return element;
    }

    public void clickOn(String fieldName) {
        WebElement element = getField(fieldName);
        try {
            WebElement group = webDriver.findElement(By.xpath("//button//*[text()=\"Все категории\"]"));
            group.click();
        }catch (Exception e){}
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void search(String findString){
        inputSearch.clear();
        inputSearch.sendKeys(findString);
        inputSearch.submit();
    }

    public abstract void selectElements(String selection, List<String> strings);

    public abstract int getResultNumber();
}
