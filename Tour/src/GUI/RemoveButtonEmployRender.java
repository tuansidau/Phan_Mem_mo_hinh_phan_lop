/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.NhanVienBLL;
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
public class RemoveButtonEmployRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removebtn;
    private JTable table;
    NhanVienBLL bll = new NhanVienBLL();
    Icon editIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-delete-20.png"));

    public RemoveButtonEmployRender(JTable table){
        removebtn = new JButton();
        this.table = table;
        removebtn.setIcon(editIcon);
        removebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removebtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                    int i = table.getSelectedRow();
                    int id = Integer.parseInt(table.getValueAt(i, 0).toString());
                    int answer = JOptionPane.showConfirmDialog(null, "Xác nhận xóa?", null, JOptionPane.WARNING_MESSAGE);
                    if (answer == JOptionPane.YES_OPTION) 
                    {
                        if(table.getValueAt(i, 6).toString().equals("Đã có đoàn"))
                        {
                            JOptionPane.showMessageDialog(null, "Nhân viên này đang trong đoàn đi tour");
                        } else {
                        bll.xoaNhanvien(id);
                        JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công");
                        OverrallFrame.changeMainInfo(5);
                        }
                    }
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
        if (value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
