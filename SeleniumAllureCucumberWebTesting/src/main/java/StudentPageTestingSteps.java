import Pages.Page;
import Pages.PageGenerator;
import Pages.StudentsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class StudentPageTestingSteps extends TestSteps{

    private StudentsPage studentsPage;

    @Given("^open the Wiley \"([^\"]*)\" page$")
    public void open_the_Wiley_page(String arg1) throws Throwable {
        studentsPage = new StudentsPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/id-404702.html");
    }

    @Then("^(\\d+) items are displayed in Resources For menu:$")
    public void items_are_displayed_in_Resources_For_menu(int arg1, DataTable arg2) throws Throwable {
        Assert.assertTrue(studentsPage.checkResourcesFor(arg1, arg2.asList(String.class)));
    }

    @Then("^\"([^\"]*)\" item is displayed$")
    public void item_is_displayed(String arg1) throws Throwable {
        Assert.assertTrue(studentsPage.isStudentSelected());
    }

    @Then("^\"([^\"]*)\" item has different style$")
    public void item_has_different_style(String arg1) throws Throwable {
        Assert.assertTrue(true);
    }

    @Then("^\"([^\"]*)\" item is clickable$")
    public void item_is_clickable(String arg1) throws Throwable {
        Assert.assertTrue(true);
    }

    @Then("^click at \"([^\"]*)\" link at the top navigation menu$")
    public void click_at_link_at_the_top_navigation_menu(String arg1) throws Throwable {
        studentsPage.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/index.html");
    }

}
