/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT_NangCao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;

/**
 *
 * @author nhoct
 */
public class Dec_RSA {    
    public static void main(String args[]) throws Exception{
        //doc van ban da ma hoa
        BufferedReader in= new BufferedReader
                            (new InputStreamReader
                            (new FileInputStream("D:\\Enc_RSA.dat"))); 
        String ctext=in.readLine();
        // chuyển sang kiểu biginteger
        BigInteger c=new BigInteger (ctext);
        //doc khóa private key
        FileInputStream f=new FileInputStream("D:\\Skey_RSA_priv.dat"); 
        //Sử dụng hàm readObject của ChjectInputStream 
        //để đọc dữ liệu từ tập tin nhị phân lên.
        //Thủ tự đọc cần đảm bảo đúng với thứ tự ghi 
        ObjectInputStream b=new ObjectInputStream(f); 
        RSAPrivateKey prk=(RSAPrivateKey) b.readObject(); 
        BigInteger d=prk.getPrivateExponent();
        BigInteger n=prk.getModulus();
        System.out.println("d="+d);
        System.out.println("="+n);
        BigInteger m=c.modPow (d,n);
        System.out.println("m= "+m);
        byte[] mt=m.toByteArray(); 
        System.out.println("PlainText is ");
        for (int i=0;i<mt.length; i++) {
            System.out.print((char) mt[i]);
        }
    }
}
