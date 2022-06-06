package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TGApplicationPage {

    public TGApplicationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='comp-kh9s3kyz3']//span/span")
    public WebElement heading1;

    @FindBy(xpath = "//ul[@class = 'ctas']/li[1]")
    List<WebElement> cards;


    public void clickOnCars(String cardText){
        for (WebElement element : cards){
            if (element.getText().equals(cardText)){
                element.click();
                break;
            }
        }
    }
    }



