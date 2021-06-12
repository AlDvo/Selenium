package util;

import gherkin.formatter.model.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseStep;


public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

        @Override
        public void result(Result result){
            if(result.getStatus().equals("failed")){
            BaseStep.takeScreenshot();}
            super.result(result);
        }

    }

