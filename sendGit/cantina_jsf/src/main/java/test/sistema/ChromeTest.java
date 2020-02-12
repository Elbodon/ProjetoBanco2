package test.sistema;

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;


public class ChromeTest extends TestCase {

    private static ChromeDriverService service;
    private WebDriver driver;

    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File
                        ("C:\\Users\\IamGa\\Documents\\Backup\\Daniel\\2019.1\\PW1\\RepositorioPW\\RepositorioLuz\\Projeto\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAndStopService() {
        service.stop();
    }
    
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
    }
    
    public void quitDriver() {
        driver.quit();
    }

    public void testGoogleSearch() {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("webdriver");
        //searchBox.quit();
        assertEquals("webdriver - Google Search", driver.getTitle());
    }

}
