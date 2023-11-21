package org.hbrs.se1.ws23.uebung4.model;

import org.hbrs.se1.ws23.uebung2.exception.ContainerException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hbrs.se1.ws23.uebung3.persistence.PersistenceException.ExceptionType.NoStrategyIsSet;

public class ContainerGeneric<T extends UserStory> {
    private static ContainerGeneric<UserStory> instance = null;      //Instance Variable für Singleton Pattern
    private List<T> liste;
    private PersistenceStrategy<T> persistenceStrategy;

    private ContainerGeneric(){
        liste = new ArrayList<>();
    }
    /**
     *Thread-Safe?  →   über synchronized
     * Nachteil: höhere Laufzeit
     */
    public static synchronized ContainerGeneric getInstance() {   //Statische Methode für das Singleton Pattern
        if (instance == null) {                                         //Es wird beim Aufruf der Methode immer nur eine Instance verwendet
            instance = new ContainerGeneric();
        }
        return instance;
    }

    public void addUS(T us) throws ContainerException {
        for(T m : liste) {
            if(m.getID() == us.getID()){
                throw new ContainerException("Das UserStory-Objekt mit der ID " + us.getID() + " ist bereits vorhanden!");
            }
        }
        liste.add(us);
    }

    public String deleteUS(Integer id) {
        for(T m : liste) {
            if(m.getID() == id) {
                liste.remove(m);
                return "UserStory mit ID " + id + " geloescht!";
            }
        }
        return "UserStory mit ID " + id + " ist nicht im Container vorhanden und kann deshalb nicht geloescht werden!";
    }

    /*
    public void dump() {
        for (T m : liste) {
            System.out.println(m.toString());
        }
    }*/

    public int size() {
        return liste.size();
    }

    public void setPersistenceStrategy(PersistenceStrategy<T> persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    public void store() throws PersistenceException, IOException {
        if (persistenceStrategy != null) {
            persistenceStrategy.save(liste);
        } else {
            throw new PersistenceException(NoStrategyIsSet, "Keine Persistenzstrategie festgelegt!");
        }
    }

    public void load() throws PersistenceException {
        if (persistenceStrategy != null) {
            liste = persistenceStrategy.load();
        } else {
            throw new PersistenceException(NoStrategyIsSet, "Keine Persistenzstrategie festgelegt!");
        }
    }

    public List<T> getCurrentList() {
        return liste;
    }

    public void deleteAll() {
        liste.clear();
    }
}
