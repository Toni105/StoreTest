package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport() {

        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\extentReport.html");
        ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);

        spark.config().setTheme(Theme.STANDARD);
        spark.config().setReportName("Toni105 Store Test Results");
        spark.config().setDocumentTitle("Automation report");
        spark.config().setTimeStampFormat("hh:mm:ss  dd.mm.yyyy.");

        extentReport.attachReporter(spark);

        File propFiles = new File(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propFiles);
            properties.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        extentReport.setSystemInfo("Test created by", "Toni105");
        extentReport.setSystemInfo("Application URL", properties.getProperty("AUT_URL"));
        extentReport.setSystemInfo("Browser Name", properties.getProperty("browserName"));
        extentReport.setSystemInfo("Resolution", properties.getProperty("resolutionSize"));

        return extentReport;
    }
}
