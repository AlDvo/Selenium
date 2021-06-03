package steps;

import pages.InsurTravelPage;
import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SenAppPageSteps extends BaseStep{

    @Step("Поле {0} заполняем значением {1}")
    public void stepFillField(String field , String value){
        new SendAppPage(driver).fillField(field,value);
    }

    @Step("заполняются поля: ")
    public void stepFillFields(HashMap<String , String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("Проверяем что поле {0} заполнено значением {1}")
    public void stepGetAttribute(String fieldName, String value){
        String actual = new SendAppPage(driver).getFillField(fieldName);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", fieldName, actual, value),
                actual.equals(value));
    }
    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> stepGetAttribute(k,v));
    }

    @Step("Нажали кнопку Оформить")
    public void stepClickButton(){
        new SendAppPage(driver).clickButton();
    }

    @Step("Проверка появления сообщения {0}")
    public void stepGetMistake(){
        new SendAppPage(driver).getMistake("При заполнении данных произошла ошибка");
        new SendAppPage(driver).getMistake("Поле не заполнено.");
    }



}
