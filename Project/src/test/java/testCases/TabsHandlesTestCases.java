package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;

public class TabsHandlesTestCases {

    WebDriver driver;
    HomePage homePage;
    SoftAssert softAssert;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.navigate().to("https://demo.nopcommerce.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void FollowUsFb() {
        homePage.switchToFb();
        homePage.WindowsHandles(1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://web.facebook.com/nopCommerce?_rdc=1&_rdr");

    }

    @Test (priority = 2)
    public void FollowUsTwitter() {
        homePage.switchToTwitter();
        homePage.WindowsHandles(1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://twitter.com/nopCommerce");
    }
    @Test (priority = 3)
    public void FollowUsRss() {
        homePage.switchToRss();
        homePage.WindowsHandles(0);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo.nopcommerce.com/news/rss/1");
    }
    @Test(priority = 4)
    public void FollowUsYoutube() {
        homePage.switchToYoutube();
        homePage.WindowsHandles(1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://www.youtube.com/user/nopCommerce");
    }

    }

