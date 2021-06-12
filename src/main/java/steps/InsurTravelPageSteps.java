package steps;

import pages.InsurTravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurTravelPageSteps{

    @Step("Нажали на кнопку Оформить онлайн")
    public void stepSendIssue() {
        new InsurTravelPage(BaseStep.getDriver()).issue();
    }

    @Step("Выбрали сумму страховой защиты")
    public void stepSelectRecomInsur(String menuItem) throws InterruptedException {
        new InsurTravelPage(BaseStep.getDriver()).selectRecomInsur(menuItem);
    }

    @Step("Нажали кнопку Оформить")
    public void stepIssueDoc() {
        new InsurTravelPage(BaseStep.getDriver()).issueDoc();
    }

}
