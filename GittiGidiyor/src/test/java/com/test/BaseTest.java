package com.test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BaseTest {
    protected static WebDriver driver;
    public WebElement element(By Locator){
        return driver.findElement(Locator);
    }
    @BeforeClass
    public static void before(){
    	//driver location; .exe for windows, without extension for macos
        System.setProperty("webdriver.chrome.driver", "/Users/Frichtone/Desktop/GittiGidiyor/chromedriver");
        driver=new ChromeDriver();
    }
    @AfterClass
    public static void after() throws InterruptedException{
        Thread.sleep(2000);
    }

    public WebDriver getDriver(){
        return driver;
    }
}