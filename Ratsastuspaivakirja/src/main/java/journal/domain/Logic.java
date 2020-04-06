/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.domain;

import java.util.ArrayList;
import java.util.Scanner;
import journal.domain.Horse.Gender;

/**
 *
 * @author lautanas
 */
public class Logic {
    private Scanner reader;
    private boolean signedIn;
    private boolean quit;
    private Database db;
    private ArrayList<User> users;
    private User currentUser;
    
    public Logic() {
        this.reader = reader;

    }
    
    public boolean signIn(String user, ArrayList<User> users) {

        int userFound = -1;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user)) {
                userFound = i;
                break;
            }
        }

        if (userFound > -1) {
            System.out.println("Signing in.");
            this.currentUser = users.get(userFound);
            return true;
        } else {
            System.out.println("User was not found. Try again (1), create new user (2) or quit (3)");
            return false;
        }
    }
    
    public User createUser(String name, ArrayList<User> users) {

        boolean userFound = false;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                userFound = true;
                break;
            }
        }

        if (userFound) {
            System.out.println("User name already exists.");
            return null;
        } else {
            User newUser = new User(name);
            System.out.println("New user " + name + " created.");
            return newUser;
        }
    }
    
    public Horse createHorse(String name, ArrayList<Horse> horses) {
        boolean horseFound = false;
        
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getName().equals(name)) {
                horseFound = true;
                break;
            }
        }

        if (horseFound) {
            System.out.println("Horse already exists.");
            return null;
        } else {
            Horse newHorse = new Horse(name);
            System.out.println("New horse " + name + " created.");
            return newHorse;
        }
    }
    
    public Horse addHorseInformation(Horse horse) {
        Horse newHorse = new Horse(horse.getName());
        System.out.println("Add optional information:");
        System.out.println("Gender: ");
        Gender gender = Gender.valueOf(reader.nextLine());
        System.out.println("Year of birth: ");
        int year = Integer.parseInt(reader.nextLine());
        
        newHorse.setGender(gender);
        newHorse.setYearOfBirth(year);
        
        return newHorse;
    }
    
    public void getHorseInformation(String horse, ArrayList<Horse> horses) {
        int index = -1;
        
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getName().equals(horse)) {
                index = i;
            }
        }
        
        if (index == -1) {
            System.out.println("Horse " + horse + " was not found.");
        } else {
            horses.get(index).printInformation();
        }
        
    }
}
