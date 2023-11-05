package org.hbrs.se1.ws23.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
        /*try {
            FileOutputStream fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);

            FileInputStream fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            throw new PersistenceException("Öffnen der Verbindung nicht möglich: " + e.getMessage());
        }*/
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        /*try {
            oos.close();
            ois.close();
        } catch (IOException e) {
            throw new PersistenceException("Fehler beim schließen der Verbindung: " + e.getMessage());
        }*/
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException, IOException {

        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(member);
            oos.close();

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"Fehler beim schreiben");
        }

    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        /*Some Coding hints ;-)

         ObjectInputStream ois = null;
         FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        and finally close the streams (guess where this could be...?)*/
        FileInputStream fis = null;
        List<E> newListe =  null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            if (o instanceof List<?>) {
                newListe = (List) o;
                ois.close();
                return newListe;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Fehler beim Laden: " + e.getMessage());
        }
        return null;
    }
}
