import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAuthenticationTest {

    @Test
    void validateWithValidCredentials() {
        auth.LoginAuthentication loginAuthentication = new auth.LoginAuthentication("user","pass");
        assertTrue(loginAuthentication.authenticate("user","pass"));
    }

    @Test
    void validateWithInvalidCredentials() {
        auth.LoginAuthentication loginAuthentication = new auth.LoginAuthentication("user","pass");
        assertFalse(loginAuthentication.authenticate("user","wrong"));
    }

    @Test
    void validateUsernameEmpty() {
        auth.LoginAuthentication loginAuthentication = new auth.LoginAuthentication("user","pass");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> loginAuthentication.authenticate("", "pass"));
        assertEquals("Username is mandatory", ex.getMessage());
    }

    @Test
    void validatePasswordEmpty() {
        auth.LoginAuthentication loginAuthentication = new auth.LoginAuthentication("user","pass");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> loginAuthentication.authenticate("user", ""));
        assertEquals("Password is mandatory", ex.getMessage());
    }

    @Test
    void validatePasswordNull() {
        auth.LoginAuthentication loginAuthentication = new auth.LoginAuthentication("user","pass");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> loginAuthentication.authenticate("user", null));
        assertEquals("Password is mandatory", ex.getMessage());
    }
}
