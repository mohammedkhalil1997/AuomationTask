package base;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaskTestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static Faker faker = new Faker(new Random());
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static String getFName;
    public static String getLname;

    public static String checkFullName;
    public static String checkAddress;
    public static String checkCity;
    public static String checkPhone;
    public static String checkPetName;
    public static String checkPetBirthDate;
    public static String checkPetType;


    public void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://petclincqpros.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

}
