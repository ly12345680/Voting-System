
package Voter;

import Connections.ConnectionToDB;
import Forms.Login;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


import java.sql.*;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
public class VoteForm extends javax.swing.JFrame {
    
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;

int  presidentVote ,secretaryVote,treasurerVote,auditorVote;

   
    public VoteForm() {
        initComponents();
        conn = ConnectionToDB.ConnectToDB();
    }
    public void close(){
        WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    //Get firsname, lastname, middlename
    public static String[] splitName(String fullName) {
    String[] parts = fullName.trim().split("\\s+"); // split on whitespace
    String[] result = new String[3];
    result[0] = parts[2]; // first name
    result[1] = parts[1]; // middle name
    result[2] = parts[0]; // last name
    
    return result;
}
    // Populate method
    public void populatePresident(){
        try{
            String sql = "SELECT Last_name,First_name, Middle_name FROM Candidate WHERE Position='President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                candidateCombo.addItem(rs.getString("Last_name")+" "+rs.getString("Middle_name")+" "+rs.getString("First_name"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public void populateTreasurer(){
        try{
            String sql = "SELECT Last_name,First_name, Middle_name FROM Candidate WHERE Position='Treasurer'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                candidateCombo.addItem(rs.getString("Last_name")+" "+rs.getString("Middle_name")+" "+rs.getString("First_name"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void populateSecretary(){
        try{

            String sql = "SELECT Last_name,First_name, Middle_name FROM Candidate WHERE Position='Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                candidateCombo.addItem(rs.getString("Last_name")+" "+rs.getString("Middle_name")+" "+rs.getString("First_name"));

            }
        }catch(Exception e){
            System.out.println("Error in populateSecretary: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void populateAuditors(){
        try{
            String sql = "SELECT Last_name,First_name, Middle_name FROM Candidate WHERE Position='Auditor'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                candidateCombo.addItem(rs.getString("Last_name")+" "+rs.getString("Middle_name")+" "+rs.getString("First_name"));
            }
        }catch(Exception e){
            System.out.println("Error in populateAuditors: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Sellect Votes_count method

    public void selectVoteCountForPresident(){
        try{
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);
            
            String sql = "SELECT Votes_count FROM Candidate WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                presidentVote = Integer.parseInt(rs.getString("Votes_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void selectVoteCountForSecretary(){
        try{
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);
            
             String sql = "SELECT Votes_count FROM Candidate WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                secretaryVote = Integer.parseInt(rs.getString("Votes_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     public void selectVoteCountForAuditors(){
        try{
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);
            
            String sql = "SELECT Votes_count FROM Candidate WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Auditor'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                auditorVote = Integer.parseInt(rs.getString("Votes_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForTreasurer(){
        try{
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);
            
            String sql = "SELECT Votes_count FROM Candidate WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Treasurer'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                treasurerVote = Integer.parseInt(rs.getString("Votes_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   // Update the Votes_count for selected Candidate
    public void updateForPresident(){
        
        try{
            String C_ID;
            String V_ID;
            String sql;
            // get  name of Voter
            String[] nameVoter = splitName(nameLbl.getText());
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);

            // get V_ID of Voter
            sql = "SELECT V_ID FROM Voter WHERE First_name = ? AND Last_name = ? AND Middle_name = ?";
            pst = conn.prepareCall(sql);
            pst.setString(1, nameVoter[0]);            
            pst.setString(2, nameVoter[2]);            
            pst.setString(3, nameVoter[1]);

            rs = pst.executeQuery();
            
            if (rs.next()) {
            V_ID = rs.getString("V_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for voter");
            }
            
            // get C_ID of Candidate
            sql = "SELECT C_ID FROM Candidate WHERE First_name = ? AND Middle_name = ? AND Last_name = ? AND Position = 'President'";
            pst = conn.prepareCall(sql);
            pst.setString(1, stringName[0]);            
            pst.setString(2, stringName[1]);            
            pst.setString(3, stringName[2]);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            C_ID = rs.getString("C_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for candidate");
            }
            
                        // Create a Votes
            sql = "INSERT INTO Votes (Votes_ID, Date, V_ID, C_ID) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Math.abs(ThreadLocalRandom.current().nextInt()));            
            pst.setString(3, V_ID);
            pst.setString(4, C_ID);
            
            // set the Date parameter to the current date
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.toString();
            pst.setString(2, formattedDate);
            pst.execute();
            
            // update votes count for candidate
             sql = "UPDATE Candidate SET Votes_count='"+ presidentVote +"' WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='President'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void updateForSecretary(){
        try{
           String C_ID;
            String V_ID;
            String sql;
            // get  name of Voter
            String[] nameVoter = splitName(nameLbl.getText());
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);

            // get V_ID of Voter
            sql = "SELECT V_ID FROM Voter WHERE First_name = ? AND Last_name = ? AND Middle_name = ?";
            pst = conn.prepareCall(sql);
            pst.setString(1, nameVoter[0]);            
            pst.setString(2, nameVoter[2]);            
            pst.setString(3, nameVoter[1]);

            rs = pst.executeQuery();
            
            if (rs.next()) {
            V_ID = rs.getString("V_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for voter");
            }
            
            // get C_ID of Candidate
            sql = "SELECT C_ID FROM Candidate WHERE First_name = ? AND Middle_name = ? AND Last_name = ? AND Position = 'Secretary'";
            pst = conn.prepareCall(sql);
            pst.setString(1, stringName[0]);            
            pst.setString(2, stringName[1]);            
            pst.setString(3, stringName[2]);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            C_ID = rs.getString("C_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for candidate");
            }
            
                        // Create a Votes
            sql = "INSERT INTO Votes (Votes_ID, Date, V_ID, C_ID) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Math.abs(ThreadLocalRandom.current().nextInt()));            
            pst.setString(3, V_ID);
            pst.setString(4, C_ID);
            
            // set the Date parameter to the current date
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.toString();
            pst.setString(2, formattedDate);
            pst.execute();
            
            // Update Votes count for Candidate
            sql = "UPDATE Candidate SET Votes_count='"+ secretaryVote +"' WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Secretary'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void updateForTreasurer(){
        try{
            String C_ID;
            String V_ID;
            String sql;
            // get  name of Voter
            String[] nameVoter = splitName(nameLbl.getText());
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);

            // get V_ID of Voter
            sql = "SELECT V_ID FROM Voter WHERE First_name = ? AND Last_name = ? AND Middle_name = ?";
            pst = conn.prepareCall(sql);
            pst.setString(1, nameVoter[0]);            
            pst.setString(2, nameVoter[2]);            
            pst.setString(3, nameVoter[1]);

            rs = pst.executeQuery();
            
            if (rs.next()) {
            V_ID = rs.getString("V_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for voter");
            }
            
            // get C_ID of Candidate
            sql = "SELECT C_ID FROM Candidate WHERE First_name = ? AND Middle_name = ? AND Last_name = ? AND Position = 'Treasurer'";
            pst = conn.prepareCall(sql);
            pst.setString(1, stringName[0]);            
            pst.setString(2, stringName[1]);            
            pst.setString(3, stringName[2]);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            C_ID = rs.getString("C_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for candidate");
            }
            
                        // Create a Votes
            sql = "INSERT INTO Votes (Votes_ID, Date, V_ID, C_ID) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Math.abs(ThreadLocalRandom.current().nextInt()));            
            pst.setString(3, V_ID);
            pst.setString(4, C_ID);
            
            // set the Date parameter to the current date
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.toString();
            pst.setString(2, formattedDate);
            pst.execute();
            
             sql = "UPDATE Candidate SET Votes_count='"+ treasurerVote +"' WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Treasurer'";
            pst = conn.prepareStatement(sql);
            pst.execute();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateForAuditors(){
        try{
        String C_ID;
            String V_ID;
            String sql;
            // get  name of Voter
            String[] nameVoter = splitName(nameLbl.getText());
            // get the selected item from the candidateCombo combo box
            String selectedItem = (String) candidateCombo.getSelectedItem();
            // get the String name including 3 part first, middle, and last
            String[] stringName = splitName(selectedItem);
    
            // get V_ID of Voter
            sql = "SELECT V_ID FROM Voter WHERE First_name = ? AND Last_name = ? AND Middle_name = ?";
            pst = conn.prepareCall(sql);
            pst.setString(1, nameVoter[0]);            
            pst.setString(2, nameVoter[2]);            
            pst.setString(3, nameVoter[1]);

            rs = pst.executeQuery();
            
            if (rs.next()) {
            V_ID = rs.getString("V_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for voter");
            }
            
            // get C_ID of Candidate
            sql = "SELECT C_ID FROM Candidate WHERE First_name = ? AND Middle_name = ? AND Last_name = ? AND Position = 'Auditor'";
            pst = conn.prepareCall(sql);
            pst.setString(1, stringName[0]);            
            pst.setString(2, stringName[1]);            
            pst.setString(3, stringName[2]);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            C_ID = rs.getString("C_ID");
            } else {
                // handle the case where no records were found
                throw new RuntimeException("No records found for candidate");
            }
            
                        // Create a Votes
            sql = "INSERT INTO Votes (Votes_ID, Date, V_ID, C_ID) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Math.abs(ThreadLocalRandom.current().nextInt()));            
            pst.setString(3, V_ID);
            pst.setString(4, C_ID);
            
            // set the Date parameter to the current date
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.toString();
            pst.setString(2, formattedDate);
            pst.execute();
            
             sql = "UPDATE Candidate SET Votes_count='"+ auditorVote +"' WHERE First_name='"+stringName[0]+"' AND Middle_name='"+stringName[1]+"' AND Last_name='"+stringName[2]+"' AND position='Auditor'";
            pst = conn.prepareStatement(sql);
            pst.execute();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voteCombo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        positionCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        candidateCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jobLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        addsLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please select your candidates", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        voteCombo.setText("Vote");
        voteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteComboActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Position");

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        positionCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        positionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "President", "Secretary", "Auditor", "Treasurer" }));
        positionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionComboActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Pick the candidate in the list:");

        jLabel1.setText("Candidate");

        candidateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                candidateComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(voteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(positionCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 258, Short.MAX_VALUE)
                            .addComponent(candidateCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(candidateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voteCombo)
                    .addComponent(exitBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Please Vote Wisely!");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voter Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Age:");

        nameLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(102, 0, 0));
        nameLbl.setText("Name");
        nameLbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                nameLblAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Address");

        jobLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jobLbl.setForeground(new java.awt.Color(102, 0, 0));
        jobLbl.setText("Job");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Name:");

        ageLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ageLbl.setForeground(new java.awt.Color(102, 0, 0));
        ageLbl.setText("Age");

        addsLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addsLbl.setForeground(new java.awt.Color(102, 0, 0));
        addsLbl.setText("Address");

        genderLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        genderLbl.setForeground(new java.awt.Color(102, 0, 0));
        genderLbl.setText("Gender");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Gender:");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Job:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderLbl)
                    .addComponent(ageLbl)
                    .addComponent(nameLbl))
                .addGap(249, 249, 249)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jobLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(addsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(nameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ageLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(genderLbl))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jobLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        Login l = new Login();
        close();
        l.setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void voteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteComboActionPerformed
      
        if(candidateCombo.getSelectedIndex()== -1 || positionCombo.getSelectedIndex() == -1){
               JOptionPane.showMessageDialog(null, "Please Choose Your Candidates");
           }else{
                int des = JOptionPane.showConfirmDialog(null, "Finish Voting?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(des==0){
                    if(positionCombo.getSelectedItem() == "Secretary"){
                        selectVoteCountForSecretary();
                        updateForSecretary();
                    } else if(positionCombo.getSelectedItem() == "Auditor"){
                        selectVoteCountForAuditors();
                        updateForAuditors();
                    } else if(positionCombo.getSelectedItem() == "Treasurer") {
                        selectVoteCountForTreasurer();
                        updateForTreasurer();
                    } else {
                        selectVoteCountForPresident();
                        updateForPresident();
                    }
                    JOptionPane.showMessageDialog(null, "Voted Successfully!");
                }
        }
    }//GEN-LAST:event_voteComboActionPerformed

    private void positionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionComboActionPerformed
        // TODO add your handling code here:
//        if(positionCombo.getSelectedIndex() == 0) {
//            populatePresident();
//        }

        candidateCombo.removeAllItems(); // clear the combo box before adding new items
        if(positionCombo.getSelectedItem() == "Secretary") {
            populateSecretary();
        } else if(positionCombo.getSelectedItem() == "Auditor") {
            populateAuditors();
        } else if (positionCombo.getSelectedItem() == "President") {
            populatePresident();
        } else {
            populateTreasurer();
        }
         
                
        
    }//GEN-LAST:event_positionComboActionPerformed

    private void nameLblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_nameLblAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_nameLblAncestorAdded

    private void candidateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candidateComboActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_candidateComboActionPerformed

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
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel addsLbl;
    public static javax.swing.JLabel ageLbl;
    private javax.swing.JComboBox<String> candidateCombo;
    private javax.swing.JButton exitBtn;
    public static javax.swing.JLabel genderLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel jobLbl;
    public static javax.swing.JLabel nameLbl;
    private javax.swing.JComboBox positionCombo;
    private javax.swing.JButton voteCombo;
    // End of variables declaration//GEN-END:variables
}
