/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.DoanBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import DTO.NguoidiDTO;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
/**
 *
 * @author USER
 */
public class RemoveButtonDoanRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removebtn;
    private JTable table;
    Icon editIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-delete-20.png"));
    DoanBLL doanbll = new DoanBLL();
    NhanVienBLL nhanvienBll = new NhanVienBLL();
    KhachHangBLL khachBll = new KhachHangBLL();
    
    public RemoveButtonDoanRender(JTable table){
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
                        
                        doanbll.docNguoidi();
                        String arrNhanvienProp[] = null;
                        String arrKhachProp[] = null;
                        for (NguoidiDTO a : DoanBLL.sumArrNguoidi) {
                            if (a.getDoan_id() == id) {
                                arrNhanvienProp = a.getNguoidi_dsnhanvien().split(",");
                                arrKhachProp = a.getNguoidi_dskhach().split(",");
                                break;
                            }
                        }
                        for(String a : arrNhanvienProp) {
                            nhanvienBll.suaTrangthai(Integer.parseInt(a.split("-")[0]), 0);
                        }
                        for (String a : arrKhachProp) {
                            khachBll.suaTrangthai(Integer.parseInt(a), 0);
                        }
                        doanbll.xoaDoan(id);
                        JOptionPane.showMessageDialog(null, "Xóa đoàn thành công");
                        OverrallFrame.changeMainInfo(3);
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
