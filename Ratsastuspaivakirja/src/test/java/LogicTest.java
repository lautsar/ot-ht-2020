
import journal.domain.Logic;
import journal.domain.User;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import journal.ui.UI;

public class LogicTest {
    Logic logic;

    public LogicTest() {
    }

    @Before
    public void setUp() {
        logic = new Logic();
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
