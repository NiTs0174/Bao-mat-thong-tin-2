/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ThuatToan2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author nhoct
 */
public class frm_3Des extends javax.swing.JFrame {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myDecryptionKey;
    private String myEncryptionScheme; 
    SecretKey key;    
    public static final String DESEDE_DECRYPTION_SCHEME = "DESede";
    private String myDecryptionScheme;
    
    /**
     * Creates new form frm_Des
     */
    public frm_3Des() {
        initComponents();
    }    
    
//------------------------------------------------------------------------------
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
        txtKhoa = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        btnAllShow = new javax.swing.JButton();
        btnGhiFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtVanBan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoa = new javax.swing.JTextField();
        btnGiaiMa = new javax.swing.JButton();
        btnMoFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("DESEDE");

        jLabel2.setText("Input Key:");

        txtKhoa.setText("baomatthongtin-congnghethongtin");
        txtKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhoaActionPerformed(evt);
            }
        });

        btnMaHoa.setText("Mã Hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        btnAllShow.setText("All Show");
        btnAllShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllShowActionPerformed(evt);
            }
        });

        btnGhiFile.setText("Ghi File");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        jLabel3.setText("Plaintext:");

        txtVanBan.setText("mon thuc hanh bao mat thong tin");

        jLabel4.setText("CipherText:");

        btnGiaiMa.setText("Giải Mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });

        btnMoFile.setText("Hiển Thị");
        btnMoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 45, Short.MAX_VALUE)
                        .addComponent(btnMaHoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoFile)
                        .addGap(20, 20, 20)
                        .addComponent(btnGhiFile)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtKhoa)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVanBan)
                    .addComponent(txtMaHoa))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGiaiMa)
                .addGap(18, 18, 18)
                .addComponent(btnAllShow)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaHoa)
                    .addComponent(btnGhiFile)
                    .addComponent(btnMoFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtVanBan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaiMa)
                    .addComponent(btnAllShow))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------------------------------
    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        // TODO add your handling code here:        
        try{
            //quot;Sanjaal.com&quot
            myDecryptionKey = txtKhoa.getText();
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            keyAsBytes = myDecryptionKey.getBytes(UNICODE_FORMAT); 
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key= mySecretKeyFactory.generateSecret (myKeySpec); 
            System.out.println(" khoa mà hoa k :" +" "+ key);
            // sử dụng lớp DESEDE_EN
            String plainText = txtVanBan.getText(); 
            // gọi phương thức mà hoa
            String encrypted = encrypt (plainText); 
            System.out.println("Encrypted Value :"+encrypted);
            txtMaHoa.setText (encrypted);
        } catch (Exception ex) {}
    }//GEN-LAST:event_btnMaHoaActionPerformed
//------------------------------------------------------------------------------
    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        // TODO add your handling code here:        
        try{
            //quot;Sanjaal.com&quot
            myDecryptionScheme = txtKhoa.getText();
            myDecryptionScheme = DESEDE_DECRYPTION_SCHEME;
            keyAsBytes = myDecryptionKey.getBytes(UNICODE_FORMAT); 
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory = SecretKeyFactory.getInstance(myDecryptionScheme);
            cipher = Cipher.getInstance(myDecryptionScheme);
            key= mySecretKeyFactory.generateSecret (myKeySpec); 
            System.out.println(" khoa mà hoa k :" +" "+ key);
            // sử dụng lớp DESEDE_EN
            String plainText = txtMaHoa.getText(); 
            // gọi phương thức mà hoa
            String decrypted = decrypt (plainText); 
            System.out.println("Decrypted Value :"+decrypted);
            txtVanBan.setText (decrypted);
        } catch (Exception ex) {}
    }//GEN-LAST:event_btnGiaiMaActionPerformed
//------------------------------------------------------------------------------
    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        // TODO add your handling code here:        
        try {
            BufferedWriter bw= null; 
            //ghi van ban da ma hoa
            String fileName = "M:\\Des.txt"; 
            //luu van ban
            String s = txtVanBan.getText();            
            bw = new BufferedWriter (new FileWriter(fileName)); // van ban sau khi ma hoa
            //ghi van ban
            bw.write(s);
                bw.close();
            JOptionPane.showMessageDialog(null," Đã ghi file");
            txtMaHoa.setText(s);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger (DESCS.class.getName()).log (Level. SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGhiFileActionPerformed
//------------------------------------------------------------------------------
    private void btnMoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoFileActionPerformed
        // TODO add your handling code here:        
        try {
        BufferedReader br = null;
        
        String fileName="M:\\EnDes.txt"; //GEN-
        br = new BufferedReader (new FileReader (fileName)); 
        StringBuffer sb = new StringBuffer();
        
        JOptionPane.showMessageDialog(null, "Đã mở file");
        char[] ca = new char [5];
        while (br.ready()) {
            int len = br.read(ca);
            sb.append(ca, 0, len);
        }
        br.close();
        //xuất chuỗi
        System.out.println("Du Lieu la: " + "" + sb);
        String chuoi = sb.toString();

        txtVanBan.setText(chuoi);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger (DESCS.class.getName()).log (Level. SEVERE, null, ex);}
        }
    }//GEN-LAST:event_btnMoFileActionPerformed
//------------------------------------------------------------------------------
    private void btnAllShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllShowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllShowActionPerformed

    private void txtKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhoaActionPerformed
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
            java.util.logging.Logger.getLogger(frm_3Des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_3Des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_3Des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_3Des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_3Des().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllShow;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnMoFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaHoa;
    private javax.swing.JTextField txtVanBan;
    // End of variables declaration//GEN-END:variables
}
