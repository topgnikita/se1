package org.hbrs.se1.ws23.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
    private Integer id;
    public ConcreteMember(Integer id){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public String toString(){
        return "Member (ID = " + getID() +" )";
    }
}
