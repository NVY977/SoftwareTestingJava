package ru.nvy;

public class Main {

    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        calculatorView.printResult(calculatorService.add());
    }
}