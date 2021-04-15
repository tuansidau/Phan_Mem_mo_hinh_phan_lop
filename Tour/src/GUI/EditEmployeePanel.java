/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.NhanVienBLL;
import BLL.NhiemvuBLL;
import DTO.NhanvienDTO;
import DTO.NhiemvuDTO;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Nam
 */
public class EditEmployeePanel extends javax.swing.JPanel {
    JTextFieldDateEditor ngaysinhTxt;
    NhanVienBLL bll = new NhanVienBLL();
    NhiemvuBLL bllNhiemvu = new NhiemvuBLL();
    NhanvienDTO dto;
    CheckLoi cl = new CheckLoi();
    FormatTable format = new FormatTable();
    DefaultTableModel modelDs =new DefaultTableModel();
    DefaultTableModel model =new DefaultTableModel();
    public static int currentIdnhanvien;
    String arr[] = null;

    /**
     * Creates new form EmployeePanel
     */
    public EditEmployeePanel() {
        initComponents();
        init();
    }
    
    public void init()
    {
        ngaysinhTxt = (JTextFieldDateEditor) dateTxt.getDateEditor();
        ngaysinhTxt.setEditable(false);
        format.formatTablenoIcon(nhiemvuTable);
        format.formatTablenoIcon(dsnhiemvuTable);
              
        
        //table nhan vien
        Vector header = new Vector();
        header.add("Tên nhiệm vụ");
        header.add("");
        if (modelDs.getRowCount()==0)
        { 
                modelDs=new DefaultTableModel(header,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {          
                    if(column == 1)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        } 
        dsnhiemvuTable.setModel(modelDs);
        dsnhiemvuTable.getColumnModel().getColumn(1).setCellEditor(new Add());
        dsnhiemvuTable.getColumnModel().getColumn(1).setCellRenderer(new Add());
        dsnhiemvuTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        dsnhiemvuTable.getColumnModel().getColumn(0).setPreferredWidth(260);
        
        if (model.getRowCount()==0)
        { 
                model=new DefaultTableModel(header,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {          
                    if(column == 1)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        } 
        nhiemvuTable.setModel(model);
        nhiemvuTable.getColumnModel().getColumn(1).setCellEditor(new Remove());
        nhiemvuTable.getColumnModel().getColumn(1).setCellRenderer(new Remove());
        nhiemvuTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        nhiemvuTable.getColumnModel().getColumn(0).setPreferredWidth(260);
        
        bllNhiemvu.docNhiemvu();
        
        //Set info 
        bll.docNhanvien();
        idLb.setText(String.valueOf(currentIdnhanvien));
        for(NhanvienDTO a : NhanVienBLL.sumArr)
        {
            if(a.getNv_id() == currentIdnhanvien)
            {
                tenTxt.setText(a.getNv_ten());
                sdtTxt.setText(a.getNv_sdt());
                ngaysinhTxt.setText(a.getNv_ngaysinh());
                emailTxt.setText(a.getNv_email());
                arr = a.getNv_nhiemvu().split(",");
                break;
            }
        }        
        
        for(String a : arr)
        {
            Vector row = new Vector();
            row.add(a);
            model.addRow(row);           
        }
        nhiemvuTable.setModel(model);
        setDsnhiemvu();

    }
    public boolean checkTrungnhiemvu(String str)
    {
        boolean check = true;
        for(String a : arr)
        {
            if(str.equals(a))
            {
                check = false;
                break;
            }
        }
        return check;
    }
    
    public void setDsnhiemvu()
    {
        try
        {
            int rowCount = modelDs.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                modelDs.removeRow(i);
            }
            for(NhiemvuDTO nv : NhiemvuBLL.sumArr)
            {
                if(checkTrungnhiemvu(nv.getNv_ten()))
                {
                    Vector row = new Vector();
                    row.add(nv.getNv_ten());

                    modelDs.addRow(row);
                }
            }
            dsnhiemvuTable.setModel(modelDs);
        
        } catch(Exception e) {
            System.out.println("Lỗi đọc nhiệm vụ GUI");
        }
    }
    
    public void suaNhanvien()
    {
        if(check())
        {
            dto = new NhanvienDTO(currentIdnhanvien ,tenTxt.getText(), sdtTxt.getText(), ngaysinhTxt.getText(), emailTxt.getText(), getNhiemvu());
            bll.suaNhanvien(dto);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            OverrallFrame.changeMainInfo(5);
        }
    }
    public String getNhiemvu()
    {
        String res = "";
        int rows = nhiemvuTable.getRowCount();
        if(rows != 0)
        {
            for(int num = 0; num < rows; num++)
            {
                res += nhiemvuTable.getValueAt(num, 0) + ",";                    
            }
        }                   
        return res;
    }
    
    public boolean check()
    {
        boolean check = true;
        if(tenTxt.getText().equals(""))
        {
            tenErr.setText("Chưa nhập tên");
            check = false;
        } else {
            tenErr.setText("");
        }
        //---------------------------------
        if(sdtTxt.getText().equals(""))
        {
            sdtErr.setText("Chưa nhập số điện thoại");
            check = false;
        } else if(cl.kiemtraSDT(sdtTxt.getText()) == false) {
            sdtErr.setText("Số điện thoại phải có 10 chữ số (0 + 9 chữ số)");
        } else {
            sdtErr.setText("");
        }

        //---------------------------------
        if(emailTxt.getText().equals(""))
        {
            emailErr.setText("Chưa nhập Email");
            check = false;
        } else if(cl.kiemtraEmail(emailTxt.getText()) == false) {
            emailErr.setText("Email không đúng định dạng");
            check = false;
        } else {
            emailErr.setText("");
        }
        //---------------------------------
        Date today = new Date();
        int compare = 0;
        if(!ngaysinhTxt.getText().equals(""))
        {
            compare = today.getYear() - dateTxt.getDate().getYear();
        }
        if(ngaysinhTxt.getText().equals(""))
        {
            ngaysinhErr.setText("Chưa chọn ngày sinh");
            check = false;
        } else if(dateTxt.getDate().after(today)) {
            ngaysinhErr.setText("Ngày sinh không hợp lý");
            check = false;
        } else if(compare < 18 || compare > 55) {
            ngaysinhErr.setText("Tuổi nhân viên không hợp lệ(18 < tuổi < 55)");
            check = false;
        } else {
            ngaysinhErr.setText("");
        }
        //---------------------------------
        if(nhiemvuTable.getRowCount() == 0)
        {
            nhiemvuErr.setText("Chưa chọn nhiệm vụ");
            check = false;
        } else {
            nhiemvuErr.setText("");
        }
        return check;
    }
class Remove extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    JButton removebtn;
    Icon removeIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-do-not-disturb-20.png"));
    public Remove(){
        removebtn = new JButton();
        removebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removebtn.setIcon(removeIcon);
        removebtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                   
                    int i = nhiemvuTable.getSelectedRow();
                    
                    Vector row = new Vector();
                    row.add(nhiemvuTable.getValueAt(i, 0));
                    modelDs.addRow(row);
                    dsnhiemvuTable.setModel(modelDs);
                  
                    model.removeRow(i);
                   
                    stopCellEditing();
                } catch(Exception err) {
                    System.out.println(err);}
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
class Add extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    JButton addbtn;
    JComboBox nhiemvuCbb = new JComboBox();
    Icon addIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-ok-20.png"));
    public Add(){
        addbtn = new JButton();
        addbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addbtn.setIcon(addIcon);
        addbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                    
                    int i = dsnhiemvuTable.getSelectedRow();
                    
                    Vector row = new Vector();
                    row.add(dsnhiemvuTable.getValueAt(i, 0));
                    model.addRow(row);
                    nhiemvuTable.setModel(model);
                  
                    modelDs.removeRow(i);
                    
                    stopCellEditing();
                } catch(Exception err) {
                    System.out.println(err);}
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
        if (value instanceof Icon) addbtn.setIcon((Icon)value);
        return addbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) addbtn.setIcon((Icon)value);
        return addbtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ngaysinhErr = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tenTxt = new javax.swing.JTextField();
        tenErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sdtErr = new javax.swing.JLabel();
        sdtTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nhiemvuErr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        emailErr = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        dateTxt = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsnhiemvuTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        nhiemvuTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idLb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Chọn ngày sinh:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        ngaysinhErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaysinhErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(ngaysinhErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 480, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Nhập tên nhân viên:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));
        jPanel1.add(tenTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 740, 30));

        tenErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tenErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(tenErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 480, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Nhập số điện thoại:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        sdtErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        sdtErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(sdtErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 480, 30));
        jPanel1.add(sdtTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 740, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Chọn nhiệm vụ:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 30));

        nhiemvuErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        nhiemvuErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(nhiemvuErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 480, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Nhập email:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        emailErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        emailErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(emailErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 480, 30));
        jPanel1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 740, 30));

        dateTxt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 740, 30));

        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-save-all-20.png"))); // NOI18N
        saveBtn.setText("Lưu thông tin");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 170, 30));

        dsnhiemvuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dsnhiemvuTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 220, 160));

        nhiemvuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(nhiemvuTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 230, 160));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-hand-with-pen-30.png"))); // NOI18N
        jLabel1.setText("SỬA THÔNG TIN NHÂN VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("NHÂN VIÊN ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 27, -1, 20));

        idLb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        idLb.setForeground(new java.awt.Color(255, 51, 0));
        idLb.setText("id");
        jPanel1.add(idLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 70, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-right-arrow-30.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-left-arrow-30.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 780, 540));

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-clear-symbol-20.png"))); // NOI18N
        backBtn.setText(" Quay lại");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        int answer = JOptionPane.showConfirmDialog(null, "Xác nhận sửa?", null, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) 
        {
            suaNhanvien();
            
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        OverrallFrame.changeMainInfo(5);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser dateTxt;
    private javax.swing.JTable dsnhiemvuTable;
    private javax.swing.JLabel emailErr;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel idLb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ngaysinhErr;
    private javax.swing.JLabel nhiemvuErr;
    private javax.swing.JTable nhiemvuTable;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel sdtErr;
    private javax.swing.JTextField sdtTxt;
    private javax.swing.JLabel tenErr;
    private javax.swing.JTextField tenTxt;
    // End of variables declaration//GEN-END:variables
}
