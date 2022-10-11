package ru.nvy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import ru.nvy.mock.ViewMock;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {
    private final ViewMock viewMock = new ViewMock();
    private final CalculatorPresenter calculatorPresenter = new CalculatorPresenter(viewMock);

    @DisplayName("Sum two numbers")
    @RepeatedTest(10)
    void sum() {
        double a = Math.random();
        double b = Math.random();
        viewMock.setA(String.valueOf(a));
        viewMock.setB(String.valueOf(b));
        calculatorPresenter.onPlusClicked();
        assertEquals(a + b, viewMock.getResult());
    }

    @DisplayName("Subtract two numbers")
    @RepeatedTest(10)
    void subtract() {
        double a = Math.random();
        double b = Math.random();
        viewMock.setA(String.valueOf(a));
        viewMock.setB(String.valueOf(b));
        calculatorPresenter.onMinusClicked();
        assertEquals(a - b, viewMock.getResult());
    }

    @DisplayName("Multiply two numbers")
    @RepeatedTest(10)
    public void multiply() {
        double a = Math.random();
        double b = Math.random();
        viewMock.setA(String.valueOf(a));
        viewMock.setB(String.valueOf(b));
        calculatorPresenter.onMultiplyClicked();
        assertEquals(a * b, viewMock.getResult());
    }

    @DisplayName("Divide two numbers")
    @RepeatedTest(10)
    void divide() {
        double a = Math.random();
        double b = Math.random();
        viewMock.setA(String.valueOf(a));
        viewMock.setB(String.valueOf(b));
        calculatorPresenter.onDivideClicked();
        assertEquals(a / b, viewMock.getResult());
    }
}