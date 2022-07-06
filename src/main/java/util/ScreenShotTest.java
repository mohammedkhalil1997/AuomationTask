package util;

import base.TaskTestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotTest extends TaskTestBase {
    public static void takePicture(String name) throws IOException
    {
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("src/test/ReportResult/"+name+".png"));
    }
}
