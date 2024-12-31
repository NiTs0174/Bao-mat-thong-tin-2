
package ThuatToan1;

//import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.logging.Level;
import javax.swing.JOptionPane;

public class Caesar extends javax.swing.JFrame {

    /**
     * Creates new form Caesar
     */
    public Caesar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtbanro = new javax.swing.JTextField();
        txtkhoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmahoa = new javax.swing.JTextField();
        btnmahoa = new javax.swing.JButton();
        btnghi = new javax.swing.JButton();
        btnmo = new javax.swing.JButton();
        btngiaima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Chương  Trình Mã Hoá/ Giải Mã Ceasar Cipher");

        jLabel2.setText("Bản rõ");

        jLabel3.setText("Khoá");

        txtbanro.setText("MINH THANG");
        txtbanro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbanroActionPerformed(evt);
            }
        });

        txtkhoa.setText("2");

        jLabel4.setText("Bản mã hoá");

        txtmahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahoaActionPerformed(evt);
            }
        });

        btnmahoa.setText("Encypt");
        btnmahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmahoaActionPerformed(evt);
            }
        });

        btnghi.setText("Ghi File");
        btnghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnghiActionPerformed(evt);
            }
        });

        btnmo.setText("Mở File");
        btnmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoActionPerformed(evt);
            }
        });

        btngiaima.setText("Dencypt");
        btngiaima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngiaimaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbanro)
                            .addComponent(txtkhoa)
                            .addComponent(txtmahoa)))
                    .addComponent(jLabel1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnmahoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnghi)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btngiaima)
                        .addGap(18, 18, 18)
                        .addComponent(btnmo)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbanro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmahoa)
                    .addComponent(btnghi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtmahoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngiaima)
                    .addComponent(btnmo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbanroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbanroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbanroActionPerformed

    private void btnmahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmahoaActionPerformed
        int k = Integer.valueOf(this.txtkhoa.getText());
        String br=this.txtbanro.getText();
        this.txtmahoa.setText(mahoa(br,k));
    }//GEN-LAST:event_btnmahoaActionPerformed

    private void txtmahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahoaActionPerformed
    
    private void btngiaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngiaimaActionPerformed
       int k=Integer.valueOf(this.txtkhoa.getText());
       String br=this.txtmahoa.getText();
       this.txtbanro.setText(mahoa(br,-k));
    }//GEN-LAST:event_btngiaimaActionPerformed

    private void btnghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnghiActionPerformed
        try{
            BufferedWriter bw = null;
            
            String fileName = "M:\\Dulieu.txt";
            
            String s = txtmahoa.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Đã ghi File Thành công!!!");
        }catch (IOException ex){
            //Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Lỗi!!!");
        }
    }//GEN-LAST:event_btnghiActionPerformed

    private void btnmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoActionPerformed
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
            JOptionPane.showMessageDialog(null, "Lỗi!!!");
            //Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnmoActionPerformed

    char mahoakt(char c,int k){
        if(!Character.isLetter(c)) return c;
        return (char)((((Character.toUpperCase(c)-'A')+k)%26+26)%26+'A');
    }
    private String mahoa(String br,int k){
        String kq="";
        int n=br.length();
        for(int i=0;i<n;i++)
            kq+=mahoakt(br.charAt(i),k);
        return kq;
    }
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caesar().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnghi;
    private javax.swing.JButton btngiaima;
    private javax.swing.JButton btnmahoa;
    private javax.swing.JButton btnmo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtbanro;
    private javax.swing.JTextField txtkhoa;
    private javax.swing.JTextField txtmahoa;
    // End of variables declaration//GEN-END:variables

   
}
