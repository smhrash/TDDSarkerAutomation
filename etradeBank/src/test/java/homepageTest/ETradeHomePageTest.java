package homepageTest;

import commonAPI.WebAPI;
import homePage.ETradeHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ETradeHomePageTest extends WebAPI {

    static ETradeHomePage eTradeHomePage;

    public static void getInItElement(){

        eTradeHomePage = PageFactory.initElements(driver, ETradeHomePage.class);


    }
    @Test (enabled = false)
    public void testClickOnLink(){

        getInItElement();
        eTradeHomePage.doClickOnLink();
        eTradeHomePage.validateClickOnLink();
    }
    @Test(enabled = false)
    public void testUrl(){

        getInItElement();
        eTradeHomePage.doClickOnLink();
        eTradeHomePage.validateUrl();



    }
    @Test(enabled = false)
    public void testTitle(){

        getInItElement();
        eTradeHomePage.mouseHooverOnAccountTypesMenu();
        eTradeHomePage.clickOnAccountTypesLink();
    }
    @Test
    public void testPageUrl(){
        getInItElement();
        eTradeHomePage.doClickOnOpenAnAccountButton();
        eTradeHomePage.validatePageUrl();
    }



}
