package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung2.exception.ContainerException;
import org.hbrs.se1.ws23.uebung3.ContainerGeneric;
import org.hbrs.se1.ws23.uebung3.MemberView;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerGenericTestNew {
    ContainerGeneric<Member> container;
    @BeforeEach
    void setUp() {
        container = ContainerGeneric.getInstance();
        container.setPersistenceStrategy(null);
        container.deleteAll();
    }

    @AfterEach
    void tearDown() {
        container = null;
    }

    @Test
    public void testNoStrategySet() {
        try {
            container.addMember(new ConcreteMember(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThrows(PersistenceException.class, () -> container.store());
    }

    @Test
    public void testUseMongoDBStrategy() {
        container.setPersistenceStrategy(new PersistenceStrategyMongoDB<>());

        try {
            container.addMember(new ConcreteMember(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows(UnsupportedOperationException.class, () -> container.store());
    }

    @Test
    public void testInvalidLocation() {
        PersistenceStrategyStream<Member> stream = new PersistenceStrategyStream<>();
        container.setPersistenceStrategy(stream);
        stream.setLocation("/directory/");

        try {
            container.addMember(new ConcreteMember(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows(PersistenceException.class, () -> container.store());
    }

    @Test
    public void testRoundTrip() {
        PersistenceStrategyStream<Member> stream = new PersistenceStrategyStream<>();
        container.setPersistenceStrategy(stream);

        Member m1 = new ConcreteMember(7);

        MemberView mv = new MemberView();

        assertEquals(0, container.size());
        try {
            //Füge ein Member hinzu
            container.addMember(m1);
            assertEquals(1, container.size());

            //Persistent abspeichern
            container.store();
            assertEquals(1, container.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Löschen des ersten Members
        container.deleteMember(7);
        assertEquals(0, container.size());


        //Daten wieder in den Container laden
        try {
            container.load();
            assertEquals(1, container.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
