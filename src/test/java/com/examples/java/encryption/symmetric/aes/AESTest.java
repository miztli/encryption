package com.examples.java.encryption.symmetric.aes;

import com.examples.java.encryption.symmetric.aes.utils.EncryptionUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by miztli on 22/02/17.
 */
public class AESTest {

    //@Rule
    //public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAESEncryption() throws SymmetricEncryptionException, NoSuchAlgorithmException {
        //expectedException.expect(SymmetricEncryptionException.class);
        //expectedException.expect(NoSuchAlgorithmException.class);

        System.out.println("Testing AESEncryption");
        AESEncryption aesEncryption = new AESEncryption(AESEncryption.AES_ECB_PKCS5Padding);

        System.out.println("Creating Key");
        Key key = EncryptionUtils.generateKey(KeyType.AES, AESKey.BITS_128);
        System.out.println("Generated key: ");
        byte[] binary = key.getEncoded();
        String text = String.format("%032X", new BigInteger(+1, binary));
        System.out.println(text);

        System.out.println("Encrypting String: Hola mundo");
        String encryptedData = aesEncryption.encrypt("Hola Mundo", key);
        System.out.println("Encrypted String: " + encryptedData);

        System.out.println("Decrypting String: " + encryptedData);
        System.out.println("Decrypted String: " + aesEncryption.decrypt(encryptedData, key));

    }
}
