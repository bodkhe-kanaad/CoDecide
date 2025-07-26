package persistence;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DataStoreTest {

    @Test
    public void testGetAllUsers() {
        assertNotNull(DataStore.getAllUsers());
    }

    @Test
    public void testGetAllPolls() {
        assertNotNull(DataStore.getAllPolls());
    }
    
}
