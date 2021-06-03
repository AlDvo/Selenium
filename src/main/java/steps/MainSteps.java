package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseStep{

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectSubMenu(String menuItem) throws InterruptedException {
        new MainPage(driver).selectSubMenu(menuItem);
    }

    @Step("Выбран фильтр страхования {0}")
    public void stepSelectFiltreMenu(String menuItem){
        new MainPage(driver).selectFiltreMenu(menuItem);
    }

    @Step("Выбрана программа страхования {0}")
    public void stepSelectProgrammInsurance(String menuItem) throws InterruptedException {
        new MainPage(driver).selectProgrammInsurance(menuItem);
    }
}
