package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    //Variables

    WebDriver driver;
    //constructor
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    //Elements
    By searchBar = By.name("q");
    By clickOnSearch = By.xpath("//button[@type=\"submit\"]");
    By results = By.className("product-title");
    //By SKU = By.xpath("//span[text()=\"M8_HTC_5L\"]");
    By sameSKU = By.cssSelector("div[class=\"sku\"] > span[class=\"value\"]");


    //Actions
    public void sKUINSearchbar(String SKU){
        driver.findElement(searchBar).sendKeys(SKU);
    }
    public void ClickOnSearchBtn(){
        driver.findElement(clickOnSearch).click();
    }
    public void clickOnResult(){
        driver.findElement(results).click();
    }
    public boolean isSameSKU(){
       return driver.findElement(sameSKU).isDisplayed();
    }
    public String confirmSKU(){
        return driver.findElement(sameSKU).getText();
    }

}
