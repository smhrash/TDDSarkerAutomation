package homePageTest;

import commonAPI.WebAPI;
import homePage.AmazonHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHomePageTest extends WebAPI {

    static AmazonHomePage amazonHomePage;

    public static void getInItElements(){
        amazonHomePage = PageFactory.initElements(driver,AmazonHomePage.class);


    }
    @Test(enabled = false)
    public static void testSearch(){
        getInItElements();
        amazonHomePage.doSearch();
        amazonHomePage.validateSearchText();

    }
    @Test(enabled = false)
    public static void testLinkNum(){
        getInItElements();
        int actualLinkNum= amazonHomePage.validateLinkNum();
        Assert.assertEquals(actualLinkNum,34);
    }
    @Test(enabled = false)
    public static void testTryPrimePageUrl() {
        getInItElements();
        String actualUrl=amazonHomePage.validateTryPrimePageUrl();
        String expectedUrl= "https://www.amazon.com/amazonprime?_encoding=UTF8&ref_=nav_prime_try_btn";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test (enabled = false)
    public static void testPageTitle(){
        getInItElements();
        String actualTitle=amazonHomePage.validateTitle();
        String expectedTitle= "Amazon Sign-In";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public static void testListNum(){
        getInItElements();
        int actualLinkNum= amazonHomePage.validateListNum();
        Assert.assertEquals(actualLinkNum,20);
    }

}
