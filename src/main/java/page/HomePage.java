package page;

import base.TaskTestBase;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends TaskTestBase {
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    String expectedUrl="https://petclincqpros.herokuapp.com/";
    @FindBy(className = "img-responsive")
    WebElement petsImage;
    @FindBy(xpath = "//img[@src='/resources/images/spring-pivotal-logo.png']")
    WebElement qualityImg;
    @FindBy(xpath = "//span[text()='Veterinarians']")
    WebElement veterinariansButton;
    @FindBy(xpath = "//span[text()='Find owners']")
    WebElement ownerButton;
    public void checkFromUrl()
    {
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"the url does not correct");
    }

    public void checkFromPetsImage()
    {
        Assert.assertTrue(petsImage.isDisplayed(),"the pets image does not displayed");
    }
    public void checkFromQualityImage()
    {
        Assert.assertTrue(qualityImg.isDisplayed(),"the quality image dose not show");
    }
    public VeterinariansPage goToVeterinariansPage()
    {
        veterinariansButton.click();
        return new VeterinariansPage();
    }
    public OwnerPage goToOwner()
    {
        ownerButton.click();
        return  new OwnerPage();
    }
}
