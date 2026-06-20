package com.Assignment;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Assignment_11 {

    WebDriver driver;

    @BeforeTest
    public void Setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hollandandbarrett.com/");
    }

    @Test
    public void Test() throws Exception {

        

    	driver.findElement(By.id("username")).sendKeys("username");

        driver.findElement(By.id("password")).sendKeys("9889488932");

        driver.findElement(By.name("action")).click();

        driver.findElement(By.xpath("//button[@class='MyHBNewLoyalty-module_container__XtY9q']"))
                .click();
        
        driver.findElement(By.xpath("//button[@class='MyHBNewLoyalty-module_container__XtY9q']\"))\r\n")).click();

        // Intentionally fail
        Assert.assertEquals("Ankita", "Rout");
    }

    @AfterMethod
    public void ScreenShotOnFailure(ITestResult result)
            throws Exception {

        if(result.getStatus() == ITestResult.FAILURE) {

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File src =
                    ts.getScreenshotAs(OutputType.FILE);

            File des =
                    new File("./FailureScreenshots/Chrome_"
                            + System.currentTimeMillis()
                            + ".png");

            FileUtils.copyFile(src, des);

            System.out.println("Failure Screenshot Captured");
        }
    }

    @AfterTest
    public void TearDown() {

        driver.quit();
    }
}