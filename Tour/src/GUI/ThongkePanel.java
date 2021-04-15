/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChiphiBLL;
import BLL.DoanBLL;
import BLL.GiatourBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import BLL.TourBLL;
import DTO.ChiphiDTO;
import DTO.DoanDTO;
import DTO.GiaTourDTO;
import DTO.KhachHangDTO;
import DTO.NguoidiDTO;
import DTO.NhanvienDTO;
import DTO.TourDTO;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ThongkePanel extends javax.swing.JPanel {
    FormatTable formatTable = new FormatTable();
    DefaultTableModel model =new DefaultTableModel();
    DoanBLL doanBll = new DoanBLL();
    TourBLL tourBll = new TourBLL();
    GiatourBLL giatourBll = new GiatourBLL();
    ChiphiBLL chiphiBll = new ChiphiBLL();
    NhanVienBLL nhanvienbll = new NhanVienBLL();
    KhachHangBLL khachbll = new KhachHangBLL();
    Icon Icon = new ImageIcon(this.getClass().getResource("/ICON/icons8-info-20.png"));

    /**
     * Creates new form thongkePanel
     */
    public ThongkePanel() {
        initComponents();
        init();
    }

    public void init()
    {
        formatTable.formatTablenoIcon(table);
        doanBll.docDoan();
        doanBll.docNguoidi();
        chiphiBll.docChiphi();
        
        //tour cbb
        tourCbb.addItem("--- Chọn tour ---");
        for(TourDTO a : tourBll.docdsdd())
        {
            tourCbb.addItem(a.getTour_id() + "." + a.getTour_ten());
        }
        //Header content of jtable
        Vector header = new Vector();
        header.add("#");
        header.add("Đoàn đi");
        header.add("Số khách");
        header.add("Giá tour");
        header.add("Doanh thu");
        header.add("Tổng chi phí");
        header.add("");
        header.add("Lãi");
        header.add("Lỗ");
        if (model.getRowCount()==0)
        { 
                model=new DefaultTableModel(header,0){
                @Override//No edit
                public boolean isCellEditable(int row, int column) 
                {       
                    if(column == 6)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        } 
        table.setModel(model);
        table.getColumnModel().getColumn(6).setCellEditor(new Info());
        table.getColumnModel().getColumn(6).setCellRenderer(new Info());
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(35);
        table.getColumnModel().getColumn(3).setPreferredWidth(55);
        table.getColumnModel().getColumn(4).setPreferredWidth(55);
        table.getColumnModel().getColumn(6).setPreferredWidth(15);
        table.getColumnModel().getColumn(5).setPreferredWidth(55);
        table.getColumnModel().getColumn(7).setPreferredWidth(55);
        table.getColumnModel().getColumn(8).setPreferredWidth(55);
        
        tongdoanhthu.setText(String.valueOf(toanboDoanhthu()));
        tongchiphi.setText(String.valueOf(toanboChiphi()));
        nhanvienbll.docNhanvien();
        khachbll.docKhach();
        int count1 = 0, count2 = 0;
        for(NhanvienDTO a : NhanVienBLL.sumArr)
        {
            count1++;
        }
        for(KhachHangDTO a : KhachHangBLL.sumArr)
        {
            count2++;
        }
        toanbokhach.setText(String.valueOf(count2));
        toanbonhanvien.setText(String.valueOf(count1));
    }
    public void doc()
    {
        if(tourCbb.getSelectedIndex() != 0)
        {
            String str = tourCbb.getSelectedItem().toString();
            int rowCount = model.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                model.removeRow(i);
            }
            for(DoanDTO a : DoanBLL.sumArrDoan)
            {
                if(a.getTour_id() == Integer.parseInt(str.split("\\.")[0]))
                {
                    
                    Vector row = new Vector();
                    row.add(a.getDoan_id());
                    row.add(a.getDoan_ten());
                    row.add(soKhach(a.getDoan_id()));
                    row.add(getGiatour(a.getDoan_id(), a.getGia_id()));
                    row.add(tinhDoanhthu(a.getDoan_id(), a.getGia_id()));
                    row.add(tongChiphi(a.getDoan_id()));
                    row.add(Icon);
                    
                    double sum = tinhDoanhthu(a.getDoan_id(), a.getGia_id()) - tongChiphi(a.getDoan_id());
                    if(sum >= 0)
                    {
                        row.add(sum);
                        row.add(0);
                    } else {
                        row.add(0);
                        row.add(Math.abs(sum));
                    }
                    
                    model.addRow(row);
                }                
            }
            table.setModel(model);

            //tong
            int rows = table.getRowCount();           
            int tongKhach = 0;
            double tongDoanhthu = 0;
            double tongChiphi = 0;
            double tongLai = 0, tongLo = 0;
            for(int i = 0; i<rows; i++)
            {
                tongKhach += Integer.parseInt(table.getValueAt(i, 2).toString());
                tongDoanhthu += Double.parseDouble(table.getValueAt(i, 4).toString());
                tongChiphi += Double.parseDouble(table.getValueAt(i, 5).toString());
                tongLai += Double.parseDouble(table.getValueAt(i, 7).toString());
                tongLo += Double.parseDouble(table.getValueAt(i, 8).toString());
            }
            soDoan.setText(String.valueOf(rows));
            soKhach.setText(String.valueOf(tongKhach));
            doanhthu.setText(String.valueOf(tongDoanhthu));
            chiphi.setText(String.valueOf(tongChiphi));
            lai.setText(String.valueOf(tongLai));
            lo.setText(String.valueOf(tongLo));
            
        } else {
            int rowCount = model.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                model.removeRow(i);
            }
        }
    }
    public double getGiatour(int doanId, int idGia)
    {
        double gia = 0;
        for(GiaTourDTO a : giatourBll.docdsgia())
        {
            if(a.getGia_id() == idGia)
            {
                gia = a.getGia_sotien();
                break;
            }
        }
        return gia;
    }
    public int soKhach(int doanId)
    {
        String arr[] = null;
        for(NguoidiDTO a : DoanBLL.sumArrNguoidi)
        {
            if(a.getDoan_id() == doanId)
            {
                arr = a.getNguoidi_dskhach().split(",");
                break;
            }
        }
        return arr.length;
    }
    public double toanboDoanhthu()
    {
        double sum = 0;
        for(DoanDTO a : DoanBLL.sumArrDoan)
        {
            sum += tinhDoanhthu(a.getDoan_id(), a.getGia_id());
        }
        return sum;
    }
    public double toanboChiphi()
    {
        double sum = 0;
        for(ChiphiDTO a : ChiphiBLL.sumArrChiphi)
        {
            sum += a.getChiphi_total();
        }
        return sum;
    }
    public double tinhDoanhthu(int doanId, int idGia)
    {
        double gia = 0;
        int soKhach = soKhach(doanId);
        for(GiaTourDTO a : giatourBll.docdsgia())
        {
            if(a.getGia_id() == idGia)
            {
                gia = a.getGia_sotien();
                break;
            }
        }
        return soKhach * gia;
    }
    public double tongChiphi(int doanId)
    {
        double sum = 0;
        for(ChiphiDTO a : ChiphiBLL.sumArrChiphi)
        {
            if(a.getDoan_id() == doanId)
            {
                sum = a.getChiphi_total();
                break;
            }
        }
        return sum;
    }
class Info extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton infobtn;
    public Info(){
        infobtn = new JButton();
        infobtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        infobtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                   stopCellEditing();
                   
                   int i = table.getSelectedRow();
                   if(Double.parseDouble(table.getValueAt(i, 5).toString()) == 0)
                {
                    JOptionPane.showMessageDialog(null, "Đoàn này chưa có chi phí");
                } else {
                   InfoChiphithongke.currentDoan_id = Integer.parseInt(table.getValueAt(i, 0).toString());
                   InfoChiphithongke cp = new InfoChiphithongke();
                   cp.setVisible(true);
                   cp.setLocationRelativeTo(null);
                }  
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
        if(value instanceof Icon) infobtn.setIcon((Icon)value);
        return infobtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) infobtn.setIcon((Icon)value);
        return infobtn;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        tourCbb = new javax.swing.JComboBox();
        xemBtn = new javax.swing.JButton();
        lo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        soDoan = new javax.swing.JLabel();
        soKhach = new javax.swing.JLabel();
        doanhthu = new javax.swing.JLabel();
        chiphi = new javax.swing.JLabel();
        lai = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        toanbonhanvien = new javax.swing.JLabel();
        tongchiphi = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tongdoanhthu = new javax.swing.JLabel();
        toanbokhach = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        table.setFillsViewportHeight(true);
        table.setName(""); // NOI18N
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 280));

        tourCbb.setMaximumRowCount(1000);
        tourCbb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tourCbbMouseClicked(evt);
            }
        });
        jPanel1.add(tourCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 30));

        xemBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        xemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-expand-arrow-20.png"))); // NOI18N
        xemBtn.setText("Xem");
        xemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemBtnActionPerformed(evt);
            }
        });
        jPanel1.add(xemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 90, 30));

        lo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 160, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Tổng số khách:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));

        soDoan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        soDoan.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(soDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, 30));

        soKhach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        soKhach.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(soKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 70, 30));

        doanhthu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        doanhthu.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(doanhthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 150, 30));

        chiphi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chiphi.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(chiphi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 160, 30));

        lai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lai.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lai, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 160, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Tổng tiền lãi:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 90, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Tổng số đoàn:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Tổng doanh thu:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 110, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Tổng chi phí:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 90, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Tổng tiền lãi:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 90, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, 780, 410));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 0, new java.awt.Color(0, 51, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("TỔNG QUÁT");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-financial-success-20.png"))); // NOI18N
        jLabel11.setText("Tổng số khách đã đăng kí:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-paid-search-20.png"))); // NOI18N
        jLabel12.setText("Tổng nhân viên:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 180, 30));

        toanbonhanvien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        toanbonhanvien.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(toanbonhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 180, 30));

        tongchiphi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tongchiphi.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(tongchiphi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 170, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-increase-20.png"))); // NOI18N
        jLabel13.setText("Tổng doanh thu toàn bộ tour :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-decrease-20.png"))); // NOI18N
        jLabel14.setText("Tổng chi phí toàn bộ đoàn:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 30));

        tongdoanhthu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tongdoanhthu.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(tongdoanhthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 170, 30));

        toanbokhach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        toanbokhach.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(toanbokhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 180, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 780, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void tourCbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tourCbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tourCbbMouseClicked

    private void xemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemBtnActionPerformed
        // TODO add your handling code here:
        doc();
    }//GEN-LAST:event_xemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chiphi;
    private javax.swing.JLabel doanhthu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lai;
    private javax.swing.JLabel lo;
    private javax.swing.JLabel soDoan;
    private javax.swing.JLabel soKhach;
    private javax.swing.JTable table;
    private javax.swing.JLabel toanbokhach;
    private javax.swing.JLabel toanbonhanvien;
    private javax.swing.JLabel tongchiphi;
    private javax.swing.JLabel tongdoanhthu;
    private javax.swing.JComboBox tourCbb;
    private javax.swing.JButton xemBtn;
    // End of variables declaration//GEN-END:variables
}
