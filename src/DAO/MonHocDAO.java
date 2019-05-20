/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import core.MonHoc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Pro
 */
public class MonHocDAO {

    DBConnection db = new DBConnection();

    public void loadComboboxTenMon(JComboBox cb) throws SQLException {

        String sql = "select TENMH from MONHOC";
        Connection conn = db.getConnectionAdmin();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cb.addItem(rs.getString(1));
        }

    }

    public String maMon(JComboBox cb) throws SQLException {

        String sql = "select MAMH from MONHOC where TENMH = N'" + cb.getSelectedItem() + "'";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("MAMH");
        } else {
            return null;
        }

    }

    public ArrayList<MonHoc> findAll() throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_INMONHOC}");
        ResultSet rs = command.executeQuery();
        ArrayList<MonHoc> list = new ArrayList<MonHoc>();

        while (rs.next()) {
            MonHoc monHoc = new MonHoc(rs);
            list.add(monHoc);
        }

        return list;

    }

    public void themMonPROC(MonHoc monHoc) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ThemMonHoc (?,?)}");
        command.setString(1, monHoc.getMAMH());
        command.setString(2, monHoc.getTENMH());

        command.execute();

    }

    public void capNhatMonPROC(MonHoc monHoc) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_CapNhatMonHoc (?,?)}");
        command.setString(1, monHoc.getMAMH());
        command.setString(2, monHoc.getTENMH());

        command.execute();

    }

    public void xoaMonPROC(String maMH) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_XoaMonHoc (?)}");
        command.setString(1, maMH);
        command.execute();

    }
}
