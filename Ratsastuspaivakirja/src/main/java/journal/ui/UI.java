package journal.ui;

import journal.domain.Database;
import journal.domain.Logic;
import journal.domain.User;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import journal.domain.Horse;

public class UI {

    private Scanner reader;
    private boolean signedIn;
    private boolean quit;
    private Database db;
    private ArrayList<User> users;
    private ArrayList<Horse> horses;
    private User currentUser;
    private Logic logic;
    private Map<String, String> commands;
    private Map<String, String> userCommands;

    public UI(Scanner reader, Logic logic) {
        this.reader = reader;
        this.signedIn = false;
        this.quit = false;
        this.db = db;
        this.users = new ArrayList<>();
        this.horses = new ArrayList<>();
        this.logic = logic;

        userCommands = new TreeMap<>();
        userCommands.put("1", "1) Sign in");
        userCommands.put("2", "2) Create a new user");
        // Tähän väliin lisää toimintoja
        userCommands.put("x", "x) Quit");

        commands = new TreeMap<>();
        commands.put("0", "0) List commands");
        commands.put("1", "1) Create a new horse");
        commands.put("2", "2) Get horse's information");
        commands.put("x", "x) Quit");
    }

    public void start() {
        while (!signedIn) {
            userMenu();
        }

        while (true) {
            if (quit) {
                return;
            } else {
                mainMenu();
            }
        }
    }
    
    public void userMenu() {
        for (Entry<String,String> entry : userCommands.entrySet()) {
            System.out.println(entry.getValue());
        }
        userMenuCommands();
    }

    public void mainMenu() {
        for (Entry<String,String> entry : commands.entrySet()) {
            System.out.println(entry.getValue());
        }

        mainMenuCommands();
    }

    public void mainMenuCommands() {
        System.out.println("Enter command: ");
        String command = reader.nextLine();
        
        if(!commands.keySet().contains(command)) {
            System.out.println("Invalid command.");
            mainMenuCommands();
        }

        // Lisää toimintoja lisätään myöhemmin
        if (command.equals("0")) {
            mainMenu();
        } else if (command.equals("1")) {
            Horse newHorse = logic.createHorse(horses);
            // Tilapäinen ratkaisu
            if (newHorse != null) {
                horses.add(newHorse);
            }
        } else if (command.equals("2")) {
           logic.getHorseInformation(horses);
        } else if (command.equals("x")) {
            quit = true;
            return;
        }
    }

    public void userMenuCommands() {
        System.out.println("Enter command: ");
        String command = reader.nextLine();
        
        if(!userCommands.keySet().contains(command)) {
            System.out.println("Invalid command.");
            userMenuCommands();
        }
        
        if (command.equals("1")) {
            signedIn = logic.signIn(users);
        } else if (command.equals("2")) {
            User user = logic.createUser(users);
            
            // Tilapäinen ratkaisu
            if (user != null) {
                users.add(user);
            }
        } else if (command.equals("x")) {
            this.quit = true;
            return;
        }
    }

    

}
