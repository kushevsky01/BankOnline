package BankExceptions;

public class BankOnlineException extends Exception {
    String message;

    public BankOnlineException(String msg) {
        this.message = msg;
    }

    public void Message() {
        System.out.println("Error : " + message);
    }
}
