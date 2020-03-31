
import domain.Logic;
import domain.User;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.UI;

public class LogicTest {
    Logic logic;

    public LogicTest() {
    }

    @Before
    public void setUp() {
        Scanner reader = new Scanner(System.in);
        logic = new Logic(reader);
    }
    
    @Test
    public void cannotSignInWhenNoUsers() {
        ArrayList<User> users = new ArrayList<>();
        boolean signedIn = logic.signIn("Test user", users);
        assertFalse(signedIn);
    }
    
    @Test
    public void createNewUserWorks() {
        ArrayList<User> users = new ArrayList<>();
        User user = logic.createUser("Test user", users);
        
        assertTrue(user != null);
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
