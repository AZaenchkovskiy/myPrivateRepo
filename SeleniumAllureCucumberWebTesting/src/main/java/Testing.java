import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by AZaenchkovskiy on 11.09.2017.
 */
public class Testing {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-404702.html");
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"sidebar\"]//ul[@*=\"autonavLevel1\"]/li"));
        for (WebElement element : elementList){
            System.out.println(element.getText());
        }
//        System.out.println(elementList.get(1).getText());
    }
}
