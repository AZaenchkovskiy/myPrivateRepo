package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AZaenchkovskiy on 07.09.2017.
 */
public abstract class AbstractPage implements Page{

    protected final String searchURL = "http://eu.wiley.com/WileyCDA/Section/id-WILEYEUROPE2_SEARCH_RESULT.html?query=";
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id=\"links-site\"]//a[contains(., \"Home\")]")
    protected WebElement homeButton;
    @FindBy(xpath = "//*[@id=\"links-site\"]//a[contains(., \"Subjects\")]")
    protected WebElement subjectsButton;
    @FindBy(xpath = "//*[@id=\"links-site\"]//a[contains(., \"About Wiley\")]")
    protected WebElement aboutWileyButton;
    @FindBy(xpath = "//*[@id=\"links-site\"]//a[contains(., \"Contact Us\")]")
    protected WebElement contactUsButton;
    @FindBy(xpath = "//*[@id=\"links-site\"]//a[contains(., \"Help\")]")
    protected WebElement helpButton;
    @FindBy(id = "query")
    protected WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"query\"]/following-sibling::input[@type=\"submit\"]")
    protected WebElement startSearchIcon;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getStartSearchIcon() {
        return startSearchIcon;
    }

    public HomePage clickHome(){
        this.getHomeButton().click();
        return new HomePage(driver);
    }

    public SearchPage search(String searchString){
        searchInput.sendKeys(searchString);
        startSearchIcon.click();
        return new SearchPage(driver, searchString);
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getSubjectsButton() {
        return subjectsButton;
    }

    public WebElement getAboutWileyButton() {
        return aboutWileyButton;
    }

    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public WebElement getHelpButton() {
        return helpButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }
}
