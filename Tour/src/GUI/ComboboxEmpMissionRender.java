/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.NhanVienBLL;
import DTO.NhanvienDTO;
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
public class ComboboxEmpMissionRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JComboBox combo = new JComboBox();;
    private JTable table;
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    NhanVienBLL bll = new NhanVienBLL();
    
    public ComboboxEmpMissionRender(DefaultComboBoxModel model)
    {
        
    }
    
    public ComboboxEmpMissionRender(JTable table)
    {
        this.table = table;
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
//        if (value instanceof DefaultComboBoxModel) combo.setModel((DefaultComboBoxModel)value);
        return combo;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        if (value instanceof DefaultComboBoxModel) combo.setModel((DefaultComboBoxModel)value);
        return combo;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
