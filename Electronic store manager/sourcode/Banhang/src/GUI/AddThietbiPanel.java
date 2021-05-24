/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ImageHelper;
import BLL.loaiTBBUS;
import BLL.thietbiBus;
import DTO.loaiDTO;
import DTO.thietbiDTO;
import java.awt.Image;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author HOANG MINH HUY
 */
public class AddThietbiPanel extends javax.swing.JPanel {
private byte[] personalImage;
public final String pathImg = "C:\\Users\\HOANG MINH HUY\\Downloads\\Banhang\\Banhang\\src\\IMG\\";
public static File fileName;

    DefaultListModel<String> model = new DefaultListModel<>();
    
    thietbiDTO tbdto;
    thietbiBus bll = new thietbiBus();
    loaiTBBUS blll=new loaiTBBUS();
    /**
     * Creates new form EditThietbiPanel
     */
    public AddThietbiPanel() {
        initComponents();
        loadCombobox1();
    }
    public void loadCombobox1(){
           for(loaiDTO a : blll.docdsloai())
        {
            coboboxloai.addItem(a.getLoai_id()+ "." + a.getLoai_ten());
            //chontourCbbox.addMouseListener(this);
        }
           lbid.setText(String.valueOf(bll.getsp_id()));
    }
    public boolean check()
    {
        boolean check = true;
        if(tentxt.getText().equals(""))
        {
            tenERR.setText("Chưa nhập tên thiết bị");
            check = false;
        } else {
            tenERR.setText("");
        }
        if(coboboxloai.getItemCount() == 0)
        {
            loaiErr.setText("Chưa có loại thiết bị");
            check = false;
        } else
        {
            loaiErr.setText("");
        }
        //-----------------------------------------
        if(motatxt.getText().equals(""))
        {
            motaErr.setText("Chưa nhập ghi chú");
            check = false;
        } else {
            motaErr.setText("");
        }
        return check;
    }
public void themthietbi()
    {
        if(check())
        {
            int id = bll.getsp_id();
            
            int idLoai = Integer.parseInt(coboboxloai.getSelectedItem().toString().split("\\.")[0]);
      
            String tb = "";
            float tien3=Float.parseFloat(dongiatxt.getText());
     
            tbdto=new thietbiDTO(id, tentxt.getText(), idLoai, motatxt.getText(), 0, 0, tien3);
 //           tbdto = new thietbiDTO(tentxt.getText(),motatxt.getText(),personalImage, id, idLoai , tonkhotxt.getText(), dabantxt.getText(), dongiatxt.getText());
            bll.themThietbi(tbdto);

            JOptionPane.showMessageDialog(null, "Thêm thiết bị thành công");
            
            
            OverrallFrame.changeMainInfo(10);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tentxt = new javax.swing.JTextField();
        motatxt = new javax.swing.JTextField();
        dongiatxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tenERR = new javax.swing.JLabel();
        loaiErr = new javax.swing.JLabel();
        motaErr = new javax.swing.JLabel();
        dongiaErr = new javax.swing.JLabel();
        tonkhoErr = new javax.swing.JLabel();
        dabanErr = new javax.swing.JLabel();
        coboboxloai = new javax.swing.JComboBox<>();
        slErr = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel2.setText("Sp_ten");

        jLabel3.setText("Loai_id");

        jLabel4.setText("sp_mota");

        jLabel5.setText("sp_dongia");

        jButton1.setText("Chọn Ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tenERR.setForeground(new java.awt.Color(255, 51, 51));
        tenERR.setText("  ");

        loaiErr.setText("  ");

        motaErr.setForeground(new java.awt.Color(255, 51, 51));
        motaErr.setText("  ");

        dongiaErr.setForeground(new java.awt.Color(255, 51, 51));
        dongiaErr.setText(" ");

        tonkhoErr.setText("  ");

        dabanErr.setText("  ");

        coboboxloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        slErr.setForeground(new java.awt.Color(255, 51, 51));
        slErr.setText(" ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/label.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm mới thiết bị");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        lbid.setForeground(new java.awt.Color(255, 51, 51));

        jLabel7.setText("ID thiết bị:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(slErr, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tonkhoErr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dabanErr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dongiatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(coboboxloai, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(motaErr, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(motatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dongiaErr, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 38, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(6, 6, 6)
                                .addComponent(lbid, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loaiErr, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenERR, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tentxt, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbid, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(tenERR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tentxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loaiErr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(coboboxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(motaErr)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(motatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dongiaErr)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dongiatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tonkhoErr)
                    .addComponent(slErr))
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(dabanErr))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JFileChooser chooser=new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file.isDirectory()){
                    return true;
                }
                else{
                    return file.getName().toLowerCase().endsWith(".jpg");
                    
                }
 //               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
//   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        if(chooser.showOpenDialog(this)==JFileChooser.CANCEL_OPTION){
            return;
        }
        File file=chooser.getSelectedFile();
        try {
            ImageIcon icon=new ImageIcon(file.getPath());
            Image img=ImageHelper.resize(icon.getImage(), jLabel6.getWidth(), jLabel6.getHeight());
            ImageIcon resizedIcon=new ImageIcon(img);
            fileName=file;
            jLabel6.setIcon(resizedIcon);
//            personalImage=ImageHelper.toByteArray(img, "jpg");
        } catch (Exception e) {
            System.out.println("that bai");
            
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        themthietbi();
        //them anh
        File filemoi = new File(pathImg + lbid.getText() + ".jpg");//dinh dang file bang ma san pham
        fileName.renameTo(filemoi);//chuyển zo thu mục img
        JOptionPane.showMessageDialog(null, "Thêm sản phẩm mới thành công");
        
//        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
public static void main(String[] args) 
    {
        JFrame j = new JFrame();
        j.setSize(1160,700);
        j.setLayout(null);
        JPanel p =new AddThietbiPanel();
        p.setBounds(0, 0, 1160, 700);
        //j.add(g);
        //j.pack();
        j.add(p);
        j.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> coboboxloai;
    private javax.swing.JLabel dabanErr;
    private javax.swing.JLabel dongiaErr;
    private javax.swing.JTextField dongiatxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel loaiErr;
    private javax.swing.JLabel motaErr;
    private javax.swing.JTextField motatxt;
    private javax.swing.JLabel slErr;
    private javax.swing.JLabel tenERR;
    private javax.swing.JTextField tentxt;
    private javax.swing.JLabel tonkhoErr;
    // End of variables declaration//GEN-END:variables
}