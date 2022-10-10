//package ru.nvy;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.InputMismatchException;
//import java.util.NoSuchElementException;
//
//import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
//import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculatorViewTest {
//    private CalculatorView calculatorView;
//
//    @DisplayName("Print result")
//    @Test
//    void printResult() throws Exception {
//        calculatorView = new CalculatorView();
//        String text = tapSystemOut(() -> {
//            calculatorView.printResult(5);
//        });
//        assertEquals("Result: 5.0", text.trim());
//    }
//
//    @DisplayName("Get error")
//    @Test
//    void displayError() throws Exception {
//        calculatorView = new CalculatorView();
//        String text = tapSystemErr(() -> {
//            calculatorView.displayError("INPUT_DOUBLE");
//        });
//        assertEquals("ERROR::INPUT_DOUBLE", text.trim());
//    }
//
//    @DisplayName("Get first number")
//    @Test
//    void getFirstArgumentAsString() {
//        calculatorView = new CalculatorView();
//        calculatorView.setFirstArgument("7.0");
//        assertEquals("7.0", calculatorView.getFirstArgumentAsString());
//    }
//
//    @DisplayName("Get second number")
//    @Test
//    void getSecondArgumentAsString() {
//        calculatorView = new CalculatorView();
//        calculatorView.setSecondArgument("7.0");
//        assertEquals("7.0", calculatorView.getSecondArgumentAsString());
//    }
//
//    //region Test CheckDouble
//    /*
//    @DisplayName("Correct input")
//    @Test
//    @Deprecated
//    void checkDoubleTest() {
//        calculatorView = new CalculatorView();
//        ByteArrayInputStream in = new ByteArrayInputStream("7,7".getBytes());
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in);                     // подменяем ввод
//        assertEquals(7.7, calculatorView.checkDouble());
//        System.setIn(inputStream);            // подменяем обратно
//    }
//
//    @DisplayName("Correct input")
//    @Test
//    @Deprecated
//    void checkDoubleTestCorrectInput() {
//        calculatorView = new CalculatorView();
//        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in);                     // подменяем ввод
//        assertEquals(7, calculatorView.checkDouble());
//        System.setIn(inputStream);            // подменяем обратно
//    }
//
//    @DisplayName("Input letter")
//    @Test
//    @Deprecated
//    void checkDoubleTestInputLetter() {
//        calculatorView = new CalculatorView();
//        ByteArrayInputStream in = new ByteArrayInputStream("g".getBytes());
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in);                     // подменяем ввод
//        Exception exception = assertThrows(InputMismatchException.class, () ->
//                 calculatorView.checkDouble());
//        assertNull(exception.getMessage());
//        System.setIn(inputStream);            // подменяем обратно
//    }
//
//    @DisplayName("Input [7.7]")
//    @Test
//    @Deprecated
//    void checkDoubleTestInputDot() {
//        calculatorView = new CalculatorView();
//        ByteArrayInputStream in = new ByteArrayInputStream("7.7".getBytes());
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in);                     // подменяем ввод
//        Exception exception = assertThrows(InputMismatchException.class, () ->
//                calculatorView.checkDouble());
//        assertNull(exception.getMessage());
//        System.setIn(inputStream);            // подменяем обратно
//    }
//
//    @DisplayName("Input nothing")
//    @Test
//    @Deprecated
//    void checkDoubleTestInputNothing() {
//        calculatorView = new CalculatorView();
//        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in);                     // подменяем ввод
//        Exception exception = assertThrows(NoSuchElementException.class, () ->
//                calculatorView.checkDouble());
//        assertNull(exception.getMessage());
//        System.setIn(inputStream);            // подменяем обратно
//    }*/
//    // endregion
//}