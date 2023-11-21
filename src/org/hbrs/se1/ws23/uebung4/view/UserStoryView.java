package org.hbrs.se1.ws23.uebung4.view;

import org.hbrs.se1.ws23.uebung4.model.UserStory;

import java.util.Collections;
import java.util.List;

public class UserStoryView {
    public void dump(List<UserStory> list){
        // Stream-basierte Implementierung mit Filter, Map und Collect
        list.stream()
                .sorted((us1, us2) -> Double.compare(us2.getPrio(), us1.getPrio())) // Sortiere nach Priorität absteigend
                .forEach(us -> System.out.println(us.toString()));

        /*
        Collections.sort(list);
        for (UserStory us : list) {
            System.out.println(us.toString());   //Ausgabe auf der Konsole
        }*/
    }

}
