package ru.nvy;

import ru.nvy.interfaces.ICalculatorPresenter;
import ru.nvy.interfaces.ICalculatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView implements ICalculatorView {
    private final JFrame frame = new JFrame();
    public final JTextField firstNumber = new JTextField("");
    public final JTextField secondNumber = new JTextField("");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("/");
    public final JLabel output = new JLabel("");
    private final ICalculatorPresenter calcPres;
    public CalculatorView() {
        calcPres = new CalculatorPresenter(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 400, 200);
        frame.setVisible(true);
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(2,1));

        JLabel equals = new JLabel("=");
        Font font = new Font(equals.getFont().getName(),Font.PLAIN,30);
        Font fontForNumber = new Font(equals.getFont().getName(),Font.ITALIC,20);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p1.add(new JLabel(""), new JLabel(""));
        firstNumber.setFont(fontForNumber);
        secondNumber.setFont(fontForNumber);
        p1.add(firstNumber);
        p1.add(secondNumber);
        equals.setFont(font);
        p1.add(equals);
        output.setFont(fontForNumber);
        p1.add(output);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3));
        plus.setFont(font);
        minus.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);
        p2.add(plus);
        p2.add(minus);
        p2.add(multiply);
        p2.add(divide);

        container.add(p1);
        container.add(p2);

        plus.addActionListener(new PlusListener());
        minus.addActionListener(new MinusListener());
        multiply.addActionListener(new MultiplyListener());
        divide.addActionListener(new DivListener());
    }

    // region Action
    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onPlusClicked();
        }
    }
    class MinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onMinusClicked();
        }
    }
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onMultiplyClicked();
        }
    }
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onDivideClicked();
        }
    }
    // endregion
    @Override
    public void printResult(double result) {
        output.setText(Double.toString(result));
    }
    @Override
    public void displayError(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
    @Override
    public String getFirstArgumentAsString() {
        return firstNumber.getText();
    }
    @Override
    public String getSecondArgumentAsString() {
        return secondNumber.getText();
    }

    //region Get/Set
    public JButton getPlus() {
        return plus;
    }
    public JButton getMinus() {
        return minus;
    }
    public JButton getMultiply() {
        return multiply;
    }
    public JButton getDivide() {
        return divide;
    }
    //endregion
    public static void main(String[] args) {
        new CalculatorView();
    }
}
