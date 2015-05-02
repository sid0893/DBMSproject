/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import GUIs.*;
import java.awt.Color;
import javax.swing.JFrame;
import java.sql.*;
import tables.Doctor;
import tables.GeneralPhysician;
import tables.Patient;
import tables.PtExaminedBy;
import tables.Speciality;
import tables.Test;
import tables.TestUndertaken;
import tables.TrFollowed;
import tables.Treatment;
import tables.Ward;

/**
 *
 * @author hp
 */
public class TestGUI extends javax.swing.JFrame {

    /**
     * Creates new form TestGUI
     */
    public static TestGUI mTestGUI;
    Connection conn = null;
    Statement stmt = null;

    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost/dbms/";
    //static final String USER = "username";
    //static final String PASS = "password";

    public TestGUI() {
        initComponents();
        initialiseJDBC();
    }

    public void initialiseJDBC() {
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?user=dbms&password=123");

            stmt = conn.createStatement();
            System.out.println("stmt created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableChoice = new javax.swing.JPopupMenu();
        completeDatabaseButton = new javax.swing.JButton();
        proceedButton = new javax.swing.JButton();
        operationComboBox = new javax.swing.JComboBox();
        tableComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Management System");
        setBackground(new java.awt.Color(0, 255, 204));

        completeDatabaseButton.setText("View Complete Database");
        completeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeDatabaseButtonActionPerformed(evt);
            }
        });

        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        operationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search", "Insert", "Delete", "Update", "" }));

        tableComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "doctor", "test", "ward", "test_undertaken", "treatment", "tr_followed", "speciality", "pt_examined_by", "general_physician", "patient" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(proceedButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(completeDatabaseButton)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(proceedButton)
                .addGap(39, 39, 39)
                .addComponent(completeDatabaseButton)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void completeDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeDatabaseButtonActionPerformed
        // TODO add your handling code here:
        new CompleteDatabase().setVisible(true);
    }//GEN-LAST:event_completeDatabaseButtonActionPerformed

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        // TODO add your handling code here:
        int operation = operationComboBox.getSelectedIndex();
        int table = tableComboBox.getSelectedIndex();
        switch (table) {

            case 0:
                //mTable = new Doctor(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        DoctorSearch mDoctorSearch = new DoctorSearch(stmt);
                        mDoctorSearch.setVisible(true);
                        break;
                    case 1:
                        //insert = mTable.insert();
                        DoctorInsert mDoctorInsert = new DoctorInsert(stmt);
                        //System.out.println("doctor insert opened");
                        mDoctorInsert.setVisible(true);
                        break;
                    case 2:
                        //mTable.delete();
                        DoctorDelete mDoctorDelete = new DoctorDelete(stmt);
                        mDoctorDelete.setVisible(true);
                        break;
                    case 3:
                        //mTable.update();
                        DoctorUpdate mDoctorUpdate = new DoctorUpdate(stmt);
                        mDoctorUpdate.setVisible(true);
                        break;

                }
                break;
            case 1:
                //mTable = new Test(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 2:
                //mTable = new Ward(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 3:
                //mTable = new TestUndertaken(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 4:
                //mTable = new Treatment(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 5:
                //mTable = new TrFollowed(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 6:
                //mTable = new Speciality(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 7:

                //mTable = new PtExaminedBy(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 8:
                //mTable = new GeneralPhysician(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;
            case 9:
                //mTable = new Patient(stmt,this);
                switch (operation) {
                    case 0:
                        //mTable.search();
                        break;
                    case 1:
                        //insert = mTable.insert();
                        break;
                    case 2:
                        //mTable.delete();
                        break;
                    case 3:
                        //mTable.update();
                        break;

                }
                break;

        }
        mTestGUI.setVisible(false);
//        OperationPerform mOperationPerform = new OperationPerform(operation,table);
//        mOperationPerform.setVisible(true);
//        mOperationPerform.setSize(400, 350);
//        mOperationPerform.setLocationRelativeTo(null);

        //System.out.println(operation);
    }//GEN-LAST:event_proceedButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//        Connection conn = null;
//        Statement stmt = null;
//        try{
//      
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//     
//      System.out.println("Connecting to database...");
//      
//      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?user=dbms&password=123");
//
//      
//      System.out.println("Creating statement...");
//      stmt = conn.createStatement();
//      String sql;
//      sql = "SELECT name, id, age FROM emp";
//      ResultSet rs = stmt.executeQuery(sql);
//      while(rs.next()){
//         
//          String name = rs.getString("name");
//         int id  = rs.getInt("id");
//         int age = rs.getInt("age");
//         
//         
//         System.out.print("ID: " + id);
//         System.out.print(", Age: " + age);
//         System.out.println(", First: " + name);
//         
//      }
//      rs.close();
//      stmt.close();
//      conn.close();
//   }catch(SQLException se){
//      //Handle errors for JDBC
//      se.printStackTrace();
//   }catch(Exception e){
//      //Handle errors for Class.forName
//      e.printStackTrace();
//   }finally{
//      //finally block used to close resources
//      try{
//         if(stmt!=null)
//            stmt.close();
//      }catch(SQLException se2){
//      }// nothing we can do
//      try{
//         if(conn!=null)
//            conn.close();
//      }catch(SQLException se){
//         se.printStackTrace();
//      }//end finally try
//   }//end try
        //System.out.println("Goodbye!");
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
                mTestGUI.setLocationRelativeTo(null);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completeDatabaseButton;
    private javax.swing.JComboBox operationComboBox;
    private javax.swing.JButton proceedButton;
    private javax.swing.JPopupMenu tableChoice;
    private javax.swing.JComboBox tableComboBox;
    // End of variables declaration//GEN-END:variables
}
