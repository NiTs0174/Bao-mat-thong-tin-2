/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiKiemTra;

import BaiKiemTra.frmEnc;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Administrator
 */
public class frmDec extends javax.swing.JFrame {
//----------------------------------------------------------------
    //3DES---------------------
    public static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    KeySpec myKeySpec;
    SecretKeyFactory mySecretKeyFactory;
    Cipher cipher;
    byte[] keyAsBytes;
    public String myDecryptionKey;
    public String myEncryptionScheme; 
    SecretKey key;    
    public static final String DESEDE_DECRYPTION_SCHEME = "DESede";
    public String myDecryptionScheme;    
 //---------------------------------------------------------------
    /**
     * Creates new form frmEnc
     */
    public frmDec() {
        initComponents();
    }
//Function----------------------------------------------------------------------
    //3DES----
    // Decrypt 
    public String decrypt (String encryptedString) { 
        String decryptedText=null;
        try {
        cipher.init(Cipher. DECRYPT_MODE, key);
        BASE64Decoder base64decoder = new BASE64Decoder();
        byte[] encryptedText = base64decoder.decodeBuffer(encryptedString); 
        byte[] plainText = cipher.doFinal(encryptedText); 
        String a = new String (plainText);
        System.out.println("chuoi plaintext :"+a);
        //decryptedText= bytea2String (plainText);
        decryptedText=a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
    //DES-------
    //Hàm doCopy
    private static void doCopy (InputStream is, OutputStream os) throws IOException{
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }
    //Hàm Mã hóa   
    public static void encrypt (String key, InputStream is, OutputStream os) throws Throwable { 
        encryptOrDecrypt (key, Cipher.ENCRYPT_MODE, is, os);
    }  
    //Hàm Giải mã 
    public static void decrypt (String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt (key, Cipher.DECRYPT_MODE, is, os);
    }  
    //Hàm thực hiện    
    public static void encryptOrDecrypt (String key, int mode, InputStream is, OutputStream os) throws Throwable {
        DESKeySpec dks = new DESKeySpec (key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); 
        SecretKey desKey = skf.generateSecret (dks);
        Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher); 
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher); 
            doCopy(is, cos);
        }
    }
    //--------------------------------------
    // Phương thức tách chuỗi sau khi mã hóa
    private String[] splitEncryptedString(String encryptedString) {
        return encryptedString.split("\\*");
    }
    private String[] splitEncryptedString2(String encryptedString) {
        return encryptedString.split("\\@");
    }
    //---------------------------------------------
    // So sánh 2 chuỗi băm
    private String calculateHash(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(message.getBytes());
            byte[] byteData = md.digest();
            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : byteData) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//--------------------------------------------------------------    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtE1 = new javax.swing.JTextField();
        txtM2 = new javax.swing.JTextField();
        txtM3 = new javax.swing.JTextField();
        txtN1 = new javax.swing.JTextField();
        txtK3 = new javax.swing.JTextField();
        txtD3 = new javax.swing.JTextField();
        btnGiaiMaE3 = new javax.swing.JButton();
        btnTachChuoiD3 = new javax.swing.JButton();
        btnGiaiMaE1 = new javax.swing.JButton();
        btnBamChuoiN1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnKiemTraToanVen = new javax.swing.JButton();
        btnMoFileMaHoaE3 = new javax.swing.JButton();
        btnTachChuoiN1 = new javax.swing.JButton();
        txtE3 = new javax.swing.JTextField();
        txtH2 = new javax.swing.JTextField();
        txtH21 = new javax.swing.JTextField();
        txtM1 = new javax.swing.JTextField();
        txtK1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FROM DECRYPT");

        jLabel2.setText("Cipher (E3):");

        jLabel3.setText("Key Encrypt (K3):");

        jLabel4.setText("Decrypt (D3):");

        jLabel5.setText("Message (N1)");

        jLabel6.setText("Message Hash (H2)");

        jLabel7.setText("Message (M3):");

        jLabel8.setText("Key Encrypt (K1):");

        jLabel9.setText("Message (E1):");

        jLabel10.setText("Message (M2):");

        txtK3.setText("12345678");

        btnGiaiMaE3.setText("Giải mã E3");
        btnGiaiMaE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaE3ActionPerformed(evt);
            }
        });

        btnTachChuoiD3.setText("Tách chuỗi D3: M3 + M2 + N1");
        btnTachChuoiD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTachChuoiD3ActionPerformed(evt);
            }
        });

        btnGiaiMaE1.setText("Giải mã E1");
        btnGiaiMaE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaE1ActionPerformed(evt);
            }
        });

        btnBamChuoiN1.setText("Băm Chuỗi N1");
        btnBamChuoiN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBamChuoiN1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Message (M1):");

        jLabel12.setText("Hash (H2')");

        btnKiemTraToanVen.setText("Kiểm tra toàn vẹn");
        btnKiemTraToanVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraToanVenActionPerformed(evt);
            }
        });

        btnMoFileMaHoaE3.setText("Mở FILE mã hoá E3");
        btnMoFileMaHoaE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoFileMaHoaE3ActionPerformed(evt);
            }
        });

        btnTachChuoiN1.setText("Tách chuỗi N1: M2 + E1");
        btnTachChuoiN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTachChuoiN1ActionPerformed(evt);
            }
        });

        txtK1.setText("congnghethongtin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtD3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGiaiMaE3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtE3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoFileMaHoaE3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtM3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTachChuoiD3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtK3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtN1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtH2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtK1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtE1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtM2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTachChuoiN1)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnKiemTraToanVen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtM1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(txtH21))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBamChuoiN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGiaiMaE1))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnMoFileMaHoaE3)
                    .addComponent(txtE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtK3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGiaiMaE3))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnTachChuoiD3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTachChuoiN1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnGiaiMaE1)
                    .addComponent(txtM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnBamChuoiN1)
                    .addComponent(txtH21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnKiemTraToanVen)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------------------------------
    private void btnMoFileMaHoaE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoFileMaHoaE3ActionPerformed
        // TODO add your handling code here:
        try {
            //Mở File
            BufferedReader br = null;
            String fileName="M:\\EnDes2.txt";
            br = new BufferedReader (new FileReader (fileName)); 
            StringBuffer sb = new StringBuffer();
            
            char[] ca = new char [5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            String chuoi = sb.toString();
            txtE3.setText(chuoi);
            } catch (IOException ex) {
                ex.printStackTrace();
        }
    }//GEN-LAST:event_btnMoFileMaHoaE3ActionPerformed
    //------------------------------------
    private void btnGiaiMaE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaE3ActionPerformed
        // TODO add your handling code here:
        //DES
        FileInputStream fis2 = null;
        try {
            String fileName = "M:\\Des2.txt";
            String key= txtK3.getText();
            fis2= new FileInputStream("M:\\EnDes2.txt");
            FileOutputStream fos2= new FileOutputStream("M:\\DeDes2.txt");
            decrypt (key, fis2, fos2);
            
            BufferedReader br = null;
            br = new BufferedReader (new FileReader(fileName)); 
            StringBuffer sb = new StringBuffer(); 
            
            char[] ca = new char [5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            String chuoi = sb.toString();            
            txtD3.setText(chuoi);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnGiaiMaE3ActionPerformed
    //------------------------------------
    private void btnTachChuoiD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTachChuoiD3ActionPerformed
        // TODO add your handling code here:
        try {
            String encryptedText = txtD3.getText();
            String[] parts = splitEncryptedString(encryptedText);
            if (parts != null && parts.length == 3) {
                String N1 = parts[0];
                String H2 = parts[1];
                String M3 = parts[2];
                txtM3.setText(M3);
                txtH2.setText(H2);
                txtN1.setText(N1);
            } else {
                JOptionPane.showMessageDialog(null, "Chuỗi không hợp lệ!");
                // Reset the text fields
                txtM3.setText("");
                txtH2.setText("");
                txtN1.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTachChuoiD3ActionPerformed
    //------------------------------------
    private void btnTachChuoiN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTachChuoiN1ActionPerformed
        // TODO add your handling code here:
        try {
            String encryptedText = txtN1.getText();
            String[] parts = splitEncryptedString2(encryptedText);
            if (parts != null && parts.length == 2) {
                String E1 = parts[0];
                String M2 = parts[1];
                txtE1.setText(E1);
                txtM2.setText(M2);
            } else {
                JOptionPane.showMessageDialog(null, "Chuỗi không hợp lệ!");
                txtE1.setText("");
                txtM2.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTachChuoiN1ActionPerformed
    //------------------------------------
    private void btnGiaiMaE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaE1ActionPerformed
        // TODO add your handling code here:
        //3DES
        try{
            myDecryptionScheme = txtK1.getText();
            myDecryptionScheme = DESEDE_DECRYPTION_SCHEME;
            keyAsBytes = myDecryptionKey.getBytes(UNICODE_FORMAT); 
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory = SecretKeyFactory.getInstance(myDecryptionScheme);
            cipher = Cipher.getInstance(myDecryptionScheme);
            key= mySecretKeyFactory.generateSecret (myKeySpec); 
            
            String plainText = txtE1.getText();             
            String decrypted = decrypt (plainText); 
            txtM1.setText (decrypted);
        } catch (Exception ex) {
            System.out.println(""+ex);
        }
        
//        //DES
//        FileInputStream fis2 = null;
//        try {
//            String fileName = "M:\\Des1.txt";
//            String key= txtK1.getText();
//            fis2= new FileInputStream("M:\\EnDes1.txt");
//            FileOutputStream fos2= new FileOutputStream("M:\\DeDes1.txt");
//            decrypt (key, fis2, fos2);
//            
//            BufferedReader br = null;
//            br = new BufferedReader (new FileReader(fileName)); 
//            StringBuffer sb = new StringBuffer(); 
//            
//            char[] ca = new char [5];
//            while (br.ready()) {
//                int len = br.read(ca);
//                sb.append(ca, 0, len);
//            }
//            br.close();
//            String chuoi = sb.toString();            
//            txtM1.setText(chuoi);
//        } catch (Throwable ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                fis2.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
    }//GEN-LAST:event_btnGiaiMaE1ActionPerformed
    //------------------------------------
    private void btnBamChuoiN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBamChuoiN1ActionPerformed
        // TODO add your handling code here:
        try {
//            //Băm SHA
//            String chuoi = "";
//            chuoi = txtN1.getText();
//            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
//            md.update (chuoi.getBytes());
//            byte byteData[] = md.digest (); 
//            
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < byteData.length; i++) {
//                sb.append(Integer.toString((byteData[i] & 0xff)+0x100, 16).substring(1));
//            }            
//            System.out.println("Hex formati: " + sb.toString());
//            txtH2.setText(sb.toString());

            //Băm MD5
            String chuoi = "";
            chuoi = txtN1.getText();
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            md.update (chuoi.getBytes());
            byte byteData[] = md.digest ();
            
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff)+0x100, 16).substring(1));
            }            
            System.out.println("Hex formati: " + sb.toString());
            txtH21.setText(sb.toString());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBamChuoiN1ActionPerformed
    //------------------------------------
    private void btnKiemTraToanVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraToanVenActionPerformed
        // TODO add your handling code here:
        String H2 = txtH2.getText();
        String H21 = txtH21.getText();

        if (H2.equals(H21)) {
            JOptionPane.showMessageDialog(null, "Văn bản toàn vẹn.");
        } else {
            JOptionPane.showMessageDialog(null, "Văn bản không toàn vẹn.");
        }
    }//GEN-LAST:event_btnKiemTraToanVenActionPerformed
//------------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBamChuoiN1;
    private javax.swing.JButton btnGiaiMaE1;
    private javax.swing.JButton btnGiaiMaE3;
    private javax.swing.JButton btnKiemTraToanVen;
    private javax.swing.JButton btnMoFileMaHoaE3;
    private javax.swing.JButton btnTachChuoiD3;
    private javax.swing.JButton btnTachChuoiN1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtD3;
    private javax.swing.JTextField txtE1;
    private javax.swing.JTextField txtE3;
    private javax.swing.JTextField txtH2;
    private javax.swing.JTextField txtH21;
    private javax.swing.JTextField txtK1;
    private javax.swing.JTextField txtK3;
    private javax.swing.JTextField txtM1;
    private javax.swing.JTextField txtM2;
    private javax.swing.JTextField txtM3;
    private javax.swing.JTextField txtN1;
    // End of variables declaration//GEN-END:variables
}
