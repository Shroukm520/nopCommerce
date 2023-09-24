package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.RegisterPage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePageTestCases {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    ProductPage productPage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        softAssert = new SoftAssert();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void registrationSteps(){
        homePage.clickOnRegisterBtn();
        Assert.assertEquals(homePage.assertTheURL(), "https://demo.nopcommerce.com/register?returnUrl=%2F", "CorrectURl");
        homePage.clickOnRegisterBtn();
        registerPage.clickOnFemaleGender();
        registerPage.insertTheTheFirstName("Zaza");
        registerPage.insertTheLastName("Fazaza");
        registerPage.chooseDayOfBirth("30");
        registerPage.chooseMonthOfBirth("January");
        registerPage.chooseYearOfBirth("1997");
        registerPage.writeEmil("dapadi4552@prolug.com");
        registerPage.setPassword("Password_123456");
        registerPage.setConfirmPasswordField("Password_123456");
        registerPage.clickOnRegisterBtn();
        Assert.assertTrue(registerPage.SuccessMsg());

        softAssert.assertEquals(registerPage.getMsgColour(),"#4cb17c");

        softAssert.assertAll();

    }
    @Test (priority = 2)
    public void validLogin(){
        homePage.clickOnLoginBtn();
        loginPage.insertEmail("dapadi4552@prolug.com");
        loginPage.insertPassword("Password_123456");
        loginPage.clickOnLogin();
        softAssert.assertEquals(homePage.assertTheURL(),"https://demo.nopcommerce.com/");
        softAssert.assertTrue(homePage.myAccountBtn());
        softAssert.assertAll();
    }
    @Test (priority = 3)
    public void invalidLogin(){
        homePage.clickOnLoginBtn();
        loginPage.insertEmail("dapadi4552@prolug.com");
        loginPage.insertPassword("Pass_123456");
        loginPage.clickOnLogin();
        softAssert.assertTrue(loginPage.ErrorMsgOfInvalidLogin());
        softAssert.assertEquals(loginPage.errorMsgColour(), "#e4434b");

        softAssert.assertAll();
    }
    @Test (priority = 4)
    public void SearchProduct(){
        productPage.sKUINSearchbar("COMP_CUST");
        productPage.ClickOnSearchBtn();
        productPage.clickOnResult();
        System.out.println(productPage.confirmSKU());
        Assert.assertTrue(productPage.isSameSKU());

    }

    @Test(priority = 5)
    public void HooverCategories() {
        homePage.HooverComputerCategories();
        homePage.checkPageTitle();
        System.out.println(homePage.getTextPageTitle());
        Assert.assertTrue(homePage.checkPageTitle());
    }

    }
