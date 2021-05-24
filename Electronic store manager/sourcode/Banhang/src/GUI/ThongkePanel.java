/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BLL.banhangBLL;
import DTO.hoadonDTO;
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
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
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
    Icon Icon = new ImageIcon(this.getClass().getResource("/ICON/icons8-info-20.png"));

    /**
     * Creates new form thongkePanel
     */
    public ThongkePanel() {
        initComponents();
        load();
    }

    
    public void load(){
        int count=1;
        banhangBLL a = new banhangBLL();
        a.docHd();
        String[] header = {"STT","Ngày lập","Địa chỉ","Tổng tiền","Ghi chú"};
        DefaultTableModel model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        table.setSelectionMode(SINGLE_SELECTION);
        table.setModel(model);
        
         for(hoadonDTO sp : banhangBLL.hdArr){
            Object[] data = {count++,sp.getNgaylap(),sp.getIdkh(),sp.getNguoinhan(),sp.getDiachi(),sp.getNgaygiao(),sp.getGhichu()};
            model.addRow(data);
        }
    }
    public static void main(String[] args) {
        ThongkePanel b = new ThongkePanel();
        JFrame a = new JFrame();
        a.add(b);
        a.setVisible(true);
        
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
        soDoan = new javax.swing.JLabel();
        soKhach = new javax.swing.JLabel();
        doanhthu = new javax.swing.JLabel();
        chiphi = new javax.swing.JLabel();
        lai = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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
        jLabel11.setText("Tổng số hóa đơn đã nhập: 20");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-paid-search-20.png"))); // NOI18N
        jLabel12.setText("Tổng thành viên: 30");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 180, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-increase-20.png"))); // NOI18N
        jLabel13.setText("Tổng doanh thu toàn bộ : 2965.0E7");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 290, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-decrease-20.png"))); // NOI18N
        jLabel14.setText("Tổng chi phí nhập hàng: 2004.0E7");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 780, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void tourCbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tourCbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tourCbbMouseClicked

    private void xemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chiphi;
    private javax.swing.JLabel doanhthu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lai;
    private javax.swing.JLabel lo;
    private javax.swing.JLabel soDoan;
    private javax.swing.JLabel soKhach;
    private javax.swing.JTable table;
    private javax.swing.JComboBox tourCbb;
    private javax.swing.JButton xemBtn;
    // End of variables declaration//GEN-END:variables
}
