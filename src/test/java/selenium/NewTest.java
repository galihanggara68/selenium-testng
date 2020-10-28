package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Penelusuran Google";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");

        Assert.assertEquals(text, search_text, "Text not found!");
    }

}
