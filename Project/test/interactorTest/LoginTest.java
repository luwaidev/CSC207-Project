package interactorTest;

import entity.CommonUserFactory;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import use_case.login.*;
import entity.UserFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private MockLoginUserDataAccessInterface userDataAccess;
    private MockLoginOutputBoundary outputBoundary;
    private LoginInteractor interactor;

    @Before
    public void setUp() {
        userDataAccess = new MockLoginUserDataAccessInterface();
        outputBoundary = new MockLoginOutputBoundary();
        interactor = new LoginInteractor(userDataAccess, outputBoundary);
    }

    @Test
    public void testSuccessfulLogin() {
        userDataAccess.addUser("testUser", "testPassword");

        interactor.execute(new LoginInputData("testUser", "testPassword"));

        assertEquals("testUser", outputBoundary.successUser);
    }

    @Test
    public void testNonExistentAccount() {
        interactor.execute(new LoginInputData("nonExistentUser", "password"));

        assertTrue(outputBoundary.failureMessage.contains("Account does not exist"));
    }

    @Test
    public void testIncorrectPassword() {
        userDataAccess.addUser("testUser", "testPassword");


        interactor.execute(new LoginInputData("testUser", "wrongPassword"));

        assertTrue(outputBoundary.failureMessage.contains("Incorrect password"));
    }

    @Test
    public void testSkipLogin() {
        userDataAccess.addUser("DEV", "testPassword");


        interactor.skipLogin();

        assertEquals("DEV", outputBoundary.successUser);
    }

    @Test
    public void testCreateAccount() {
        interactor.createAccount();

        assertTrue(outputBoundary.signupViewCalled);
    }
}

class MockLoginUserDataAccessInterface implements LoginUserDataAccessInterface {
    private Map<String, User> users = new HashMap<>();
    private UserFactory userFactory = new CommonUserFactory();


    @Override
    public boolean existsByName(String username) {
        return users.containsKey(username);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    // Utility method to add a user to the mock
    public void addUser(String username, String password) {
        User user = userFactory.create(username, password, LocalDateTime.now());
        users.put(username, user);
    }
}

// Mock for LoginOutputBoundary
class MockLoginOutputBoundary implements LoginOutputBoundary {
    String successUser;
    String failureMessage;
    boolean signupViewCalled = false;

    @Override
    public void prepareSuccessView(LoginOutputData user) {
        this.successUser = user.getUsername();
    }

    @Override
    public void prepareFailView(String error) {
        this.failureMessage = error;
    }

    @Override
    public void prepareSignupView() {
        this.signupViewCalled = true;
    }
}