package homePage;

import commonAPI.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static homePage.ETradeHomePageElement.*;

public class ETradeHomePage extends WebAPI {

    @FindBy(how = How.LINK_TEXT, using = webElementLowFeesLink)
     public WebElement lowFeesLink;
    @FindBy(how = How.XPATH, using = webElementLowFeesText)
     public WebElement lowFeesText;
    @FindBy(how = How.XPATH, using = webElementAccountTypeMenu)
     public WebElement accountTypesMenu;
    @FindBy(how = How.XPATH, using = webElementAccountTypesLink)
     public WebElement accountTypesLink;
    @FindBy(how = How.XPATH,using = webElementOpenAnAccountButton)
    public WebElement openAnAccount;
    @FindBy(how = How.XPATH,using = webElementSelectAnAccountText)
    public WebElement selectAnAccountText;


    public void doClickOnLink(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(lowFeesLink));

        clickOnElement(lowFeesLink);
    }
    public  void validateClickOnLink(){

        String actualText = lowFeesText.getText();
        String expectedText = "Rates and Fees";
        System.out.println(actualText);
        System.out.println(expectedText);


        Assert.assertEquals(actualText,expectedText);
    }

    public  void validateUrl(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://us.etrade.com/bank/bank-rates";

       Assert.assertEquals(actualUrl, expectedUrl);

    }

    public void mouseHooverOnAccountTypesMenu(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(accountTypesMenu));

        Actions action = new Actions(driver);

        action.moveToElement(accountTypesMenu).build().perform();

    }

    public void clickOnAccountTypesLink(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(accountTypesLink));
        clickOnElement(accountTypesLink);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,"Online Brokerage Account | Open an Account | E*TRADE");

    }
    public void doClickOnOpenAnAccountButton(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(openAnAccount));
        clickOnElement(openAnAccount);

    }
    public void validatePageUrl(){

        WebDriverWait wait = new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.visibilityOf(selectAnAccountText));

        String expectedUrl ="https://express.etrade.com/etx/rtao/bank/accounts/premium-savings-account?tb=5000";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
