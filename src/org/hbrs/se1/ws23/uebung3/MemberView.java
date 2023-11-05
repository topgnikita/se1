package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung2.Member;
import java.util.List;

public class MemberView {
    public void dump(List<Member> list){
        for (Member m : list) {
            System.out.println(m.toString());   //Ausgabe auf der Konsole
        }
    }
}
