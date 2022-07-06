package page;

import base.TaskTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class PetsPage extends TaskTestBase {
    public PetsPage()
    {
        PageFactory.initElements(driver,this);

    }
    String expectedIsRequiredMsg="is required";

    @FindBy(id="name")
    WebElement petsName;
    @FindBy(id="birthDate")
    WebElement petBirthDate;
    @FindBy(id="type")
    WebElement typeList;
    @FindBy(xpath = "//button[text()='Add Pet']")
    WebElement addPetButton;
    @FindBy(xpath = "//span[text()='is required']")
    WebElement isRequiredErrorMsg;
    @FindBy(xpath = "//h2[text()='\n" +
            "    New \n" +
            "    Pet\n" +
            "  ']")
    WebElement newPetLabel;
    public void checkFromNamePetsEmpty()
    {
    petsName.sendKeys(faker.name().firstName());
    addPetButton.click();
        Assert.assertEquals(isRequiredErrorMsg.getText(),expectedIsRequiredMsg);
    }
    public void checkFromBirthDateEmpty()
    {
        petBirthDate.sendKeys("1997-01-01");
        addPetButton.click();
        Assert.assertEquals(isRequiredErrorMsg.getText(),expectedIsRequiredMsg);
    }
    public void checkFromBirthDateWrongFormat()
    {
        petsName.sendKeys(faker.name().firstName());
        petBirthDate.sendKeys("1997-1-1");
        addPetButton.click();
        Assert.assertTrue(newPetLabel.isDisplayed());

    }
    public void addPets() throws InterruptedException {
        checkPetName = faker.name().firstName();
        petsName.sendKeys(checkPetName);
        checkPetBirthDate = "1997-01-01";
        petBirthDate.sendKeys(checkPetBirthDate);
        Select dropdown = new Select(driver.findElement(By.id("type")));
        List<WebElement> dd = dropdown.getOptions();
        int index = 0;
        if (dd.size() > 1) {
            Random rand = new Random();
            index = rand.nextInt(dd.size() - 1);
        }
        if (index >= 0) {
            dropdown.selectByIndex(index);

        }
        Thread.sleep(2000);

    }}
