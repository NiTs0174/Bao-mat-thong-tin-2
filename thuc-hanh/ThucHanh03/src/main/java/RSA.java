/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.Random;
import java.io.*;

/**
 *
 * @author admin
 */
public class RSA {
        /*Bit length of each prime number.*/
        int primeSize ;
        /*Two distinct large prime numbers p and q q.*/
        BigInteger p, q;
        /*Modulus N.*/
        BigInteger N ;
        /*r = (P 1) (4-1)*/
        BigInteger r;
        /* Public exponent E and Private exponent D*/
        BigInteger E, D ;
//---------------------CoNSTRUCTOR------------------------------------
    public RSA(){}    
    public RSA ( int primeSize)
    {
        this.primeSize = primeSize ;
        // Generate two distinct large prime numbers p and q 
        generatePrimeNumbers();
        // Generate Public and Private Keys.
        generatePublicPrivateKeys();
    }
//---------------------------------------------------------
    public void generatePrimeNumbers()
    {
        p = new BigInteger (primeSize, 10, new Random()); 
        do
        {
            q = new BigInteger (primeSize, 10, new Random());
        }
        while(q.compareTo( p ) == 0);
    }
    /* Generate Public and Private Keys.*/
//---------------------------------------------------------
    public void generatePublicPrivateKeys ()
    {
        // N = p q
        N = p.multiply(q);
        // r = (p-1) (q-1)
        r = p.subtract(BigInteger.valueOf( 1));
        r = r.multiply (q.subtract( BigInteger.valueOf( 1 )));
        // Choose E, coprime to and less than r
        do
        {
            E = new BigInteger ( 2 * primeSize, new Random());
        }
        while((E.compareTo(r) != -1) || (E.gcd (r).compareTo( BigInteger.valueOf(1)) != 0)); 
        // Compute D, the inverse of E mod r
        D = E.modInverse(r);
    }
//---------------------------------------------------------   
    public BigInteger [] encrypt (String message)
    {
        int i;
        byte[] temp = new byte[1];
        
        byte[] digits = message.getBytes();
        
        BigInteger[] bigdigits = new BigInteger [digits.length]; 
        
        for(i=0; i < bigdigits.length; i++)
        {
            temp [0]= digits[i];
            bigdigits[i] = new BigInteger ( temp ) ;
        }
        
        BigInteger[] encrypted = new BigInteger [bigdigits.length];
        for(i=0; i < bigdigits.length; i++ )
            encrypted[i] = bigdigits[i].modPow( E, N); 
        
        return( encrypted) ;
    }
//---------------------------------------------------------   
    public BigInteger[] encrypt(String message, BigInteger userD, BigInteger userN)
    {
        int i;
        byte[] temp = new byte[1];
        
        byte[] digits = message.getBytes();
        
        BigInteger[] bigdigits=new BigInteger [digits.length];
        
        for (i=0; i < bigdigits.length; i++)
        {
            temp [0]= digits[i];
            bigdigits[i]= new BigInteger( temp ) ;
        }
        BigInteger [] encrypted = new BigInteger [bigdigits.length]; 
        for(i=0; i < bigdigits.length; i++)
            encrypted[i]= bigdigits[i].modPow( userD, userN);
        return( encrypted );
    }
//---------------------------------------------------------  
    public String decrypt( BigInteger [] encrypted, BigInteger D, BigInteger N)
    {
        int i;
        BigInteger [] decrypted = new BigInteger [encrypted.length] ; 
        for(i=0; i < decrypted.length; i++ )
        {
            decrypted[i] = encrypted[i].modPow( D, N);            
        }
        char[] charArray = new char[decrypted.length];
        
        for(i=0; i < charArray.length; i++)
            charArray[i] = (char) (decrypted[i].intValue());
        
        return (new String (charArray));
    }
//---------------------------------------------------------  
        public BigInteger getp()
        {
            return(p);
        }
        public BigInteger getq()
        {
            return(q);
        }
        public BigInteger getr()
        {
            return(r);
        }
        public BigInteger getN()
        {
            return(N);
        }
        public BigInteger getE()
        {
            return(E);
        }
        public BigInteger getD()
        {
            return(D);
        }
//---------------------------------------------------------  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int primeSize =8;
        // Generate Public and Private Keys
        RSA rsa = new RSA ( primeSize) ;
        System.out.println( "Key Size: ["+primeSize + "]");
        System.out.println("Generated prime numbers p and q" );
        System.out.println("");
        System.out.println( "p: ["+ rsa.getp().toString( 16 ).toUpperCase() + "]");
        System.out.println( "q: ["+rsa.getq().toString( 16 ).toUpperCase() + "]");
        System.out.println("");
        System.out.println( "The public key is the pair (N, E) which will be published."); 
        System.out.println("N: ["+rsa.getN().toString( 16 ).toUpperCase() + "]"); 
        System.out.println( "E: ["+rsa.getE().toString( 16 ).toUpperCase() + "]");
        System.out.println("");
        System.out.println("The private key is the pair (N, D) which will be kept private."); 
        System.out.println("N: ["+rsa.getN().toString( 16 ).toUpperCase() + "]"); 
        System.out.println( "D: ["+rsa.getD().toString( 16 ).toUpperCase() + "]");
        System.out.println("");
        // Get message (plaintext) from user
        System.out.println( "Please enter message (plaintext):");
        String plaintext = (new BufferedReader( new InputStreamReader(System.in))).readLine();
        System.out.println( "" );
        // Encrypt Message
        BigInteger[] ciphertext = rsa.encrypt (plaintext); 
        System.out.print("Ciphertext: [");
        for (int i = 0; i < ciphertext.length; i++ )
        {
            System.out.print( ciphertext[i].toString( 16 ).toUpperCase());
            if(i!= ciphertext.length-1);
                System.out.print("");
        }
        System.out.println("1"); 
        System.out.println("");
        RSA rsal = new RSA (8);
        String recoveredPlaintext = rsal.decrypt( ciphertext,rsa.getD (), rsa.getN()); 
        System.out.println( "Recovered plaintext: ["+ recoveredPlaintext + "]");
    }    
}
