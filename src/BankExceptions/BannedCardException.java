package BankExceptions;

public class BannedCardException extends BankOnlineException {
    public BannedCardException(String msg) {
        super(msg);
    }

}
