package com.samuil.olegovich.shortener;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString() {
        // будет генерировать случайную строку.
        // Воспользуйся для этого классами SecureRandom и BigInteger.
        // Подсказка: гугли запрос "random string java".
        // Строка может состоять из цифр и любой из 26 маленьких букв английского алфавита.
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(36);
    }

    public static void printMessage(String message) {
        // Он должен выводить переданный текст в консоль.
        // Весь дальнейший вывод в программе должен быть реализован через этот метод!
        System.out.println(message);
    }
}
