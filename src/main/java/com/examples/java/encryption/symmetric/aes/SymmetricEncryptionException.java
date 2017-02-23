package com.examples.java.encryption.symmetric.aes;

/**
 * Created by miztli on 22/02/17.
 */
public class SymmetricEncryptionException extends Exception {
    public SymmetricEncryptionException() {
        super();
    }

    public SymmetricEncryptionException(String message) {
        super(message);
    }

    public SymmetricEncryptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SymmetricEncryptionException(Throwable cause) {
        super(cause);
    }

    protected SymmetricEncryptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
