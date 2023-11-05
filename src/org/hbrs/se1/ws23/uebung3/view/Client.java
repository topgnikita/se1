package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.ContainerGeneric;
import org.hbrs.se1.ws23.uebung3.Main;
import org.hbrs.se1.ws23.uebung3.MemberView;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Client {
    public static void main(String[] args){

        Main.init();
        ContainerGeneric<Member> container = ContainerGeneric.getInstance();


        Member m1 = new ConcreteMember(3);
        Member m2 = new ConcreteMember(2);
        Member m3 = new ConcreteMember(4);
        try {
            container.addMember(m1);
            container.addMember(m2);
            container.addMember(m3);
            container.store();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Member> currentList = container.getCurrentList();

        MemberView mv = new MemberView();
        mv.dump(currentList);
    }
}
