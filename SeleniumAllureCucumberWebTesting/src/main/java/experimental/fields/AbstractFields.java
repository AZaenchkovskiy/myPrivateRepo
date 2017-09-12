package experimental.fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class AbstractFields {

    private static final String RESOURCES_PATTERN = "//*[@id=\"links-site\"]//a[contains(., \"%s\")]";
    private static final String HOME_BUTTON = String.format(RESOURCES_PATTERN, "Home");
    private static final String SUBJECT_BUTTON = String.format(RESOURCES_PATTERN, "Subjects");
    private static final String ABOUT_WILEY_BUTTON = String.format(RESOURCES_PATTERN, "About Wiley");
    private static final String CONTACT_US_BUTTON = String.format(RESOURCES_PATTERN, "Contact Us");
    private static final String HELP_BUTTON = String.format(RESOURCES_PATTERN, "Help");
    private static final String SEARCH_INPUT = "//*[@id=\"query\"]";
    private static final String SEARCH_ICON = "//*[@id=\"query\"]/following-sibling::input[@type=\"submit\"]";


    public static Map<String, String> ABSTRACT_FIELD_MAP = new HashMap<String, String>(){
        {
            put("Home", HOME_BUTTON);
            put("Subjects", SUBJECT_BUTTON);
            put("About Wiley", ABOUT_WILEY_BUTTON);
            put("Contact Us", CONTACT_US_BUTTON);
            put("Help", HELP_BUTTON);
            put("SearchInput", SEARCH_INPUT);
            put("SearchIcon", SEARCH_ICON);

        }
    } ;

}
