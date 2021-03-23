package BankExceptions;

public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException(String msg) {
        super(msg);
    }
}
