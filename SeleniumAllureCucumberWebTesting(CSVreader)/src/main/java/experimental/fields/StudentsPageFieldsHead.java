package experimental.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class StudentsPageFieldsHead extends HeadMenuFields {

    private static String RESOURCES_PATTERN;
    private static String AUTHORS_BUTTON;
    private static String LIBRARIANS_BUTTON;
    private static String BOOKSELLERS_BUTTON;
    private static String INSTRUCTORS_BUTTON;
    private static String STUDENT_BUTTON;
    private static String SOCIETIES_BUTTON;
    private static String CPARTNERS_BUTTON;

    public static void initializeMap(){

        STUDENTS_PAGE_FIELD_MAP.put("Students", STUDENT_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Authors", AUTHORS_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Instructors", INSTRUCTORS_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Librarians", LIBRARIANS_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Societies", SOCIETIES_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Corporate Partners", CPARTNERS_BUTTON);
        STUDENTS_PAGE_FIELD_MAP.put("Booksellers", BOOKSELLERS_BUTTON);

    }

    public static Map<String, String> STUDENTS_PAGE_FIELD_MAP = new HashMap<String, String>(MENU_FIELD_MAP);

    public static WebElement getFieldByName(WebDriver driver, String fieldName) {
        WebElement field = null;
        try {
            field = driver.findElement(By.xpath(STUDENTS_PAGE_FIELD_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return field;
    }


}
