import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseStep;
import steps.InsurTravelPageSteps;
import steps.MainSteps;
import steps.SenAppPageSteps;

import java.util.HashMap;

public class TaskWork3 extends BaseStep {

    @Test
    @Title("Страхование")
    public void testInsur() throws InterruptedException {
        MainSteps mainSteps = new MainSteps();
        InsurTravelPageSteps insurTravelPageSteps = new InsurTravelPageSteps();
        SenAppPageSteps senAppPageSteps = new SenAppPageSteps();

        HashMap<String,String> testData = new HashMap<>();
        testData.put("Фамилия / Surname" , "Петров");
        testData.put("Имя / Name","Вася");
        testData.put("Дата рождения","11.09.2000");
        testData.put("Фамилия страхователя","Сидоров");
        testData.put("Имя страхователя","Игнат");
        testData.put("Отчество страхователя","Константинович");
        testData.put("Дата рождения страхователя","11.09.1980");

        testData.put("Серия паспорта","2233");
        testData.put("Номер паспорта","454545");
        testData.put("Дата выдачи","11.09.2000");
        testData.put("Кем выдан","Москва");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Все страховые программы");
        mainSteps.stepSelectFiltreMenu("Путешествия");
        mainSteps.stepSelectProgrammInsurance("Страхование для путешественников");

        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        Assert.assertEquals("Страхование путешественников" , title.getText());

        insurTravelPageSteps.stepSendIssue();
        insurTravelPageSteps.stepSelectRecomInsur("Минимальная");
        insurTravelPageSteps.stepIssueDoc();

        senAppPageSteps.stepFillFields(testData);
        senAppPageSteps.checkFillFields(testData);
        senAppPageSteps.stepClickButton();
        senAppPageSteps.stepGetMistake();
        senAppPageSteps.stepGetMistake();
    }
}
