package steps;

import pages.InsurTravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurTravelPageSteps extends BaseStep{

    @Step("Нажали на кнопку Оформить онлайн")
    public void stepSendIssue(){
        new InsurTravelPage(driver).issue();
    }

    @Step("Выбрали сумму страховой защиты")
    public void stepSelectRecomInsur(String menuItem) throws InterruptedException {
        new InsurTravelPage(driver).selectRecomInsur(menuItem);
    }

    @Step("Нажали кнопку Оформить")
    public void stepIssueDoc(){
        new InsurTravelPage(driver).issueDoc();
    }

}
