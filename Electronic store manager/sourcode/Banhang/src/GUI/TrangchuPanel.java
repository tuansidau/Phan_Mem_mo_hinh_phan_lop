/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nam
 */
public class TrangchuPanel extends javax.swing.JPanel {
    /**
     * Creates new form EmployeePanel
     */
    public TrangchuPanel() {
        initComponents();
        init();
    }
    
    public void init()
    {
    }
//    public static void main(String[] args) {
//        JFrame j = new JFrame();
//        j.setSize(960,700);
//        j.setLayout(null);
//        JPanel p =new GuestMainPanel();
//        p.setBounds(0, 0, 960, 700);
//        j.add(p);
//        j.setVisible(true);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/dash.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 490));

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Xây dựng phần mềm theo phân lớp");
        jLabel2.setToolTipText("");
        jLabel2.setOpaque(true);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 780, 80));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
