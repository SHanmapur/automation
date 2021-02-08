package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public  WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public  void setUp(){
        WebDriverManager.chromedriver().arch32().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
        driver.get("http://google.com");
    }

    @AfterMethod(alwaysRun = true)
    public  void kill(){
        driver.quit();
    }
}
