package ru.nvy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("Sum two numbers")
    @RepeatedTest(50)
    void sum() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a + b, calculator.sum(a, b));
    }

    @DisplayName("Subtract two numbers")
    @RepeatedTest(50)
    void subtract() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a - b, calculator.subtract(a, b));
    }

    @DisplayName("Multiply two numbers")
    @RepeatedTest(50)
    public void multiply() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a * b, calculator.multiply(a, b));
    }

    @DisplayName("Divide two numbers")
    @RepeatedTest(50)
    void divide() {
        double a = Math.random();
        double b = Math.random();
        assertEquals(a / b, calculator.divide(a, b));
    }

    @DisplayName("DivideZero two numbers")
    @org.junit.jupiter.api.Test
    void divideZero() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        assertNull(exception.getMessage());
    }
}