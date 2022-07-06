package page;

import base.TaskTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.List;

public class VeterinariansPage extends TaskTestBase {
    public VeterinariansPage()
    {
        PageFactory.initElements(driver,this);

    }
    String expectedUrl="https://petclincqpros.herokuapp.com/vets.html";

    public void checkFromUrl()
    {

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"wrong current url ");
    }
    public void printAllData()
    {
        List <WebElement> col=driver.findElements(By.xpath("//*[@id='vets']/thead/tr/th"));
        List <WebElement> row=driver.findElements(By.xpath("//*[@id='vets']/tbody/tr/td"));

        System.out.println("Number of column :"+col.size());
        System.out.println("Number of Row :"+row.size());
        System.out.println("Veterinarians Data");
        for (int x=0;x<col.size();x++)
        {
            System.out.println(col.get(x).getText());
        }
        for (int i=0;i< row.size();i++)
        {
            System.out.println(row.get(i).getText());
        }
        Assert.assertEquals(col.size(),2,"wrong number of column");
        Assert.assertEquals(row.size(),12,"wrong number of column");
    }
}
