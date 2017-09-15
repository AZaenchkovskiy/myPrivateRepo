package experimental.fields;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by AZaenchkovskiy on 13.09.2017.
 */
public class FieldHandler {
    public static Map<String, Map<String, String>> getMap() {
        return map;
    }

    private static Map<String, Map<String, String> > map = new TreeMap<String, Map<String, String>>();

    public static void setter(String[] values){
            String currentClassName = values[0];
            if(!map.containsKey(currentClassName)){
                map.put(currentClassName, new HashMap<String, String>());
                Map<String, String> fields = map.get(currentClassName);
                if (values[1].equals("")) {
                    fields.put(values[2], values[3]);
                } else {
                    fields.put(values[2], String.format(fields.get("RESOURCES_PATTERN"), values[3]));
                }

            }else {
                Map<String, String> fields = map.get(currentClassName);
                if (values[1].equals("")) {
                    fields.put(values[2], values[3]);
                } else {
                    fields.put(values[2], String.format(fields.get("RESOURCES_PATTERN"), values[3]));
                }
            }
    }

    public static void initializeClassFields(){
        for (Map.Entry<String, Map<String, String>> classFields: map.entrySet()){
            Class currentClass = null;
            try {
                currentClass = Class.forName(classFields.getKey());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (Map.Entry<String, String> fieldAndValue : classFields.getValue().entrySet()){
                try {
                    Field field = currentClass.getDeclaredField(fieldAndValue.getKey());
                    field.setAccessible(true);
                    field.set(null, fieldAndValue.getValue());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            try {
                currentClass.getMethod("initializeMap").invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
