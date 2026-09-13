class InvalidUsernameException extends Exception {

    InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {

    InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {

    AccountLockedException(String message) {
        super(message);
    }
}

class LoginSystem {

    private String correctUsername = "admin";
    private String correctPassword = "1234";

    private int failedAttempts = 0;

    void login(String username, String password)
            throws InvalidUsernameException,
                   InvalidPasswordException,
                   AccountLockedException {

        if (failedAttempts >= 3) {
            throw new AccountLockedException(
                "Account is locked"
            );
        }

        if (!username.equals(correctUsername)) {
            failedAttempts++;
            throw new InvalidUsernameException(
                "Invalid username"
            );
        }

        if (!password.equals(correctPassword)) {
            failedAttempts++;
            throw new InvalidPasswordException(
                "Invalid password"
            );
        }

        failedAttempts = 0;

        System.out.println("Login successful");
    }
}

public class Seventh {

    public static void main(String[] args) {

        LoginSystem system = new LoginSystem();

        try {

            system.login("admin", "1111");

        }
        catch (InvalidUsernameException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
        catch (AccountLockedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Login attempt completed");
        }
    }
}