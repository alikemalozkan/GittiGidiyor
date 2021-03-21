package com.gittigidiyor.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;


public class SearchPage extends BasePage{

    //input
    @FindBy(xpath = "//INPUT[@type='text']")
    private WebElement searchInput;

    //button
    @FindBy(xpath = "//BUTTON[@data-cy='search-find-button']")
    private WebElement searchButton;

    //price
    @FindBy(xpath = "//SPAN[@id='sp-price-highPrice']")
    private WebElement price;

    
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //fill the box
    public void enterData(String input) {
        this.searchInput.clear();
        this.searchInput.sendKeys(input);
    }

    //click search
    public void submit() {
        searchButton.click();
    }

    //click item
    public void clickItem(){

        WebElement ele = driver.findElement(By.xpath("(//DIV[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 product-title-info'])["+returnRandom()+"]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    //second page
    public void secondPage(){
        WebElement ele = driver.findElement(By.xpath("//A[@href='/arama/?k=bilgisayar&sf=2'][text()='2']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    //add to basket
    public void addToBasket(){
        WebElement ele = driver.findElement(By.xpath("//BUTTON[@id='add-to-basket']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    //price in page
    public String getSearchPrice(){
        return price.getText();
    }

    //random
    public String returnRandom(){
        Random random = new Random();
        final int i = random.nextInt(30) + 1;
        return String.valueOf(i);
    }


}