package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

public class _07_DropdownTest extends Base{
    /*
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    Validate below error message is displayed with expected text
    Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.
     */

    @Test(priority = 1, description = "TC763: Validate FaceBook sign in error message for password")
    public void testUnsecurePasswordErrorMessage(){
        driver.get("https://www.facebook.com/");

        faceBookPage.createNewAccountLink.click();

        faceBookPage.firstNameInputBox.sendKeys("John");
        faceBookPage.lastNameInputBox.sendKeys("Doe");
        faceBookPage.emailOrPhoneInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.emailReEnterInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.passwordInputBox.sendKeys("abcd1234");

        //In order to be able to select an option we need an instance of the Select class
        Select monthSelector = new Select(faceBookPage.monthDropdown);
        monthSelector.selectByValue("4");
        //monthSelector.selectByVisibleText("Apr");
        //monthSelector.selectByIndex(3); //index starts at 0

        Select daySelector = new Select(faceBookPage.dayDropdown);
        daySelector.selectByValue("1");
        //daySelector.selectByVisibleText("1");

        Select yearSelector = new Select(faceBookPage.yearDropdown);
        yearSelector.selectByVisibleText("1990");

        faceBookPage.genderRadioButtons.get(1).click();
        faceBookPage.signUpButton.click();

        String expectedMessage = "Please choose a more secure password. " +
                "It should be longer than 6 characters, unique to you, and difficult for others to guess.";

        new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(faceBookPage.errorMessage, expectedMessage));

        Assert.assertEquals(faceBookPage.errorMessage.getText(), expectedMessage, "Error message hae issues!!!");
    }

}
