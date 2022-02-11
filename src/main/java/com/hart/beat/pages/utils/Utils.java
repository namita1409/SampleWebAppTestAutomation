package com.hart.beat.pages.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
    private static WebDriver driver;

    private Utils()
    {

    }

    public static WebDriver  getDriver()
    {
        if ( null == driver)
        {
            WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           // WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();

        }
        return driver;

    }
    public static void openBrowser(){
        Utils.getDriver();
       }

    public static void closeBrowser(){
        if(null != driver)
        driver.quit();
            }
}
