package example.data;

/**
 * Represents a user of the application.
 */
public class User {
    private String name;
    private String password;
    private String email;

    /**
     * Creates a new User.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @param email    The email of the user.
     */
    public User(String name, String password, String email) throws InvalidUserException {
        this.name = name;
        this.setEmail(email);
        this.setPassword(password);
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name of the user.
     *
     * @param newName The new name of the user.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public void setEmail(String email) throws InvalidUserException {
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new InvalidUserException("Email must contain only one @ symbol.");
        }
        this.email = email;
    }

    public void setPassword(String password) throws InvalidUserException {
        if (password.length() < 5) {
            throw new InvalidUserException("Password must be at least 5 characters long.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidUserException("Password must contain at least one number.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidUserException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidUserException("Password must contain at least one lowercase letter.");
        }
        this.password = password;
    }
}
