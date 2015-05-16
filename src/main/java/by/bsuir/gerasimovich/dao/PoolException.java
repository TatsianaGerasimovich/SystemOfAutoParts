package by.bsuir.gerasimovich.dao;

/**
 * @author Tatiana
 * @version 1.00 01.05.2015.
 */
public class PoolException extends Exception {

    public PoolException() {
    }

    public PoolException(String message) {
        super(message);
    }

    public PoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolException(Throwable cause) {
        super(cause);
    }

    public PoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
