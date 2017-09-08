import Pages.HomePage;
import Pages.StudentsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class HomePageTestingSteps extends TestSteps{

    private HomePage homePage;

    @Given("^open the Wiley \"([^\"]*)\"$")
    public void open_the_Wiley_page(String arg1) throws Throwable {
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/index.html");
    }

    @Then("^following item is displayed in top navigation menu:$")
    public void following_item_is_displayed_in_top_navigation_menu(DataTable arg1) throws Throwable {
        Assert.assertTrue(homePage.checkTopNavigationMenu());
    }

    @Then("^(\\d+) items are displayed under Resources sub-header:$")
    public void items_are_displayed_under_Resources_sub_header(int arg1, DataTable arg2) throws Throwable {
        Assert.assertTrue(homePage.checkItemUnderResources());
    }

    @When("^click on \"([^\"]*)\" item")
    public void click_on(String arg1) throws Throwable {
        StudentsPage studentsPage = homePage.clickOnStudent();
        Assert.assertTrue(studentsPage != null);
    }

    @Then("^\"([^\"]*)\" url is opened$")
    public void url_is_opened(String arg1) throws Throwable {
        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(arg1, pageUrl);
    }

    @Then("^\"([^\"]*)\" header is displayed$")
    public void header_is_displayed(String arg1) throws Throwable {
        Assert.assertEquals("Students" , driver.findElement(By.xpath("//*[@id=\"page-title\"]/h1")).getText());
    }


}
