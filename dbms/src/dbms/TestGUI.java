/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.awt.Color;
import javax.swing.JFrame;
import java.sql.*;

/**
 *
 * @author hp
 */
public class TestGUI extends javax.swing.JFrame {

    /**
     * Creates new form TestGUI
     */
    public static TestGUI mTestGUI;
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost/dbms/";
    //static final String USER = "username";
    //static final String PASS = "password";
    public TestGUI() {
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

        TableCommand = new javax.swing.JComboBox();
        TableNames = new javax.swing.JComboBox();
        searchButton = new javax.swing.JButton();
        completeDatabaseButton = new javax.swing.JButton();
        actionButton = new javax.swing.JButton();
        AttributesOfTables = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Management System");
        setBackground(new java.awt.Color(0, 255, 204));

        TableCommand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Update", "Insert", "Delete" }));
        TableCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableCommandActionPerformed(evt);
            }
        });

        TableNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Table 1", "Table 2", "Table 3", "Table 4" }));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        completeDatabaseButton.setText("View Complete Database");
        completeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeDatabaseButtonActionPerformed(evt);
            }
        });

        actionButton.setText("Perform");
        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        AttributesOfTables.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Attr 1", "Attr 2", "Attr 3", "Attr 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("(Ignore for insertions)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TableCommand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(completeDatabaseButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TableNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(AttributesOfTables, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(completeDatabaseButton))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TableCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TableNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AttributesOfTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(actionButton)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableCommandActionPerformed

    private void completeDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeDatabaseButtonActionPerformed
        // TODO add your handling code here:
        new CompleteDatabase().setVisible(true);
    }//GEN-LAST:event_completeDatabaseButtonActionPerformed

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actionButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Search mSearch = new Search();
        mSearch.setLocationRelativeTo(null);
        mSearch.setVisible(true);
        mSearch.setExtendedState(mSearch.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        Connection conn = null;
        Statement stmt = null;
        try{
      //STEP 2: Register JDBC driver
      //Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?user=dbms&password=123");

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT name, id, age FROM emp";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
         //Retrieve by column name
          String name = rs.getString("name");
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         
         //String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Age: " + age);
         System.out.println(", First: " + name);
         //System.out.println(", Last: " + last);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        System.out.println("Goodbye!");
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                mTestGUI = new TestGUI();
//                //mTestGUI.getContentPane().setBackground(Color.CYAN);
//                mTestGUI.setLocationRelativeTo(null);
//                mTestGUI.setVisible(true);
//                //mTestGUI.setExtendedState(mTestGUI.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//            }
//        });
        
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
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        mTestGUI = new TestGUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mTestGUI.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AttributesOfTables;
    private javax.swing.JComboBox TableCommand;
    private javax.swing.JComboBox TableNames;
    private javax.swing.JButton actionButton;
    private javax.swing.JButton completeDatabaseButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
