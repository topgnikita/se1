package org.hbrs.se1.ws23.uebung4.model;

public class UserStory implements java.io.Serializable, Comparable<UserStory>{

    private int id;
    private String beschreibung;
    private String akzeptanzkriterien;
    private String projekt;

    //Gloger 4 Kennzahlen
    private int aufwand; //Fibonacci
    private int mehrwert; //1-5
    private int risiko; //1-5
    private int strafe; //1-5

    public UserStory() {}
    public UserStory(int id, String beschreibung, String akzeptanzkriterien,
                     String projekt, int aufwand, int mehrwert, int risiko, int strafe) {

        if((mehrwert <= 0 || mehrwert > 5) || (risiko <= 0 || risiko > 5) || (strafe <= 0 || strafe > 5)) {
            throw new IllegalArgumentException("Mehrwert muss zwischen 1-5 sein!");
        }
        if(!checkFibo(aufwand)) {
            throw new IllegalArgumentException("Aufwand muss Fibonacci Zahl sein");
        }

        this.id = id;
        this.beschreibung = beschreibung;
        this.akzeptanzkriterien =  akzeptanzkriterien;
        this.projekt = projekt;
        this.aufwand = aufwand;
        this.mehrwert = mehrwert;
        this.risiko = risiko;
        this.strafe = strafe;
    }

    //Getter und Setter
    public int getID(){
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getAkzeptanzkriterien() {
        return akzeptanzkriterien;
    }
    public void setAkzeptanzkriterien(String akzeptanzkriterien) {
        this.akzeptanzkriterien = akzeptanzkriterien;
    }

    public String getProjekt() {
        return projekt;
    }
    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }

    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        if(!checkFibo(aufwand)) {
            throw new IllegalArgumentException("Aufwand muss Fibonacci Zahl sein");
        }
        this.aufwand = aufwand;
    }

    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        if(mehrwert <= 0 || mehrwert > 5) {
            throw new IllegalArgumentException("Mehrwert muss zwischen 1-5 sein!");
        }
        this.mehrwert = mehrwert;
    }

    public int getRisiko() {
        return risiko;
    }
    public void setRisiko(int risiko) {
        if(risiko <= 0 || risiko > 5) {
            throw new IllegalArgumentException("Risiko muss zwischen 1-5 sein!");
        }
        this.risiko = risiko;
    }

    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        if(strafe <= 0 || strafe > 5) {
            throw new IllegalArgumentException("Strafe muss zwischen 1-5 sein!");
        }
        this.strafe = strafe;
    }


    public double getPrio(){
        return ((double) (mehrwert + strafe)) / ((double) (aufwand + risiko));
    }

    @Override
    public int compareTo(UserStory o) {
        if (this.getPrio() < o.getPrio()) {
            return 1;
        } else if (this.getPrio() > o.getPrio()) {
            return -1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "UserStory " + id + "\n" + "Projekt: " + projekt + "\n" +
                "Priorität: " + getPrio() + "\n" +
                "--------------------------------------------\n" +
               beschreibung + "\n\n" + "Akzeptanzkriterien (Test): " +
                akzeptanzkriterien + "\n" ;
    }

    private boolean checkFibo(int n){
        int[] arr= {1,2,3,5,8,13,20,35,50,85,135};
        for (int num : arr) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }
}
