package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.hbrs.se1.ws23.uebung1.control.TranslatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {
        Translator translator = TranslatorFactory.createGermanTranslator();

    @Test
    void aPositiveTest() {
        String value1 = translator.translateNumber(1);
        String value5 = translator.translateNumber(5);
        String value10 = translator.translateNumber(10);
        assertEquals(value1, "eins");
        assertEquals(value5, "fünf");
        assertEquals(value10, "zehn");
    }
    @Test
    void aNegativeTest() {
        //Äquivalenzklasse x < 0
        assertThrows(IndexOutOfBoundsException.class, () -> {translator.translateNumber(0);});
        assertThrows(IndexOutOfBoundsException.class, () -> {translator.translateNumber(-1);});
        assertThrows(IndexOutOfBoundsException.class, () -> {translator.translateNumber(-300);});

        //Äquivalenzklasse x > 10
        assertThrows(IndexOutOfBoundsException.class, () -> {translator.translateNumber(11);});
        assertThrows(IndexOutOfBoundsException.class, () -> {translator.translateNumber(200);});
    }
}