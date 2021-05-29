import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InsurTravelPage;
import pages.MainPage;
import pages.SendAppPage;

public class TaskWork2 extends BaseTest {

    @Test
    public void newInsuranceTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Перейти в каталог");
        mainPage.selectFiltreMenu("Путешествия");
        mainPage.selectProgrammInsurance("Страхование для путешественников");

        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        Assert.assertEquals("Страхование путешественников" , title.getText());

        InsurTravelPage travel = new InsurTravelPage(driver);
        travel.issue();
        travel.selectRecomInsur("Минимальная");
        travel.issueDoc();


        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия / Surname" , "Петров");
        sendAppPage.fillField("Имя / Name","Вася");
        sendAppPage.fillField("Дата рождения","11092000");


        sendAppPage.fillField("Фамилия страхователя","Сидоров");
        sendAppPage.fillField("Имя страхователя","Игнат");
        sendAppPage.fillField("Отчество страхователя","Константинович");
        sendAppPage.fillField("Дата рождения страхователя","11091980");

        sendAppPage.selectSex("Женский");

        sendAppPage.fillField("Серия паспорта","2233");
        sendAppPage.fillField("Номер паспорта","454545");
        sendAppPage.fillField("Дата выдачи","11092000");
        sendAppPage.fillField("Кем выдан","Москва");

    }
}