package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.EnglishTranslator;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.hbrs.se1.ws23.uebung1.control.TranslatorFactory;

public class Assembler {
    /**
     *
     * "Anwendung des Musters "Depending Injection(DI)"
     */
    public static void main(String[] args) {
        Translator t1 = new GermanTranslator();
        Client client = new Client(t1);

        client.display(5);

        client.setTranslator(new EnglishTranslator());

        client.display(5);
    }
}
