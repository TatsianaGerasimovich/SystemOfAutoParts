package by.bsuir.gerasimovich.dao;

/**
 * @author Tatiana
 * @version 1.00 01.05.2015.
 */
public class FactoryException extends Exception {

    public FactoryException() {
    }

    public FactoryException(String message) {
        super(message);
    }

    public FactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryException(Throwable cause) {
        super(cause);
    }

    public FactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

