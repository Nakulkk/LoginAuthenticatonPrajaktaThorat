package auth;

public class LoginAuthentication {
    private final String validUser;
    private final String validPassword;

    public LoginAuthentication() {
        this.validUser = "admin";
        this.validPassword = "password123";
    }

    public LoginAuthentication(String validUser, String validPassword) {
        this.validUser = validUser;
        this.validPassword = validPassword;
    }

    public boolean authenticate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is mandatory");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is mandatory");
        }
        return username.equals(validUser) && password.equals(validPassword);
    }
}
