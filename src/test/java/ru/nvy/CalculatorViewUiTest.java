
package ru.nvy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.nvy.mock.ViewMock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorViewUiTest {
    private static ViewMock viewMock;
    private static Robot robot;
    private static double a, b;
    private static CalculatorView calculatorView;

    @BeforeAll
    public static void init() {
        viewMock = new ViewMock();
        calculatorView = new CalculatorView();
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        a = Math.random();
        b = Math.random();
    }

    public void click(JButton button) throws InterruptedException {
        Point p = button.getLocationOnScreen(); // создали точку текущей кнопки
        robot.mouseMove(p.x + 15, p.y + 50);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
    }

    private void setA(double a) throws InterruptedException {
        calculatorView.firstNumber.setText(Double.toString(a));
        Thread.sleep(20);
    }

    private void setB(double b) throws InterruptedException {
        calculatorView.secondNumber.setText(Double.toString(b));
        Thread.sleep(20);
    }

    @Test
    public void testPlus() throws InterruptedException {
        setA(a);
        setB(b);
        click(calculatorView.getPlus());
        assertEquals(Double.toString(a + b), calculatorView.output.getText());
        Thread.sleep(100);
    }

    @Test
    public void testMinus() throws InterruptedException {
        setA(a);
        setB(b);
        click(calculatorView.getMinus());
        assertEquals(Double.toString(a - b), calculatorView.output.getText());
        Thread.sleep(100);
    }

    @Test
    public void testMultiply() throws InterruptedException {
        setA(a);
        setB(b);
        click(calculatorView.getMultiply());
        assertEquals(Double.toString(a * b), calculatorView.output.getText());
        Thread.sleep(100);
    }

    @Test
    public void testDivide() throws InterruptedException {
        setA(a);
        setB(b);
        click(calculatorView.getDivide());
        assertEquals(Double.toString(a / b), calculatorView.output.getText());
        Thread.sleep(100);
    }

    @Test
    public void testDivideZero() throws InterruptedException {
        setA(a);
        setB(0);
        click(calculatorView.getDivide());
        assertEquals("Divide 0",calculatorView.output.getText());
        Thread.sleep(100);
    }

    @Test
    public void testNullString() throws InterruptedException {
        setA(a);
        calculatorView.secondNumber.setText(null);
        click(calculatorView.getPlus());
        assertEquals("Input double",calculatorView.output.getText());
        Thread.sleep(100);
    }
}
