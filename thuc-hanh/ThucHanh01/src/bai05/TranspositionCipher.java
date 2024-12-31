/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class TranspositionCipher extends javax.swing.JFrame {
     
    public TranspositionCipher(){
        initComponents();
    }    
    //-----------------------------------------
    // Hàm kiểm tra tính hợp lệ của khóa
    private boolean isValidKey(String[] keys) {
        int keyLength = keys.length;
        boolean[] visited = new boolean[keyLength];
        // Initialize visited array to false
        for (int i = 0; i < keyLength; i++) {
            visited[i] = false;
        }
        // Check if all numbers are unique and within range
        for (String key : keys) {
            int num = Integer.parseInt(key);
            if (num < 1 || num > keyLength || visited[num - 1]) {
                return false;
            }
            visited[num - 1] = true;
        }
        return true;
    }
//------------------------------------------------------------     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtbanro = new javax.swing.JTextField();
        txtkhoa = new javax.swing.JTextField();
        txtbanma = new javax.swing.JTextField();
        btnmahoa = new javax.swing.JButton();
        btngiaima = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bản rõ");

        jLabel2.setText("Khoá");

        jLabel3.setText("Bản Mã");

        txtbanro.setText("HUTECHCNTT");
        txtbanro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbanroActionPerformed(evt);
            }
        });

        txtkhoa.setText("3,5,1,6,4,2");
        txtkhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkhoaActionPerformed(evt);
            }
        });

        btnmahoa.setText("Mã hoá");
        btnmahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmahoaActionPerformed(evt);
            }
        });

        btngiaima.setText("Giải mã");
        btngiaima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngiaimaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Thuật toán Mã hoá Hoán vị");

        jButton3.setText("Ghi File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Mở File");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(txtbanro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbanma, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnmahoa)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btngiaima)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbanro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmahoa)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtbanma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngiaima)
                    .addComponent(jButton5))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkhoaActionPerformed

    private void btnmahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmahoaActionPerformed
        String k = this.txtkhoa.getText();
        String ks[] = k.split(",");   
        int keyLength = ks.length;
        
        if (!isValidKey(ks)) {
            JOptionPane.showMessageDialog(this, "Khóa không hợp lệ. Vui lòng nhập lại.");
            return;
        }
        
        int[] key = new int[keyLength];
        for(int i=0; i<keyLength;i++)           
            key[i]=Integer.parseInt(ks[i])-1;
        
        String plaintext = this.txtbanro.getText();
        String ciphertext = "";
        int plaintextLength = plaintext.length();
        int rows = (int) Math.ceil((double) plaintextLength / keyLength);
        // Pad the plaintext with spaces if necessary
        int padding = keyLength * rows - plaintextLength;
        for (int i = 0; i < padding; i++)
            plaintext += " ";
        // Perform encryption
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyLength; j++)
                ciphertext += plaintext.charAt(i * keyLength + key[j]);
        }
        this.txtbanma.setText(ciphertext);
    }//GEN-LAST:event_btnmahoaActionPerformed

    private void btngiaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngiaimaActionPerformed
        try {
            String k = this.txtkhoa.getText();
            String ks[]=k.split(",");  
            int keyLength = ks.length;
            
            if (!isValidKey(ks)) {
                JOptionPane.showMessageDialog(this, "Khóa không hợp lệ. Vui lòng nhập lại.");
                return;
            }
            
            int[] key = new int[keyLength];
            for(int i=0; i<keyLength;i++)
                key[i]=Integer.parseInt(ks[i])-1;

            int[] reverseKey = new int[keyLength];
            for (int i = 0; i < keyLength; i++)
                reverseKey[key[i]] = i;

            String ciphertext = this.txtbanma.getText();
            String plaintext = "";
            int ciphertextLength = ciphertext.length();
            int rows = (int) Math.ceil((double) ciphertextLength / keyLength);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < keyLength; j++)
                    plaintext += ciphertext.charAt(i * keyLength + reverseKey[j]);
            }

        this.txtbanro.setText(plaintext.trim());
        } catch (Exception e) {
            System.out.println("nhập lỗi");
        }        
    }//GEN-LAST:event_btngiaimaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            BufferedWriter bw = null;
            
            String fileName = "M:\\Dulieu.txt";
            
            String s = txtbanma.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Đã ghi File Thành công!!!");
        }catch (IOException ex){
            //Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Lỗi!!!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                try {
            BufferedReader br = null;
            String fileName = "M:\\Dulieu.txt";
            br = new BufferedReader(new FileReader(fileName));
            
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Da mo file thanh cong!!");
            
            char[] ca = new char[5];
            while (br.ready()){
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Du lieu la:"+""+sb);
            String chuoi = sb.toString();
        } catch (Exception e) {
            //Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Lỗi!!!");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbanroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbanroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbanroActionPerformed
//-----------------------------------------
    public static void main(String args[]) {        
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
            java.util.logging.Logger.getLogger(TranspositionCipher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TranspositionCipher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TranspositionCipher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TranspositionCipher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TranspositionCipher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngiaima;
    private javax.swing.JButton btnmahoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtbanma;
    private javax.swing.JTextField txtbanro;
    private javax.swing.JTextField txtkhoa;
    // End of variables declaration//GEN-END:variables
    }
