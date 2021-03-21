package com.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import com.gittigidiyor.pages.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCase extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TestCase.class);
    @Test

    //homepage
    public void test1HomePage(){
    	HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
        } catch (Exception e){
            logger.error("Hatalı başlık.");
        }

        logger.info("Homepage opened.");
    }
    
    //Login page
    private By login=By.cssSelector("div[class='gekhq4-3 icMLoL']:nth-child(1)");
    private By log=By.cssSelector("a[data-cy='header-login-button']");
    @Test
    public void test2LoginPage() throws InterruptedException {
        element(login).click();
        Thread.sleep(3000);
        element(log).click();
        logger.info("Login page opened.");
    }

    //login
    private By username=By.id("L-UserNameField");
    private By password=By.id("L-PasswordField");
    private By enter=By.id("gg-login-enter");
    @Test
    public void test3LoggedIn() throws InterruptedException {
        element(username).sendKeys("alivol");
        element(password).sendKeys("116568Ali");
        Thread.sleep(3000);
        element(enter).click();
        logger.info("Logged in.");
    }

    //search
    @Test
    public void test4Search() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterData("bilgisayar");
        searchPage.submit();
        searchPage.waitForPageLoad();
        searchPage.secondPage();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor - 2/"));
        logger.info("Second page opened.");

    }
    
    //add to basket
    @Test
    public void test5AddtoBasket() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickItem();
        searchPage.waitForPageLoad();
        Thread.sleep(5000);
        searchPage.addToBasket();
        logger.info("Product added to the basket.");

        String price = searchPage.getSearchPrice();
        logger.info("Price : "+price);
    }
    
    //price comparison
    private By sepet=By.cssSelector("a[class='gg-ui-btn-default padding-none']");
    @Test
    public void test6comparison() throws InterruptedException {
       String price=driver.findElement(By.cssSelector("span[id='sp-price-highPrice']")).getText();
       Thread.sleep(2000);
       element(sepet).click();
       Thread.sleep(2000);
       String sepetprice=driver.findElement(By.cssSelector("div[class='total-price']")).getText();
       Assert.assertEquals(price,sepetprice);
       logger.info("price checked");
    }
    
 
    
   


}