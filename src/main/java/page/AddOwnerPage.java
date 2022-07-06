package page;

import base.TaskTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddOwnerPage extends TaskTestBase {
    public AddOwnerPage()
    {
        PageFactory.initElements(driver,this);

    }
    String expectedUrl="https://petclincqpros.herokuapp.com/owners/new";
    String expectedEmptyMsg="must not be empty";
    String expectedErrorNumericMsg="numeric value out of bounds (<10 digits>.<0 digits> expected)";
    String phoneLength;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id="lastName")
    WebElement lastName;
    @FindBy(id="address")
    WebElement address;
    @FindBy(id="city")
    WebElement city;
    @FindBy(id="telephone")
    WebElement telephone;
    @FindBy(xpath = "//button[text()='Add Owner']")
    WebElement submitAddOwner;
    @FindBy(xpath = "//span[text()='must not be empty']")
    WebElement emptyErrorMsg;
    @FindBy(xpath = "//span[text()='numeric value out of bounds (<10 digits>.<0 digits> expected)']")
    WebElement numericErrorMsg;
    @FindBy(xpath = "//span[text()='[must not be empty\n" +
            "numeric value out of bounds (<10 digits>.<0 digits> expected)]']")
    WebElement numericErrorMsgWhenEmpty;
    //*[@id="add-owner-form"]/div[1]/div[5]/div/span[2]/text()[2]
    public void emptyFirstName()
    {
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        telephone.sendKeys(faker.phoneNumber().cellPhone());
        submitAddOwner.click();
        Assert.assertTrue(emptyErrorMsg.isDisplayed());
        Assert.assertEquals(emptyErrorMsg.getText(),expectedEmptyMsg);

    }
    public void emptyLastName()
    {
        firstName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        telephone.sendKeys(faker.phoneNumber().cellPhone());
        submitAddOwner.click();
        Assert.assertTrue(emptyErrorMsg.isDisplayed());
        Assert.assertEquals(emptyErrorMsg.getText(),expectedEmptyMsg);
    }
    public void emptyAddress()
    {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        city.sendKeys(faker.address().city());
        telephone.sendKeys(faker.phoneNumber().cellPhone());
        submitAddOwner.click();
        Assert.assertTrue(emptyErrorMsg.isDisplayed());
        Assert.assertEquals(emptyErrorMsg.getText(),expectedEmptyMsg);
    }
    public void emptyCity()
    {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        telephone.sendKeys(faker.phoneNumber().cellPhone());
        submitAddOwner.click();
        Assert.assertTrue(emptyErrorMsg.isDisplayed());
        Assert.assertEquals(emptyErrorMsg.getText(),expectedEmptyMsg);
    }
    public void telephoneMoreThan10Number()
    {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        telephone.sendKeys("0123564789587");
        submitAddOwner.click();
        Assert.assertEquals(numericErrorMsg.getText(),expectedErrorNumericMsg);
    }
    public void numericErrorMsgWhenString()
    {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        telephone.sendKeys("dfsf");
        submitAddOwner.click();
        Assert.assertEquals(numericErrorMsg.getText(),expectedErrorNumericMsg);
    }
    public void numericErrorMsgWhenSymbol()
    {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        telephone.sendKeys("/*/*");
        submitAddOwner.click();
        Assert.assertEquals(numericErrorMsg.getText(),expectedErrorNumericMsg);
    }
    public OwnerInformationPage addOwner()
    {
        getFName=faker.name().firstName();
        firstName.sendKeys(getFName);
        getLname=faker.name().lastName();
        lastName.sendKeys(getLname);
        checkFullName=getFName+" "+getLname;
        checkAddress=faker.address().fullAddress();
        address.sendKeys(checkAddress);
        checkCity=faker.address().city();
        city.sendKeys(checkCity);
      phoneLength=  faker.phoneNumber().cellPhone().replaceAll("-", "").replaceAll("\\.", "").replaceAll("[()]", "").replaceAll(" ", "");
       if(phoneLength.length()<=10 )
           telephone.sendKeys(phoneLength);
        else
       {
        phoneLength="1547854785";
        telephone.sendKeys(phoneLength);
       }
       checkPhone=phoneLength;
        submitAddOwner.click();
    return new OwnerInformationPage();
    }
    public void checkFromUrl()
    {
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"wrong Url");
    }


}
