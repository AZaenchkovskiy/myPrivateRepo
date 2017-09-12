package experimental.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class SearchResultPageFields extends AbstractFields {

    private static final String SEARCH_RESULTS_BLOCK = "//*[@id=\"search-results\"]";
    private static final String SEARCH_RESULT_ITEMS = "//*[@id=\"search-results\"]/div/div[@*=\"product-title\"]/a";

    public static Map<String, String> SEARCH_RESULTS_MAP = new HashMap<String, String>(){
        {
            put("ResultsBlock", SEARCH_RESULTS_BLOCK);
            put("ResultItems", SEARCH_RESULT_ITEMS);
        }
    } ;

    public static WebElement getFieldByName(WebDriver driver, String fieldName) {
        WebElement field = null;
        try {
            field = driver.findElement(By.xpath(SEARCH_RESULTS_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return field;
    }

    public static List<WebElement> getFieldsByName(WebDriver driver, String fieldName) {
        List<WebElement> fields = null;
        try {
            fields = driver.findElements(By.xpath(SEARCH_RESULTS_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return fields;
    }
}
