package com.examples.java.encryption.symmetric.aes.utils;

import com.examples.java.encryption.symmetric.aes.KeyType;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by miztli on 23/02/17.
 */
public class EncryptionUtils {
    public static Key generateKey(KeyType keyType, int size) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator;
        switch (keyType){
            case AES:
                keyGenerator = KeyGenerator.getInstance("AES");
                break;
            case DES:
                keyGenerator = KeyGenerator.getInstance("DES");
                break;
            default:
                keyGenerator = KeyGenerator.getInstance("AES");
                break;
        }
        keyGenerator.init(size);
        return keyGenerator.generateKey();
    }

}
