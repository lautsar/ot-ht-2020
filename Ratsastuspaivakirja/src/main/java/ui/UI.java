package ui;

import domain.Database;
import domain.Logic;
import domain.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private Scanner reader;
    private boolean signedIn;
    private boolean quit;
    private Database db;
    private ArrayList<User> users;
    private User currentUser;
    private Logic logic;

    public UI(Scanner reader) {
        this.reader = reader;
        this.signedIn = false;
        this.quit = false;
        this.db = db;
        this.users = new ArrayList<>();
        this.logic = new Logic(reader);
    }

    public void start() {
        while (true) {
            if (quit) {
                return;
            } else if (!signedIn) {
                manageUsers();
            } else {
                mainMenu();
            }
        }
    }

    public void mainMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Manage horses");
        System.out.println("2) Manage lessons");
        System.out.println("3) See statistics");
        System.out.println("4) Quit");

        mainMenuCommands();
    }

    public void mainMenuCommands() {
        System.out.print("Enter command (1-4): ");
        String command = reader.nextLine();

        if (command.equals("1")) {
            manageHorses();
        } else if (command.equals("2")) {
            manageLessons();
        } else if (command.equals("3")) {
            seeStatistics();
        } else if (command.equals("4")) {
            quit = true;
            return;
        } else {
            System.out.println("Invalid command.");
        }
    }

    

    public void userChoices() {
        System.out.print("Enter command (1-3): ");
        String choice = reader.nextLine();
        if (choice.equals("1")) {
            System.out.print("Enter user name: ");
            String user = reader.nextLine();
            
            signedIn = logic.signIn(user, users);
        } else if (choice.equals("2")) {
            System.out.print("Give user name: ");
            String name = reader.nextLine();
            
            User user = logic.createUser(name, users);
            
            if (user != null) {
                users.add(user);
            }
        } else if (choice.equals("3")) {
            this.quit = true;
            return;
        } else {
            System.out.println("Invalid command. Enter command 1-3: ");
            userChoices();
        }
    }

    public void manageUsers() {
        System.out.println("1) Sign in");
        System.out.println("2) Create new user");
        System.out.println("3) Quit");
        System.out.println("");

        userChoices();
    }

    public void manageHorses() {
        System.out.println("Manage horses. Work in progress.");
    }

    public void manageLessons() {
        System.out.println("Manage lessons. Work in progress.");
    }

    public void seeStatistics() {
        System.out.println("See statistics. Work in progress.");
    }

}
