package paula.prueba.automation.utilities;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtilities {
	
	protected WebDriver driver;
    protected WebDriverWait wait;
    
    public static String URL_BASE = "https://www.ebay.com/";
    
    @BeforeEach
    public void init() throws MalformedURLException {
          selectPlatform();
    }
    
    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void navigateTo(String url){
        driver.get(url);
    }
    
    /**
     * Method that selected the requested platform.
     * 
     * @throws MalformedURLException
     */
    public void selectPlatform() throws MalformedURLException
    {
    	/*ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	options.addArguments("--headless");*/
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 60);
    }    
}


