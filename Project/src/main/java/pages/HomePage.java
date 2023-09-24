package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class HomePage {
    //Variables

    WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //Elements
    By RegisterBtn = By.cssSelector("a[href=\"/register?returnUrl=%2F\"]");
    By loginBtnInHomePage = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
    By myAccount = By.cssSelector("a[class=\"ico-account\"]");
    By notebookBtn = By.linkText("Notebooks");

    By pageTitle = By.className("page-title");


    //Wishlist Elements
    By wishList = By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]");
    By successMsg = By.cssSelector("div[class=\"bar-notification success\"]");
    By wishListBtnInBar = By.className("wishlist-label");
    //Followus
    By facebook = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
    By twitter = By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]");
    By rss = By.className("rss");
    By youtube = By.className("youtube");


    //Qty
    By quantity = By.className("qty-input");

    //Actions

    public void clickOnRegisterBtn() {
        driver.findElement(RegisterBtn).click();

    }


    public String assertTheURL() {
        return driver.getCurrentUrl();
    }

    public void clickOnLoginBtn() {
        driver.findElement(loginBtnInHomePage).click();
    }

    public boolean myAccountBtn() {
        return driver.findElement(myAccount).isDisplayed();
    }


    //3-HooverCategories
    public void HooverComputerCategories() {
        Actions actions = new Actions(driver);
        WebElement computersCategory = driver.findElement(By.cssSelector("[href=\"/computers\"]"));
        actions.moveToElement(computersCategory).perform();
        driver.findElement(notebookBtn).click();
    }

    public String getTextPageTitle() {
        return driver.findElement(pageTitle).getText();

    }

    public boolean checkPageTitle() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    //FollowUs Scenario


    public void WindowsHandles(int intValue) {
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(intValue));

    }

    public void switchToFb() {
        driver.findElement(facebook).click();
    }

    public void switchToTwitter() {
        driver.findElement(twitter).click();
    }

    public void switchToRss() {
        driver.findElement(rss).click();
    }

    public void switchToYoutube() {
        driver.findElement(youtube).click();
    }

    public void clickOnWishlistBtn(String text) {
        driver.findElement(RelativeLocator.with(wishList).
                below(By.partialLinkText(text))).click();
    }

    public boolean isSuccessMsgDisplayed() {
        return driver.findElement(wishList).isDisplayed();
    }

    public String successMsgColour() {
        String msgColorProductAdded = driver.findElement(successMsg).getCssValue("background-color");
        return Color.fromString(msgColorProductAdded).asHex();

    }

    public void clickOnWishListBtnInBar() {
        driver.findElement(wishListBtnInBar).click();

    }

    public String quantityField() {
        WebElement Qty = driver.findElement(quantity);
        return Qty.getAttribute("value");

    }



    }



