package by.bsuir.gerasimovich.logic;

/**
 * @author Tatiana
 * @version 1.00 01.05.2015.
 */
public class CommandException extends Exception {

    public CommandException() {
    }

    public CommandException (String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }

    public CommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

