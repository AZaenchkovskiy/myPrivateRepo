package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class PageGenerator {

    public static Page getPageByName(WebDriver driver, String name){
        Page createdPage = null;
        switch (PageName.valueOf(name.toUpperCase())){
            case HOME:
                createdPage = new HomePage(driver);
                break;
            case STUDENTS:
                createdPage = new SearchPage(driver);
                break;
            case SEARCH:
                createdPage = new SearchPage(driver);
                break;
        }
        return createdPage;
    }

    enum PageName{
        HOME, STUDENTS, SEARCH
    }
}
