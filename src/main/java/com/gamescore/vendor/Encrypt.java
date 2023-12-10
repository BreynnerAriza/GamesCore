package com.gamescore.vendor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Encrypt {

    private final static String SALT = "f616506655688890fad93c1e0d5ad9c63f066f92";

    //Metodo para obtenre una llave de encriptacion / desencriptacion
    private static SecretKeySpec crearClave() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = SALT.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretKey;
    }

    //Metodo para encriptar
    public static String encriptar(String datos) {
        try {
            SecretKeySpec secretKey = crearClave();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] datosEncriptar = datos.getBytes("UTF-8");
            byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
            String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
            return encriptado;
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
    //Metodo para desencriptars
    public static String desencriptar(String datosEncriptados){
        try {
            SecretKeySpec secretKey = crearClave();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
            byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
            String datos = new String(datosDesencriptados);
            return datos;
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
}
