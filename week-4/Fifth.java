class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    AccountNotFoundException(String message) {
        super(message);
    }
}

class Bank {

    private int balance = 5000;

    void checkAccount(int accountNumber)
            throws AccountNotFoundException {

        if (accountNumber != 1001) {
            throw new AccountNotFoundException(
                "Account not found"
            );
        }
    }

    void deposit(int amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be positive"
            );
        }

        balance += amount;

        System.out.println("Deposit successful");
    }

    void withdraw(int amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be positive"
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance"
            );
        }

        balance -= amount;

        System.out.println("Withdrawal successful");
    }

    void showBalance() {
        System.out.println("Balance = " + balance);
    }
}

public class Fifth {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            bank.checkAccount(1001);

            bank.deposit(2000);

            bank.withdraw(3000);

            bank.showBalance();

        }
        catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}