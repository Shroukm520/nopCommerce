package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage {

    //Variables

    WebDriver driver;
    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Elements
    By email = By.cssSelector("input[name=\"Email\"]");
    By password = By.name("Password");
    By loginBtn = By.xpath("(//button[@type=\"submit\"])[2]");
    By loginWasUnsuccessful = By.xpath("//*[contains(text(), 'Login was unsuccessful.')]");

    //Actions

    public void insertEmail(String E){
        driver.findElement(email).sendKeys(E);
    }
    public void insertPassword(String P){
        driver.findElement(password).sendKeys(P);
    }
    public void clickOnLogin(){
        driver.findElement(loginBtn).click();
    }
    public boolean ErrorMsgOfInvalidLogin(){
        return driver.findElement(loginWasUnsuccessful).isDisplayed();
    }
    public String errorMsgColour(){
        String errorMsgColourOfLoginUnsuccessful = driver.findElement(loginWasUnsuccessful).getCssValue("Color");
        return Color.fromString(errorMsgColourOfLoginUnsuccessful).asHex();

    }
}

