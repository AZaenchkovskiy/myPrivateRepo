import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features")
public class TestRunner {



}
