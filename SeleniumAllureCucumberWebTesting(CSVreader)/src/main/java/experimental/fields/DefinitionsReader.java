package experimental.fields;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by AZaenchkovskiy on 13.09.2017.
 */
public class DefinitionsReader {

    private static DefinitionsReader instance = new DefinitionsReader();

    private DefinitionsReader(){
    }

    public DefinitionsReader getInstanse(){
        return instance;
    }
    public void readFields(){
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/elementDefinition.csv"), ';');
            String[] valuesLine;
            while ((valuesLine = reader.readNext()) != null){
                FieldHandler.setter(valuesLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FieldHandler.initializeClassFields();
    }

    public static DefinitionsReader getInstance(){
        return instance;
    }
}
