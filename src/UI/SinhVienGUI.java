/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DangNhapDAO;
import DAO.LopDAO;
import DAO.SinhVienDAO;
import static UI.QuanLyGUI.phanQuyen;
import core.Lop;
import core.SinhVien;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pro
 */
public final class SinhVienGUI extends javax.swing.JDialog {

    private SinhVienDAO sinhvienDAO;
    private final DangNhapDAO dangnhapDAO;
    public static String status = "";
    public static Stack<SinhVien> stackSV = null;
    public static Stack<String> stringSV = null;
    public static String MaLop = "";
    private LopDAO lopDAO;

    public SinhVienGUI(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        setColor();
        dangnhapDAO = new DangNhapDAO();
        stackSV = new Stack<>();
        stringSV = new Stack<>();
        dangnhapDAO.loadCombobox(jComboBoxKhoa);
        jComboBoxKhoa.setSelectedItem(DangNhapGUI.siteNow);
        jComboBoxKhoa.removeItem("Phòng Kế Toán");
        danhSachLop();

        //checkPermission();
    }

    public void setColor() {
        this.getContentPane().setBackground(Color.orange);
        this.btnThem.setBackground(Color.GREEN);
        this.btnGhi.setBackground(Color.magenta);
        this.btnXoa.setBackground(Color.red);
        this.jButtonPhucHoi.setBackground(Color.yellow);
        this.btnThoat.setBackground(Color.red);
    }

