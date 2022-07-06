package test;

import base.TaskTestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.VeterinariansPage;
import util.ScreenShotTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class VeterinariansTest extends TaskTestBase {
    HomePage homePage;
    VeterinariansPage veterinariansPage;
    @BeforeMethod
    public void setup(Method method) throws IOException {
        logger = extent.startTest(method.getName());
        initialization();
       homePage=new HomePage();

    }

    @Test ( priority =4)
    public void checkFromVeterinariansUrl()
    {
        veterinariansPage= homePage.goToVeterinariansPage();
    }

    @Test (priority = 5)
    public void checkFromNumberOfColumnAndRow()
    {
        veterinariansPage= homePage.goToVeterinariansPage();
        veterinariansPage.printAllData();

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
