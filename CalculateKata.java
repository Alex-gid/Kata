package Kata;

import java.util.Scanner;

public class CalculateKata {
    private static int calculate(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                return a / b;
            case "*":
                return a * b;
            default:
                throw new Exception("Некорректная операция: " + operator);
        }
    }
    private static void methodCalc() throws Exception {
        System.out.println("Input : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] math = input.trim().split("\\s+");

        if (math.length != 3) {

            System.out.println("Error length");

        } else if (isString(math[0])) {

            String array0 = math[0];
            String operator = math[1];
            String array2 = math[2];
            int result = calculate(konvert(array0), konvert(array2), operator);
            if (result < 0) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            String romanResult = RomanConverter(result);
            System.out.println("Otvet : " + romanResult);

        } else {

            try {

                int a = Integer.parseInt(math[0]);
                if (a < 1 || a >= 11) {
                    System.out.println("Можно использовать числа только от 1 до 10");
                    return;
                }
                int b = Integer.parseInt(math[2]);
                if (b < 1 || b >= 11) {
                    System.out.println("Можно использовать числа только от 1 до 10");
                    return;
                }
                String operator = math[1];
                int result = calculate(a, b, operator);
                System.out.println("Otvet : " + result);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное число");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль");
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный оператор");
            }
        }
    }
    private static int konvert(String romain) throws Exception {
        switch (romain) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception("Можно использовать числа от I до X");
        }
    }
    public static String RomanConverter(int number) {

        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Некорректное число для римской системы");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < romanSymbols.length; i++) {
            while (number >= arabicValues[i]) {
                roman.append(romanSymbols[i]);
                number -= arabicValues[i];
            }
        }
        return roman.toString();
    }
    public static boolean isString(String variable) {
        try {
            Integer.parseInt(variable);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        methodCalc();
    }
}
