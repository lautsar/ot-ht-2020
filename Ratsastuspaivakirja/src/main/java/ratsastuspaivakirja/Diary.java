/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratsastuspaivakirja;

import java.util.Scanner;

public class Diary {

    private Scanner reader;

    public Diary(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        System.out.println("1) Sign in");
        System.out.println("2) Create new user");
        System.out.println("3) Quit");
        System.out.println("");

        choices();
    }

    public void signIn() {
        System.out.print("Enter user name: ");
        String user = reader.nextLine();

        if (user.equals("Koira")) {
            System.out.println("Signing in.");
        } else {
            System.out.println("User was not found. Try again (1), create new user (2) or quit (3)");
            choices();
        }
    }

    public void createUser() {
        System.out.print("Give user name: ");
        String user = reader.nextLine();

        if (user.equals("Kissa")) {
            System.out.println("User name already exists. Sign in (1), create new user (2) or quit (3)");
            choices();
        } else {
            System.out.println("New user " + user + " created. Sign in (1), create new user (2) or quit (3)");
            choices();
        }
    }

    public void choices() {
        System.out.print("Enter command (1-3): ");
        String choice = reader.nextLine();
        if (choice.equals("1")) {
            signIn();
        } else if (choice.equals("2")) {
            createUser();
        } else if (choice.equals("3")) {
            return;
        } else {
            System.out.println("Invalid command. Enter command 1-3: ");
            choices();
        }
    }

}
