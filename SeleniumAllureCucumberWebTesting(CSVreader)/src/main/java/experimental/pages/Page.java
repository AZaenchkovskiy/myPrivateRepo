package experimental.pages;

import experimental.fields.DefinitionsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public abstract class Page {


    String url;
    WebDriver driver;

    public Page(WebDriver driver, String url){
        this.driver = driver;
        this.url = url;
        driver.get(url);
    }

    public abstract WebElement getFieldByName(WebDriver driver, String fieldName);

    public abstract List<WebElement> getFieldsByName(WebDriver driver, String fieldName);

    public abstract void clickOn(String fieldName);

    public String getUrl(){
        return url;
    }

    public SearchResultsPage search(String searchSting){
        return new SearchResultsPage(driver, searchSting);
    }
}
