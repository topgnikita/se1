package org.hbrs.se1.ws23.uebung1.control;

public class EnglishTranslator implements Translator{

    public String date = "Oct/2023"; // Default-Wert

    /**
     * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
     */
    public String translateNumber(int number) {
        // [ihr Source Code aus Übung 1-2]
        try {
            String[] zahlen = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
            String erg = zahlen[number - 1];
            return erg;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Translation of number " + number + " not possible " + "(" +version +")");
        }
    }

    /**
     * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
     */
    public void printInfo(){
        System.out.println( "EnglishTranslator v1.9, created on  " + this.date );
    }

    /**
     * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
     * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
     */
    public void setDate(String date) {
        this.date = date;
    }

}
