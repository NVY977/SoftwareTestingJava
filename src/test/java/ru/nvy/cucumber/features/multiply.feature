# language: en
@calculator
Feature: : Умножение двух чисел

  Scenario: :  Добавление двух чисел и их умножение
    Given Ввод первого числа 50.0
    And Ввод второго числа 2.5
    When Нажал на умножить
    Then Результат: 125