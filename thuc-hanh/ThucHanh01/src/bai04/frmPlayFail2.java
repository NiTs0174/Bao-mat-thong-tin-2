/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai04;

import bai03.*;
import bai02.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class frmPlayFail2 extends javax.swing.JFrame {
     
    char pf[][] = {{'M','I','N','H','T'},
                   {'A','G','B','C','D'},
                   {'E','F','K','L','O'},
                   {'P','Q','R','S','U'},
                   {'V','W','X','Y','Z'}
    };
    public frmPlayFail2(){
        initComponents();
    }
//-----------------------------------------------
    static void toLowerCase(char plain[], int ps)
  {
    int i;
    for (i = 0; i < ps; i++) {
      if (plain[i] > 64 && plain[i] < 91)
        plain[i] += 32;
    }
  }
    //--------------------------------------
    static String removeDuplicate(String s)
	{
		int j, index = 0, len = s.length();
		char c[] = s.toCharArray();
		for (int i = 0; i < len; i++) {
			for (j = 0; j < i; j++) {
				if (c[i] == c[j])
					break;
			}
			if (i == j)
				c[index++] = c[i];
		}
		s = new String((Arrays.copyOf(c, index)));
		return s;
	}
    //---------------------------------------------------
    static String removeWhiteSpace(char[] ch, String key)
	{
		char[] c = key.toCharArray();                
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if (c[i] == ch[j])
					c[i] = ' ';
			}
		}
		key = new String(c);
		key = key.replaceAll(" ", "");
		return key;
	}
    //------------------------------
    static String makePair(String pt)
	{
		String s = "";
		char c = 'a';
		for (int i = 0; i < pt.length(); i++) {
			if (pt.charAt(i) == ' ')
				continue;
			else {
				c = pt.charAt(i);
				s += pt.charAt(i);
			}
			if (i < pt.length() - 1)
				if (pt.charAt(i) == pt.charAt(i + 1))
					s += "x";
		}
		if (s.length() % 2 != 0)
			s += "x";
		System.out.println(s);
		return s;
	}
    //--------------------------------------------
    static int[] findIJ(char a, char b, char x[][])
	{
		int[] y = new int[4];
		if (a == 'j')
			a = 'i';
		else if (b == 'j')
			b = 'i';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (x[i][j] == a) {
					y[0] = i;
					y[1] = j;
				}
				else if (x[i][j] == b) {
					y[2] = i;
					y[3] = j;
				}
			}
		}
		if (y[0] == y[2]) {
			y[1] += 1;
			y[3] += 1;
		}
		else if (y[1] == y[3]) {
			y[0] += 1;
			y[2] += 1;
		}
		for (int i = 0; i < 4; i++)
			y[i] %= 5;
		return y;
	}
    //------------------------------------------
    static String encrypt(String pt, char x[][])
	{
		char ch[] = pt.toCharArray();
		int a[] = new int[4];
		for (int i = 0; i < pt.length(); i += 2) {
			if (i < pt.length() - 1) {
				a = findIJ(pt.charAt(i), pt.charAt(i + 1),x);
				if (a[0] == a[2]) {
					ch[i] = x[a[0]][a[1]];
					ch[i + 1] = x[a[0]][a[3]];
				}
				else if (a[1] == a[3]) {
					ch[i] = x[a[0]][a[1]];
					ch[i + 1] = x[a[2]][a[1]];
				}
				else {
					ch[i] = x[a[0]][a[3]];
					ch[i + 1] = x[a[2]][a[1]];
				}
			}
		}
		pt = new String(ch);
		return pt;
	}
    //-------------------
    static String decrypt(String ct, char x[][]){
         char ch[] = ct.toCharArray();
        int a[] = new int[4];
        for (int i = 0; i < ct.length(); i += 2) {
            if (i < ct.length() - 1) {
                a = findIJ(ct.charAt(i), ct.charAt(i + 1), x);
                if (a[0] == a[2]) {
                    ch[i] = x[a[0]][a[1]];
                    ch[i + 1] = x[a[0]][a[3]];
                } else if (a[1] == a[3]) {
                    ch[i] = x[a[0]][a[1]];
                    ch[i + 1] = x[a[2]][a[1]];
                } else {
                    ch[i] = x[a[0]][a[3]];
                    ch[i + 1] = x[a[2]][a[1]];
                }
            }
        }
        ct = new String(ch);
        return ct;
    }
