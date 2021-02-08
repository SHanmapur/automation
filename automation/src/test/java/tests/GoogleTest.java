package tests;

import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class GoogleTest  {
    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().arch32().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        HomePage homePage= new HomePage(driver);
        homePage.searchText("Ducks");
        homePage.verifyResults("Duck");
    }
}
