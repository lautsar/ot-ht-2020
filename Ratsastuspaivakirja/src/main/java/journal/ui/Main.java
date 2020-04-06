package journal.ui;

import journal.ui.UI;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import journal.domain.Logic;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Logic logic = new Logic();
        
        UI ui = new UI(reader, logic);
        ui.start();
    }
}
