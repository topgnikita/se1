package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

public class Main {
    public static void init() {

        //CR3 Frage: Es handelt sich um das Strategy Pattern

        ContainerGeneric<Member> container = ContainerGeneric.getInstance();
        PersistenceStrategy<Member> stream = new PersistenceStrategyStream<>();
        container.setPersistenceStrategy(stream);
    }
}