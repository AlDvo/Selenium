package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(BaseStep.getDriver()).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        new MainPage(BaseStep.getDriver()).selectSubMenu(menuItem);
    }

    @Step("Выбран фильтр страхования {0}")
    public void stepSelectFiltreMenu(String menuItem){
        new MainPage(BaseStep.getDriver()).selectFiltreMenu(menuItem);
    }

    @Step("Выбрана программа страхования {0}")
    public void stepSelectProgrammInsurance(String menuItem) throws InterruptedException {
        new MainPage(BaseStep.getDriver()).selectProgrammInsurance(menuItem);
    }
}
