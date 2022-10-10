package ru.nvy.mock;

import ru.nvy.interfaces.ICalculatorView;

public class ViewMock implements ICalculatorView {
    private String a,b;
    private double result;
    private String error;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public void printResult(double result) {
        this.result=result;
    }
    @Override
    public void displayError(String message) {
        error = message;
    }
    @Override
    public String getFirstArgumentAsString() {
        return a;
    }
    @Override
    public String getSecondArgumentAsString() {
        return b;
    }
}
