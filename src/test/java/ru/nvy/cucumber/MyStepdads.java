package ru.nvy.cucumber;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.nvy.CalculatorView;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdads {
    CalculatorView calculatorView;

    @Given("^Ввод первого числа (.+)$")
    public void enterFirst(double firstNum) {
        calculatorView = new CalculatorView();
        calculatorView.firstNumber.setText(Double.toString(firstNum));
    }

    @And("^Ввод второго числа (.+)$")
    public void enterSecond(double secondNum) {
        calculatorView.secondNumber.setText(Double.toString(secondNum));
    }

    @When("^Нажал на плюс")
    public void pressPlus() {
        calculatorView.getPlus().doClick();
    }

    @When("^Нажал на минус")
    public void pressMinus() {
        calculatorView.getMinus().doClick();
    }

    @When("^Нажал на умножить")
    public void pressMultiply() {
        calculatorView.getMultiply().doClick();
    }

    @When("^Нажал на деление")
    public void pressDivide() {
        calculatorView.getDivide().doClick();
    }

    @Then("^Результат: (.+)")
    public void result(double result) {
        assertEquals(Double.toString(result), calculatorView.output.getText());
    }
}

