/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DBConnection.DBConnection;
import core.Lop;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Pro
 */
public class LopDAO {

    DBConnection db = new DBConnection();

    public void loadComboboxLop(JComboBox cb) throws SQLException {

        String sql = "select Distinct MALOP from LOP";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cb.addItem(rs.getString("MALOP"));
        }

    }

    public void loadComboboxTenLop(JComboBox cb) throws SQLException {

        String sql = "select Distinct TENLOP from LOP";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cb.addItem(rs.getString("TENLOP"));
        }

    }

    public String tenLop(JComboBox cb) throws SQLException {

        String sql = "select TENLOP from LOP where MALOP = '" + cb.getSelectedItem() + "'";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("TENLOP");
        } else {
            return null;
        }

    }

    public String maLop(JComboBox cb) throws SQLException {

        String sql = "select MALOP from LOP where TENLOP = N'" + cb.getSelectedItem() + "'";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("MALOP");
        } else {
            return null;
        }

    }

    public ArrayList<Lop> findAll() throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_INLOP}");
        ResultSet rs = command.executeQuery();
        ArrayList<Lop> dsLop = new ArrayList<Lop>();

        while (rs.next()) {
            Lop lop = new Lop(rs);
            dsLop.add(lop);
        }
        return dsLop;

    }

    public void themLopPROC(Lop lop) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ThemLop (?,?,?)}");
        command.setString(1, lop.getMALOP());
        command.setString(2, lop.getTENLOP());
        command.setString(3, lop.getMAKHOA());

        command.execute();

    }

    public void capNhatLopPROC(Lop lop) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_CapNhatLop (?,?,?)}");
        command.setString(1, lop.getMALOP());
        command.setString(2, lop.getTENLOP());
        command.setString(3, lop.getMAKHOA());

        command.execute();

    }

    public void xoaLopPROC(String maLop) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_XoaLop (?)}");
        command.setString(1, maLop);
        command.execute();

    }

}
