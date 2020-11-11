package homePage;


import commonAPI.WebAPI;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;

import static homePage.AmazonHomePageElements.*;

public class AmazonHomePage extends WebAPI {

    @FindBy(how = How.CSS, using = webElementSearchBox)
    public WebElement searchBox;
    @FindBy(how = How.CSS, using = webElementSearchButton)
    public WebElement searchButton;
    @FindBy(how = How.XPATH, using = webElementSearchText)
    public WebElement searchText;
    @FindBy(how = How.CSS, using = webElementSearchBoxDropDown)
    public WebElement searchBoxDropDown;
    @FindBy(how = How.XPATH, using = webElementTryPrimeButton)
    public WebElement tryPrimeButton;
    @FindBy(how = How.XPATH, using = webElementTryPrimeLink)
    public WebElement tryPrimeLink;
    @FindBy(how = How.XPATH, using = webElementAccountAndListMenu)
    public WebElement accountAndListMenu;
    @FindBy(how = How.XPATH, using = webElementYourOrderLink)
    public WebElement yourOrderLink;

    public void doSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("computers");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        clickOnElement(searchButton);

    }

    public void validateSearchText() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchText));
        String actualText = searchText.getText();
        String expectedText = "\"computers\"";
        Assert.assertEquals(actualText, expectedText, "Expected Text not found");
    }

    public int validateLinkNum() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchBoxDropDown));
        clickOnElement(searchBoxDropDown);
        List<WebElement> links = driver.findElements(By.cssSelector(webElementSearchBoxDropDown));
        System.out.println(links.size());

        return links.size();

    }
    public String validateTryPrimePageUrl()  {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(tryPrimeButton));
        clickOnElement(tryPrimeButton);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        return driver.getCurrentUrl();



    }
    public String validateTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(accountAndListMenu));
        Actions ac = new Actions(driver);
        ac.moveToElement(accountAndListMenu).build().perform();
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       clickOnElement(yourOrderLink);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);



        return driver.getTitle();

    }
    public int validateListNum(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(accountAndListMenu));
        Actions ac = new Actions(driver);
        ac.moveToElement(accountAndListMenu).build().perform();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        List<WebElement> list= driver.findElements(By.xpath(webElementProductsList));
        for (WebElement we:list){
            System.out.println(we.getText());
            System.out.println(we.getSize());
        }

        return 20;
    }


}
