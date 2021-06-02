package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurTravelPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'online-card-program')]")
    WebElement recomInsur;

    @FindBy(xpath = "//div[contains(@class,'page-teaser-dict__button')]//span[text()='Оформить онлайн']")
    WebElement issueButton;

    @FindBy(xpath = "//div[contains(@class,'col-12 centered-col')]//button[text()='Оформить']")
    WebElement issueDocButton;


    public InsurTravelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void issue() {
        issueButton.click();
    }

    public void  selectRecomInsur(String menuItem) throws InterruptedException {
        recomInsur.findElement(By.xpath(".//h3[text()='"+menuItem+"']")).click();
        Thread.sleep(1000);
    }

    public void issueDoc()  {
        issueDocButton.click();
    }

}
