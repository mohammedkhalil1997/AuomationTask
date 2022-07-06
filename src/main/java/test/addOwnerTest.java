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

public class addOwnerTest extends TaskTestBase {
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

    @Test (priority = 8)
    public void checkFromAddNewOwnerUrl()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
    }
    @Test(priority = 9)
    public void checkFromEmptyFnameMsg()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.emptyFirstName();
    }

    @Test(priority = 10)
    public void checkFromEmptyLnameMsg()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.emptyLastName();
    }
    @Test (priority = 11)
    public void checkFromEmptyAddressMsg()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.emptyAddress();
    }
    @Test(priority = 12)
    public void checkFromEmptyCityMsg()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.emptyCity();
    }

    @Test(priority = 13)
    public void checkFromEmptyPhone()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.telephoneMoreThan10Number();
    }
    @Test(priority = 14)
    public void checkErrorMsgWhenString()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.numericErrorMsgWhenString();
    }
    @Test(priority = 15)
    public void checkErrorMsgWhenSymbol()
    {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        addOwnerPage.numericErrorMsgWhenSymbol();
    }
    @Test(priority = 16)
    public void checkIfAddNewOwner() throws InterruptedException {
        ownerPage= homePage.goToOwner();
        addOwnerPage=ownerPage.goToAddOwner();
        ownerInformationPage=addOwnerPage.addOwner();
        petsPage=ownerInformationPage.goToAddPets();
        petsPage.addPets();
        ownerInformationPage.assertAddOwner();
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
