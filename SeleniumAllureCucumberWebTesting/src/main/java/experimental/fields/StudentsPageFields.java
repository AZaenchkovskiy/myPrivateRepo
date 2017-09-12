package experimental.fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class StudentsPageFields extends AbstractFields {

    private static final String RESOURCES_FOR_PATTERN = "//*[@id=\"sidebar\"]//ul[@*=\"autonavLevel1\"]/li/*[(name()=\"span\" or name()=\"a\") and contains(.,\"%s\")]";
    private static final String AUTHORS_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Authors");
    private static final String LIBRARIANS_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Librarians");
    private static final String BOOKSELLERS_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Booksellers");
    private static final String INSTRUCTORS_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Instructors");
    private static final String STUDENT_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Students");
    private static final String SOCIETIES_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Societies");
    private static final String CPARTNERS_BUTTON = String.format(RESOURCES_FOR_PATTERN, "Corporate Partners");

    public static Map<String, String> STUDENTS_PAGE_FIELD_MAP = new HashMap<String, String>(AbstractFields.ABSTRACT_FIELD_MAP){
        {
            put("Students", STUDENT_BUTTON);
            put("Authors", AUTHORS_BUTTON);
            put("Instructors", INSTRUCTORS_BUTTON);
            put("Librarians", LIBRARIANS_BUTTON);
            put("Societies", SOCIETIES_BUTTON);
            put("Corporate Partners", CPARTNERS_BUTTON);
            put("Booksellers", BOOKSELLERS_BUTTON);
        }
    };


    public static WebElement getFieldByName(WebDriver driver, String fieldName) {
        WebElement field = null;
        try {
            field = driver.findElement(By.xpath(STUDENTS_PAGE_FIELD_MAP.get(fieldName)));
        }catch (Exception e){

        }
        return field;
    }
}
