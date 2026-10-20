package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        assertTrue(login.checkUsername("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUsername("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity_Success() {
        assertTrue(login.checkPassword("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_Failure() {
        assertFalse(login.checkPassword("password"));
    }

    @Test
    public void testCheckCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCell("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCell("08966553"));
    }

    @Test
    public void testRegisterUserSuccess() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result.contains("successfully"));
        
    }
    @Test
public void testReturnLoginStatus() {
    login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
    boolean success = login.loginUser("kyl_1", "Ch&&sec@ke99!");
    assertTrue(success);
}
}
