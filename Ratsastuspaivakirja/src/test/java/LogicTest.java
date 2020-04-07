
import journal.domain.Logic;
import journal.domain.User;
import java.util.ArrayList;
import java.util.Scanner;
import journal.domain.Horse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import journal.ui.UI;

public class LogicTest {

    public LogicTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void cannotSignInWhenNoUsers() {
        Scanner reader = new Scanner("Test user");
        Logic logic = new Logic(reader);

        ArrayList<User> users = new ArrayList<>();
        boolean signedIn = logic.signIn(users);
        assertFalse(signedIn);
    }

    @Test
    public void createNewUserWorks() {
        Scanner reader = new Scanner("Test user");
        Logic logic = new Logic(reader);

        ArrayList<User> users = new ArrayList<>();
        User user = logic.createUser(users);

        assertTrue(user != null);
    }
    
    @Test
    public void cannotCreateTwoUsersWithSameName() {
        Scanner reader = new Scanner("Test user");
        Logic logic = new Logic(reader);

        ArrayList<User> users = new ArrayList<>();
        User user1 = logic.createUser(users);
        if (user1 != null) {
        users.add(user1);
        }
        logic.setReader(new Scanner("Test user 2"));
        User user2 = logic.createUser(users);
        if (user2 != null) {
        users.add(user2);
        }
        logic.setReader(new Scanner("Test user"));
        User user3 = logic.createUser(users);
        if (user3 != null) {
        users.add(user3);
        }
        
        assertTrue(user3 == null);
        assertEquals(2, users.size());
    }
    
    @Test
    public void createNewHorseWorks() {
        Scanner reader = new Scanner("Test horse");
        Logic logic = new Logic(reader);

        ArrayList<Horse> horses = new ArrayList<>();
        Horse horse = logic.createHorse(horses);

        assertTrue(horse != null);
    }
    
    @Test
    public void cannotCreateTwoHorsesWithSameName() {
        Scanner reader = new Scanner("Test horse");
        Logic logic = new Logic(reader);

        ArrayList<Horse> horses = new ArrayList<>();
        Horse horse1 = logic.createHorse(horses);
        horses.add(horse1);
        logic.setReader(new Scanner("Test horse"));
        Horse horse2 = logic.createHorse(horses);
        
        assertTrue(horse2 == null);
        assertEquals(1, horses.size());
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @After
//    public void tearDown() {
//    }
}
