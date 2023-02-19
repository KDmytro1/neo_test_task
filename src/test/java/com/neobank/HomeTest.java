package com.neobank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class HomeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.get("https://web.neobank.one/");
    }

    @Test
    public void isCorrectPageOpened() {
        assertEquals("https://web.neobank.one/", driver.getCurrentUrl());
    }

    @Test
    public void checkName() {
        // Open the NeoBank page
        driver.get("https://web.neobank.one/");
        // Verify the page title
        String expectedTitle = "NEOBANK для бізнесу";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void enterNumber() {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        // Enter the phone number
        homePage.enterPhoneNumber("636901699");
    }

    @Test
    public void clickContinue() {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        // Enter the phone number
        homePage.enterPhoneNumber("636901699");
        // Click the continue button
        homePage.clickContinueButton();
    }

    @Test
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void checkText() {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        homePage.enterPhoneNumber("636901698");
        homePage.clickContinueButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formAuthQr")));
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Відкриття бізнес-рахунку можливе тільки через NEOBANK для бізнесу')]"));
        // Check if the text is present
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void closePage() {
        driver.quit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
