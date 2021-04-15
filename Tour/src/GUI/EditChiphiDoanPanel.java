/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChiphiBLL;
import BLL.DoanBLL;
import static BLL.DoanBLL.sumArrDoan;
import BLL.NhanVienBLL;
import DTO.ChiphiDTO;
import DTO.DoanDTO;
import DTO.LoaichiphiDTO;
import DTO.NguoidiDTO;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Nam
 */
public class EditChiphiDoanPanel extends javax.swing.JPanel {
    JTextFieldDateEditor ngaylapTxt;
    FormatTable format = new FormatTable();
    ChiphiBLL bll = new ChiphiBLL();
    ChiphiDTO dto;
    DoanBLL doanBll = new DoanBLL();
    public static int currentDoan_id;
    public static String currentDoan_ten;
    DefaultTableModel model =new DefaultTableModel();
    CheckLoi cl = new CheckLoi();
    Icon removeIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-delete-20.png"));

    
    /**
     * Creates new form EmployeePanel
     */
    public EditChiphiDoanPanel() {
        initComponents();
        init();
    }
    
    public void init()
    {
        idlb.setText(String.valueOf(currentDoan_id));
        format.formatTablenoIcon(table);
        ngaylapTxt = (JTextFieldDateEditor) ngaylap.getDateEditor();
        ngaylapTxt.setEditable(false);
        tendoanTxt.setEditable(false);
        tendoanTxt.setText(currentDoan_ten);
              
        bll.docLoai();
        for(LoaichiphiDTO loai : ChiphiBLL.sumArrLoai)
        {
            loaiCbb.addItem(loai.getCp_ten());
        }
        
        onButtonSave();
        
        Vector header = new Vector();
        header.add("HĐ");
        header.add("Loại");
        header.add("Ngày");
        header.add("Tên");
        header.add("Số tiền");
        header.add("");
        if (model.getRowCount()==0)
        { 
                model=new DefaultTableModel(header,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {          
                    if(column == 5)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        }        
        table.setModel(model);
        
        table.getColumnModel().getColumn(5).setCellEditor(new Remove());
        table.getColumnModel().getColumn(5).setCellRenderer(new Remove());
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        
        setInfo();
    }
    
    public void setInfo()
    {
        String arr[] = null;      
        bll.docChiphi();
        for(ChiphiDTO a : ChiphiBLL.sumArrChiphi)
        {
            if(a.getDoan_id() == currentDoan_id)
            {
                arr = a.getChiphi_chitiet().split(",");
                break;
            }
        }
        for(String a : arr)
        {
            Vector row = new Vector();
            row.add(a.split("\\|")[0]);
            row.add(a.split("\\|")[1]);
            row.add(a.split("\\|")[2]);
            row.add(a.split("\\|")[3]);
            row.add(a.split("\\|")[4]);
            row.add(removeIcon);
            model.addRow(row);
        }
        table.setModel(model);
        saveBtn.setEnabled(true);
        tongtien();
    }
    
    public void suaChiphi()
    {
        dto = new ChiphiDTO(Double.parseDouble(tongtienTxt.getText()), getChitietchiphi(), currentDoan_id);
        bll.suaChiphi(dto);
        JOptionPane.showMessageDialog(null, "Sửa chi phí thành công");
        OverrallFrame.changeMainInfo(3);
    }
    public String getChitietchiphi()
    {
        String res = "";
        int rows = table.getRowCount();
        if(rows != 0)
        {
            for(int num = 0; num < rows; num++)
            {
                res += table.getValueAt(num, 0) + "|" + table.getValueAt(num, 1) + "|" +
                        table.getValueAt(num, 2) + "|" + table.getValueAt(num, 3) + "|" + table.getValueAt(num, 4) + ",";
            }
        }            
        
        return res;
    }
    public void addTable()
    {
        if(check())
        {           
            Vector row = new Vector();
            row.add(hoadonTxt.getText());
            row.add(loaiCbb.getSelectedItem());
            row.add(ngaylapTxt.getText());
            row.add(noidungTxt.getText());
            row.add(sotienTxt.getText());
            row.add(removeIcon);
            model.addRow(row);
            table.setModel(model);
            tongtien();
            onButtonSave();
        }
    }
    
    public boolean check()
    {
        boolean check = true;       
        //-----------------------------------------
        Date today = new Date();
        if(ngaylapTxt.getText().equals(""))
        {
            ngaylapErr.setText("Chưa chọn ngày lập hóa đơn");
            check = false;
        } else if(checkNgaylap() == false) 
        {
            ngaylapErr.setText("Ngày lập hóa đơn ngoài thời gian đoàn đi tour");
            check = false;
        }
//        else if(ngaylap.getDate().after(today)) 
//        {
//            ngaylapErr.setText("Ngày lập hóa đơn không hợp lý");
//            check = false;
//        } 
        else {
            ngaylapErr.setText("");
        }
        //-----------------------------------------
        if(hoadonTxt.getText().equals(""))
        {
            hoadonErr.setText("Chưa nhập mã hóa đơn");
            check = false;
        } else if(checkMahoadon() == false) {
            hoadonErr.setText("Mã hóa đơn này đã có trong chi tiết");
            check = false;
        } else {
            hoadonErr.setText("");
        }
        //-----------------------------------------
        if(noidungTxt.getText().equals(""))
        {
            noidungErr.setText("Chưa nhập nội dung hóa đơn");
            check = false;
        } else {
            noidungErr.setText("");
        }
        //-----------------------------------------
        if(sotienTxt.getText().equals(""))
        {
            sotienErr.setText("Chưa nhập số tiền");
            check = false;
        } else if(cl.kiemtraSo(sotienTxt.getText()) == false) {
            sotienErr.setText("Vui lòng nhập số");
            check = false;
        } else {
            sotienErr.setText("");
        }
        
        return check;
    }
    
    public boolean checkNgaylap()
    {
        boolean check = true;
        try 
        {
            doanBll.docDoan();
            for (DoanDTO a : DoanBLL.sumArrDoan) 
            {
                if (a.getDoan_id() == currentDoan_id) 
                {
                    SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
                    Date ngaydi = sp.parse(a.getDoan_ngaydi());
                    Date ngayve = sp.parse(a.getDoan_ngayve());
                    if(ngaylap.getDate().before(ngaydi) || ngaylap.getDate().after(ngayve))
                    {
                        check = false;
                   
                    }
                    break;
                }
            }
        } catch(Exception e) {}
        return check;
    }
    
    public boolean checkMahoadon()
    {
        boolean check = true;
        if(table.getRowCount() != 0)
        {
            for(int i = 0; i < table.getRowCount(); i++)
            {
                if(table.getValueAt(i, 0).equals(hoadonTxt.getText()))
                {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    public void onButtonSave()
    {
        if(tongtienTxt.getText().equals("0.0"))
        {
            saveBtn.setEnabled(false);
        } else {
            saveBtn.setEnabled(true);
        }
    }
    
    public void tongtien()
    {
        double sum = 0;
        if(table.getRowCount() != 0)
        {
            for(int i = 0; i<table.getRowCount(); i++)
            {
                sum += Double.parseDouble(table.getValueAt(i, 4).toString());
            }
        } else { sum = 0; }
        tongtienTxt.setText(String.valueOf(sum));
    }
    
class Remove extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removebtn;
    public Remove(){
        removebtn = new JButton();
        removebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removebtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                   stopCellEditing();
                   
                   int i = table.getSelectedRow();
                   model.removeRow(i);
                   tongtien();
                   onButtonSave();
                   
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
        sotienErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sotienTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        loaiErr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        hoadonErr = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        ngaylap = new com.toedter.calendar.JDateChooser();
        loaiCbb = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tongtienTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tendoanTxt = new javax.swing.JTextField();
        hoadonTxt = new javax.swing.JTextField();
        ngaylapErr = new javax.swing.JLabel();
        noidungErr = new javax.swing.JLabel();
        noidungTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addTable = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        idlb = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Số tiền:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 30));

        sotienErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        sotienErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(sotienErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 400, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Nhập tên đoàn:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));
        jPanel1.add(sotienTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 450, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Loại chi phí:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        loaiErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        loaiErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(loaiErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 370, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Hóa đơn:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        hoadonErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hoadonErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(hoadonErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 390, 30));

        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-save-all-20.png"))); // NOI18N
        saveBtn.setText("Lưu thông tin");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 170, 30));

        ngaylap.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(ngaylap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 450, 30));

        jPanel1.add(loaiCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 450, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CHI TIẾT CHI PHÍ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 460));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Tổng tiền:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, 40));

        tongtienTxt.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tongtienTxt.setForeground(new java.awt.Color(255, 0, 0));
        tongtienTxt.setText("0.0");
        jPanel2.add(tongtienTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 210, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 300, 540));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("SỬA CHI PHÍ CHUYẾN ĐI TOUR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(tendoanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 450, 30));
        jPanel1.add(hoadonTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 450, 30));

        ngaylapErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaylapErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(ngaylapErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 330, 30));

        noidungErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        noidungErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(noidungErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 380, 30));
        jPanel1.add(noidungTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 450, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Nội dung:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Ngày lập hóa đơn:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 30));

        addTable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        addTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-next-page-20.png"))); // NOI18N
        addTable.setText("Thêm vào chi tiết");
        addTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableActionPerformed(evt);
            }
        });
        jPanel1.add(addTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 190, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("ĐOÀN ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 20));

        idlb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        idlb.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(idlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 70, 40));

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
        suaChiphi();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void addTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableActionPerformed
        // TODO add your handling code here:
        addTable();
    }//GEN-LAST:event_addTableActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        OverrallFrame.changeMainInfo(3);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel hoadonErr;
    private javax.swing.JTextField hoadonTxt;
    private javax.swing.JLabel idlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox loaiCbb;
    private javax.swing.JLabel loaiErr;
    private com.toedter.calendar.JDateChooser ngaylap;
    private javax.swing.JLabel ngaylapErr;
    private javax.swing.JLabel noidungErr;
    private javax.swing.JTextField noidungTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel sotienErr;
    private javax.swing.JTextField sotienTxt;
    private javax.swing.JTable table;
    private javax.swing.JTextField tendoanTxt;
    private javax.swing.JLabel tongtienTxt;
    // End of variables declaration//GEN-END:variables
}
