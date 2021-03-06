/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import JasperReport.reportDanhSachHocPhi;
import DAO.LopDAO;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Pro
 */
public class InDanhSachDongHocPhiCuaLopGUI extends javax.swing.JDialog {

    /**
     * Creates new form InDanhSachDongHocPhiCuaLopGUI
     */
    private LopDAO lopDAO;

    public InDanhSachDongHocPhiCuaLopGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            setColor();
            lopDAO = new LopDAO();
            lopDAO.loadComboboxLop(jComboBox1);
            jComboBox1.setSelectedItem(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    public void setColor() {
        this.getContentPane().setBackground(Color.orange);
        this.jButton1.setBackground(Color.GREEN);
        this.jButton2.setBackground(Color.red);

    }

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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNienKhoa = new javax.swing.JTextField();
        jTextFieldHocKi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DANH SÁCH ĐÓNG HỌC PHÍ");

        jLabel2.setText("Mã Lớp:");

        jLabel3.setText("Niên khóa:");

        jLabel4.setText("Học Kì:");

        jTextFieldNienKhoa.setText("2018-2022");
        jTextFieldNienKhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNienKhoaKeyPressed(evt);
            }
        });

        jTextFieldHocKi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHocKiKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print-scan-icon.png"))); // NOI18N
        jButton1.setText("In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-exit-icon.png"))); // NOI18N
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldHocKi)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 216, Short.MAX_VALUE)
                            .addComponent(jTextFieldNienKhoa, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNienKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextFieldNienKhoa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "vui lòng nhập niên khóa");
        } else if (jTextFieldHocKi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "vui lòng nhập học kì");
        } else {
            try {
                // TODO add your handling code here:
                reportDanhSachHocPhi danhSachHocPhi = new reportDanhSachHocPhi((String) jComboBox1.getSelectedItem(), jTextFieldNienKhoa.getText(), Integer.parseInt(jTextFieldHocKi.getText()));
                this.dispose();
            } catch (SQLException | JRException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNienKhoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNienKhoaKeyPressed
        // TODO add your handling code here:
        jTextFieldNienKhoa.setEditable(false);
        if ((evt.getKeyChar() >= 48 && evt.getKeyChar() <= 57) || evt.getKeyChar() == 45 || evt.getKeyChar() == 8) {
            jTextFieldNienKhoa.setEditable(true);
        }
    }//GEN-LAST:event_jTextFieldNienKhoaKeyPressed

    private void jTextFieldHocKiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHocKiKeyPressed
        // TODO add your handling code here:
        jTextFieldHocKi.setEditable(false);
        if ((evt.getKeyChar() >= 48 && evt.getKeyChar() <= 57) || evt.getKeyChar() == 8) {
            jTextFieldHocKi.setEditable(true);
        }
    }//GEN-LAST:event_jTextFieldHocKiKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InDanhSachDongHocPhiCuaLopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InDanhSachDongHocPhiCuaLopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InDanhSachDongHocPhiCuaLopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InDanhSachDongHocPhiCuaLopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InDanhSachDongHocPhiCuaLopGUI dialog = new InDanhSachDongHocPhiCuaLopGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldHocKi;
    private javax.swing.JTextField jTextFieldNienKhoa;
    // End of variables declaration//GEN-END:variables
}
