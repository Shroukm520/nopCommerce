package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;

public class WishListTestCases {
    WebDriver driver;
    HomePage homePage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void wishlistBtn(){
        homePage.clickOnWishlistBtn("HTC One M8 Android L 5.0 Lollipop");
        softAssert.assertTrue(homePage.isSuccessMsgDisplayed());
        homePage.successMsgColour();
        softAssert.assertEquals(homePage.successMsgColour(), "#4bb07a");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        homePage.clickOnWishListBtnInBar();
        homePage.quantityField();
        String strValue = homePage.quantityField();
        Integer intValue = Integer.parseInt(strValue);
        softAssert.assertTrue(intValue >=1);
        System.out.println("The Qty is : "+ homePage.quantityField());


        softAssert.assertAll();

    }


}
