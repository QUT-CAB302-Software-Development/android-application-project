package example.services;

import com.google.gson.Gson;

public class DummyUser {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", password=" + password +
                "}";
    }

    /**
     * Converts a JSON string to a DummyUser object using GSon.
     *
     * @param json the JSON string to convert
     * @return the DummyUser object
     */
    public static DummyUser fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyUser.class);
    }
}