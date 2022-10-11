package ru.nvy;

import ru.nvy.interfaces.ICalculatorPresenter;
import ru.nvy.interfaces.ICalculatorView;

import java.util.InputMismatchException;

public class CalculatorPresenter implements ICalculatorPresenter {
    private final CalculatorModel calculatorModel;
    private final ICalculatorView calculatorView;

    public CalculatorPresenter(ICalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        calculatorModel = new CalculatorModel();
    }

    public double checkNumber(String getString) {
        double number;
        try {
            number = Double.parseDouble(getString);
        } catch (NumberFormatException | InputMismatchException e) {
            calculatorView.displayError("Input double");
            throw new InputMismatchException();
        }
        return number;
    }

    @Override
    public void onPlusClicked() {
        double firstNumber = checkNumber(calculatorView.getFirstArgumentAsString());
        double secondNumber = checkNumber(calculatorView.getSecondArgumentAsString());
        calculatorView.printResult(calculatorModel.sum(firstNumber, secondNumber));
    }

    @Override
    public void onMinusClicked() {
        double firstNumber = checkNumber(calculatorView.getFirstArgumentAsString());
        double secondNumber = checkNumber(calculatorView.getSecondArgumentAsString());
        calculatorView.printResult(calculatorModel.subtract(firstNumber, secondNumber));
    }
    @Override
    public void onMultiplyClicked() {
        double firstNumber = checkNumber(calculatorView.getFirstArgumentAsString());
        double secondNumber = checkNumber(calculatorView.getSecondArgumentAsString());
        calculatorView.printResult(calculatorModel.multiply(firstNumber, secondNumber));
    }
    @Override
    public void onDivideClicked() {
        double firstNumber = checkNumber(calculatorView.getFirstArgumentAsString());
        double secondNumber = checkNumber(calculatorView.getSecondArgumentAsString());
        try {
            calculatorView.printResult(calculatorModel.divide(firstNumber, secondNumber));
        } catch(ArithmeticException e) {
            calculatorView.displayError("Divide 0");
        }
    }
}
