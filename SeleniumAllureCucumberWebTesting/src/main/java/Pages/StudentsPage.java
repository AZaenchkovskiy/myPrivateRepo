package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by AZaenchkovskiy on 07.09.2017.
 */
public class StudentsPage extends AbstractPage{

    private WebElement sideBar;


    public StudentsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver= driver;
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-404702.html");
        sideBar = driver.findElement(By.xpath("//*[@id=\"sidebar\"]//span[contains(., \"Student\")]/parent::*"));
    }

    public boolean checkResourcesFor(int count, List<String> givenElementList){
        List<WebElement> currentElementList = driver.findElements(By.xpath("//*[@id=\"sidebar\"]//ul[@*=\"autonavLevel1\"]/li/*[name()=\"span\" or name()=\"a\"]"));
        if (currentElementList.size() == count) {
            List<String> currentElementTextList = new ArrayList<String>();
            for (WebElement element : currentElementList) {
                currentElementTextList.add(element.getText());
            }
            for (String givenElem : givenElementList) {
                if(!currentElementTextList.contains(givenElem)){
                    return false;
                }
            }
        }else return false;
        return true;
    }

    public boolean isStudentSelected(){
        boolean isAnotherStyle = sideBar.getAttribute("class").contains("active");
        boolean isNotClickable  = true;   // ????
        return isAnotherStyle && isNotClickable;
    }

    public List<WebElement> getSideBarElements(){
        return driver.findElements(By.xpath("//*[@id=\"sidebar\"]//ul[@*=\"autonavLevel1\"]/*"));
    }


}

//     private String locationPattern = "//*[@class=\"autonav\"]//a[contains(., \"%s\")]";

//    private Map<String, WebElement> elementMap = new HashMap<String, WebElement>(){
//        {
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Authors"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Librarians"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Booksellers"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Instructors"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Students"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Government Employees"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Societies"))));
//            put("Authors", driver.findElement(By.xpath(String.format(locationPattern, "Corporate Partners"))));
//        }
//    };
//    private List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"sidebar\"]//ul[@*=\"autonavLevel1\"]/*"));

//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Authors\")]")
//    private WebElement authorsButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Librarians\")]")
//    private WebElement librariansButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Booksellers\")]")
//    private WebElement booksellersButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Instructors\")]")
//    private WebElement instructorsButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Students\")]")
//    private WebElement studentButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Government Employees\")]")
//    private WebElement govermentButton;
//    @FindBy(xpath = "//*[@class=\"autonavItem\"]//a[contains(., \"Societies\")]")
//    private WebElement societiesButton;
//    @FindBy(xpath = "//*[@class=\"autonav\"]//a[contains(., \"Corporate Partners\")]")
//    private WebElement cpartnersButton;


//            if (studentButton.getText().equals("Students") && authorsButton.getText().equals("Authors") && instructorsButton.getText().equals("Instructors")
//                    && librariansButton.getText().equals("Librarians") && societiesButton.getText().equals("Societies")
//                    && govermentButton.getText().equals("Government Employees") && booksellersButton.getText().equals("Booksellers")
//                    && cpartnersButton.getText().equals("Corporate Partners")) {
//                return true;