/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

/**
 *
 * @author siddharth
 */
public abstract class Table {

    public abstract JTextField[] insert();

    public abstract JTextField delete();

    public abstract JTextField[] update();

    public abstract void search();
}
