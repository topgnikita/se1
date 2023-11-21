package org.hbrs.se1.ws23.uebung4.controller;

import org.hbrs.se1.ws23.uebung4.model.ContainerGeneric;
import org.hbrs.se1.ws23.uebung4.model.UserStory;
import org.hbrs.se1.ws23.uebung4.view.UserStoryView;

import java.io.PrintStream;
import java.util.Scanner;

public class InputDialog {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    ContainerGeneric<UserStory> container = ContainerGeneric.getInstance();
    UserStoryView uv = new UserStoryView();

    public void input() {
        ps.println("UserStory Programm bitte Befehle eingeben!(help für Hilfe)");

        while (true) {
            System.out.print("> ");
            String command = scanner.next().toLowerCase();

            switch (command) {
                case "enter":
                    enterUserStory(scanner, container,ps);
                    break;
                case "store":
                    try {
                        container.store();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ps.println("UserStorys persistent gespeichert.");
                    break;
                case "load":
                    try {
                        container.load();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ps.println("UserStorys geladen!");
                    break;
                case "dump":
                    uv.dump(container.getCurrentList());
                    break;
                case "search":
                    String searchTerm = scanner.next();
                    System.out.println(searchUserStories(container, searchTerm.toLowerCase()));
                    break;
                case "exit":
                    System.out.println("Anwendung wird beendet.");
                    return;
                case "help":
                    displayHelp();
                    break;
                default:
                    System.out.println("Ungültiger Befehl. Tippe 'help' für Hilfe.");
            }
        }
    }

    private static void enterUserStory (Scanner sc, ContainerGeneric container,PrintStream ps) {
        UserStory us = new UserStory();
        ps.println("UserStory ID eingeben: ");
        us.setID(sc.nextInt());
        sc.nextLine();

        ps.println("UserStory Projekt eingeben: ");
        us.setProjekt(sc.nextLine());

        ps.println("UserStory Beschreibung eingeben: ");
        us.setBeschreibung(sc.nextLine());

        ps.println("UserStory Akzeptanzkriterien eingeben: ");
        us.setAkzeptanzkriterien(sc.nextLine());

        ps.println("UserStory Aufwand (Fibonacci-Zahl) eingeben: ");
        us.setAufwand(sc.nextInt());

        ps.println("UserStory Mehrwert (1-5) eingeben: ");
        us.setMehrwert(sc.nextInt());

        ps.println("UserStory Risiko (1-5) eingeben: ");
        us.setRisiko(sc.nextInt());

        ps.println("UserStory Strafe (1-5) eingeben: ");
        us.setStrafe(sc.nextInt());
        try {
            container.addUS(us);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String searchUserStories (ContainerGeneric<UserStory> container, String s){
        for(UserStory us : container.getCurrentList())  {
            if((us.getProjekt().toLowerCase()).equals(s)){
                return us.toString();
            }
        }
        return "Die UserStory mit dem Projekt " + s + " ist nicht vorhanden!";
    }

    private static void displayHelp () {
        System.out.println("Mögliche Befehle:");
        System.out.println("enter - Eingabe einer User Story");
        System.out.println("store - Persistentes Abspeichern von User Stories");
        System.out.println("load - Laden von User Stories in Container");
        System.out.println("dump - Ausgabe der User Stories nach Priorisierung");
        System.out.println("search - Suche nach User Stories (Projekten)");
        System.out.println("exit - Verlassen der Anwendung");
        System.out.println("help - Anzeige aller möglichen Befehle");
    }
}