    public void checkPermission() {

        if (QuanLyGUI.phanQuyen.equals("PGV")) {

        } else if (phanQuyen.equals("KHOA")) {
            this.jComboBoxKhoa.setEnabled(false);
        } else if (phanQuyen.equals("USER")) {
            this.jComboBoxKhoa.setEnabled(false);
        } else if (phanQuyen.equals("PKeToan")) {

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSinhVien = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jButtonPhucHoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxKhoa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jTableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSinhVien);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Add-icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-validated-icon.png"))); // NOI18N
        btnGhi.setText("Sửa");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("                     DANH SÁCH SINH VIÊN");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-exit-icon.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jButtonPhucHoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/redo-icon.png"))); // NOI18N
        jButtonPhucHoi.setText("Phục Hồi");
        jButtonPhucHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPhucHoiActionPerformed(evt);
            }
        });

        jTableLop.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLopMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableLop);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("                                            DANH SÁCH LỚP");

        jLabel3.setText("Khoa:");

        jComboBoxKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxKhoaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(43, 43, 43)
                        .addComponent(btnGhi)
                        .addGap(36, 36, 36)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPhucHoi)
                        .addGap(39, 39, 39)
                        .addComponent(btnThoat)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(40, 40, 40)))
                        .addComponent(jComboBoxKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnGhi)
                        .addComponent(jButtonPhucHoi)
                        .addComponent(btnThoat)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTableLop.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn lớp");
                return;
            }
            status = "Them";
            SinhVienUPDATE add = new SinhVienUPDATE(this, sinhvienDAO);
            add.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        // TODO add your handling code here:
        int row = jTableLop.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn lớp");
            return;
        }
        status = "CapNhat";
        capNhatSinhVien();

    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = jTableLop.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn lớp");
            return;
        }
        xoaSinhVien();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jTableLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLopMouseClicked
        // TODO add your handling code here:
        displaySinhVien();
    }//GEN-LAST:event_jTableLopMouseClicked

    private void jButtonPhucHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPhucHoiActionPerformed
        // TODO add your handling code here:
        int row = jTableLop.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn lớp");
            return;
        }
        if (stringSV.isEmpty() || stackSV.isEmpty()) {
            return;
        } else {
            String check = stringSV.pop();
            if (check.equals("Them")) {
                try {
                    int response = JOptionPane.showConfirmDialog(
                            this, "Bạn có muốn xóa sinh viên vừa thêm không?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response != JOptionPane.YES_OPTION) {
                        return;
                    }
                    // get the current student
                    SinhVien tempSV = stackSV.pop();
                    sinhvienDAO.xoaSinhVienPROC(tempSV.getMASV());
                    displaySinhVien();
                } catch (SQLException ex) {
                    JOptionPane.showConfirmDialog(rootPane, ex.getMessage());
                }
            } else if (check.equals("CapNhat")) {
                try {
                    SinhVien tempSV = stackSV.pop();
                    sinhvienDAO.capNhatSinhVienPROC(tempSV);
                    // refrprocessesh GUI
                    displaySinhVien();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
            } else if (check.equals("Xoa")) {
                try {
                    SinhVien tempSV = stackSV.pop();
                    // delete the student
                    sinhvienDAO.themSinhVienPROC(tempSV);
                    // refrprocessesh GUI
                    displaySinhVien();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex);
                }

            }

        }
    }//GEN-LAST:event_jButtonPhucHoiActionPerformed

    private void jComboBoxKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxKhoaItemStateChanged
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Program.changeSite = "Change";
            Program.serverName = dangnhapDAO.getServerName(jComboBoxKhoa);
            danhSachLop();
            checkPermission();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_jComboBoxKhoaItemStateChanged

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
            java.util.logging.Logger.getLogger(SinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                SinhVienGUI dialog = new SinhVienGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void displaySinhVien() {
        try {
            sinhvienDAO = new SinhVienDAO();
            ArrayList<SinhVien> students = null;

            int row = jTableLop.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn lớp");
                return;
            }

            Lop tempLop = (Lop) jTableLop.getValueAt(row, LopTableModel.OBJECT_COL);

            MaLop = tempLop.getMALOP();
            students = sinhvienDAO.timSinhVienTheoLop(tempLop.getMALOP());
            SinhVienTableModel model = new SinhVienTableModel(students);
            jTableSinhVien.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    public void danhSachLop() {
        try {

            lopDAO = new LopDAO();
            ArrayList<Lop> dsLop = null;
            ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
            dsLop = lopDAO.findAll();
            LopTableModel model = new LopTableModel(dsLop);
            jTableLop.setModel(model);
            SinhVienTableModel modelSV = new SinhVienTableModel(dsSV);
            jTableSinhVien.setModel(modelSV);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }

    public void capNhatSinhVien() {

        try {
            // get the selected item
            int row = jTableSinhVien.getSelectedRow();

            // make sure a row is selected
            if (row < 0) {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn sinh viên");
                return;
            }

            // get the current student
            SinhVien tempStudent = (SinhVien) jTableSinhVien.getValueAt(row, SinhVienTableModel.OBJECT_COL);

            // create dialog
            SinhVienUPDATE dialog = new SinhVienUPDATE(this, sinhvienDAO, tempStudent, true);
            // show dialog
            dialog.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    public void xoaSinhVien() {

        try {
            // get the selected row
            int row = jTableSinhVien.getSelectedRow();

            // make sure a row is selected
            if (row < 0) {
                JOptionPane.showMessageDialog(this,
                        "Bạn phải chọn sinh viên", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // prompt the user
            int response = JOptionPane.showConfirmDialog(
                    this, "Bạn có muốn xóa sinh viên này không?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response != JOptionPane.YES_OPTION) {
                return;
            }

            // get the current student
            SinhVien tempStudent = (SinhVien) jTableSinhVien.getValueAt(row, SinhVienTableModel.OBJECT_COL);

            // delete the student
            sinhvienDAO.xoaSinhVienPROC(tempStudent.getMASV());
            stringSV.push("Xoa");
            stackSV.push(tempStudent);
            // refrprocessesh GUI
            displaySinhVien();

            // show success message
            JOptionPane.showMessageDialog(this,
                    "Xóa sinh viên thành công.", "Deleted",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this,
                    "Lỗi xóa sinh viên: " + exc.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButtonPhucHoi;
    private javax.swing.JComboBox<String> jComboBoxKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLop;
    private javax.swing.JTable jTableSinhVien;
    // End of variables declaration//GEN-END:variables
}
