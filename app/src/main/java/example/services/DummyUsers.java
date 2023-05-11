package example.services;
import com.google.gson.Gson;

public class DummyUsers {
    private DummyUser[] users;

    public DummyUser[] getDummyUsers() {
        return users;
    }

    /**
     * Converts a JSON string to a DummyUsers object using GSon.
     *
     * @param json the JSON string to convert
     * @return the DummyUsers object
     */
    public static DummyUsers fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyUsers.class);
    }
}