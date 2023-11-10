package homework.onlineStore.exception;

public class OutStockException extends Exception{
    public OutStockException() {
    }

    public OutStockException(String message) {
        super(message);
    }

    public OutStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutStockException(Throwable cause) {
        super(cause);
    }

    public OutStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
