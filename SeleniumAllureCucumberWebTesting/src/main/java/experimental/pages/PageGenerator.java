package experimental.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class PageGenerator {

    public static WebDriver driver = new ChromeDriver();

    public static Page openPage(String pageName){
        switch (PageName.valueOf(pageName.toUpperCase())){
            case HOME:
                return new HomePage(driver);
            case STUDENTS:
                return new StudentsPage(driver);
            case SEARCH: new SearchResultsPage(driver, "");
            default: return null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
