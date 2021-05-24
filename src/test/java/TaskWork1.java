import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TaskWork1 {
    WebDriver driver;
    String baseUrl;


    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void TaskWork1() throws InterruptedException {
        driver.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]//a[contains(@aria-label,'Страхование')]")).click();
        driver.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item')]//a[contains(text(),'Перейти в каталог')]")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Путешествия')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'uc-full__block uc-full__block_header')]//h3[contains(text(),'Страхование для путешественников')]")).click();

        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        Assert.assertEquals("Страхование путешественников" , title.getText());

        driver.findElement(By.xpath("//div[contains(@class,'page-teaser-dict__button')]//span[text()='Оформить онлайн']")).click();

        driver.findElement(By.xpath("//h3[text()='Минимальная']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class,'col-12 centered-col')]//button[text()='Оформить']")).click();

        fill(By.xpath("//input[contains(@placeholder,'Фамилия / Surname') ]"),"Караев");
        fill(By.xpath("//input[contains(@placeholder,'Имя / Name') ]"),"Иван");
        fill(By.xpath("//div[contains(@class,'col-md-3 col-sm-6 col-12 col-md-4')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]"),"10101989");

        driver.findElement(By.xpath("//label[text() = 'гражданин РФ']")).click();

        fill(By.xpath("//input[contains(@id,'person_lastName') ]"),"Петров");
        fill(By.xpath("//input[contains(@id,'person_firstName') ]"),"Семен");
        fill(By.xpath("//input[contains(@id,'person_middleName') ]"),"Васильевич");
        fill(By.xpath("//div[contains(@class,'col-md-6 col-12')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]"),"11091980");


        driver.findElement(By.xpath("//legend[contains(text(),'Паспортные данные')]")).click();
        driver.findElement(By.xpath("//label[contains(@class,'active')][text() = 'Мужской']")).click();


        fill(By.xpath("//input[contains(@id,'passportSeries')]"),"6116");
        fill(By.xpath("//input[contains(@id,'passportNumber')]"),"321123");
        fill(By.xpath("//*[@title = 'Дата выдачи']//input[contains(@placeholder,'дд.мм.гггг') ]"),"11092000");

        driver.findElement(By.xpath("//div[contains(@class ,'form-group form-group_label-fill')]//*[contains(text(),'Кем выдан')]")).click();
        fill(By.xpath("//input[contains(@id,'documentIssue')]"),"УВД Москвы");


        Assert.assertEquals("Караев" ,driver.findElement(By.xpath("//input[contains(@placeholder,'Фамилия / Surname') ]")).getAttribute("value"));
        Assert.assertEquals("Иван" , driver.findElement(By.xpath("//input[contains(@placeholder,'Имя / Name') ]")).getAttribute("value"));
        Assert.assertEquals("10.10.1989", driver.findElement(By.xpath("//div[contains(@class,'col-md-3 col-sm-6 col-12 col-md-4')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]")).getAttribute("value"));


        Assert.assertEquals("Петров" , driver.findElement(By.xpath("//input[contains(@id,'person_lastName') ]")).getAttribute("value"));
        Assert.assertEquals("Семен" , driver.findElement(By.xpath("//input[contains(@id,'person_firstName') ]")).getAttribute("value"));
        Assert.assertEquals("Васильевич", driver.findElement(By.xpath("//input[contains(@id,'person_middleName') ]")).getAttribute("value"));
        Assert.assertEquals("11.09.1980", driver.findElement(By.xpath("//div[contains(@class,'col-md-6 col-12')]//*[@title = 'Дата рождения']//input[contains(@placeholder,'дд.мм.гггг') ]")).getAttribute("value"));


        Assert.assertEquals("6116" , driver.findElement(By.xpath("//input[contains(@id,'passportSeries')]")).getAttribute("value"));
        Assert.assertEquals("321123", driver.findElement(By.xpath("//input[contains(@id,'passportNumber')]")).getAttribute("value"));
        Assert.assertEquals("11.09.2000", driver.findElement(By.xpath("//*[@title = 'Дата выдачи']//input[contains(@placeholder,'дд.мм.гггг')]")).getAttribute("value"));
        Assert.assertEquals("УВД Москвы", driver.findElement(By.xpath("//input[contains(@id,'documentIssue')]")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary page__btn')]")).click();

        Assert.assertEquals("При заполнении данных произошла ошибка",driver.findElement(By.xpath("//div[contains(@role,'alert-form')]")).getText());
        Assert.assertEquals("Поле не заполнено.",driver.findElement(By.xpath("//*[@title = 'Повтор электронной почты']//span[contains(@class,'invalid-validate form-control__message')]")).getText());

    }

    public void fill(By locator , String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void after(){
        driver.quit();
    }
}
