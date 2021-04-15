/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.KhachHangBLL;
import DTO.KhachHangDTO;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nam
 */
public class EditGuestPanel extends javax.swing.JPanel {
    JTextFieldDateEditor ngaysinhTxt;
    KhachHangBLL bll = new KhachHangBLL();
    KhachHangDTO dto;
    CheckLoi cl = new CheckLoi();
    public static int currentIdkhach;
    /**
     * Creates new form EmployeePanel
     */
    public EditGuestPanel() {
        initComponents();
        init();
    }
    
    public void init()
    {        
        ngaysinhTxt = (JTextFieldDateEditor) dateTxt.getDateEditor();
        ngaysinhTxt.setEditable(false);
        bll.docKhach();
        //Set info 
        idLb.setText(String.valueOf(currentIdkhach));
        for(KhachHangDTO a : KhachHangBLL.sumArr)
        {
            if(a.getIdkh() == currentIdkhach)
            {
                dto = new KhachHangDTO(a.getKh_ten(), a.getKh_sdt(), a.getKh_ngaysinh(),
                        a.getKh_email(), a.getKh_cmnd(),
                        a.getKh_ghichu());
                break;
            }
        }
        
        tenTxt.setText(dto.getKh_ten());
        sdtTxt.setText(dto.getKh_sdt());
        ngaysinhTxt.setText(dto.getKh_ngaysinh());
        emailTxt.setText(dto.getKh_email());
        cmndTxt.setText(dto.getKh_cmnd());
        ghichuTxt.setText(dto.getKh_ghichu());
    }
    
    
    public void suaKhach()
    {
        if(check())
        {
            dto = new KhachHangDTO(currentIdkhach ,tenTxt.getText(), sdtTxt.getText(), ngaysinhTxt.getText(), emailTxt.getText(), cmndTxt.getText(),
                    ghichuTxt.getText());
            bll.suaKhach(dto);
            JOptionPane.showMessageDialog(null, "Sửa thông tin khách thành công");
            OverrallFrame.changeMainInfo(6);
        }
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
            check = false;
        } else {
            sdtErr.setText("");
        }
        //---------------------------------
        if(cmndTxt.getText().equals(""))
        {
            cmndErr.setText("Chưa nhập CMND");
            check = false;
        } else if(cl.kiemtraCmnd(cmndTxt.getText()) == false) {
            cmndErr.setText("CMND phải có 9 chữ số");
            check = false;
        } else if(cmndCheck() == false) {
            cmndErr.setText("Đã có khách hàng khác cùng số CMND này");
            check = false;
        } else {
            cmndErr.setText("");
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
        if(ngaysinhTxt.getText().equals(""))
        {
            ngaysinhErr.setText("Chưa chọn ngày sinh");
            check = false;
        } else if(dateTxt.getDate().after(today)) {
            ngaysinhErr.setText("Ngày sinh không hợp lý");
            check = false;
        } else {
            ngaysinhErr.setText("");
        }
        //---------------------------------
        if(ghichuTxt.getText().equals(""))
        {
            ghichuErr.setText("Chưa nhập ghi chú");
            check = false;
        } else {
            ghichuErr.setText("");
        }
        return check;
    }
    
    public boolean cmndCheck()
    {
        bll.docKhach();
        boolean check = true;
        for(KhachHangDTO a : KhachHangBLL.sumArr)
        {
            if(a.getKh_cmnd().equals(cmndTxt.getText()))
            {
                if(a.getIdkh() == currentIdkhach)
                {
                    check = true;
                    break;
                } else {
                    check = false;
                    break;
                }
            }
        }
        return check;
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
        jLabel1 = new javax.swing.JLabel();
        ngaysinhErr = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tenTxt = new javax.swing.JTextField();
        tenErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sdtErr = new javax.swing.JLabel();
        sdtTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmndErr = new javax.swing.JLabel();
        cmndTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailErr = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        dateTxt = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        idLb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ghichuErr = new javax.swing.JLabel();
        ghichuTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Chọn ngày sinh:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-hand-with-pen-30.png"))); // NOI18N
        jLabel1.setText("SỬA THÔNG TIN KHÁCH HÀNG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        ngaysinhErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaysinhErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(ngaysinhErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 480, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Nhập tên khách:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));
        jPanel1.add(tenTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 740, 30));

        tenErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tenErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(tenErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 480, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Nhập số điện thoại:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        sdtErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        sdtErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(sdtErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 480, 30));
        jPanel1.add(sdtTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 740, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Nhập cmnd:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        cmndErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cmndErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(cmndErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 480, 30));
        jPanel1.add(cmndTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 740, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Nhập email:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        emailErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        emailErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(emailErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 480, 30));
        jPanel1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 740, 30));

        dateTxt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 740, 30));

        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8-save-all-20.png"))); // NOI18N
        saveBtn.setText("Lưu thông tin");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 170, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("KHÁCH HÀNG ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 27, -1, 20));

        idLb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        idLb.setForeground(new java.awt.Color(255, 51, 0));
        idLb.setText("id");
        jPanel1.add(idLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 70, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Ghi chú:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 30));

        ghichuErr.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ghichuErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(ghichuErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 480, 30));
        jPanel1.add(ghichuTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 740, 30));

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
            suaKhach();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        OverrallFrame.changeMainInfo(6);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cmndErr;
    private javax.swing.JTextField cmndTxt;
    private com.toedter.calendar.JDateChooser dateTxt;
    private javax.swing.JLabel emailErr;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel ghichuErr;
    private javax.swing.JTextField ghichuTxt;
    private javax.swing.JLabel idLb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ngaysinhErr;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel sdtErr;
    private javax.swing.JTextField sdtTxt;
    private javax.swing.JLabel tenErr;
    private javax.swing.JTextField tenTxt;
    // End of variables declaration//GEN-END:variables
}
