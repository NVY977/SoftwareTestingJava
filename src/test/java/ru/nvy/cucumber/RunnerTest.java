package ru.nvy.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/nvy/cucumber/features",
        glue = "ru.nvy.cucumber",
        tags = "@calculator",
        /*
        dryRun Если true, то сразу после запуска теста фреймворк проверяет, все ли шаги теста разработаны, если нет,
        то выдает предупреждение. При false предупреждение будет выдаваться по достижении неразработанного шага
         */
        dryRun = false
)
public class RunnerTest {

}