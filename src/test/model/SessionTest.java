package model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class SessionTest {
    private Session testSession;
    private User testUser;

    @Before
    public void runBefore() {
        testUser = User.getTestuser();
        testSession = Session.sessionInitializer(testUser);
    }

    @Test 
    public void testgetCurrentUserLoggedIn() {
        assertSame(testSession.getCurrentUserLoggedIn(), testUser);
    }

    @Test
    public void testsetCurrentUserLoggedIn() {
        testSession.setCurrentUserLoggedIn(null);
        assertSame(testSession.getCurrentUserLoggedIn(), null);
    }

}
