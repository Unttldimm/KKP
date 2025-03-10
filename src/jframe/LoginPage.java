/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane; // Untuk JOptionPane
import java.sql.PreparedStatement; // Untuk PDimdddreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

/**
 *
 * @author Dimas kartiko
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    public LoginPage() {
        initComponents();
    }
    
    //method to insert values into users table
    
    
    //validation
    public boolean validationLogin() {
    String name = txt_usn.getText().trim(); // Username from JTextField
    char[] passwordChars = txt_pw.getPassword(); // Password from JPasswordField
    String password = new String(passwordChars).trim(); // Convert char[] to String
    

    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter username");
        return false;
    }
    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter password");
        return false;
    }

    // Clear the password array for security
    java.util.Arrays.fill(passwordChars, '0');

    return true;
}
    
    //verify creds
    public void login() {
    String name = txt_usn.getText().trim(); // Username from JTextField
    char[] passwordChars = txt_pw.getPassword(); // Password from JPasswordField
    String password = new String(passwordChars).trim(); // Convert char[] to String

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kkp", "root", "");
        PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");

        pst.setString(1, name);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            HomePage home = new HomePage();
            home.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
        }

        // Clear the password array for security
        java.util.Arrays.fill(passwordChars, '0');
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Edior
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_usn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_pw = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel3.setText("Database Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checklist_2821834.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 560, 520));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel6.setText("- WELCOME TO - ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        panel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("KELOMPOK II");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 150, 30));

        panel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KKP");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 830));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setName("Input Username"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 30, -1));

        txt_usn.setBackground(new java.awt.Color(51, 153, 255));
        txt_usn.setFont(new java.awt.Font("Sans Serif Collection", 0, 14)); // NOI18N
        txt_usn.setForeground(new java.awt.Color(255, 255, 255));
        txt_usn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_usn.setName(""); // NOI18N
        txt_usn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usnFocusLost(evt);
            }
        });
        txt_usn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usnActionPerformed(evt);
            }
        });
        jPanel2.add(txt_usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 350, 30));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        rSMaterialButtonCircle1.setText("Login");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 300, 80));

        jLabel13.setFont(new java.awt.Font("Rage Italic", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Login Page");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/usn.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pw.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Sans Serif Collection", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Sign Up");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, -1, 30));

        jLabel15.setFont(new java.awt.Font("Sans Serif Collection", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dont have an account? ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, 30));

        txt_pw.setBackground(new java.awt.Color(51, 153, 255));
        txt_pw.setFont(new java.awt.Font("Sans Serif Collection", 0, 18)); // NOI18N
        txt_pw.setForeground(new java.awt.Color(255, 255, 255));
        txt_pw.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pwActionPerformed(evt);
            }
        });
        jPanel2.add(txt_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 350, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 530, 840));

        setSize(new java.awt.Dimension(1417, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usnActionPerformed

    private void txt_usnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usnFocusGained

    private void txt_usnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usnFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_usnFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if (validationLogin()) {
            login();
        }

        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here
        Signup sign  = new Signup();
        sign.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txt_pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pwActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JPasswordField txt_pw;
    private javax.swing.JTextField txt_usn;
    // End of variables declaration//GEN-END:variables

    private void pageVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
