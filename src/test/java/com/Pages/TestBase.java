package com.Pages;

import com.Utilities.ConfigurationReader;
import com.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    public HomePage homePage;
    public SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {

       driver= Driver.get();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get(ConfigurationReader.getProperty("url"));
       driver.switchTo().frame("result");
       driver.manage().window().maximize();
       homePage = new HomePage();
       softAssert = new SoftAssert();

   }

    @AfterMethod
    public void teardown() {
        Driver.close();
    }

}
