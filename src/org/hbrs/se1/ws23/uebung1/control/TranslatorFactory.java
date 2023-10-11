package org.hbrs.se1.ws23.uebung1.control;

public class TranslatorFactory {
        /**
         * Anwendung des Factory Method Pattern (Kapitel 6; [GOF])
         * Problem: Inkonsistente Objekt-Erzeugung und -Parametrisierung
         * Lösung: Service-Klasse für die zentrale und konsistente Erzeugung.
         */
        public static Translator createGermanTranslator() {
            Translator translator = new GermanTranslator();
            return translator;
        }
}
