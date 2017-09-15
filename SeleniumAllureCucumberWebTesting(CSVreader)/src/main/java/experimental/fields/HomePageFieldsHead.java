package experimental.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class HomePageFieldsHead extends HeadMenuFields {

    private static String RESOURCES_PATTERN;
    private static String AUTHORS_BUTTON;
    private static String LIBRARIANS_BUTTON;
    private static String BOOKSELLERS_BUTTON;
    private static String INSTRUCTORS_BUTTON;
    private static String STUDENT_BUTTON;
    private static String SOCIETIES_BUTTON;
    private static String CONFERENCES_BUTTON;
    private static String INSTITUTIONS_BUTTON;
    private static String CORPORATIONS_BUTTON;

    private static String UPDATE_ARROW;
    private static String EMAIL_UPDATE_INPUT;


    public static Map<String, String> HOME_PAGE_FIELD_MAP = new HashMap<String, String>(MENU_FIELD_MAP);


    public static void initializeMap(){
        HOME_PAGE_FIELD_MAP.put("Students", STUDENT_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Authors", AUTHORS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Instructors", INSTRUCTORS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Librarians", LIBRARIANS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Societies", SOCIETIES_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Conferences", CONFERENCES_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Booksellers", BOOKSELLERS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Corporations", CORPORATIONS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Institutions", INSTITUTIONS_BUTTON);
        HOME_PAGE_FIELD_MAP.put("Arrow", UPDATE_ARROW);
        HOME_PAGE_FIELD_MAP.put("EmailUpdate", EMAIL_UPDATE_INPUT);
    }

    public static WebElement getFieldByName(WebDriver driver, String fieldName) {
        WebElement field = null;
        try {
            field = driver.findElement(By.xpath(HOME_PAGE_FIELD_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return field;
    }


}
