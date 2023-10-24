package org.hbrs.se1.ws23.uebung2;

import org.hbrs.se1.ws23.uebung2.exception.ContainerException;
import java.util.LinkedList;

public class Container {
    private LinkedList<Member> liste;

    public Container(){
        liste = new LinkedList<>();
    }

    public void addMember(Member member) throws ContainerException {
        for(Member m : liste) {
            if(m.getID() == member.getID()) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        liste.add(member);
    }

    public String deleteMember(Integer id) {
        for(Member m : liste) {
            if(m.getID() == id) {
                liste.remove(m);
                return "Member mit ID " + id + " geloescht!";
            }
        }
        return "Member mit ID " + id + " ist nicht im Container vorhanden und kann deshalb nicht geloescht werden!";
    }

    public void dump() {
        for (Member m : liste) {
            System.out.println(m.toString());
        }
    }

    public int size() {
        return liste.size();
    }
}
