package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by AZaenchkovskiy on 07.09.2017.
 */
public class StudentsPage extends AbstractPage{

    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Authors\")]")
    private WebElement authorsButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Librarians\")]")
    private WebElement librariansButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Booksellers\")]")
    private WebElement booksellersButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Instructors\")]")
    private WebElement instructorsButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Students\")]")
    private WebElement studentButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Government Employees\")]")
    private WebElement govermentButton;
    @FindBy(xpath = "//*[@class=\"autonavItem\"]//a[contains(., \"Societies\")]")
    private WebElement societiesButton;
    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Corporate Partners\")]")
    private WebElement cpartnersButton;

    @FindBy(xpath = "//*[@id=\"sidebar\"]//span[contains(., \"Student\")]/parent::*")
    private WebElement sideBar;


    public StudentsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver= driver;
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-404702.html");
    }

    public boolean checkResourcesFor(){
        try {
            if (studentButton.getText().equals("Students") && authorsButton.getText().equals("Authors") && instructorsButton.getText().equals("Instructors")
                    && librariansButton.getText().equals("Librarians") && societiesButton.getText().equals("Societies")
                    && govermentButton.getText().equals("Government Employees") && booksellersButton.getText().equals("Booksellers")
                    && cpartnersButton.getText().equals("Corporate Partners")) {
                return true;
            }
        }catch (NoSuchElementException e){
        }
        return false;
    }

    public boolean isStudentSelected(){
        boolean isAnotherStyle = sideBar.getAttribute("class").contains("active");
        boolean isNotClickable  = true;   // ????
        return isAnotherStyle && isNotClickable;
    }


}
