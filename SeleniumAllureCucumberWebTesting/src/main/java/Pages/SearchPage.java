package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 07.09.2017.
 */
public class SearchPage extends AbstractPage {


    @FindBy(id = "search-results")
    private WebElement searchResultBlock;
    @FindBy(xpath = "//*[@id=\"search-results\"]/div/div[@*=\"product-title\"]/a")
    private List<WebElement> searchResultItems;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.get(searchURL);
    }

    public SearchPage(WebDriver driver, String searchString) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.get(searchURL + searchString);
    }

    public WebElement getSearchResultBlock() {
        return searchResultBlock;
    }

    public List<WebElement> getSearchResultItems() {
        return searchResultItems;
    }
}
