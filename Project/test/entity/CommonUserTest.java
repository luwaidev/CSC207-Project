package entity;

import entity.CommonUser;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommonUserTest {

    private CommonUser commonUser;
    private final String name = "TestUser";
    private final String password = "TestPassword";
    private LocalDateTime creationTime;

    @Before
    public void setUp() {
        creationTime = LocalDateTime.now();
        commonUser = new CommonUser(name, password, creationTime);
    }

    @Test
    public void testConstructor() {
        assertEquals("Constructor does not set name correctly", name, commonUser.getName());
        assertEquals("Constructor does not set password correctly", password, commonUser.getPassword());
        assertEquals("Constructor does not set creation time correctly", creationTime, commonUser.getCreationTime());
    }

    @Test
    public void testGetName() {
        assertEquals("getName method does not return the correct name", name, commonUser.getName());
    }

    @Test
    public void testGetPassword() {
        assertEquals("getPassword method does not return the correct password", password, commonUser.getPassword());
    }

    @Test
    public void testGetCreationTime() {
        assertEquals("getCreationTime method does not return the correct creation time", creationTime, commonUser.getCreationTime());
    }
}