package ru.nvy;

import ru.nvy.interfaces.ICalculatorView;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorView implements ICalculatorView {
    private String a;
    private String b;

    @Deprecated
    public double checkDouble() {
        double number = 0;
        CalculatorView calculatorView = new CalculatorView();
        Scanner sc = new Scanner(System.in);
        try {
            number = sc.nextDouble();
        } catch (InputMismatchException e) {
            calculatorView.displayError("Input double+");
            throw new InputMismatchException();
        } catch (NoSuchElementException e) {
            calculatorView.displayError("Input double");
            throw new NoSuchElementException();
        }
        return number;
    }

    @Override
    public void printResult(double result) {
        System.out.print("Result: " + result);
    }

    @Override
    public void displayError(String message) {
        System.err.println("ERROR::" + message);
    }

    @Override
    public String getFirstArgumentAsString() {
        return a;
    }

    @Override
    public String getSecondArgumentAsString() {
        return b;
    }


    public void setFirstArgument(String a) {
        this.a = a;
    }

    public void setSecondArgument(String b) {
        this.b = b;
    }
}