package test;

import base.TaskTestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import util.ScreenShotTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomeTest extends TaskTestBase {
    HomePage homePage;
    @BeforeMethod
    public void setup(Method method) throws IOException {
        logger = extent.startTest(method.getName());
        initialization();
        homePage=new HomePage();
    }
    @Test(priority = 1)
    public void checkFromHomePageUrl()
    {
        homePage.checkFromUrl();
    }

    @Test (priority = 2)
    public void checkFromPetsImage()
    {
        homePage.checkFromPetsImage();
    }
    @Test (priority = 3)
    public void checkFromQualityImage()
    {
        homePage.checkFromQualityImage();
    }
    @AfterMethod
    public void end(ITestResult result, Method method) throws InterruptedException, IOException{
        ScreenShotTest.takePicture(method.getName());
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test pass");
            logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png"
                    + "'><span class='lable info'>Download ScreenShot</span></a>");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png"
                    + "'><span class='lable info'>Download ScreenShot</span></a>");

        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Skipped");
        }
        driver.quit();

    }
}
