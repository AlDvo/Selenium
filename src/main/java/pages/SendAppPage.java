package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//input[contains(@placeholder,'Фамилия / Surname') ]")
    WebElement surName;

    @FindBy(xpath = "//input[contains(@placeholder,'Имя / Name') ]")
    WebElement name;

    @FindBy(xpath = "//div[contains(@class,'col-md-3 col-sm-6 col-12 col-md-4')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]")
    WebElement date;

    @FindBy(xpath = "//input[contains(@id,'person_lastName') ]")
    WebElement person_lastName;

    @FindBy(xpath = "//input[contains(@id,'person_firstName') ]")
    WebElement person_firstName;

    @FindBy(xpath = "//input[contains(@id,'person_middleName') ]")
    WebElement person_middleName;

    @FindBy(xpath = "//div[contains(@class,'col-md-6 col-12')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]")
    WebElement person_date;

    @FindBy(xpath = "//*[@title = 'Пол']//div[contains(@class,'form-control__container form-control__radio-button')]")
    WebElement sex;

    @FindBy(xpath = "//input[contains(@id,'passportSeries')]")
    WebElement passportSeries;

    @FindBy(xpath = "//input[contains(@id,'passportNumber')]")
    WebElement passportNumber;

    @FindBy(xpath = "//*[@title = 'Дата выдачи']//input[contains(@placeholder,'дд.мм.гггг') ]")
    WebElement passport_date;

    @FindBy(xpath = "//input[contains(@id,'documentIssue')]")
    WebElement documentIssue;

    @FindBy(xpath = "//div[contains(@role,'alert-form')]")
    WebElement alert_form;

    @FindBy(xpath = "//*[@title = 'Повтор электронной почты']//span[contains(@class,'invalid-validate form-control__message')]")
    WebElement invalid_validate;


    public SendAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия / Surname":
                fillField(surName, value);
                break;
            case  "Имя / Name":
                fillField(name, value);
                break;
            case  "Дата рождения":
                fillField(date , value);
                date.sendKeys(Keys.TAB);
                break;
            case  "Фамилия страхователя":
                fillField(person_lastName, value);
                break;
            case  "Имя страхователя":
                fillField(person_firstName, value);
                break;
            case  "Отчество страхователя":
                fillField(person_middleName, value);
                break;
            case  "Дата рождения страхователя":
                fillField(person_date, value);
                person_date.sendKeys(Keys.TAB);
                 break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Дата выдачи":
                fillField(passport_date, value);
                passport_date.sendKeys(Keys.TAB);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public void selectSex(String menuSex){
        sex.findElement(By.xpath(".//*[text() = '"+menuSex+"']")).click();
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия / Surname":
                return surName.getAttribute("value");
            case  "Имя / Name":
                return name.getAttribute("value");
            case  "Дата рождения":
                return date.getAttribute("value");
            case  "Фамилия страхователя":
                return person_lastName.getAttribute("value");
            case  "Имя страхователя":
                return person_firstName.getAttribute("value");
            case  "Отчество страхователя":
                return person_middleName.getAttribute("value");
            case  "Дата рождения страхователя":
                return person_date.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return passport_date.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void clickButton(){
        driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary page__btn')]")).click();
    }

    public String getMistake(String fieldName){
        switch (fieldName){
            case  "При заполнении данных произошла ошибка":
                return alert_form.getAttribute("value");
            case  "Поле не заполнено.":
                return invalid_validate.getAttribute("value");
        }
        throw new AssertionError("Не отобразилось сообщение об ошибке");
    }

}
