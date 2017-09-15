package experimental.pages;

import experimental.fields.SearchResultPageFieldsHead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class SearchResultsPage extends Page {

    public SearchResultsPage(WebDriver driver, String searchString) {
        super(driver, PageURL.SEARCH + searchString);
    }

    public WebElement getFieldByName(WebDriver driver, String fieldName) {
        return SearchResultPageFieldsHead.getFieldByName(driver, fieldName);
    }

    public List<WebElement> getFieldsByName(WebDriver driver, String fieldName) {
        return SearchResultPageFieldsHead.getFieldsByName(driver, fieldName);
    }

    public void clickOn(String fieldName) {

    }

}
