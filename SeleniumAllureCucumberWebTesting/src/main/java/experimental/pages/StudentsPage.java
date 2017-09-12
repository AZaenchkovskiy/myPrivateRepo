package experimental.pages;

import experimental.fields.StudentsPageFields;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class StudentsPage extends Page {

    public StudentsPage(WebDriver driver) {
        super(driver, PageURL.STUDENTS);
    }

    @Override
    public WebElement getFieldByName(WebDriver driver, String fieldName) {
        return StudentsPageFields.getFieldByName(driver, fieldName);
    }

    public List<WebElement> getFieldsByName(WebDriver driver, String fieldName) {
        return null;
    }

    @Override
    public void clickOn(String fieldName) {
        StudentsPageFields.getFieldByName(driver, fieldName).click();
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
}
