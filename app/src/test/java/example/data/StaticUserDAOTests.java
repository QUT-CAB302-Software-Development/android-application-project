package example.data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaticUserDAOTests {

    private UserDAO userDAO;

    @BeforeEach
    void setUp(){
        userDAO = new StaticUserDAO();
    }

    @AfterEach
    void tearDown(){
        for (User user : userDAO.listUsers()){
            userDAO.deleteUser(user.getEmail());
        }
        userDAO.close();
    }

    @Test
    void testAddUser() throws InvalidUserException {
        User user = new User("name", "Pass0", "email@example.com");
        userDAO.addUser(user);
        // Check that there is one user in the database
        assertEquals(1, userDAO.listUsers().size());
    }

    @Test
    void testGetUser() throws InvalidUserException {
        addTwoUsers();
        // Check that the user is found.
        assertEquals("name", userDAO.getUser("email@example.com").getName());
    }

    @Test
    void testGetUserNotFound() throws InvalidUserException {
        addTwoUsers();
        // Check that the email3 is not found.
        assertNull(userDAO.getUser("email3@example.com"));
    }

    @Test
    void testDeleteUser() throws InvalidUserException {
        addTwoUsers();
        userDAO.deleteUser("email@example.com");
        // Check that the user was deleted, and that there is only one user left.
        assertNull(userDAO.getUser("email@example.com"));
        assertEquals(1, userDAO.listUsers().size());
    }

    @Test
    void testUpdateUser() throws InvalidUserException {
        addTwoUsers();
        User updatedUser = new User("name3", "Pass03", "email@example.com");
        userDAO.updateUser(updatedUser);
        // Check that the user was updated.
        assertEquals(updatedUser, userDAO.getUser("email@example.com"));
    }

    private void addTwoUsers() throws InvalidUserException {
        User user = new User("name", "Pass0", "email@example.com");
        User user2 = new User("name2", "Pass02", "email2@example.com");
        userDAO.addUser(user);
        userDAO.addUser(user2);
    }
}
