package lab04;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DESCS extends javax.swing.JFrame {

    /**
     * Creates new form DESCS
     */
    public DESCS() {
        initComponents();
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
        txtKhoa = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        btnMoKhoaA = new javax.swing.JButton();
        btnMoKhoaB = new javax.swing.JButton();
        btnGhiFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMaHoa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtVanBan = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnALLSHOW = new javax.swing.JButton();
        btnGiaiMa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Input Key");

        btnMaHoa.setText("MA HOA");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        btnMoKhoaA.setText("MO KHOA A");
        btnMoKhoaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoKhoaAActionPerformed(evt);
            }
        });

        btnMoKhoaB.setText("MO KHOA B");
        btnMoKhoaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoKhoaBActionPerformed(evt);
            }
        });

        btnGhiFile.setText("GHI FILE");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        jLabel2.setText("Plaintext");

        txtMaHoa.setColumns(20);
        txtMaHoa.setRows(5);
        jScrollPane1.setViewportView(txtMaHoa);

        txtVanBan.setColumns(20);
        txtVanBan.setRows(5);
        txtVanBan.setText("Minh Thang");
        jScrollPane2.setViewportView(txtVanBan);

        jLabel3.setText("CipherText");

        btnALLSHOW.setText("ALL SHOW");
        btnALLSHOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALLSHOWActionPerformed(evt);
            }
        });

        btnGiaiMa1.setText("Giai Ma");
        btnGiaiMa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(btnMoKhoaB)
                                .addGap(28, 28, 28)
                                .addComponent(btnGiaiMa1)
                                .addGap(26, 26, 26)
                                .addComponent(btnALLSHOW)))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnMoKhoaA)
                        .addGap(39, 39, 39)
                        .addComponent(btnGhiFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMaHoa)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaHoa)
                    .addComponent(btnMoKhoaA)
                    .addComponent(btnGhiFile))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaiMa1)
                    .addComponent(btnALLSHOW)
                    .addComponent(btnMoKhoaB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------
    private static  void doCopy(InputStream is, OutputStream os) throws IOException{
        byte[] bytes = new byte[64];
        int numBytes;
        while((numBytes = is.read(bytes))!= -1){
            os.write(bytes,0,numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }    
    //---------------
     private static void encrypt(String key,InputStream is, OutputStream os) throws Throwable{
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }
    //------------------------------ 
    private static void decrypt(String key,InputStream is, OutputStream os) throws Throwable{
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }    
    //------------------------------
    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable{
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        
        if(mode == Cipher.ENCRYPT_MODE){
            cipher.init(Cipher.ENCRYPT_MODE,desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis,os);
        }else if(mode == Cipher.DECRYPT_MODE){
            cipher.init(Cipher.DECRYPT_MODE,desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
        }
     }
//---------------------------Ma Hoa A---------------------------     
    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        // TODO add your handling code here:
        try{
            String key = txtKhoa.getText();
            
            FileInputStream fis = new FileInputStream("D:\\Des.txt");
            FileOutputStream fos = new FileOutputStream("D:\\EnDes.txt");
            encrypt(key, fis, fos);
            JOptionPane.showConfirmDialog(null,"da ma hoa thanh cong!!!");
            
            //-----------------------                
            StringBuffer sb = new StringBuffer(); 
            BufferedReader br = null;
            String fileName = "D:\\EnDes.txt"; //GEN-
            br = new BufferedReader(new FileReader(fileName));
            char[] ca=new char [5];
            while (br.ready()) {
                int len = br.read(ca); 
                sb.append(ca, 0, len);
            }
            br.close();
            String chuoi = sb.toString();
            txtMaHoa.setText(chuoi);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMaHoaActionPerformed
//-----------------------Mo Khoa A-------------------------------
    private void btnMoKhoaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoKhoaAActionPerformed
        // TODO add your handling code here:
        try{
            BufferedReader br = null;
            
            String fileName = "D:\\KhoaA.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            
            JOptionPane.showMessageDialog(null, "Da mo File");
            char[] ca = new char[5];
            while(br.ready()){
                int len = br.read(ca);
                sb.append(ca,0,len); 
            }
            br.close();
            
            System.out.println("Du lieu la :"+" "+ sb);
            String chuoi = sb.toString();
            
            txtKhoa.setText(chuoi);
        }catch(IOException ex){
            Logger.getLogger(DESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMoKhoaAActionPerformed
//------------------------Mo Khoa B------------------------------
    private void btnMoKhoaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoKhoaBActionPerformed
        try{
            BufferedReader br = null;
            
            String fileName = "D:\\KhoaB.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            
            JOptionPane.showMessageDialog(null, "Da mo File");
            char[] ca = new char[5];
            while(br.ready()){
                int len = br.read(ca);
                sb.append(ca,0,len); 
            }
            br.close();
            
            System.out.println("Du lieu la :"+" "+ sb);
            String chuoi = sb.toString();
            
            txtKhoa.setText(chuoi);
        }catch(IOException ex){
            Logger.getLogger(DESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMoKhoaBActionPerformed
//----------------------Ghi File--------------------------------
    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        // TODO add your handling code here:
        try{
            BufferedWriter bw = null;
            
            String fileName = "D:\\Des.txt";
            
            String s = txtVanBan.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null ,"Da ghi file");
            //txtMaHoa.setText(s);
        }catch(IOException ex){
            Logger.getLogger(DESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGhiFileActionPerformed
//------------------------------------------------------
    private void btnGiaiMa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMa1ActionPerformed
        // TODO add your handling code here:
        FileInputStream fis2= null;
        try{
            String key = txtKhoa.getText();
            fis2 = new FileInputStream("D:\\EnDes.txt");
            FileOutputStream fos2 = new FileOutputStream("D:\\DeDes.txt");
            decrypt(key, fis2, fos2);
            BufferedReader br = null;
            String fileName = "D:\\DeDes.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            JOptionPane.showConfirmDialog(null,"Da giai ma thanh cong!!!");
            char[] ca = new char[5];
            while(br.ready()){
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Du lieu la :" + " " + sb);
            String chuoi = sb.toString();
            txtVanBan.setText(chuoi);
        }catch(Throwable ex){
            Logger.getLogger(DESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGiaiMa1ActionPerformed
//---------------------Hien Thi---------------------------------
    private void btnALLSHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALLSHOWActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = null;
            String fileName = "D:\\DeDes.txt"; //GEN-
            br = new BufferedReader(new FileReader(fileName)); 
            StringBuffer sb = new StringBuffer(); 
            JOptionPane.showMessageDialog(null, " Đã mở file");
            char[] ca=new char [5];
            while (br.ready()) {
                int len = br.read(ca); 
                sb.append(ca, 0, len);
            }
            br.close();
            String ff = "D:\\EnDes.txt";
            br = new BufferedReader(new FileReader(ff)); 
            StringBuffer sb1 = new StringBuffer();
            char[] ca1 = new char[5];
            while (br.ready()) {
                int len = br.read(ca1); 
                sb1.append(ca1, 0, len);
            }
            //xuat chuoi
            System.out.println("Du Lieu la: "+" "+sb);
            String chuoi = sb.toString();
            String chuoi1 = sb1.toString();
            txtVanBan.setText(chuoi);
            txtMaHoa.setText (chuoi1);
        } catch (IOException ex) {}
    }//GEN-LAST:event_btnALLSHOWActionPerformed
//------------------------------------------------------
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
            java.util.logging.Logger.getLogger(DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DESCS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALLSHOW;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnGiaiMa1;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnMoKhoaA;
    private javax.swing.JButton btnMoKhoaB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextArea txtMaHoa;
    private javax.swing.JTextArea txtVanBan;
    // End of variables declaration//GEN-END:variables
}
