package scripts;

import org.testng.annotations.Test;
import utilities.Waiters;

public class _08_GoogleResultsTest extends Base{

    @Test
    public void testGoogleResults(){
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("books");
        googleSearchPage.googleSearchButton.click();
        String resultTag = googleSearchResultPage.resultTag.getText();
        resultTag = resultTag.replaceAll("[\\D]", "");
        System.out.println(resultTag.substring(0, resultTag.length()-3));

    }
}
