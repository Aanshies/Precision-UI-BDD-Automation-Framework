package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    
    public static void init() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(fis);

            String browser = prop.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {

                String edgePath = prop.getProperty("edgeDriverPath");

                if (edgePath != null && !edgePath.isEmpty()) {
                    System.setProperty("webdriver.edge.driver", edgePath);
                    driver = new EdgeDriver();
                    System.out.println("Edge launched using manual driver path");
                } else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    System.out.println("Edge launched using WebDriverManager");
                }
            }

            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        driver.quit();
    }
}