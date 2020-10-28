package selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestTestng {

    private WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterTest
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