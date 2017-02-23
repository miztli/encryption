package com.examples.java.encryption.symmetric.aes;

import java.security.Key;

/**
 * Created by miztli on 22/02/17.
 */
public interface SymmetricEncryption<T, E> {
    E encrypt(T data, Key key) throws SymmetricEncryptionException;
    E decrypt(T encryptedData, Key key) throws SymmetricEncryptionException;
}
