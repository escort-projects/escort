package org.escort.exception;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:53
 */
public class EscortRuntimeException extends RuntimeException {

    public EscortRuntimeException() {
    }

    public EscortRuntimeException(String message) {
        super(message);
    }

    public EscortRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EscortRuntimeException(Throwable cause) {
        super(cause);
    }

    public EscortRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
