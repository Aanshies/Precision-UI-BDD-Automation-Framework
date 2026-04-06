package com.veeva.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static Logger log = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public static Properties prop;

    public void initialization() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(fis);

            String browser = prop.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("Chrome browser launched");
            } else if (browser.equalsIgnoreCase("edge")) {

            	System.setProperty("webdriver.edge.driver", prop.getProperty("edgeDriverPath"));

                driver = new EdgeDriver();
                log.info("Edge browser launched (manual setup)");
            }

            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        driver.quit();
        log.info("Browser closed");
    }
}