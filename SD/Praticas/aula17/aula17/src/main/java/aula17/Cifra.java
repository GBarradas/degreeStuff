/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula17;
import java.security.InvalidKeyException;
import java.security.Security;
import javax.crypto.KeyGenerator;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import java.security.Signature;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.security.cert.X509Certificate;

/**
 *
 * @author barradas
 */
public class Cifra {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Provider[] pvdrs = Security.getProviders();
        /*
        for(Provider pvdr : pvdrs){
            System.out.println("= "+pvdr);
            System.out.println("\t name: "+pvdr.getName());
            System.out.println("\t version: " + pvdr.getVersionStr());
        }*/
        
        //System.out.println(pvdrs[0].getServices());
        /*
        Set<String> alg =  Security.getAlgorithms("Cipher");
        for (String a : alg){
            System.out.println(a);
        }
        */
        KeyGenerator key = KeyGenerator.getInstance("AES");
        SecretKey sKey = key.generateKey();
        System.out.println(sKey.getFormat());
        
        Cipher cipher;

        cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, sKey);
        /* para vários blocos usar-se-ia o método update() (multiple-part encryption)
           até ao penúltimo bloco, seguido de doFinal()
        */
        String MSG = "Teste";
        byte[] plaintext = MSG.getBytes();
        byte[] ciphertext = cipher.doFinal( plaintext );  // cifrar num "bloco" só

        // teste rápido para ver o q fica, que não será visível:
        System.out.println( new String(ciphertext) );
        
    }
    
    
}
