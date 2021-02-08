package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Clock;
import java.util.List;
import java.util.Locale;

public class HomePage {
WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;

    }


    By searchTextBox = By.name("q");
    public void searchText(String text){
        driver.findElement(searchTextBox).sendKeys(text);
        driver.findElement(searchTextBox).sendKeys(Keys.ENTER);
    }
By result = By.cssSelector("#search div.g");
    public void verifyResults(String str){
        List<WebElement> results = driver.findElements(result);
        System.out.println(results.size());
        for(WebElement ele: results){
            if(ele.getText().trim().length()>0)
            if(!ele.getText().toLowerCase().contains(str.toLowerCase())){
                System.out.println(ele.getText());
                Assert.fail();break;
            }
            else
                System.out.println("----"+ele.getText());
        }
    }
}
