package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//nav[contains(@class,'top-menu_wide')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li[contains(@class,'item_opened')]//div[contains(@class,'dropdown_icons')]")
    WebElement subMenuInsurance;

    @FindBy(xpath = "//div[contains(@aria-label,'Фильтрация карт')]")
    WebElement filtreMenu;

    @FindBy(xpath = "//div[contains(@class,'uc-form__wrapper-full_no-grouping')]")
    WebElement programmInsurance;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[text()='"+menuItem+"']")).click();
    }

    public void selectSubMenu(String menuItem) throws InterruptedException {
        subMenuInsurance.findElement(By.xpath(".//a[text()='"+menuItem+"']")).click();
        Thread.sleep(1000);
    }

    public void selectFiltreMenu(String menuItem){
        filtreMenu.findElement(By.xpath(".//label[text()='"+menuItem+"']")).click();
    }

    public void selectProgrammInsurance(String menuItem) throws InterruptedException {
        programmInsurance.findElement(By.xpath(".//h3[text()='"+menuItem+"']")).click();
        Thread.sleep(1000);
    }

}
