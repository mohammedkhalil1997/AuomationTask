package page;

import base.TaskTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OwnerInformationPage extends TaskTestBase {
    public OwnerInformationPage()
    {
        PageFactory.initElements(driver,this);

    }
    String expectedUrl="https://petclincqpros.herokuapp.com/owners/11";
    @FindBy(xpath = "//h2[text()='Owner Information']")
    WebElement ownerInformationLabel;
    @FindBy(xpath = "//a[text()='Add\n" +
            "      New Pet']")
    WebElement addNewPetButton;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[1]/td/b")
    WebElement actualName;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[2]/td")
    WebElement actualAddress;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[3]/td")
    WebElement actualCity;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[4]/td")
    WebElement actualTelephone;
    @FindBy(xpath = "/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]")
    WebElement actualPetName;
    @FindBy(xpath = "/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[2]")
    WebElement actualPetDate;
    @FindBy(xpath ="//td")
    List<WebElement> webElements;

    public PetsPage goToAddPets()
    {
        addNewPetButton.click();
    return new PetsPage();
    }
    public void assertAddOwner()
    {
       Assert.assertTrue(ownerInformationLabel.isDisplayed());
        Assert.assertEquals(actualName.getText(),checkFullName);
        System.out.println(checkFullName);

        Assert.assertEquals(webElements.get(1).getText(),checkAddress);
        System.out.println(checkAddress);

        Assert.assertEquals(webElements.get(2).getText(),checkCity);
        System.out.println(checkCity);

        Assert.assertEquals(webElements.get(3).getText(),checkPhone);
        System.out.println(checkPhone);
        Assert.assertEquals(actualPetName.getText(),checkPetName);
        System.out.println(checkPetName);

        Assert.assertEquals(actualPetDate.getText(),checkPetBirthDate);
        System.out.println(checkPetBirthDate);
    }

}
