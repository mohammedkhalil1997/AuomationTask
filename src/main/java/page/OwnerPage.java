package page;

import base.TaskTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OwnerPage extends TaskTestBase {
    public OwnerPage()
    {
        PageFactory.initElements(driver,this);
    }
    String expectedUrl="https://petclincqpros.herokuapp.com/owners/find";

    @FindBy(xpath = "//button[text()='Find\n" +
            "          Owner']")
    WebElement findOwnerButton;
    @FindBy(xpath = "//a[text()='Add Owner']")
    WebElement addOwnerButton;
    public void checkFromUrl()
{
    Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
}
public void checkFromOwnerData()
{
    findOwnerButton.click();
    List<WebElement> col=driver.findElements(By.xpath("//*[@id='owners']/thead/tr/th"));
    List <WebElement> row=driver.findElements(By.xpath("//*[@id='owners']/tbody/tr/td"));
    System.out.println("Number of column :"+col.size());
    System.out.println("Number of Row :"+row.size());
    System.out.println("Owner Data");
    for (int x=0;x<col.size();x++)
    {
        System.out.println(col.get(x).getText());
    }
    for (int i=0;i< row.size();i++)
    {
        System.out.println(row.get(i).getText());
    }
    Assert.assertEquals(col.size(),5,"wrong number of column");
    Assert.assertEquals(row.size(),row.size(),"wrong number Of Row");
}
    public AddOwnerPage goToAddOwner()
    {
        addOwnerButton.click();
        return new AddOwnerPage();
    }

}
