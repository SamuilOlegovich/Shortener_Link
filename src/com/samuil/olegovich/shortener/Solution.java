package com.samuil.olegovich.shortener;

import com.samuil.olegovich.shortener.strategy.HashMapStorageStrategy;
import com.samuil.olegovich.shortener.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        // Этот метод должен для переданного множества строк возвращать множество идентификаторов.
        // Идентификатор для каждой отдельной строки нужно получить, используя shortener.
        Set<Long> set = new TreeSet<>();

        for (String string : strings) {
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        // Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
        Set<String> set = new TreeSet<>();

        for (Long key : keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        try {
            // Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber.
            // Реализация метода должна:
            // Выводить имя класса стратегии. Имя не должно включать имя пакета.
            System.out.println(strategy.getClass().getSimpleName());
            // Генерировать тестовое множество строк, используя com.samuil.olegovich.shortener.Helper и заданное количество элементов elementsNumber.
            Shortener shortener = new Shortener(strategy);
            HashSet<String> generateString = new HashSet<>();

            for (long i = 0; i < elementsNumber; i++) {
                generateString.add(Helper.generateRandomString());
            }
            // Создавать объект типа com.samuil.olegovich.shortener.Shortener, используя переданную стратегию.
            // Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и
            //      заданного множества элементов. Время вывести в миллисекундах. При замере времени работы метода можно
            //      пренебречь переключением процессора на другие потоки, временем, которое тратится на сам вызов,
            //      возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием
            //      объектов типа Date.
//        long startTime = new Date().getTime();
            Date d1 = new Date();
            Set<Long> id = getIds(shortener, generateString);
//        long endTime = new Date().getTime();
//        com.samuil.olegovich.shortener.Helper.printMessage("" + (endTime - startTime));
            Date d2 = new Date();
            // Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
            //      и полученного в предыдущем пункте множества идентификаторов.
//        startTime = 0L;
//        endTime = 0L;
//        startTime = new Date().getTime();
            Date d3 = new Date();
            Set<String> stringSet = getStrings(shortener, id);
//        endTime = new Date().getTime();
//        com.samuil.olegovich.shortener.Helper.printMessage("" + (endTime - startTime));
            Date d4 = new Date();
            Helper.printMessage("getIds - " + (d2.getTime() - d1.getTime()));
            Helper.printMessage("getStrings - " + (d4.getTime() - d3.getTime()));
            // Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества,
            //      которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.",
            //      иначе "Тест не пройден.".
            if (stringSet.size() == generateString.size()) {
                Helper.printMessage("Тест пройден.");
//            com.samuil.olegovich.shortener.Helper.printMessage(stringSet.size() + "");
//            com.samuil.olegovich.shortener.Helper.printMessage(generateString.size() + "");

            } else {
                Helper.printMessage("Тест не пройден.");
            }
        } catch (Exception e) { Helper.printMessage("Тест не пройден."); }
    }
}
