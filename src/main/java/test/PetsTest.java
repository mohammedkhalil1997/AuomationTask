package test;

import base.TaskTestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import util.ScreenShotTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class PetsTest extends TaskTestBase {

    HomePage homePage;
    OwnerPage ownerPage;
    AddOwnerPage addOwnerPage;
    OwnerInformationPage ownerInformationPage;
    PetsPage petsPage;
    @BeforeMethod
    public void setup(Method method) throws IOException {
        logger = extent.startTest(method.getName());
        initialization();
        homePage=new HomePage();

    }
    @Test(priority = 17)
    public void checkFromEmptyPetsName()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        ownerInformationPage=addOwnerPage.addOwner();
        petsPage=ownerInformationPage.goToAddPets();
        petsPage.checkFromNamePetsEmpty();
    }

    @Test(priority = 18)
    public void checkFromEmptyBirthDate()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        ownerInformationPage=addOwnerPage.addOwner();
        petsPage=ownerInformationPage.goToAddPets();
        petsPage.checkFromBirthDateEmpty();
    }
@Test(priority = 19)
public void checkBirthDateWrongFormat()
{
    ownerPage= homePage.goToOwner();
    addOwnerPage=ownerPage.goToAddOwner();
    ownerInformationPage=addOwnerPage.addOwner();
    petsPage=ownerInformationPage.goToAddPets();
    petsPage.checkFromBirthDateWrongFormat();
}





    @AfterMethod
    public void end(ITestResult result, Method method) throws InterruptedException, IOException {
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
