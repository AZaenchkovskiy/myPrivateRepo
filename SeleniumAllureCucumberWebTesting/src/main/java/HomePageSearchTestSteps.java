import Pages.HomePage;
import Pages.SearchPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by AZaenchkovskiy on 08.09.2017.
 */
public class HomePageSearchTestSteps extends TestSteps{

    private static HomePage homePage;
    private SearchPage searchPage;
    private String titleFromList;
    private String contentTitle;

    @Then("^find “Sign up to receive Wiley updates” line and click arrow button$")
    public void find_Sign_up_to_receive_Wiley_updates_line_and_click_arrow_button() throws Throwable {
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/index.html");
    }

    @Then("^check that alert appeared with text \"([^\"]*)\"$")
    public void check_that_alert_appeared_with_text(String arg1) throws Throwable {
        Assert.assertEquals(arg1, homePage.checkAlertUpdatesNullSearch());
    }

    @Then("^enter invalid email and click arrow button$")
    public void enter_invalid_email_and_click_arrow_button() throws Throwable {
        Assert.assertTrue(homePage.checkInputInvalidEmail());
    }

    @Then("^enter \"([^\"]*)\" to the search input field and pres search icon$")
    public void enter_to_the_search_input_field_and_pres_search_icon(String arg1) throws Throwable {
        System.out.println();
        searchPage = homePage.search(arg1);
        Assert.assertNotNull(searchPage);
    }

    @Then("^check that list of items appeared$")
    public void check_that_list_of_items_appeared() throws Throwable {
        Assert.assertTrue(searchPage.getSearchResultBlock().isEnabled());
    }

    @Then("^click random item link$")
    public void click_random_item_link() throws Throwable {
        titleFromList = driver.findElements(By.xpath("//*[@id=\"search-results\"]//div[@class=\"product-title\"]")).get(0).getText();
        searchPage.getSearchResultItems().get(0).click();
    }

    @Then("^check that page with header equal to the title you clicked is displayed$")
    public void check_that_page_with_header_equal_to_the_title_you_clicked_is_displayed() throws Throwable {
        contentTitle = driver.findElement(By.xpath("//*[@id=\"main-content-left\"]//h1")).getText();
        Assert.assertEquals(titleFromList, contentTitle);
    }

    @Then("^click “Home” link at the top navigation menu$")
    public void click_Home_link_at_the_top_navigation_menu() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"links-site\"]//a[contains(., \"Home\")]")).click();
    }

    @Then("^click “Institutions” icon under Resources sub-header$")
    public void click_Institutions_icon_under_Resources_sub_header() throws Throwable {
        homePage.clickOnInstitution();
    }

    @Then("^check \"([^\"]*)\" is opened in new window$")
    public void check_http_wileyedsolutions_com_is_opened_in_new_window(String arg1) throws Throwable {
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertEquals(arg1, driver.getCurrentUrl());
        driver.quit();
    }

}
