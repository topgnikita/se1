package org.hbrs.se1.ws23.uebung2.exception;

public class ContainerException extends Exception{
    public ContainerException(String nachricht) {
        super(nachricht);
    }
    public ContainerException( ) {
        super ("NULL-Werte dürfen nicht aufgenommen werden!");
    }
}
