package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

public class _06_RadioButtonTest extends Base{
    /*
    Go to https://www.facebook.com/
    Click on “Create New Account” link
    Validate “Female”, “Male” and “Custom” radio buttons are displayed, enabled and not selected
    Select “Female” and validate it is selected
    Select “Male” radio button and validate “Male” is selected and “Female” is deselected
     */

    @Test(priority = 1, description = "TC234: Validate Facebook gender radio buttons")
    public void testFacebookGenderRadioButtons(){
        driver.get("https://www.facebook.com/");
        Waiters.pause(2);

        faceBookPage.createNewAccountLink.click();
        Waiters.pause(2);

        for(WebElement element : faceBookPage.genderRadioButtons){
            Assert.assertTrue(element.isDisplayed(), "Element IS NOT displayed");
            Assert.assertTrue(element.isEnabled(), "Element IS NOT enabled");
            Assert.assertFalse(element.isSelected(), "Element IS selected");
        }

        faceBookPage.genderRadioButtons.get(0).click();
        Waiters.pause(2);
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(0).isSelected());

        faceBookPage.genderRadioButtons.get(1).click();
        Waiters.pause(2);
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(1).isSelected());
        Assert.assertFalse(faceBookPage.genderRadioButtons.get(0).isSelected());

    }
}