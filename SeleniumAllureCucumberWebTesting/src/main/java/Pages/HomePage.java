package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AZaenchkovskiy on 07.09.2017.
 */
public class HomePage extends AbstractPage{


    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Students\")]")
    private WebElement studentButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Authors\")]")
    private WebElement authorsButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Instructors\")]")
    private WebElement instructorsButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Librarians\")]")
    private WebElement librariansButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Societies\")]")
    private WebElement societiesButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Conferences\")]")
    private WebElement conferencesButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Booksellers\")]")
    private WebElement booksellersButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Corporations\")]")
    private WebElement corporationsButton;
    @FindBy(xpath = "//*[@id=\"homepage-links\"]//a[contains(., \"Institutions\")]")
    private WebElement institutionsButton;
    @FindBy(xpath = "//*[@id=\"EmailAddress\"]/following-sibling::*/button")
    private WebElement searchArrow;
    @FindBy(xpath = "//*[@id=\"EmailAddress\"]")
    private WebElement emailUpdateInput;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("http://www.wiley.com/WileyCDA/");
    }

    public boolean checkTopNavigationMenu(){
        if (homeButton.getText().equals("Home") && subjectsButton.getText().equals("Subjects") && aboutWileyButton.getText().equals("About Wiley")
                && contactUsButton.getText().equals("Contact Us") && helpButton.getText().equals("Help")){
            return true;
        }
        return false;
    }

    public boolean checkItemUnderResources(){
        if (studentButton.getText().equals("Students") && authorsButton.getText().equals("Authors") && instructorsButton.getText().equals("Instructors")
                && librariansButton.getText().equals("Librarians") && societiesButton.getText().equals("Societies")
                && conferencesButton.getText().equals("Conferences") && booksellersButton.getText().equals("Booksellers")
                && corporationsButton.getText().equals("Corporations") && institutionsButton.getText().equals("Institutions")){
            return true;
        }
        return false;
    }

    public StudentsPage clickOnStudent(){
        studentButton.click();
        return new StudentsPage(driver);
    }

    public InstitutionsPage clickOnInstitution(){
        institutionsButton.click();
        return new InstitutionsPage(driver);
    }

    public String checkAlertUpdatesNullSearch(){
        searchArrow.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        driver.switchTo().defaultContent();
        return alertMessage;
    }

    public boolean checkInputInvalidEmail(){

        emailUpdateInput.sendKeys("aplana.com");
        searchArrow.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return "Invalid email address.".equals(alertMessage);
    }

}
