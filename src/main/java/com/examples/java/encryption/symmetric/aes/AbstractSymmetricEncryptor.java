package com.examples.java.encryption.symmetric.aes;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * Created by miztli on 22/02/17.
 */
public abstract class AbstractSymmetricEncryptor<T, E> implements SymmetricEncryption<T, E> {

    private Cipher cipher;
    private Provider provider;
    private String transformation;

    protected AbstractSymmetricEncryptor(String transformation) throws SymmetricEncryptionException {
        try {
            this.cipher = Cipher.getInstance(transformation);
        }catch (NoSuchPaddingException e){
            throw new SymmetricEncryptionException("Could not intantiate SymmetricEncryptor: " + e.getMessage(), e);
        }catch (NoSuchAlgorithmException e){
            throw new SymmetricEncryptionException("Could not intantiate SymmetricEncryptor: " + e.getMessage(), e);
        }
        this.transformation = transformation;
    }
    protected AbstractSymmetricEncryptor(String transformation, Provider provider) throws SymmetricEncryptionException {
        try {
            this.cipher = Cipher.getInstance(transformation, provider);
        }catch (NoSuchPaddingException e){
            throw new SymmetricEncryptionException("Could not intantiate SymmetricEncryptor: " + e.getMessage());
        }catch (NoSuchAlgorithmException e){
            throw new SymmetricEncryptionException("Could not intantiate SymmetricEncryptor: " + e.getMessage());
        }
        this.provider = provider;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getTransformation() {
        return transformation;
    }

    public void setTransformation(String transformation) {
        this.transformation = transformation;
    }

    public enum Algorithm {
        AES
    }
}
