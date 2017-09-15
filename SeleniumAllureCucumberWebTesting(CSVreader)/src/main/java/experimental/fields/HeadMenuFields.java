package experimental.fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class HeadMenuFields {

    private static String RESOURCES_PATTERN;
    private static String HOME_BUTTON;
    private static String SUBJECT_BUTTON;
    private static String ABOUT_WILEY_BUTTON;
    private static String CONTACT_US_BUTTON;
    private static String HELP_BUTTON;

    private static String SEARCH_INPUT;
    private static String SEARCH_ICON;

    public static Map<String, String> MENU_FIELD_MAP =MENU_FIELD_MAP = new HashMap<String, String>();

    public static void initializeMap() {
                MENU_FIELD_MAP.put("Home", HOME_BUTTON);
                MENU_FIELD_MAP.put("Subjects", SUBJECT_BUTTON);
                MENU_FIELD_MAP.put("About Wiley", ABOUT_WILEY_BUTTON);
                MENU_FIELD_MAP.put("Contact Us", CONTACT_US_BUTTON);
                MENU_FIELD_MAP.put("Help", HELP_BUTTON);
                MENU_FIELD_MAP.put("SearchInput", SEARCH_INPUT);
                MENU_FIELD_MAP.put("SearchIcon", SEARCH_ICON);
    }
}
