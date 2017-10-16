package com.aplana.course.pages;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PageMapper {
    private static Map<String, Class<? extends AbstractPage>> pageMap = new HashMap<>();

    static {
        pageMap.put("Главная", MainPage.class);
        pageMap.put("Маркет", MarketPage.class);
        pageMap.put("Электроника", ElectronicPage.class);
        pageMap.put("Телевизоры", TVPage.class);
        pageMap.put("Все фильтры", AllFiltersPage.class);
        pageMap.put("Результаты поиска", SearchResultPage.class);
    }

    public static AbstractPage getPageByName(String pageName, WebDriver webDriver){
        AbstractPage page = null;
        try {
            Class<? extends AbstractPage> aClass = pageMap.get(pageName);
            Constructor constructor = aClass.getConstructor(WebDriver.class);
            page = (AbstractPage)constructor.newInstance(webDriver);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static String getPageName(Class<? extends AbstractPage> pageClass){
        String pageName = "";
        for (Map.Entry<String, Class<? extends AbstractPage>> pageData : pageMap.entrySet()){
            if (pageData.getValue().equals(pageClass)){
                pageName = pageData.getKey();
                break;
            }
        }
        return pageName;
    }
}
