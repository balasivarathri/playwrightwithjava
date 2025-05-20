package org.qa.automation.runner;

import io.cucumber.junit.Cucumber;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.qa.automation.processor.Initialize;
import org.qa.automation.processor.TearDown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRunner extends Runner {

    private static final Logger log = LoggerFactory.getLogger(CustomRunner.class);
    private final Class<?> testClass;
    private Cucumber cucumber;

    public CustomRunner(Class<?> testClass) throws Exception {
        this.testClass = testClass;
        this.cucumber = new Cucumber(testClass);
    }

    @Override
    public Description getDescription() {
        return this.cucumber.getDescription();
    }

    private void runAnnotatedMethods(Class<? extends Annotation> annotation) throws Exception {
        if (annotation.isAnnotation()) {
            for (Method method : testClass.getMethods()) {
                for (Annotation item : method.getAnnotations()) {
                    if (item.annotationType().equals(annotation)) {
                        method.invoke(null);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            this.runAnnotatedMethods(Initialize.class);
            this.cucumber = new Cucumber(this.testClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.cucumber.run(notifier);

        try {
            this.runAnnotatedMethods(TearDown.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
