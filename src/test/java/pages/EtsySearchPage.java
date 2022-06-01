package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsySearchPage {

    public EtsySearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-id='gnav-search-submit-button']")
    public WebElement searchButton;

    @FindBy(id = "logo")
    public WebElement logo;

    @FindBy(css = ".wt-display-inline-flex-sm>span")
    public WebElement resultTag;

    @FindBy(css = "ul[data-ui='top-nav-category-list'] span")
    public List<WebElement> mainHeaderLinks;
}