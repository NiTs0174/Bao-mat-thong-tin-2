/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT_NangCao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author nhoct
 */
public class Skey_RSA {    
    public static void main(String args[]) throws Exception{
        // KeyPairGenerator: giúp tạo ra các cặp key 
        KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA"); 
        kpg.initialize(1024);
        // public/private keypairs được dùng để khởi tạo phase của
        // quá trình đăng ký kẹp
        KeyPair kp=kpg.genKeyPair();
        PublicKey pbkey=kp.getPublic();
        PrivateKey prkey=kp.getPrivate();
        //Ghi file publickey
        FileOutputStream f1=new FileOutputStream("D:\\Skey_RSA_pub.dat");
        ObjectOutputStream b1=new ObjectOutputStream(f1);
        b1.writeObject (pbkey);
        // ghi file private key
        FileOutputStream f2=new FileOutputStream("D:\\Skey_RSA_priv.dat"); 
        ObjectOutputStream b2=new ObjectOutputStream(f2);
        b2.writeObject(prkey);
    }
}
