package com.samuil.olegovich.shortener.tests;

import com.samuil.olegovich.shortener.Shortener;
import com.samuil.olegovich.shortener.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

//      14.4. Добавь в класс FunctionalTest метод testStorage(com.samuil.olegovich.shortener.Shortener shortener). Он должен:
    public void testStorage(Shortener shortener) {
//      14.4.1. Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
        String string1 = "Текст 1 и 3 строк должен быть одинаковым.";
        String string2 = "Создавать три строки.";
        String string3 = "Текст 1 и 3 строк должен быть одинаковым.";
//      14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
        Long stringId1 = shortener.getId(string1);
        Long stringId2 = shortener.getId(string2);
        Long stringId3 = shortener.getId(string3);
//      14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
//            Подсказка: метод Assert.assertNotEquals.
        Assert.assertNotEquals(stringId2, stringId1);
        Assert.assertNotEquals(stringId2, stringId3);
//      14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.
//            Подсказка: метод Assert.assertEquals.
        Assert.assertEquals(stringId1, stringId3);
//      14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
        String stringOut1 = shortener.getString(stringId1);
        String stringOut2 = shortener.getString(stringId2);
        String stringOut3 = shortener.getString(stringId3);
//      14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
//            Подсказка: метод Assert.assertEquals.
        Assert.assertEquals(string1, stringOut1);
        Assert.assertEquals(string2, stringOut2);
        Assert.assertEquals(string3, stringOut3);
    }

//      14.5. Добавь в класс FunctionalTest тесты:

//    @Test
//    public void testHashMapStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new HashMapStorageStrategy()));
//    }
//
//    @Test
//    public void testOurHashMapStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new OurHashMapStorageStrategy()));
//    }
//
//    @Test
//    public void testFileStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new FileStorageStrategy()));
//    }
//
//    @Test
//    public void testHashBiMapStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new HashBiMapStorageStrategy()));
//    }
//
//    @Test
//    public void testDualHashBidiMapStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new DualHashBidiMapStorageStrategy()));
//    }
//
//    @Test
//    public void testOurHashBiMapStorageStrategy() {
//        testStorage(new com.samuil.olegovich.shortener.Shortener(new OurHashBiMapStorageStrategy()));
//    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

}
