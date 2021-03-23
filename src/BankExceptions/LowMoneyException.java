package BankExceptions;

public class LowMoneyException extends BankOnlineException {
    public LowMoneyException(String msg) {
        super(msg);
    }
}
