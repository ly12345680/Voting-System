
package Admin;

import Connections.ConnectionToDB;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
public class AddCandidatesPanel extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String gender = "";
  
    public AddCandidatesPanel() {
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
        firstnameTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        femaleRadioBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        lastnameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        positionCombo = new javax.swing.JComboBox();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        adminTxt = new javax.swing.JTextField();
        middleNameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Candidates Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        firstnameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        phoneTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("GENDER");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("FIRSTNAME");

        femaleRadioBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        femaleRadioBtn.setText("FEMALE");
        femaleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("POSITION");

        lastnameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Phone");

        maleRadioBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        maleRadioBtn.setText("MALE");
        maleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("LASTNAME");

        positionCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        positionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "President", "Secretary", "Auditor", "Treasurer" }));
        positionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionComboActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addBtn.setText("Add");
        addBtn.setPreferredSize(new java.awt.Dimension(63, 25));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.setPreferredSize(new java.awt.Dimension(63, 25));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("MANAGER");

        middleNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleNameTxtActionPerformed(evt);
            }
        });

        jLabel6.setText("MIDDLE NAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(maleRadioBtn)
                                .addGap(18, 18, 18)
                                .addComponent(femaleRadioBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTxt)
                            .addComponent(positionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstnameTxt)
                            .addComponent(lastnameTxt)
                            .addComponent(middleNameTxt)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maleRadioBtn)
                    .addComponent(femaleRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(adminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if(lastnameTxt.getText().equals("") || firstnameTxt.getText().equals("") || phoneTxt.getText().equals("") || positionCombo.getSelectedIndex() == -1 || middleNameTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill up all the required fields");
        }else{
           
             try{
                 
                 String position; 
                 String sql;
           // Find the Admin of Candidate
                sql = "SELECT A_ID FROM Admin WHERE A_ID =?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, adminTxt.getText());
                ResultSet rs = pst.executeQuery();
                if(rs.next()) {
               
                     switch (positionCombo.getSelectedIndex()) {
                         case 0:
                             position = "President";
                             break;
                         case 1:
                             position = "Secretary";
                             break;
                         case 2:
                             position ="Auditor";
                             break;
                         default:
                             position = "Treasurer";
                             break;
                     }
                    sql = "INSERT INTO Candidate (C_ID, First_name, Last_name, Phone, Position, Votes_count, A_ID, Middle_name) VALUES (?,?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setInt(1, Math.abs(ThreadLocalRandom.current().nextInt()));
                    pst.setString(3, lastnameTxt.getText());
                    pst.setString(2, firstnameTxt.getText());
                    pst.setString(4, phoneTxt.getText());
                    pst.setString(5, position);
                    pst.setString(6, "0");                   
                    pst.setString(7, rs.getString("A_ID"));
                    pst.setString(8, middleNameTxt.getText());

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Candidates has been added!");

                } else{
                    JOptionPane.showMessageDialog(null, "Please check Candidate's manageer and try again!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
       
    }//GEN-LAST:event_addBtnActionPerformed

    private void maleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioBtnActionPerformed
        gender = "MALE";
    }//GEN-LAST:event_maleRadioBtnActionPerformed

    private void femaleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioBtnActionPerformed
        gender = "FEMALE";
    }//GEN-LAST:event_femaleRadioBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void positionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionComboActionPerformed

    private void middleNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameTxtActionPerformed

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
            java.util.logging.Logger.getLogger(AddCandidatesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCandidatesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCandidatesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCandidatesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCandidatesPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField adminTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JTextField firstnameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastnameTxt;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JTextField middleNameTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JComboBox positionCombo;
    // End of variables declaration//GEN-END:variables
}
