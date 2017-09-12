package experimental.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class HomePageFields extends AbstractFields {

    private static final String RESOURCES_PATTERN = "//*[@id=\"homepage-links\"]//a[contains(., \"%s\")]";
    private static final String AUTHORS_BUTTON = String.format(RESOURCES_PATTERN, "Authors");
    private static final String LIBRARIANS_BUTTON = String.format(RESOURCES_PATTERN, "Librarians");
    private static final String BOOKSELLERS_BUTTON = String.format(RESOURCES_PATTERN, "Booksellers");
    private static final String INSTRUCTORS_BUTTON = String.format(RESOURCES_PATTERN, "Instructors");
    private static final String STUDENT_BUTTON = String.format(RESOURCES_PATTERN, "Students");
    private static final String SOCIETIES_BUTTON = String.format(RESOURCES_PATTERN, "Societies");
    private static final String CONFERENCES_BUTTON = String.format(RESOURCES_PATTERN, "Conferences");
    private static final String INSTITUTIONS_BUTTON = String.format(RESOURCES_PATTERN, "Institutions");
    private static final String CORPORATIONS_BUTTON = String.format(RESOURCES_PATTERN, "Corporations");

    private static final String UPDATE_ARROW = "//*[@id=\"EmailAddress\"]/following-sibling::*/button";
    private static final String EMAIL_UPDATE_INPUT = "//*[@id=\"EmailAddress\"]";

    public static Map<String, String> HOME_PAGE_FIELD_MAP = new HashMap<String, String>(AbstractFields.ABSTRACT_FIELD_MAP){
        {
            put("Students", STUDENT_BUTTON);
            put("Authors", AUTHORS_BUTTON);
            put("Instructors", INSTRUCTORS_BUTTON);
            put("Librarians", LIBRARIANS_BUTTON);
            put("Societies", SOCIETIES_BUTTON);
            put("Conferences", CONFERENCES_BUTTON);
            put("Booksellers", BOOKSELLERS_BUTTON);
            put("Corporations", CORPORATIONS_BUTTON);
            put("Institutions", INSTITUTIONS_BUTTON);
            put("Arrow", UPDATE_ARROW);
            put("EmailUpdate", EMAIL_UPDATE_INPUT);
        }
    };


    public static WebElement getFieldByName(WebDriver driver, String fieldName) {
        WebElement field = null;
        try {
            field = driver.findElement(By.xpath(HOME_PAGE_FIELD_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return field;
    }
}