//------------------------------------------------------------    
//    private String timViTri(char a){
//        for(int i=0;i<5;i++)
//            for(int j=0; j<5; j++)
//                if(pf[i][j]==a)
//                    return i+""+j;
//        return "";
//    }
//    private String giaima(String banma){
//        int n = banma.length();
//        String banro = "";
//        char a,b;
//        for(int i=0;i<n;i+=2){
//            a=banma.charAt(i);
//            b=banma.charAt(i+1);
//            
//            banro+=thayTheNguoc(a,b);
//        }
//        return banro;
//    }
//    String thayTheNguoc(char a, char b){
//        String vta = timViTri(a);
//        String vtb = timViTri(b);
//        char x,y;
//        if(vta.charAt(0)==vtb.charAt(0)){   //cung dong
//            x=pf[(vta.charAt(0)-'0')][((vta.charAt(1)-'0')-1+5)%5];
//            y=pf[(vtb.charAt(0)-'0')][((vtb.charAt(1)-'0')-1+5)%5];
//            return x+""+y;
//        }
//        if(vta.charAt(1)==vtb.charAt(1)){
//            x=pf[((vta.charAt(0)-'0')-1+5)%5][(vta.charAt(1)-'0')];
//            y=pf[((vtb.charAt(0)-'0')-1+5)%5][(vtb.charAt(1)-'0')];
//            return x+""+y;
//        }
//        x=pf[(vta.charAt(0)-'0')][(vta.charAt(1)-'0')];
//        y=pf[(vtb.charAt(0)-'0')][(vtb.charAt(1)-'0')];
//        return x+""+y;
//    }
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
        btnGhiGile = new javax.swing.JButton();
        btnMoiFile = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bản rõ");

        jLabel2.setText("Khoá");

        jLabel3.setText("Bản Mã");

        txtbanro.setText("hello");
        txtbanro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbanroActionPerformed(evt);
            }
        });

        txtkhoa.setText("minhthang");
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
        jLabel4.setText("Thuật toán Mã hoá Play Fail");

        btnGhiGile.setText("Ghi File");
        btnGhiGile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiGileActionPerformed(evt);
            }
        });

        btnMoiFile.setText("Mở File");
        btnMoiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiFileActionPerformed(evt);
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
                        .addComponent(btnGhiGile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btngiaima)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoiFile)))
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
                    .addComponent(btnGhiGile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtbanma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngiaima)
                    .addComponent(btnMoiFile))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkhoaActionPerformed

    private void btnmahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmahoaActionPerformed
        String banro = this.txtbanro.getText().toLowerCase();
        String key = this.txtkhoa.getText().toLowerCase();
        key = removeDuplicate(key);
        char[] ch = key.toCharArray();
        String st = "abcdefghiklmnopqrstuvwxyz";
        st = removeWhiteSpace(ch, st);
        char[] c = st.toCharArray();
        char[][] x = new char[5][5];
        int indexOfSt = 0, indexOfKey = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (indexOfKey < key.length())
					x[i][j] = ch[indexOfKey++];
				else
					x[i][j] = c[indexOfSt++];
			}
		}
                
                for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(x[i][j] + " ");
			System.out.println();
		}
                
                banro = makePair(banro);
                banro = encrypt(banro, x);
                System.out.println(banro);
                txtbanma.setText(banro.toString());
    }//GEN-LAST:event_btnmahoaActionPerformed

    private void btngiaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngiaimaActionPerformed
    String banma = this.txtbanma.getText().toLowerCase(); // Chuyển đổi chuỗi mã hóa thành chữ thường
    String key = this.txtkhoa.getText().toLowerCase(); // Chuyển đổi khóa thành chữ thường
    key = removeDuplicate(key);
    char[] ch = key.toCharArray();
    String st = "abcdefghiklmnopqrstuvwxyz";
    st = removeWhiteSpace(ch, st);
    char[] c = st.toCharArray();
    char[][] x = new char[5][5];
    int indexOfSt = 0, indexOfKey = 0;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (indexOfKey < key.length())
                x[i][j] = ch[indexOfKey++];
            else
                x[i][j] = c[indexOfSt++];
        }
    }
    
    banma = decrypt(banma, x);
    String banro = banma;
        int n = banro.length();
        String br = "";
        for(int i=0; i<n-2; i+=2)
            if(banro.charAt(i)==banro.charAt(i+2))
                br+=banro.charAt(i);
            else 
                br+=banro.charAt(i)+""+banro.charAt(i+1);
        if(banro.charAt(n-1)=='x')
            br+=banro.charAt(n-2);
        else
            br+=banro.charAt(n-2);
            br+=banro.charAt(n-1);
    System.out.println(br);
    txtbanro.setText(br); // Gán chuỗi đã giải mã vào ô văn bản    
    }//GEN-LAST:event_btngiaimaActionPerformed

    private void btnGhiGileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiGileActionPerformed
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
    }//GEN-LAST:event_btnGhiGileActionPerformed

    private void btnMoiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiFileActionPerformed
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

    }//GEN-LAST:event_btnMoiFileActionPerformed

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
            java.util.logging.Logger.getLogger(frmPlayFail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPlayFail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPlayFail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPlayFail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPlayFail2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhiGile;
    private javax.swing.JButton btnMoiFile;
    private javax.swing.JButton btngiaima;
    private javax.swing.JButton btnmahoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtbanma;
    private javax.swing.JTextField txtbanro;
    private javax.swing.JTextField txtkhoa;
    // End of variables declaration//GEN-END:variables
    }
