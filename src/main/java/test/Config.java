package test;

import base.TaskTestBase;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Config extends TaskTestBase {
    @BeforeSuite
    public void start() {

        extent=new ExtentReports("src/test/ReportResult/Test_Report.html", true);
        extent.addSystemInfo("OS", "Windows");
        extent.addSystemInfo("Owner", "Mohammed Alborine");
        extent.addSystemInfo("Test Name", "task Test");
        extent.addSystemInfo("OS", "Windows");
        extent.addSystemInfo("Language", "Java");

    }

    @AfterSuite
    public void end() {
        extent.flush();
    }
}
