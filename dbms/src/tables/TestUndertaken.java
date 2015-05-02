/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.awt.Label;
import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author siddharth
 */
public class TestUndertaken extends Table {

    Statement mStatement;
    JFrame container;
    Label mLabel;
    public TestUndertaken(Statement s, JFrame jf){
        mStatement = s;
        container = jf;
        mLabel = new Label("Attribute: p_id, t_id, pres_by, result");
    }
    
    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
