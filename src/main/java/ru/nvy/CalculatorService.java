package ru.nvy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorService {
    Calculator calculator;
    CalculatorView calculatorView;

    public CalculatorService(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        calculator = new Calculator();
    }

    public double add() {
        double firstNumber;
        double secondNumber;
//        calculatorView.setFirstArgument("13");
//        calculatorView.setSecondArgument("g");
        try {
            firstNumber = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            secondNumber = Double.parseDouble(calculatorView.getSecondArgumentAsString());
        } catch (NumberFormatException | InputMismatchException e) {
            calculatorView.displayError("Input double");
            throw new InputMismatchException();
        }

        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        in.close();

        double result;
        switch (operation) {
            case "+":
                result = calculator.sum(firstNumber, secondNumber);
                break;
            case "-":
                result = calculator.subtract(firstNumber, secondNumber);
                break;
            case "*":
                result = calculator.multiply(firstNumber, secondNumber);
                break;
            case "/":
                result = calculator.divide(firstNumber, secondNumber);
                break;
            default:
                calculatorView.displayError("INPUT +|-|*|/");
                throw new InputMismatchException();
        }
        return result;
    }

}
