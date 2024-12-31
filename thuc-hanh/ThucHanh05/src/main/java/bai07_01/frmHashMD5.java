/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bai07_01;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader; 
import java.io.FileWriter;
import java.security.MessageDigest;
import javax.swing.JOptionPane;
/**
 *
 * @author nhoct
 */
public class frmHashMD5 extends javax.swing.JFrame {

    /**
     * Creates new form frm_HashMD5
     */
    public frmHashMD5() {
        initComponents();
    }
    //----------------------------------------
    private boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = !password.equals(password.toLowerCase());
        if (!hasUppercase) {
            return false;
        }
        boolean hasLowercase = !password.equals(password.toUpperCase());
        if (!hasLowercase) {
            return false;
        }
        boolean hasDigit = password.matches(".*\\d.*");
        if (!hasDigit) {
            return false;
        }
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");
        if (!hasSpecialChar) {
            return false;
        }
        return true;
    }
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBam1 = new javax.swing.JTextArea();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBam2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGoc = new javax.swing.JTextArea();
        btnLogin = new javax.swing.JButton();
        btnRegistry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HASH MD5");

        jLabel2.setText("UserName");

        jLabel3.setText("Password");

        jLabel4.setText("Result 1");

        txtBam1.setColumns(20);
        txtBam1.setRows(5);
        jScrollPane1.setViewportView(txtBam1);

        txtUser.setText("minhthang");

        txtPass.setText("Aa2180601448@");

        jLabel5.setText("Result 2");

        txtBam2.setColumns(20);
        txtBam2.setRows(5);
        jScrollPane2.setViewportView(txtBam2);

        jLabel6.setText("String: UserName + Password");

        txtGoc.setColumns(20);
        txtGoc.setRows(5);
        jScrollPane3.setViewportView(txtGoc);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegistry.setText("Registry");
        btnRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(txtUser)
                            .addComponent(txtPass)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 73, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(btnRegistry)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnRegistry))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//-----------------------------------------------------------
    private void btnRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistryActionPerformed
        // TODO add your handling code here:
        try {
            String user= txtUser.getText();
            String pass = txtPass.getText(); 
            // Check password complexity
            if (!isPasswordValid(pass)) {
                JOptionPane.showMessageDialog(null, "Yêu cầu mật khẩu có 8 ký tự bao gồm (In thường, In hoa, Số và Ký tự đặc biết)");
                return;
            }
            String bam="";
            bam = user + pass;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bam.getBytes());
            byte[] byteData = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff)+0x100, 16).substring(1));
            }
            System.out.println("Digest (in hex format):: "+ sb.toString());
            txtBam1.setText(sb.toString());
            //convert the byte to hex format method 2 
            StringBuffer hexString = new StringBuffer(); 
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]); 
                if (hex.length() == 1) {
                    hexString.append('0');  
                }
                hexString.append(hex);
            }
            System.out.println("Digest (in hex format)::" + hexString.toString()); 
            txtBam2.setText(hexString.toString());
            txtGoc.setText(bam.toString());
            //chức năng ghi File            
            BufferedWriter bw = null;
            //ghi van ban da mà hoa
            String fileName="M:\\BamMD5.txt";
            //luu van ban
            bw = new BufferedWriter(new FileWriter(fileName));
            // ghi van ban
            bw.write(hexString.toString());
            bw.close();
            JOptionPane.showMessageDialog(null, "Bạn Đã Đăng Ký Thành Công .Vui lòng Đăng nhập lại!!!");
        }catch(Exception ex){
            System.out.println("Lỗi băm username va password: "+ex);
        }
    }//GEN-LAST:event_btnRegistryActionPerformed
//-----------------------------------------------------------
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String user=txtUser.getText();
        String pass = txtPass.getText();
        
        String bam = "";
        bam  = user + pass;
        //mở File đã lưu username và password
        BufferedReader br = null;
        String fileName = "M:\\BamMD5.txt"; //GEN-
        try{
            br = new BufferedReader(new FileReader(fileName)); 
            StringBuffer sb = new StringBuffer();
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            // hiển thị File đã lưu
            System.out.println("chung thuc: "+" "+sb);
            String chuoi = sb.toString();
            // Thực hiện băm username và pass cho người dùng đăng nhập
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bam.getBytes());
            byte[] byteData = md.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println("Băm username và password: "+" "+hexString.toString()); 
            // Thực hiện so sánh username và password
            Boolean k=hexString.toString().equals(chuoi);
            if (k==true){            
                JOptionPane.showMessageDialog(null, " Đăng Nhập Thành Công");
                // hiển thì username và password bị băm
                txtBam1.setText (hexString.toString());                
                //hien thi mă băm luu & File
                txtBam2.setText(chuoi);
                txtGoc.setText("Username: "+user+" " +"\nPassword: "+pass);
            }else{
                JOptionPane.showMessageDialog(null, " Đăng Nhập Thất bại");
            }
        }catch (Exception ex) {
            System.out.println(" Lỗi Đăng Nhập ;" + ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed
//-----------------------------------------------------------
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
            java.util.logging.Logger.getLogger(frmHashMD5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHashMD5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHashMD5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHashMD5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHashMD5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtBam1;
    private javax.swing.JTextArea txtBam2;
    private javax.swing.JTextArea txtGoc;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
