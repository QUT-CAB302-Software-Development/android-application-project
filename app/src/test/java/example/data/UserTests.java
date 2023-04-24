package example.data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
    private User user;

    @BeforeEach
    void setUp() throws InvalidUserException {
        user = new User("name", "Pass0", "email@example.com");
    }

    @Test
    void testUserConstructor(){
        assertEquals("email@example.com", user.getEmail());
        assertEquals("Pass0", user.getPassword());
        assertEquals("email@example.com", user.getEmail());
    }

    @Test
    void testUserSetName(){
        user.setName("newName");
        assertEquals("newName", user.getName());
    }

    @Test
    void testUserSetPassword() throws InvalidUserException {
        user.setPassword("NewPass0");
        assertEquals("NewPass0", user.getPassword());
    }

    @Test
    void testUserSetEmail() throws InvalidUserException {
        user.setEmail("newEmail@example.com");
        assertEquals("newEmail@example.com", user.getEmail());
    }

    @Test
    void testInvalidEmailMissingAtSymbol() {
        assertThrows(InvalidUserException.class, () -> user.setEmail("example.com"));
    }

    @Test
    void testInvalidEmailTooManyAtSymbols(){
        assertThrows(InvalidUserException.class, () -> user.setEmail("email@example@com"));
    }

    @Test
    void testInvalidPasswordTooShort(){
        assertThrows(InvalidUserException.class, () -> user.setPassword("Ps0"));
    }

    @Test
    void testInvalidPasswordNoNumber(){
        assertThrows(InvalidUserException.class, () -> user.setPassword("Password"));
    }

    @Test
    void testInvalidPasswordNoUppercase(){
        assertThrows(InvalidUserException.class, () -> user.setPassword("pass0"));
    }

    @Test
    void testInvalidPasswordNoLowercase(){
        assertThrows(InvalidUserException.class, () -> user.setPassword("PASS0"));
    }

    @Test
    void testInvalidUserConstructor(){
        // Invalid email
        assertThrows(InvalidUserException.class, () -> new User("name", "Pass0", "example.com"));
        // Invalid password
        assertThrows(InvalidUserException.class, () -> new User("name", "Ps0", "email@example.com"));
    }

    @Test
    void testInvalidUserConstructorInvalidPassword(){
        assertThrows(InvalidUserException.class, () -> new User("name", "Ps0", "email@example.com"));
    }
}
