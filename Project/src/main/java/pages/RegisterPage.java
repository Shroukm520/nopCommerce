package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    //Variables

    WebDriver driver;
    Select select;

    //Constructor

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    //Elements
    By gender = By.id("gender-female");
    By firstName = By.name("FirstName");
    By lastName = By.name("LastName");
    By dayOfBirth = By.name("DateOfBirthDay");
    By monthOfBirth = By.name("DateOfBirthMonth");
    By yearOfBirth = By.name("DateOfBirthYear");
    By emailField = By.name("Email");
    By passwordField = By.name("Password");
    By confirmPasswordField = By.name("ConfirmPassword");
    By confirmRegisterBtn = By.name("register-button");

    //Actions
    public void clickOnFemaleGender(){
        driver.findElement(gender).click();
    }

    public void insertTheTheFirstName(String Firstname){
        driver.findElement(firstName).sendKeys(Firstname);
    }

    public void insertTheLastName(String LastName){
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void chooseDayOfBirth(String day){
        Select chooseDay = new Select(driver.findElement(dayOfBirth));
        chooseDay.selectByValue(day);
    }

    public void chooseMonthOfBirth(String month){
        Select chooseMonth = new Select(driver.findElement(monthOfBirth));
        chooseMonth.selectByVisibleText(month);
    }

    public void chooseYearOfBirth(String year){
        Select chooseYear = new Select(driver.findElement(yearOfBirth));
        chooseYear.selectByValue(year);
    }

    public void writeEmil(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPasswordField(String rePassword){
        driver.findElement(confirmPasswordField).sendKeys(rePassword);
    }
    public void clickOnRegisterBtn(){
        driver.findElement(confirmRegisterBtn).click();
    }
    public boolean SuccessMsg() {
        String successfulMsg = driver.findElement(By.className("result")).getText();
        return successfulMsg.contains("Your registration completed");
    }
    public String getMsgColour(){
        String MsgColorRGBA = driver.findElement(By.className("result")).getCssValue("Color");
        return Color.fromString(MsgColorRGBA).asHex();
    }
}
