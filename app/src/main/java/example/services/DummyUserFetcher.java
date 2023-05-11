package example.services;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DummyUserFetcher {
    /**
     * Fetches a user from the dummyJSON API.
     * GET: https://dummyjson.com/users/{id}
     *
     * @param id the ID of the user to fetch
     * @return the DummyUser object
     */
    public DummyUser fetchDummyUser(int id) {
        try {
            // Construct the URL.
            URL url = new URL("https://dummyjson.com/users/" + id);
            // Open connection and read response.
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            int responseCode = httpConnection.getResponseCode();
            // Check that the response code is OK before reading the response.
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // In HTTP URL connections, the response body is an input stream.
                InputStream in = new BufferedInputStream(httpConnection.getInputStream());
                String response = Utils.inputStreamToString(in);
                System.out.println(response);
                return DummyUser.fromJson(response);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fetches multiple users from the dummyJSON API.
     * GET: https://dummyjson.com/users
     *
     * @return the DummyUser[] object
     */
    public DummyUser[] fetchDummyUsers() {
        try {
            URL url = new URL("https://dummyjson.com/users");
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(httpConnection.getInputStream());
                String response = Utils.inputStreamToString(in);
                return DummyUsers.fromJson(response).getDummyUsers();
            } else {
                System.out.println("Error: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}