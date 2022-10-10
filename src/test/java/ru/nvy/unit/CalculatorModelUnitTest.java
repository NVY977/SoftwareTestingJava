package ru.nvy.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import ru.nvy.CalculatorModel;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelUnitTest {
    private final CalculatorModel calculatorModel = new CalculatorModel();

    @DisplayName("Sum two numbers")
    @RepeatedTest(50)
    void sum() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a + b, calculatorModel.sum(a, b));
    }

    @DisplayName("Subtract two numbers")
    @RepeatedTest(50)
    void subtract() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a + b, calculatorModel.sum(a, b));
    }

    @DisplayName("Multiply two numbers")
    @RepeatedTest(50)
    public void multiply() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a + b, calculatorModel.sum(a, b));
    }

    @DisplayName("Divide two numbers")
    @RepeatedTest(50)
    void divide() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a + b, calculatorModel.sum(a, b));
    }

    @DisplayName("DivideZero two numbers")
    @org.junit.jupiter.api.Test
    void divideZero() {
        double a = Math.random();
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculatorModel.divide(a, 0));
        assertNull(exception.getMessage());
    }
}