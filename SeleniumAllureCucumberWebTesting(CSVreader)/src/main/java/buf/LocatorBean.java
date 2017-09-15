package buf;

import lombok.Data;


/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */

public class LocatorBean {


    public static String RESOURCES_PATTERN ;

    public static String HOME_BUTTON;

    public static String SUBJECT_BUTTON;
    public static String ABOUT_WILEY_BUTTON;
    public static String CONTACT_US_BUTTON;
    public static String HELP_BUTTON;

    public static String SEARCH_INPUT;
    public static String SEARCH_ICON;


    public static void setField(String[] values){
            try {
                if (values[1].equals("")){
                    LocatorBean.class.getField(values[2]).set(String.class, values[3]);
                }else {
                    LocatorBean.class.getField(values[2]).set(String.class, String.format(RESOURCES_PATTERN, values[3]));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

    }

}
