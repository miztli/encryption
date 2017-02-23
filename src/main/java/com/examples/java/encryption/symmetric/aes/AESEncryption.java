package com.examples.java.encryption.symmetric.aes;

import com.examples.java.encryption.symmetric.aes.utils.EncryptionUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * Created by miztli on 22/02/17.
 */
public class AESEncryption extends AbstractSymmetricEncryptor<String, String>{
    public static String AES_CBC_NoPadding = "AES/CBC/NoPadding"; /*Requires IVC*/
    public static String AES_CBC_PKCS5Padding = "AES/CBC/PKCS5Padding"; /*Requires IVC*/
    public static String AES_ECB_NoPadding = "AES/ECB/NoPadding"; /*Do no require IVC*/
    public static String AES_ECB_PKCS5Padding = "AES/ECB/PKCS5Padding"; /*Do no require IVC*/

    public AESEncryption(String transformation) throws SymmetricEncryptionException {
        super(transformation);
    }

    public AESEncryption(String transformation, Provider provider) throws SymmetricEncryptionException {
        super(transformation, provider);
    }

    public synchronized String encrypt(String data, Key key) throws SymmetricEncryptionException {
        try {
            getCipher().init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = getCipher().doFinal(data.getBytes("UTF-8"));
            return new BASE64Encoder().encode(encryptedData);
        } catch (InvalidKeyException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES encryption: " + e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES encryption: " + e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES encryption: " + e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES encryption: " + e.getMessage(), e);
        }
    }

    public synchronized String decrypt(String encryptedData, Key key) throws SymmetricEncryptionException {
        try {
            getCipher().init(Cipher.DECRYPT_MODE, key);
            byte[] data = getCipher().doFinal(new BASE64Decoder().decodeBuffer(encryptedData));
            return new String(data);
        } catch (InvalidKeyException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES decryption: " + e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES decryption: " + e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES decryption: " + e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES decryption: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new SymmetricEncryptionException("An error occurred during the AES decryption: " + e.getMessage(), e);
        }
    }

}
