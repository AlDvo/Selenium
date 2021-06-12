package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import pages.MainPage;

public class ScenarioStep {

    MainSteps mainSteps = new MainSteps();
    InsurTravelPageSteps insurTravelPageSteps = new InsurTravelPageSteps();
    SenAppPageSteps senAppPageSteps = new SenAppPageSteps();

    @When("^выбран пункт основного меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^выбран фильтр страхования \"(.+)\"$")
    public void stepSelectFiltreMenu(String menuItem){
        mainSteps.stepSelectFiltreMenu(menuItem);
    }

    @When("^выбрана программа страхования \"(.+)\"$")
    public void stepSelectProgrammInsurance(String menuItem) throws InterruptedException {
        mainSteps.stepSelectProgrammInsurance(menuItem);
    }

    @When("^нажали на кнопку Оформить онлайн$")
    public void stepSendIssue() {
        insurTravelPageSteps.stepSendIssue();
    }

    @When("^выбрали сумму страховой защиты \"(.+)\"$")
    public void stepSelectRecomInsur(String menuItem) throws InterruptedException {
        insurTravelPageSteps.stepSelectRecomInsur(menuItem);
    }

    @When("^нажали кнопку Оформить и переходим к заполнению анкеты$")
    public void stepIssueDoc() {
        insurTravelPageSteps.stepIssueDoc();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class ,String.class).forEach( (key,value) ->senAppPageSteps.stepFillField(key,value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class ,String.class).forEach( (key,value) ->senAppPageSteps.stepGetAttribute(key,value));
    }

    @Then("^нажали кнопку Оформить , на странице заполнения анкеты$")
    public void stepClickButton(){
        senAppPageSteps.stepClickButton();
    }

    @Then("присутствует сообщение об ошибке \"При заполнении данных произошла ошибка\"$")
    public void stepGetMistakeOne(){
        senAppPageSteps.stepGetMistakeOne();
    }

    @Then("присутствует сообщение об ошибке \"Поле не заполнено.\"$")
    public void stepGetMistakeTwo(){
        senAppPageSteps.stepGetMistakeTwo();
    }

}
