///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tables;
//
//import java.awt.BorderLayout;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Label;
//import java.sql.Statement;
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.Spring;
//import javax.swing.SpringLayout;
//import javax.swing.SwingConstants;
//import javax.swing.plaf.basic.BasicArrowButton;
//
///**
// *
// * @author siddharth
// */
//public class Doctor extends Table {
//
//    Statement mStatement;
//    JFrame container;
//    JPanel mJPanel;
//    Label mLabel;
//    JTextField d_id, d_name, speciality;
//
//    public Doctor(Statement s, JFrame jf) {
//        mStatement = s;
//        container = jf;
//        mLabel = new Label("Attribute List:");
//    }
//
//    @Override
//    public JTextField[] insert() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        //super("Add component on JFrame at runtime");
//        //container.setLayout(new BorderLayout());
////        mJPanel = new JPanel();
////        mJPanel.setLayout(new FlowLayout());
////        container.add(mJPanel, BorderLayout.CENTER);
//        //JButton button = new JButton("CLICK HERE");
//        //container.add(mLabel, BorderLayout.NORTH);
//        //mLabel.setBounds(x, y, mLabel.getWidth(), mLabel.getHeight());
//        //button.addActionListener(this);
//        //container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //container.setSize(500, 500);
//        //setVisible(true);
//        //container.revalidate();
//        //container.setVisible(true);
////        JLabel l1 = new JLabel("d_id");
////        JLabel l2 = new JLabel("d_name");
////        JLabel l3 = new JLabel("speciality");
////        JTextField mJTextField = new JTextField("Text field", 15);
//        Container pane = container.getContentPane();
//        SpringLayout layout = new SpringLayout();
////        layout.putConstraint(SpringLayout.WEST, l1, 15, SpringLayout.WEST, pane);
////        layout.putConstraint(SpringLayout.NORTH, l1, 15, SpringLayout.NORTH, pane);
////        layout.putConstraint(SpringLayout.WEST, l2, 15, SpringLayout.EAST, l1);
////        layout.putConstraint(SpringLayout.NORTH, l2, 15, SpringLayout.NORTH, pane);
////        layout.putConstraint(SpringLayout.WEST, mJTextField, 15, SpringLayout.EAST, l2);
////        layout.putConstraint(SpringLayout.NORTH, mJTextField, 15, SpringLayout.NORTH, pane);
////        
////        layout.putConstraint(SpringLayout.EAST, pane,
////                     5,
////                     SpringLayout.EAST, mJTextField);
////layout.putConstraint(SpringLayout.SOUTH, pane,
////                     5,
////                     SpringLayout.SOUTH, mJTextField);
////        pane.setLayout(layout);
////        pane.add(l1);
////        pane.add(l2);
////        pane.add(mJTextField);
////        //pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
////        mLabel.setAlignment(Label.CENTER);
//        //mLabel.setSize(20, 10);
//        //container.add(Box.createRigidArea(new Dimension(5,15)));
//        //pane.add(mLabel);
//        String[] labels = {"d_id: ", "d_name: ", "speciality: "};
//        JLabel[] jLabels = new JLabel[3];
//        JTextField[] textField=  new JTextField[3];
//        int numPairs = labels.length;
//        
////Create and populate the panel.
//        JPanel p = new JPanel(layout);
//        p.setPreferredSize(new Dimension(400, 300));
//        pane.setLayout(layout);
//        for (int i = 0; i < numPairs; i++) {
//            jLabels[i] = new JLabel(labels[i], JLabel.TRAILING);
//            p.add(jLabels[i]);
//            textField[i] = new JTextField(30);
//            //textField[i].setPreferredSize(new Dimension(1,20));
//            jLabels[i].setLabelFor(textField[i]);
//            p.add(textField[i]);
//        }
//
////Lay out the panel.
//        JButton insertButton = new JButton("Go");
//        //mButton.setAlignmentY(JButton.CENTER_ALIGNMENT);
//        //mButton.setAlignmentX(JButton.BOTTOM_ALIGNMENT);
//        layout.putConstraint(SpringLayout.WEST, insertButton, 60, SpringLayout.WEST, jLabels[2]);
//        layout.putConstraint(SpringLayout.NORTH, insertButton, 10, SpringLayout.NORTH, jLabels[2]);
//        p.add(insertButton);
//        SpringUtilities.makeCompactGrid(p,
//                numPairs, 2,  //rows, cols
//                6, 6,        //initX, initY
//                6, 6);       //xPad, yPad
//        //layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, p, 0, SpringLayout.HORIZONTAL_CENTER, pane);
//        //layout.putConstraint(SpringLayout.VERTICAL_CENTER, p, 0, SpringLayout.WEST, pane);
//        pane.add(p);
//        return textField;
//    }
//
//    @Override
//    public void delete() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Container pane = container.getContentPane();
//        SpringLayout layout = new SpringLayout();
//        JPanel p = new JPanel(layout);
//        //p.setPreferredSize(new Dimension(400, 300));
//        JLabel mJLabel = new JLabel("Where: ", JLabel.TRAILING);
//        p.add(mJLabel);
//        JTextField deleteTextField = new JTextField(30);
//        mJLabel.setLabelFor(deleteTextField);
//        p.add(deleteTextField);
//        JButton deleteButton = new JButton("Go");
//        layout.putConstraint(SpringLayout.WEST, deleteButton, 60, SpringLayout.WEST, mJLabel);
//        layout.putConstraint(SpringLayout.NORTH, deleteButton, 1, SpringLayout.NORTH, mJLabel);
//        p.add(deleteButton);
//        SpringUtilities.makeCompactGrid(p,
//                1, 2,  //rows, cols
//                6, 6,        //initX, initY
//                6, 6);
//        pane.add(p);
//    }
//
//    @Override
//    public void update() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void search() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
