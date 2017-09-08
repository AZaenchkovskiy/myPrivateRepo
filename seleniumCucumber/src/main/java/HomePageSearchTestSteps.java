import Pages.HomePage;
import Pages.SearchPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class HomePageSearchTestSteps extends TestSteps{

    private HomePage homePage;

    @Then("^find “Sign up to receive Wiley updates” line and click arrow button$")
    public void find_Sign_up_to_receive_Wiley_updates_line_and_click_arrow_button() throws Throwable {
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/index.html");
    }

    @Then("^check that alert appeared with text \"([^\"]*)\"$")
    public void check_that_alert_appeared_with_text(String arg1) throws Throwable {
        Assert.assertTrue(homePage.checkAlertUpdatesNullSearch());
    }

    @Then("^enter invalid email and click arrow button$")
    public void enter_invalid_email_and_click_arrow_button() throws Throwable {
        Assert.assertTrue(homePage.checkInputInvalidEmail());
    }

    @Then("^enter \"([^\"]*)\" to the search input field and pres search icon$")
    public void enter_to_the_search_input_field_and_pres_search_icon(String arg1) throws Throwable {
//        SearchPage searchPage = homePage.search("for dummies");

    }

    @Then("^check that list of items appeared$")
    public void check_that_list_of_items_appeared() throws Throwable {
        SearchPage searchPage = homePage.search("for dummies");
        Assert.assertTrue(searchPage.getSearchResultBlock().isEnabled());
    }
}
