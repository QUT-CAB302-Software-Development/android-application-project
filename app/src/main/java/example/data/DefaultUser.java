package example.data;

public class DefaultUser extends User {
    public DefaultUser() throws InvalidUserException {
        super("Guest", "Guest123", "guest@example.com");
    }
}
