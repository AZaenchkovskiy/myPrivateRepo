import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/yandex.feature"},
                            plugin = "com.aplana.course.Reporter")
public class SeleniumCourseRunner {

}
