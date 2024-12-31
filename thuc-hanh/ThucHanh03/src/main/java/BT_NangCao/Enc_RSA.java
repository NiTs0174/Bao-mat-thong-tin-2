/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT_NangCao;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

/**
 *
 * @author nhoct
 */
public class Enc_RSA {    
    public static void main(String args[]) throws Exception{
        // chuoi can mã hóa
        String s= "Hello World!";
        //doc file public key
        FileInputStream f=new FileInputStream("D:\\Skey_RSA_pub.dat");
        ObjectInputStream b=new ObjectInputStream(f); 
        //Sử dụng hàm readObject của ObjectInputStream 
        // để đọc dữ liệu từ tập tin nhị phân lên. 
        //Thứ từ đọc cần đảm bảo đúng với thứ từ ghi 
        RSAPublicKey pbk= (RSAPublicKey)b.readObject(); 
        BigInteger e=pbk.getPublicExponent();
        BigInteger n=pbk.getModulus();
        System.out.println("e="+e);
        System.out.println("n= "+n);
        byte ptext[]=s.getBytes("UTF8"); 
        BigInteger m=new BigInteger(ptext); 
        BigInteger c=m.modPow(e,n);
        System.out.println("c= "+c);
        String cs=c.toString();
        BufferedWriter out= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Enc_RSA.dat"))); 
        out.write(cs, 0, cs.length());
        out.close();
    }
}
