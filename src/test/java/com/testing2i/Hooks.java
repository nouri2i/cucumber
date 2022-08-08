package com.testing2i;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    @Before
    public void anotherSetup(){
        System.out.println("another before");
    }
    @Before()
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }
    @After()
    public void TearDown(){
        driver.quit();
    }
}
