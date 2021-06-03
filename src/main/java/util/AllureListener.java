package util;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseStep;


public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {

        @Override
        public void testFailure(Failure failure){
            BaseStep.takeScreenshot();
            super.testFailure(failure);
        }

    }

