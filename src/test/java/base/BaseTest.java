package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    public Properties properties;
    public Properties dataProperties;

    public void loadPropertiesFiles() {

        properties = new Properties();

        dataProperties = new Properties();

        File propFiles = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config.properties");
        try {
            FileInputStream fis = new FileInputStream(propFiles);
            properties.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        File dataPropFiles = new File(System.getProperty("user.dir") + "\\src\\main\\java\\testdata.properties");
        try {
            FileInputStream dataFis = new FileInputStream(dataPropFiles);
            dataProperties.load(dataFis);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName, String sizeResolution) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }


        if (sizeResolution.equalsIgnoreCase("full-screen")) {
            driver.manage().window().maximize();
        } else if (sizeResolution.equalsIgnoreCase("1920x1080")) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else if (sizeResolution.equalsIgnoreCase("768x1024")) {
            driver.manage().window().setSize(new Dimension(768, 1024));
        } else if (sizeResolution.equalsIgnoreCase("1024x768")) {
            driver.manage().window().setSize(new Dimension(1024, 768));
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));

        driver.get(properties.getProperty("AUT_URL"));

        return driver;
    }
}
