/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiKiemTra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
public class frmEnc extends javax.swing.JFrame {
//----------------------------------------------------------------
    public static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    public KeySpec myKeySpec;
    public SecretKeyFactory mySecretKeyFactory;
    public Cipher cipher;
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
    public frmEnc() {
        initComponents();
    }
//Function----------------------------------------------------------------------
    //3DES---------------
    // Encrypt
    public String encrypt (String unencryptedString) { 
        String encryptedString= null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key); 
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText); 
            BASE64Encoder base64encoder = new BASE64Encoder(); 
            encryptedString = base64encoder.encode(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
    //DES---------------------
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
    //-------------------------
    // Phương thức nối chuỗi N1
    private String noiChuoiN1(String E1, String M2) {
        return E1 +"@"+ M2;
    }    
    // Phương thức nối chuỗi N2
    private String noiChuoiN2(String N1, String H2, String M3) {
        return N1 +"*"+ H2 +"*"+ M3;
    }    
//------------------------------------------------------------------------------
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
        txtN2 = new javax.swing.JTextField();
        txtM3 = new javax.swing.JTextField();
        txtM2 = new javax.swing.JTextField();
        txtN1 = new javax.swing.JTextField();
        txtH2 = new javax.swing.JTextField();
        txtK1 = new javax.swing.JTextField();
        btnMaHoaM1 = new javax.swing.JButton();
        btnNoiChuoiN1 = new javax.swing.JButton();
        btnBamChuoiN1 = new javax.swing.JButton();
        btnNoiChuoiN2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnMaHoaE3 = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        txtE3 = new javax.swing.JTextField();
        txtE1 = new javax.swing.JTextField();
        txtM1 = new javax.swing.JTextField();
        txtK3 = new javax.swing.JTextField();
        btnGhiFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FROM ENCRYPT");

        jLabel2.setText("Message (M1):");

        jLabel3.setText("Key Encrypt (K1):");

        jLabel4.setText("Cipher (E1) = En (M1) + K1:");

        jLabel5.setText("Message Hash (H2):");

        jLabel6.setText("Message (N1) = E1 + M2:");

        jLabel7.setText("Message (M2):");

        jLabel8.setText("Key Encrypt (K3):");

        jLabel9.setText("Message (N2) = N1 + H2 + M3:");

        jLabel10.setText("Message (M3):");

        txtM3.setText("MaDe448");

        txtM2.setText("BaoMatThongTin");

        txtK1.setText("congnghethongtin");

        btnMaHoaM1.setText("Mã hoá M1");
        btnMaHoaM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaM1ActionPerformed(evt);
            }
        });

        btnNoiChuoiN1.setText("Nối chuỗi N1");
        btnNoiChuoiN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoiChuoiN1ActionPerformed(evt);
            }
        });

        btnBamChuoiN1.setText("Băm chuỗi N1");
        btnBamChuoiN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBamChuoiN1ActionPerformed(evt);
            }
        });

        btnNoiChuoiN2.setText("Nối chuỗi N2");
        btnNoiChuoiN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoiChuoiN2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cipher(E3) = En(N2) + K3");

        btnMaHoaE3.setText("Mã hóa E3");
        btnMaHoaE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaE3ActionPerformed(evt);
            }
        });

        btnDecrypt.setText("FORM DECRYPT");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        txtM1.setText("kiemtra");

        txtK3.setText("12345678");

        btnGhiFile.setText("Ghi FILE");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtN1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNoiChuoiN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtN2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNoiChuoiN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtM3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtM2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtH2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBamChuoiN1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtM1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtE1)
                            .addComponent(txtK1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMaHoaM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGhiFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtK3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDecrypt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtE3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(btnMaHoaE3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGhiFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMaHoaM1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnNoiChuoiN1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBamChuoiN1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoiChuoiN2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtK3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnMaHoaE3)
                    .addComponent(txtE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDecrypt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------------------------------
    private void btnMaHoaM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaM1ActionPerformed
        // TODO add your handling code here:
        //3DES
        try{            
            myDecryptionKey = txtK1.getText();
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            keyAsBytes = myDecryptionKey.getBytes(UNICODE_FORMAT); 
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key= mySecretKeyFactory.generateSecret (myKeySpec); 
            //System.out.println(" khoa mà hoa k :" +" "+ key);
            
            String plainText = txtM1.getText(); 
            
            String encrypted = encrypt (plainText); 
            //System.out.println("Encrypted Value :"+encrypted);
            txtE1.setText (encrypted);
        } catch (Exception ex) {
            System.out.println(""+ex);
        }

//        //DES
//        try {
//            //Mã Hóa
//            String key = txtK1.getText();
//            FileInputStream fis = new FileInputStream("M:\\Des1.txt");
//            FileOutputStream fos = new FileOutputStream("M:\\EnDes1.txt"); 
//            encrypt (key, fis, fos);
//            
//            //Mở File
//            BufferedReader br = null;
//            String fileName="M:\\EnDes1.txt";
//            br = new BufferedReader (new FileReader (fileName)); 
//            StringBuffer sb = new StringBuffer();
//            //Đọc File
//            char[] ca = new char [5];
//            while (br.ready()) {
//                int len = br.read(ca);
//                sb.append(ca, 0, len);
//            }
//            br.close();
//            String chuoi = sb.toString();
//            txtE1.setText(chuoi);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnMaHoaM1ActionPerformed
    //------------------------------------
    private void btnNoiChuoiN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoiChuoiN1ActionPerformed
        // TODO add your handling code here:
        String E1 = txtE1.getText();
        String M2 = txtM2.getText();
        String N1 = noiChuoiN1(E1, M2);
        txtN1.setText(N1);
    }//GEN-LAST:event_btnNoiChuoiN1ActionPerformed
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
            txtH2.setText(sb.toString());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBamChuoiN1ActionPerformed
    //------------------------------------
    private void btnNoiChuoiN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoiChuoiN2ActionPerformed
        // TODO add your handling code here:
        try {
            //Nối chuỗi N2
            String N1 = txtN1.getText();
            String H2 = txtH2.getText();
            String M3 = txtM3.getText();
            String N2 = noiChuoiN2(N1, H2, M3);
            txtN2.setText(N2);
        
            //Ghi File
            BufferedWriter bw= null; 
            String fileName = "M:\\Des2.txt"; 
            String s = txtN2.getText();            
            bw = new BufferedWriter (new FileWriter(fileName)); 
            bw.write(s);
                bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnNoiChuoiN2ActionPerformed
    //------------------------------------
    private void btnMaHoaE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaE3ActionPerformed
        // TODO add your handling code here:
        try {
            //Mã Hóa DES
            String key=txtK1.getText();            
            FileInputStream fis= new FileInputStream("M:\\Des2.txt");
            FileOutputStream fos= new FileOutputStream("M:\\EnDes2.txt"); 
            encrypt (key, fis, fos);
            
            //Mở File
            BufferedReader br = null;
            String fileName="M:\\EnDes2.txt";
            br = new BufferedReader (new FileReader (fileName)); 
            StringBuffer sb = new StringBuffer();
            //Đọc File
            char[] ca = new char [5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            String chuoi = sb.toString();
            txtE3.setText(chuoi);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMaHoaE3ActionPerformed
    //------------------------------------
    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        // TODO add your handling code here:
        frmDec frm_dec = new frmDec();
        frm_dec.setVisible(true);
        frm_dec.myDecryptionKey = myDecryptionKey;
        frm_dec.myDecryptionScheme = DESEDE_DECRYPTION_SCHEME;
    }//GEN-LAST:event_btnDecryptActionPerformed
    //------------------------------------
    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedWriter bw= null; 
            String fileName = "M:\\Des1.txt"; 
            String s = txtM1.getText();            
            bw = new BufferedWriter (new FileWriter(fileName)); 
            bw.write(s);
                bw.close();
            JOptionPane.showMessageDialog(null," Đã ghi file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGhiFileActionPerformed
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
            java.util.logging.Logger.getLogger(frmEnc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEnc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEnc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEnc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEnc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBamChuoiN1;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnMaHoaE3;
    private javax.swing.JButton btnMaHoaM1;
    private javax.swing.JButton btnNoiChuoiN1;
    private javax.swing.JButton btnNoiChuoiN2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtE1;
    private javax.swing.JTextField txtE3;
    private javax.swing.JTextField txtH2;
    private javax.swing.JTextField txtK1;
    private javax.swing.JTextField txtK3;
    private javax.swing.JTextField txtM1;
    private javax.swing.JTextField txtM2;
    private javax.swing.JTextField txtM3;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
    // End of variables declaration//GEN-END:variables
}
