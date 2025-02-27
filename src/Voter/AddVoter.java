
package Voter;


import Admin.AdminPanel;
import Connections.ConnectionToDB;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
public class AddVoter extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst=  null;
ResultSet rs = null;
String gender = "";
   
    public AddVoter() {
        initComponents();
        conn = ConnectionToDB.ConnectToDB();
    }
    public void close(){
        WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        femaleRadioBtn = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lnameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jobTxt = new javax.swing.JTextField();
        dobTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        idNumberTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        fnameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        adminTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        middlenameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Voter here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        femaleRadioBtn.setText("FEMALE");
        femaleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("FIRSTNAME");

        maleRadioBtn.setText("MALE");
        maleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("GENDER");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("DAY OF BIRTH");

        lnameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("JOB");

        jobTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        dobTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("LASTNAME");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("ADDRESS");

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("ID NUMBER");

        idNumberTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumberTxtActionPerformed(evt);
            }
        });

        addressTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        fnameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("PASSWORD");

        usernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtActionPerformed(evt);
            }
        });

        jLabel7.setText("USERNAME");

        jLabel10.setText("MANAGER ID");

        jLabel11.setText("MIDDLE NAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(123, 123, 123))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressTxt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(maleRadioBtn)
                                        .addGap(37, 37, 37)
                                        .addComponent(femaleRadioBtn))
                                    .addComponent(jobTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(fnameTxt)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTxt)
                            .addComponent(idNumberTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(passTxt)
                            .addComponent(adminTxt)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(middlenameTxt))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(idNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(middlenameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleRadioBtn)
                    .addComponent(femaleRadioBtn)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn)
                    .addComponent(cancelBtn))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTxtActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
       try{        
           String sql;
           // Find the Admin of Voter
           sql = "SELECT A_ID FROM Admin WHERE A_ID =?";
           pst = conn.prepareStatement(sql);
           pst.setString(1, adminTxt.getText());
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
                // Insert data into Voter
                sql = "INSERT INTO Voter (V_ID, Last_name, First_name, DOB, Gender, Adds, Job, A_ID, Middle_name) VALUES (?,?,?,?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, idNumberTxt.getText());
                pst.setString(2, lnameTxt.getText());
                pst.setString(3, fnameTxt.getText());
                // Use SimpleDateFormat class to parse the date string into a java.util.Date object
                 java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dobTxt.getText());
                 // Convert the java.util.Date object to a java.sql.Date object
                 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                 pst.setDate(4, sqlDate);
                 pst.setString(5, gender);
                 pst.setString(7, jobTxt.getText());
                pst.setString(6, addressTxt.getText());
                pst.setString(8, rs.getString("A_ID"));                
                pst.setString(9, middlenameTxt.getText());

                pst.execute();
                
                // Insert data into Account
                sql = "INSERT INTO Account (ACC_ID, Username, Password, V_ID) VALUES (?,?,?,?)";
                pst = conn.prepareCall(sql);
                pst.setString(2, usernameTxt.getText());
                pst.setString(3, passTxt.getText());               
                pst.setInt(1, Math.abs(ThreadLocalRandom.current().nextInt()));
                pst.setString(4, idNumberTxt.getText());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Student has been added!");
                }else{
                    JOptionPane.showMessageDialog(null, "Please check Voter's manageer and try again!");
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void maleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioBtnActionPerformed
       gender  = "MALE";
    }//GEN-LAST:event_maleRadioBtnActionPerformed

    private void femaleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioBtnActionPerformed
        gender  = "FEMALE";
    }//GEN-LAST:event_femaleRadioBtnActionPerformed

    private void idNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idNumberTxtActionPerformed

    private void fnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameTxtActionPerformed

    private void usernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTxtActionPerformed

    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVoter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxt;
    private javax.swing.JTextField adminTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JTextField idNumberTxt;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jobTxt;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JTextField middlenameTxt;
    private javax.swing.JTextField passTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
