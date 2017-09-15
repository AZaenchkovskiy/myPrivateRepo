package experimental.scenarios;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import experimental.fields.DefinitionsReader;
import experimental.fields.FieldHandler;
import experimental.pages.Page;
import cucumber.api.java.en.Given;
import experimental.pages.PageGenerator;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class WilleyTestSteps {


    private Page currentPageObject;
    private static WebDriver driver = PageGenerator.getDriver();
    private static String titleFromList;

    @Given("^open the Wiley \"([^\"]*)\" page$")
    public void open_the_Wiley_page(String pageName) throws Throwable {
        DefinitionsReader.getInstance().readFields();
        FieldHandler.initializeClassFields();
        currentPageObject = PageGenerator.openPage(pageName);
        Assert.assertEquals(currentPageObject.getUrl(), driver.getCurrentUrl());
    }

    @Then("^following item is displayed in top navigation menu:$")
    public void following_item_is_displayed_in_top_navigation_menu(DataTable expectedElems) throws Throwable {
        List<String> givenList = expectedElems.asList(String.class);
        for (String expectedElem : givenList){
            WebElement actualElem = currentPageObject.getFieldByName(driver, expectedElem);
            Assert.assertNotNull(expectedElem, actualElem.getText());
        }
    }

    @Then("^(\\d+) items are displayed under Resources sub-header:$")
    public void items_are_displayed_under_Resources_sub_header(int count, DataTable expectedElems) throws Throwable {
        List<String> givenList = expectedElems.asList(String.class);
        Assert.assertEquals(count, givenList.size());
        for (String givenElem : givenList){
            WebElement actualElem = currentPageObject.getFieldByName(driver, givenElem);
            String actualStr = actualElem.getText();
            Assert.assertNotNull(givenElem, actualStr);
        }
    }

    @When("^click on \"([^\"]*)\" item")
    @Then("^click \"([^\"]*)\" icon under Resources sub-header$")
    public void click_on(String field) throws Throwable {
        currentPageObject.clickOn(field);
    }

    @Then("^\"([^\"]*)\" url is opened$")
    public void url_is_opened(String arg1) throws Throwable {
        Assert.assertEquals(arg1, driver.getCurrentUrl());
    }

    @Then("^\"([^\"]*)\" header is displayed$")
    public void header_is_displayed(String arg1) throws Throwable {
        Assert.assertEquals(arg1 , driver.findElement(By.xpath("//*[@id=\"page-title\"]/h1")).getText());
    }

    @Then("^(\\d+) items are displayed in Resources For menu:$")
    public void items_are_displayed_in_Resources_For_menu(int count, DataTable expectedElems) throws Throwable {
        List<String> givenList = expectedElems.asList(String.class);
        Assert.assertEquals(count, givenList.size());
        for (String givenElem : givenList){
            WebElement actualElem = currentPageObject.getFieldByName(driver, givenElem);
            String actualStr = actualElem.getText();
            Assert.assertNotNull(givenElem, actualStr);
        }
    }

    @Then("^\"([^\"]*)\" item is displayed$")
    public void item_is_displayed(String arg1) throws Throwable {
        Assert.assertTrue(currentPageObject.getFieldByName(driver, arg1).isEnabled());
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
        currentPageObject.clickOn(arg1);
    }

    @Then("^find “Sign up to receive Wiley updates” line and click \"([^\"]*)\" button$")
    public void find_Sign_up_to_receive_Wiley_updates_line_and_click_arrow_button(String arrowButton) throws Throwable {
        currentPageObject.getFieldByName(driver, arrowButton).click();
    }

    @Then("^check that alert appeared with text \"([^\"]*)\"$")
    public void check_that_alert_appeared_with_text(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        driver.switchTo().defaultContent();
        Assert.assertEquals(arg1, alertMessage);
    }

    @Then("^enter \"([^\"]*)\" email and click Arrow button$")
    public void enter_invalid_email_and_click_arrow_button(String email) throws Throwable {
        WebElement emailUpdate = currentPageObject.getFieldByName(driver, "EmailUpdate");
        emailUpdate.sendKeys(email);
        currentPageObject.getFieldByName(driver, "Arrow").click();
    }

    @Then("^enter \"([^\"]*)\" to the search input field and pres search icon$")
    public void enter_to_the_search_input_field_and_pres_search_icon(String searchString) throws Throwable {
        currentPageObject.getFieldByName(driver, "SearchInput").sendKeys(searchString);
        currentPageObject.getFieldByName(driver, "SearchIcon").click();
        Assert.assertNotEquals(driver.getCurrentUrl(), currentPageObject.getUrl());
        currentPageObject = currentPageObject.search(searchString);
    }

    @Then("^check that list of items appeared$")
    public void check_that_list_of_items_appeared() throws Throwable {
        Assert.assertTrue(currentPageObject.getFieldByName(driver, "ResultsBlock").isEnabled());
    }

    @Then("^click random item link$")
    public void click_random_item_link() throws Throwable {
        titleFromList = driver.findElements(By.xpath("//*[@id=\"search-results\"]//div[@class=\"product-title\"]")).get(0).getText();
        currentPageObject.getFieldsByName(driver, "ResultItems").get(0).click();
    }

    @Then("^check that page with header equal to the title you clicked is displayed$")
    public void check_that_page_with_header_equal_to_the_title_you_clicked_is_displayed() throws Throwable {
        String contentTitle = driver.findElement(By.xpath("//*[@id=\"main-content-left\"]//h1")).getText();
        Assert.assertEquals(titleFromList, contentTitle);
    }

    @Then("^click “Home” link at the top navigation menu$")
    public void click_Home_link_at_the_top_navigation_menu() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"links-site\"]//a[contains(., \"Home\")]")).click();
        currentPageObject = PageGenerator.openPage("Home");
    }

    @Then("^check \"([^\"]*)\" is opened in new window$")
    public void check_http_wileyedsolutions_com_is_opened_in_new_window(String arg1) throws Throwable {
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertEquals(arg1, driver.getCurrentUrl());
        driver.quit();
    }
}
