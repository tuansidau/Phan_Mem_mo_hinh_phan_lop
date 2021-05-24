/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class EditButtonGuestRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton editbtn;
    private JTable table;
    Icon editIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-edit-20.png"));

    public EditButtonGuestRender(JTable table){
        editbtn = new JButton();
        this.table = table;
        editbtn.setIcon(editIcon);
        editbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                    int i = table.getSelectedRow();
                    //EditGuestPanel.currentIdkhach = Integer.parseInt(table.getValueAt(i, 0).toString());
                    //OverrallFrame.changeMainInfo(11);
                    stopCellEditing();
                } catch(Exception err) {

                }
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
    
    @Override 
    public boolean stopCellEditing(){
        return super.stopCellEditing();
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Icon) editbtn.setIcon((Icon)value);
        return editbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) editbtn.setIcon((Icon)value);
        return editbtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
