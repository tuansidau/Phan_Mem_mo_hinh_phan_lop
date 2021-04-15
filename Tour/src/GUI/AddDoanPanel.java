/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.DoanBLL;
import BLL.GiatourBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import BLL.TourBLL;
import DTO.DoanDTO;
import DTO.GiaTourDTO;
import DTO.KhachHangDTO;
import DTO.NguoidiDTO;
import DTO.NhanvienDTO;
import DTO.TourDTO;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class AddDoanPanel extends javax.swing.JPanel {
    JTextFieldDateEditor ngaydiTxt;
    JTextFieldDateEditor ngayveTxt;
    DoanBLL bll = new DoanBLL();
    NhanVienBLL nvbll = new NhanVienBLL();
    KhachHangBLL khbll = new KhachHangBLL();
    DoanDTO doandto;
    NguoidiDTO nguoididto;
    TourBLL tourbll = new TourBLL();
    GiatourBLL giatourbll = new GiatourBLL();
    CheckLoi cl = new CheckLoi();
    FormatTable format = new FormatTable();
    DefaultTableModel modelNhanvien =new DefaultTableModel();
    DefaultTableModel modelKhach =new DefaultTableModel();
    DefaultTableModel modeldsKhach =new DefaultTableModel();
    DefaultTableModel modeldsNhanvien =new DefaultTableModel();
    /**
     * Creates new form EmployeePanel
     */
    public AddDoanPanel() {
        initComponents();
        init();
    }
    
    public void init()
    {
        ngaydiTxt = (JTextFieldDateEditor) ngaydi.getDateEditor();
        ngaydiTxt.setEditable(false);
        ngayveTxt = (JTextFieldDateEditor) ngayve.getDateEditor();
        ngayveTxt.setEditable(false);
        nhanvienPanel.setVisible(false);
        khachPanel.setVisible(false);
        format.formatTablenoIcon(khachTable);
        format.formatTablenoIcon(nhanvienTable);
        format.formatTablenoIcon(dsnhanvienTable);
        format.formatTablenoIcon(dskhachTable);
        //cbb tour
        for(TourDTO a : tourbll.docdsdd())
        {
            chontourCbbox.addItem(a.getTour_id() + "." + a.getTour_ten());
            //chontourCbbox.addMouseListener(this);
        }
        //table nhan vien
        Vector headerNv = new Vector();
        headerNv.add("ID");
        headerNv.add("Tên");
        headerNv.add("Nhiệm vụ");
        headerNv.add("");
        if (modelNhanvien.getRowCount()==0)
        { 
                modelNhanvien=new DefaultTableModel(headerNv,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {          
                    if(column == 3)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        } 
        nhanvienTable.setModel(modelNhanvien);
        nhanvienTable.getColumnModel().getColumn(3).setCellEditor(new RemoveNhanvien());
        nhanvienTable.getColumnModel().getColumn(3).setCellRenderer(new RemoveNhanvien());
        nhanvienTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        nhanvienTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        nhanvienTable.getColumnModel().getColumn(1).setPreferredWidth(70);
        nhanvienTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        
        //table ds nhanvien
        nvbll.docNhanvien();
        Vector headerdsNv = new Vector();
        headerdsNv.add("ID");
        headerdsNv.add("Tên");
        headerdsNv.add("Điện thoại");
        headerdsNv.add("Nhiệm vụ");
        headerdsNv.add("Tình Trạng");
        headerdsNv.add("");
        if (modeldsNhanvien.getRowCount()==0)
        { 
                modeldsNhanvien=new DefaultTableModel(headerdsNv,0){
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
        dsnhanvienTable.setModel(modeldsNhanvien);
        docNhanvien();
        dsnhanvienTable.getColumnModel().getColumn(5).setCellEditor(new AddNhanvien());
        dsnhanvienTable.getColumnModel().getColumn(5).setCellRenderer(new AddNhanvien());
        
        dsnhanvienTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        dsnhanvienTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        dsnhanvienTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        dsnhanvienTable.getColumnModel().getColumn(4).setPreferredWidth(53);
        dsnhanvienTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        dsnhanvienTable.getColumnModel().getColumn(5).setPreferredWidth(15);
        
        //table ds khách
        khbll.docKhach();
        Vector headerdsKh = new Vector();
        headerdsKh.add("ID");
        headerdsKh.add("Tên");
        headerdsKh.add("Điện thoại");
        headerdsKh.add("Ghi chú");
        headerdsKh.add("Tình Trạng");
        headerdsKh.add("");
        if (modeldsKhach.getRowCount()==0)
        { 
                modeldsKhach=new DefaultTableModel(headerdsKh,0){
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
        dskhachTable.setModel(modeldsKhach);
        docKhach();
        dskhachTable.getColumnModel().getColumn(5).setCellEditor(new AddKhach());
        dskhachTable.getColumnModel().getColumn(5).setCellRenderer(new AddKhach());
        
        dskhachTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        dskhachTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        dskhachTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        dskhachTable.getColumnModel().getColumn(4).setPreferredWidth(53);
        dskhachTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        dskhachTable.getColumnModel().getColumn(5).setPreferredWidth(15);
        
        
        //table kahch hang
        Vector headerKh = new Vector();
        headerKh.add("ID");
        headerKh.add("Tên");
        headerKh.add("");
        if (modelKhach.getRowCount()==0)
        { 
                modelKhach=new DefaultTableModel(headerKh,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {          
                    if(column == 2)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        } 
        khachTable.setModel(modelKhach);
        khachTable.getColumnModel().getColumn(2).setCellEditor(new RemoveKhach());
        khachTable.getColumnModel().getColumn(2).setCellRenderer(new RemoveKhach());
        
        khachTable.getColumnModel().getColumn(2).setPreferredWidth(15);
        khachTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        khachTable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    public void themDoan()
    {
        if(check())
        {
            int id = bll.getIdDoan();
            int idTour = Integer.parseInt(chontourCbbox.getSelectedItem().toString().split("\\.")[0]);
            int idGia = Integer.parseInt(chongiaCbbox.getSelectedItem().toString().split("-")[0]);
            //them doan
            doandto = new DoanDTO(id, idTour , idGia, tendoanTxt.getText(), ngaydiTxt.getText(), ngayveTxt.getText(),
                    chitietTxt.getText());
            bll.themDoan(doandto);
            //them nguoi di
            nguoididto = new NguoidiDTO(getDsnhanvien(), getDskhachhang(), id);
            bll.themNguoidi(nguoididto);
            
            JOptionPane.showMessageDialog(null, "Thêm đoàn đi tour thành công");
            OverrallFrame.changeMainInfo(3);
        }
    }
    public String getDsnhanvien()
    {
       String res = "";
       int rows = nhanvienTable.getRowCount();
       if(rows != 0)
       {
           for(int num = 0; num < rows; num++)
           {
               res += nhanvienTable.getValueAt(num, 0) + "-" + nhanvienTable.getValueAt(num, 2) +",";
           }
       }    
       return res;
    }
    public String getDskhachhang()
    {
       String res = "";
       int rows = khachTable.getRowCount();
       if(rows != 0)
       {
           for(int num = 0; num < rows; num++)
           {
               res += khachTable.getValueAt(num, 0) + ",";
           }
       }    
       return res;
    }
       
//================================Info Panel==================================================== 
    public boolean check()
    {
        boolean check = true;
        if(tendoanTxt.getText().equals(""))
        {
            tenErr.setText("Chưa nhập tên đoàn");
            check = false;
        } else {
            tenErr.setText("");
        }
        //-----------------------------------------
        Date today = new Date();
        if(ngaydiTxt.getText().equals(""))
        {
            ngaydiErr.setText("Chưa chọn ngày đi");
            check = false;
        } else if(ngaydi.getDate().before(today)) {
            ngaydiErr.setText("Ngày đi không thể trước ngày hiện tại");
            check = false;
        } else if(ngaydi.getDate().after(ngayve.getDate())) {
            ngaydiErr.setText("Ngày đi không thể sau ngày về");
            check = false;
        } else {
            ngaydiErr.setText("");
        }
        //-----------------------------------------
        if(ngayveTxt.getText().equals(""))
        {
            ngayveErr.setText("Chưa chọn ngày về");
            check = false;
        } else if(ngayve.getDate().before(today)) {
            ngayveErr.setText("Ngày về không thể trước ngày hiện tại");
            check = false;
        } else if(ngayve.getDate().before(ngaydi.getDate())) {
            ngayveErr.setText("Ngày về không thể trước ngày đi");
            check = false;
        } else {
            ngayveErr.setText("");
        }
        //-----------------------------------------
        if(chitietTxt.getText().equals(""))
        {
            chitietErr.setText("Chưa nhập ghi chú");
            check = false;
        } else {
            chitietErr.setText("");
        }
        if(chongiaCbbox.getItemCount() == 0)
        {
            cbberr.setText("Chưa có giá tour");
            check = false;
        } else
        {
            cbberr.setText("");
        }
        //------------------------------------------
        int rowsnv = nhanvienTable.getRowCount();
        int rowskh = khachTable.getRowCount();
        if(rowsnv == 0 || rowskh == 0)
        {
            JOptionPane.showMessageDialog(null, "Danh sách nhân viên hoặc khách hàng còn trống");
            check = false;
        }
        return check;
    }

//================================Nhân viên Panel====================================================
public void docNhanvien()
    {
        try
        {
            int rowCount = modeldsNhanvien.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                modeldsNhanvien.removeRow(i);
            }
            for(NhanvienDTO nv : NhanVienBLL.sumArr)
            {
                if(nv.isNv_trangthai() == 0)
                {
                    Vector row = new Vector();
                    row.add(nv.getNv_id());
                    row.add(nv.getNv_ten());
                    row.add(nv.getNv_sdt());
                    row.add(nv.getNv_nhiemvu());                    
                    row.add(nv.formatTrangthai());
                    
                    modeldsNhanvien.addRow(row);
                }
            }
            dsnhanvienTable.setModel(modeldsNhanvien);
        
        } catch(Exception e) {
            System.out.println("Lỗi đọc nhân viên GUI");
        }
    }
public void search()
    {
        int rowCount = modeldsNhanvien.getRowCount();//remove all row
        for (int i = rowCount - 1; i >= 0; i--) 
        {
            modeldsNhanvien.removeRow(i);
        }
        for(NhanvienDTO nv : nvbll.search(searchTxt.getText().toUpperCase(), combobox.getSelectedIndex()))
        {
            if(nv.isNv_trangthai() == 0)
            {
                Vector row = new Vector();
                row.add(nv.getNv_id());
                row.add(nv.getNv_ten());
                row.add(nv.getNv_sdt());
                row.add(nv.getNv_nhiemvu());
                row.add(nv.formatTrangthai());

                modeldsNhanvien.addRow(row);
            }
        }
        dsnhanvienTable.setModel(modeldsNhanvien);
    }


    
class RemoveNhanvien extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removeNvbtn;
    Icon removeNvIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-delete-20.png"));
    public RemoveNhanvien(){
        removeNvbtn = new JButton();
        removeNvbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeNvbtn.setIcon(removeNvIcon);
        removeNvbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                   
                    int i = nhanvienTable.getSelectedRow();
                   
                    int id = Integer.parseInt(nhanvienTable.getValueAt(i, 0).toString());
                    nvbll.suaTrangthai(id, 0);
                    docNhanvien();
                   
                    modelNhanvien.removeRow(i);

                   
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
        if (value instanceof Icon) removeNvbtn.setIcon((Icon)value);
        return removeNvbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removeNvbtn.setIcon((Icon)value);
        return removeNvbtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
class AddNhanvien extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton addNvbtn;
    JComboBox nhiemvuCbb = new JComboBox();
    Icon addNvIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-add-20.png"));
    public AddNhanvien(){
        addNvbtn = new JButton();
        addNvbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addNvbtn.setIcon(addNvIcon);
        addNvbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();
                    int i = dsnhanvienTable.getSelectedRow();
                    String arr[] = dsnhanvienTable.getValueAt(i, 3).toString().split(",");
                    for(String a : arr)
                    {
                        nhiemvuCbb.addItem(a);
                    }                   
                    
                    JOptionPane.showMessageDialog(null, nhiemvuCbb, "Chọn nhiệm vụ",
                    JOptionPane.QUESTION_MESSAGE);
                    Vector row = new Vector();
                    row.add(dsnhanvienTable.getValueAt(i, 0));
                    row.add(dsnhanvienTable.getValueAt(i, 1));
                    row.add(nhiemvuCbb.getSelectedItem());
                    modelNhanvien.addRow(row);
                    nhanvienTable.setModel(modelNhanvien);

                    int id = Integer.parseInt(dsnhanvienTable.getValueAt(i, 0).toString());
                    nvbll.suaTrangthai(id, 1);

                    nhiemvuCbb.removeAllItems();
                    modeldsNhanvien.removeRow(i);
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
        if (value instanceof Icon) addNvbtn.setIcon((Icon)value);
        return addNvbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) addNvbtn.setIcon((Icon)value);
        return addNvbtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
//================================Khách hàng Panel====================================================
public void docKhach()
    {
        try
        {
            int rowCount = modeldsKhach.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                modeldsKhach.removeRow(i);
            }
            for(KhachHangDTO nv : KhachHangBLL.sumArr)
            {
                if(nv.isKh_trangthai() == 0)
                {
                    Vector row = new Vector();
                    row.add(nv.getIdkh());
                    row.add(nv.getKh_ten());
                    row.add(nv.getKh_sdt());
                    row.add(nv.getKh_ghichu());
                    row.add(nv.formatTrangthai());

                    modeldsKhach.addRow(row);
                }
            }
            dskhachTable.setModel(modeldsKhach);
        
        } catch(Exception e) {
            System.out.println("Lỗi đọc khách GUI");
        }
    }
    
    public void searchKh()
    {
        int rowCount = modeldsKhach.getRowCount();//remove all row
        for (int i = rowCount - 1; i >= 0; i--) 
        {
            modeldsKhach.removeRow(i);
        }
        for(KhachHangDTO nv : khbll.search(searchTxt1.getText().toUpperCase(), combobox1.getSelectedIndex()))
        {
            if(nv.isKh_trangthai() == 0)
                {
                    Vector row = new Vector();
                    row.add(nv.getIdkh());
                    row.add(nv.getKh_ten());
                    row.add(nv.getKh_sdt());
                    row.add(nv.getKh_ghichu());
                    row.add(nv.formatTrangthai());

                    modeldsKhach.addRow(row);
                }
        }
        dskhachTable.setModel(modeldsKhach);
    }
class RemoveKhach extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removeKhbtn;
    Icon removeKhIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-delete-20.png"));
    public RemoveKhach(){
        removeKhbtn = new JButton();
        removeKhbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeKhbtn.setIcon(removeKhIcon);
        removeKhbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                   stopCellEditing();
                   
                   int i = khachTable.getSelectedRow();
                   
                   int id = Integer.parseInt(khachTable.getValueAt(i, 0).toString());
                   khbll.suaTrangthai(id, 0);
                   docKhach();
                   
                   modelKhach.removeRow(i);
                   
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
        if (value instanceof Icon) removeKhbtn.setIcon((Icon)value);
        return removeKhbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removeKhbtn.setIcon((Icon)value);
        return removeKhbtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
class AddKhach extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton addKhbtn;
    Icon addKhIcon = new ImageIcon(this.getClass().getResource("/ICON/icons8-add-20.png"));
    public AddKhach(){
        addKhbtn = new JButton();
        addKhbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addKhbtn.setIcon(addKhIcon);
        addKhbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    stopCellEditing();

                    int i = dskhachTable.getSelectedRow();
                    Vector row = new Vector();
                    row.add(dskhachTable.getValueAt(i, 0));
                    row.add(dskhachTable.getValueAt(i, 1));
                    modelKhach.addRow(row);
                    khachTable.setModel(modelKhach);

                    int id = Integer.parseInt(dskhachTable.getValueAt(i, 0).toString());
                    khbll.suaTrangthai(id, 1);

                    modeldsKhach.removeRow(i);

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
        if (value instanceof Icon) addKhbtn.setIcon((Icon)value);
        return addKhbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) addKhbtn.setIcon((Icon)value);
        return addKhbtn;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nhanvienBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        khachBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhanvienTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        khachTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chontourCbbox = new javax.swing.JComboBox();
        tendoanTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbberr = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ngaydiErr = new javax.swing.JLabel();
        ngaydi = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        chitietErr = new javax.swing.JLabel();
        ngayve = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        chongiaCbbox = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        chitietTxt = new javax.swing.JTextArea();
        saveBtn = new javax.swing.JButton();
        ngayveErr = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tenErr = new javax.swing.JLabel();
        nhanvienPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dsnhanvienTable = new javax.swing.JTable();
        combobox = new javax.swing.JComboBox();
        searchTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        khachPanel = new javax.swing.JPanel();
        combobox1 = new javax.swing.JComboBox();
        searchTxt1 = new javax.swing.JTextField();
        searchBtn1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        dskhachTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("LẬP DANH SÁCH NGƯỜI ĐI");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        nhanvienBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nhanvienBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-businessman-20.png"))); // NOI18N
        nhanvienBtn.setText("Chọn nhân viên");
        nhanvienBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nhanvienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanvienBtnActionPerformed(evt);
            }
        });
        jPanel2.add(nhanvienBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Danh sách hành khách:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Danh sách nhân viên:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        khachBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        khachBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-management-20.png"))); // NOI18N
        khachBtn.setText("Chọn khách");
        khachBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        khachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachBtnActionPerformed(evt);
            }
        });
        jPanel2.add(khachBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 30));

        nhanvienTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(nhanvienTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 190));

        khachTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(khachTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 280, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 300, 540));

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(0, 51, 255)));
        infoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("LẬP ĐOÀN ĐI TOUR");
        infoPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Chọn tour:");
        infoPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        infoPanel.add(chontourCbbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 30));
        infoPanel.add(tendoanTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 450, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Nhập tên đoàn:");
        infoPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        cbberr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cbberr.setForeground(new java.awt.Color(204, 0, 0));
        infoPanel.add(cbberr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 350, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Ngày đi:");
        infoPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        ngaydiErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaydiErr.setForeground(new java.awt.Color(204, 0, 0));
        infoPanel.add(ngaydiErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 390, 30));

        ngaydi.setDateFormatString("yyyy-MM-dd");
        infoPanel.add(ngaydi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 450, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Ngày về:");
        infoPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));

        chitietErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        chitietErr.setForeground(new java.awt.Color(204, 0, 0));
        infoPanel.add(chitietErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 320, 30));

        ngayve.setDateFormatString("yyyy-MM-dd");
        infoPanel.add(ngayve, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 450, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("Chọn giá tour:");
        infoPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        infoPanel.add(chongiaCbbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 450, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel17.setText("Chi tiết chương trình:");
        infoPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        chitietTxt.setColumns(20);
        chitietTxt.setRows(5);
        jScrollPane4.setViewportView(chitietTxt);

        infoPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 450, 100));

        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-save-all-20.png"))); // NOI18N
        saveBtn.setText("Lưu thông tin");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        infoPanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 170, 30));

        ngayveErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngayveErr.setForeground(new java.awt.Color(204, 0, 0));
        infoPanel.add(ngayveErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 390, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Lọc giá");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        infoPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 30));

        tenErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tenErr.setForeground(new java.awt.Color(204, 0, 0));
        infoPanel.add(tenErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 350, 30));

        jPanel1.add(infoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

        nhanvienPanel.setBackground(new java.awt.Color(255, 255, 255));
        nhanvienPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(0, 51, 255)));
        nhanvienPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dsnhanvienTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(dsnhanvienTable);

        nhanvienPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 460, 460));

        combobox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Tên", "Số điện thoại", "Nhiệm vụ" }));
        nhanvienPanel.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));
        nhanvienPanel.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));

        searchBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-find-and-replace-20.png"))); // NOI18N
        searchBtn.setText("Tìm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        nhanvienPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 80, 30));

        jPanel1.add(nhanvienPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

        khachPanel.setBackground(new java.awt.Color(255, 255, 255));
        khachPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(0, 51, 255)));
        khachPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combobox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Tên", "SDT" }));
        khachPanel.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 30));
        khachPanel.add(searchTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));

        searchBtn1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-find-and-replace-20.png"))); // NOI18N
        searchBtn1.setText("Tìm");
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });
        khachPanel.add(searchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 80, 30));

        dskhachTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(dskhachTable);

        khachPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 460, 460));

        jPanel1.add(khachPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

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

    public void visibleNhanvienPanel()
    {
        if(nhanvienPanel.isVisible())
        {
            nhanvienPanel.setVisible(false);
            nhanvienBtn.setText("Chọn nhân viên");
            khachBtn.setEnabled(true);
            backBtn.setEnabled(true);
        } else
        {
            nhanvienPanel.setVisible(true);
            nhanvienBtn.setText("Đóng");
            khachBtn.setEnabled(false);
            backBtn.setEnabled(false);
        }
    }
    public void visibleInfoPanel()
    {
        if(infoPanel.isVisible())
        {
            infoPanel.setVisible(false);
        } else
        {
            infoPanel.setVisible(true);
        }
    }
    public void visibleKhachPanel()
    {
        if(khachPanel.isVisible())
        {
            khachPanel.setVisible(false);
            khachBtn.setText("Chọn khách");
            nhanvienBtn.setEnabled(true);
            backBtn.setEnabled(true);
        } else
        {
            khachPanel.setVisible(true);
            khachBtn.setText("Đóng");
            nhanvienBtn.setEnabled(false);
            backBtn.setEnabled(false);
        }
    }
    private void nhanvienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanvienBtnActionPerformed
        // TODO add your handling code here:
        visibleInfoPanel();
        visibleNhanvienPanel();
    }//GEN-LAST:event_nhanvienBtnActionPerformed

    private void khachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachBtnActionPerformed
        // TODO add your handling code here:
        visibleInfoPanel();
        visibleKhachPanel();
    }//GEN-LAST:event_khachBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        themDoan();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
        searchKh();
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        OverrallFrame.changeMainInfo(3);
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            
        Date today = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        int id = Integer.parseInt(chontourCbbox.getSelectedItem().toString().split("\\.")[0]);
        for(GiaTourDTO a : giatourbll.docdsgia())
        {
            if(a.gettour_id() == id)
            {
                if(sp.parse(a.getGia_ngay()).after(today))
                {
                    chongiaCbbox.addItem(a.getGia_id() + "-" + a.getGia_sotien());
                }
            }
        }
        } catch(Exception err)
        {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cbberr;
    private javax.swing.JLabel chitietErr;
    private javax.swing.JTextArea chitietTxt;
    private javax.swing.JComboBox chongiaCbbox;
    private javax.swing.JComboBox chontourCbbox;
    private javax.swing.JComboBox combobox;
    private javax.swing.JComboBox combobox1;
    private javax.swing.JTable dskhachTable;
    private javax.swing.JTable dsnhanvienTable;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton khachBtn;
    private javax.swing.JPanel khachPanel;
    private javax.swing.JTable khachTable;
    private com.toedter.calendar.JDateChooser ngaydi;
    private javax.swing.JLabel ngaydiErr;
    private com.toedter.calendar.JDateChooser ngayve;
    private javax.swing.JLabel ngayveErr;
    private javax.swing.JButton nhanvienBtn;
    private javax.swing.JPanel nhanvienPanel;
    private javax.swing.JTable nhanvienTable;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField searchTxt1;
    private javax.swing.JLabel tenErr;
    private javax.swing.JTextField tendoanTxt;
    // End of variables declaration//GEN-END:variables
}
