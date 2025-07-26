package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.User.User;

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
        Session testSession2 = Session.sessionInitializer(null);
        testSession2.setCurrentUserLoggedIn(testUser);
        assertSame(testSession2.getCurrentUserLoggedIn(), testUser);
    }

    @Test
    public void testisRunning() {
        testSession = Session.sessionInitializer(testUser);
        assertTrue(testSession.isRunning());
    }

    @Test
    public void testSetRunning() {
        testSession = Session.sessionInitializer(testUser);
        testSession.setRunning(false);
        assertFalse(testSession.isRunning());
    }

}
