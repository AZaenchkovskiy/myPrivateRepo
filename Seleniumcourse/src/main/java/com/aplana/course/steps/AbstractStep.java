package com.aplana.course.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract class AbstractStep {

    public static WebDriver webDriver;


    @Before
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://www.yandex.ru");
    }

    @After
    public void out(){
        webDriver.quit();
    }
}
