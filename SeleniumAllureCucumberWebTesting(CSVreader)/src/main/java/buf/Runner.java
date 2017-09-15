package buf;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by AZaenchkovskiy on 12.09.2017.
 */
public class Runner {
    public static void main(String[] args) {
        CSVReader reader = null;
        try {
            String[] line;
            reader = new CSVReader(new FileReader("src/main/resources/elementDefinition.csv"), ';');
            while ((line = reader.readNext()) != null){
                Class.forName(line[0]).getMethod("setFields", String[].class).invoke(null, (Object)line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Field field :LocatorBean.class.getFields()){
            try {
                System.out.println(field.getName() + " " + field.get(String.class));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
