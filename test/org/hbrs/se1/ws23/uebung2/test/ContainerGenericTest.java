package org.hbrs.se1.ws23.uebung2.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.*;
import org.hbrs.se1.ws23.uebung2.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerGenericTest {
    ContainerGeneric<Member> container = ContainerGeneric.getInstance();;
    Member m1 = new ConcreteMember(7);
    Member m2 = new ConcreteMember(11);

    @Test
    void testSize()  {
        assertEquals(0,container.size());

        try {
            container.addMember(m1);
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        }

        assertEquals(1,container.size());

        try {
            container.addMember(m2);
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2,container.size());

        assertEquals("Member mit ID " + 8
                + " ist nicht im Container vorhanden " +
                "und kann deshalb nicht geloescht werden!", container.deleteMember(8));

        Member m11 = new ConcreteMember(11);
        //container.addMember(m11);
        assertThrows(ContainerException.class, () -> {container.addMember(m11);});
        //assertThrows(ContainerException.class, () -> {container.addMember(NULL);});



        //container.dump();
        assertEquals(2,container.size());
        container.size();
        assertEquals(2,container.size());


        assertEquals("Member mit ID " + 11 + " geloescht!",container.deleteMember(11));
        assertEquals(1,container.size());
        assertEquals("Member mit ID " + 7 + " geloescht!",container.deleteMember(7));
        assertEquals(0,container.size());

        try {
            container.addMember(null);
        } catch (ContainerException e) {
            assertEquals( "NULL-Werte dürfen nicht aufgenommen werden!" ,
                    e.getMessage() );
        }
    }

}
