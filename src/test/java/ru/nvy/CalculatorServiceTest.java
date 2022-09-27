package ru.nvy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.MalformedParametersException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CalculatorServiceTest {
    CalculatorView calculatorView = new CalculatorView();

    @DisplayName("FirstNumber check(Exp)")
    @Test
    void firstNumberCheck() {
        calculatorView.setFirstArgument("g");
        calculatorView.setSecondArgument("6.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
    }
    @DisplayName("SecondNumber check(Exp)")
    @Test
    void secondNumberCheck() {
        calculatorView.setFirstArgument("6.0");
        calculatorView.setSecondArgument("g");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
    }

    @DisplayName("Without number(Exp)")
    @Test
    void withoutNumber() {
        calculatorView.setFirstArgument("");
        calculatorView.setSecondArgument("7.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        Exception exception = assertThrows(NoSuchElementException.class, calculatorService::add);
        assertNull(exception.getMessage());
    }

    @DisplayName("Without_2 number(Exp)")
    @Test
    void withoutNumber_2() {
        calculatorView.setFirstArgument("7.0");
        calculatorView.setSecondArgument("");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
    }


    @DisplayName("Sign check (+)")
    @Test
    void addCheckSum() {
        calculatorView.setFirstArgument("7.0");
        calculatorView.setSecondArgument("6.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("+".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        assertEquals(13.0, calculatorService.add());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (-)")
    @Test
    void addCheckSubtract() {
        calculatorView.setFirstArgument("7.0");
        calculatorView.setSecondArgument("6.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("-".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        assertEquals(1.0, calculatorService.add());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (*)")
    @Test
    void addCheckMultiply() {
        calculatorView.setFirstArgument("7.0");
        calculatorView.setSecondArgument("6.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("*".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        assertEquals(42.0, calculatorService.add());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (/)")
    @Test
    void addCheckDivide() {
        calculatorView.setFirstArgument("4.0");
        calculatorView.setSecondArgument("2.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("/".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        assertEquals(2.0, calculatorService.add());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (Exception)")
    @Test
    void addCheckExp() {
        calculatorView.setFirstArgument("4.0");
        calculatorView.setSecondArgument("2.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("g".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (Exception_2)")
    @Test
    void addCheckExp_2() {
        calculatorView.setFirstArgument("4.0");
        calculatorView.setSecondArgument("2.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("*-".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
        System.setIn(inputStream);            // подменяем обратно
    }

    @DisplayName("Sign check (Exception_3)")
    @Test
    void addCheckExp_3() {
        calculatorView.setFirstArgument("4.0");
        calculatorView.setSecondArgument("2.0");
        CalculatorService calculatorService = new CalculatorService(calculatorView);
        ByteArrayInputStream in = new ByteArrayInputStream("**".getBytes());
        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
        System.setIn(in);                     // подменяем ввод
        Exception exception = assertThrows(InputMismatchException.class, calculatorService::add);
        assertNull(exception.getMessage());
        System.setIn(inputStream);            // подменяем обратно
    }
}