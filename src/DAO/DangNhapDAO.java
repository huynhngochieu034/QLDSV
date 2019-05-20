/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Pro
 */
public class DangNhapDAO {

    DBConnection db = new DBConnection();

    public void loadCombobox(JComboBox cbKhoa) throws SQLException {

        String sql = "select description from V_DSPM";
        Connection conn = db.getConnectionAdmin();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cbKhoa.addItem(rs.getString(1));
        }

    }

    public String getServerName(JComboBox cbKhoa) throws SQLException {

        String sql = "select subscriber_server from V_DSPM where description =N'" + cbKhoa.getSelectedItem() + "'";
        Connection conn = db.getConnectionAdmin();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("subscriber_server");
        } else {
            return null;
        }

    }

    public String getPermission(String userName) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_DANGNHAP(?)}");
        command.setString(1, userName);
        ResultSet rs = command.executeQuery();
        if (rs.next()) {
            return rs.getString("TENNHOM");
        }
        return null;
    }

}
