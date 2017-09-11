package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class ElementsConstatnts {

    public static final String ELEMENTS_PATTERN = "//*[@class=\"autonav\"]//a[contains(., \"%s\")]";
    public static final String AUTHORS_BUTTON = String.format(ELEMENTS_PATTERN, "Authors");
    public static final String LIBRARIANS_BUTTON = String.format(ELEMENTS_PATTERN, "Librarians");
    public static final String BOOKSELLERS_BUTTON = String.format(ELEMENTS_PATTERN, "Booksellers");
    public static final String INSTRUCTORS_BUTTON = String.format(ELEMENTS_PATTERN, "Instructors");
    public static final String STUDENT_BUTTON = String.format(ELEMENTS_PATTERN, "Students");
    public static final String GOVERMENT_BUTTON = String.format(ELEMENTS_PATTERN, "Government Employees");
    public static final String SOCIETIES_BUTTON = String.format(ELEMENTS_PATTERN, "Societies");
    public static final String CPARTNERS_BUTTON = String.format(ELEMENTS_PATTERN, "Corporate Partners");

}
