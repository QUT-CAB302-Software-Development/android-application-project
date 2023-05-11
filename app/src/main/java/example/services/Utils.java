package example.services;

import java.io.InputStream;

public class Utils {
    /**
     * Converts an InputStream to a String.
     * @param inputStream the InputStream to convert
     * @return the String representation of the InputStream
     */
    public static String inputStreamToString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int c = inputStream.read();
            while (c != -1) {
                stringBuilder.append((char) c);
                c = inputStream.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
