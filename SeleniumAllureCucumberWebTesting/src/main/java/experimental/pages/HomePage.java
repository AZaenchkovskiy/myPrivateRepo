package experimental.pages;

import experimental.fields.HomePageFields;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class HomePage extends Page{

    public HomePage(WebDriver driver){
        super(driver, PageURL.HOME);
    }

    public WebElement getFieldByName(WebDriver driver, String fieldName) {
        return HomePageFields.getFieldByName(driver, fieldName);
    }

    public List<WebElement> getFieldsByName(WebDriver driver, String fieldName) {
        return null;
    }


    public void clickOn(String fieldName) {
        HomePageFields.getFieldByName(driver, fieldName).click();
    }

    public String getUrl() {
        return url;
    }
}
