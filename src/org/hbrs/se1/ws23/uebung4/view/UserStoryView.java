package org.hbrs.se1.ws23.uebung4.view;

import org.hbrs.se1.ws23.uebung4.model.UserStory;

import java.util.Collections;
import java.util.List;

public class UserStoryView {
    public void dump(List<UserStory> list){
        Collections.sort(list);
        for (UserStory us : list) {
            System.out.println(us.toString());   //Ausgabe auf der Konsole
        }
    }
}
