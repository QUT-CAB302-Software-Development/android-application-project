package example.application;

import example.data.*;
import example.services.DummyUser;
import example.services.DummyUserFetcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DummyFetcherTests {
    private DummyUserFetcher dummyFetcher;

    @BeforeEach
    void setUp() {
        dummyFetcher = new DummyUserFetcher();
    }

    @Test
    void testGetDummyUsers() {
        // Check that there are 10 dummy users.
        DummyUser[] users = dummyFetcher.fetchDummyUsers();
        assertEquals(30, users.length);
    }

    @Test
    void testGetFirstDummyUser(){
        // Check that the first dummy user has the correct name.
        DummyUser user = dummyFetcher.fetchDummyUser(1);
        assertEquals("atuny0@sohu.com", user.getEmail());
    }
}
