/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bai03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;

/**
 *
 * @author nhoct
 */
public class frm_Aes extends javax.swing.JFrame {
    String user;
    String pass;
    String khoa;
    SecretKey secretKey;  
    byte[] byteCipherText;
    
    /**
     * Creates new form frm_Des
     */
    public frm_Aes() {
        initComponents();
    }    
    
//------------------------------------------------------------------------------
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
        btnGhiFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtVanBan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoa = new javax.swing.JTextField();
        btnGiaiMa = new javax.swing.JButton();
        btnMoFile = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("AES");

        jLabel2.setText("Mã Đăng Ký:");

        txtKhoa.setText("thang1448");

        btnMaHoa.setText("Mã Hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        btnGhiFile.setText("Ghi File");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        jLabel3.setText("Plaintext:");

        txtVanBan.setText("Bao mat thong tin Thuc hanh Ma hoa AES");

        jLabel4.setText("CipherText:");

        btnGiaiMa.setText("Giải Mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });

        btnMoFile.setText("Mở File");
        btnMoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoFileActionPerformed(evt);
            }
        });

        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnDangKy.setText("Đăng Ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        jLabel5.setText("Password:");

        jLabel6.setText("User name:");

        txtPass.setText("1448");

        txtUser.setText("minhthang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVanBan, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                                    .addComponent(txtMaHoa)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(btnMaHoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnGhiFile)
                                .addGap(18, 18, 18)
                                .addComponent(btnGiaiMa)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoFile))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(btnDangNhap)
                                .addGap(18, 18, 18)
                                .addComponent(btnDangKy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKhoa)
                                    .addComponent(txtUser)
                                    .addComponent(txtPass)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap)
                    .addComponent(btnDangKy))
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
                    .addComponent(btnMaHoa)
                    .addComponent(btnMoFile)
                    .addComponent(btnGhiFile))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------------------------------
    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        // TODO add your handling code here:        
        try {
            System.out.println(" Sinh khoa: "+ secretKey);
            //thuat toan AES
            Cipher aesCipher = Cipher.getInstance("AES"); 
            // Sinh khoa
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Mã hóa văn bản
            String strData = txtVanBan.getText(); 
            //covert văn bản sang kiểu byte
            byte[] byteDataToEncrypt = strData.getBytes();
            // Gọi phương thức doFinal để mã hóa
            byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
            String strCipherText = new BASE64Encoder().encode(byteCipherText); 
            System.out.println("Cipher Text generated using AES is " + strCipherText);
            txtMaHoa.setText(strCipherText);
        } catch (Exception ex) {
            System.out.println(" Loi mà hóa: "+ ex);
        }
    }//GEN-LAST:event_btnMaHoaActionPerformed
//------------------------------------------------------------------------------
    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        // TODO add your handling code here:        
        try {
            //txtVanBan.setText(txtMaHoa.getText());
            String cipherText=txtMaHoa.getText(); 
            txtVanBan.setText(cipherText);
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters()); 
            //String giaima = txtmahoa.getText();
            // byte[] giaima=cipherText.getBytes():
            //byteCipherText
            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            String strDecryptedText = new String(byteDecryptedText);
            System.out.println(" Decrypted Text message is " + strDecryptedText); 
            txtVanBan.setText(strDecryptedText);
        } catch (Exception ex) {
            System.out.println(" Loi giai Ma: "+ ex);
        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed
//------------------------------------------------------------------------------
    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        // TODO add your handling code here:        
        try {
            BufferedWriter bw= null; 
            //ghi van ban da ma hoa
            String fileName = "M:\\GhiAES.txt"; 
            //luu van ban
            String s = txtMaHoa.getText();    
            // van ban sau khi ma hoa        
            bw = new BufferedWriter (new FileWriter(fileName)); 
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
        
        String fileName="M:\\GhiAES.txt"; //GEN-
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
        //-----------------------
        btnGiaiMa.enable(true);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger (DESCS.class.getName()).log (Level. SEVERE, null, ex);}
        }
    }//GEN-LAST:event_btnMoFileActionPerformed
//------------------------------------------------------------------------------
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        try {
            user = txtUser.getText();
            pass = txtPass.getText(); 
            khoa = user + pass;
            BufferedReader br = null;
            String fileName = "M:\\AES.txt"; //GEN-
            br= new BufferedReader(new FileReader (fileName)); 
            StringBuffer sb = new StringBuffer();
            char[] ca = new char [5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            //xuat chuoi
            System.out.println("Khoa là : "+""+sb);
            String chuoi = sb.toString();
            Boolean k = khoa.equals(chuoi);
            if (k==true) 
                JOptionPane.showMessageDialog(null, " Đăng Nhập Thanh Công");
            else
                JOptionPane.showMessageDialog(null, " Đăng Nhập Thất bại");
            txtKhoa.setText(chuoi.getBytes().toString());
            KeyGenerator keyGen  = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            // Logger.getLogger (FrAES.class.getName()).log (Level.SEVERE, null, ex); 
        } catch (Exception ex) {
            ex.printStackTrace();
            // Logger.getLogger (FrAES.class.getName()).log (Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed
//------------------------------------------------------------------------------
    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        try {
            user= txtUser.getText();
            pass = txtPass.getText();
            khoa = user + pass;
            BufferedWriter bw= null;
            //ghi van ban da ma hoa
            String fileName = "M:\\AES.txt";
            //luu van ban
            String s = txtVanBan.getText();             
            //bai van ban sự khi tan hoa
            bw = new BufferedWriter(new FileWriter (fileName));
            // ghi van ban
            bw.write(khoa); 
            bw.close();
            JOptionPane.showMessageDialog(null, "Ban Đã Đăng Ký Thành Công .Vui lòng Đăng nhập lại !!!");
            txtKhoa.setText(khoa.getBytes().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(FrAES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDangKyActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Aes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Aes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Aes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Aes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Aes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnMoFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaHoa;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVanBan;
    // End of variables declaration//GEN-END:variables
}