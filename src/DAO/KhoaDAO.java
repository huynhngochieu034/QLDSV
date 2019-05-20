/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import DBConnection.DBConnection;
import java.sql.Statement;

/**
 *
 * @author Pro
 */
public class KhoaDAO {

    DBConnection db = new DBConnection();

    public String tenKhoa() throws SQLException {

        String sql = "select TENKH from KHOA";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("TENKH");
        } else {
            return null;
        }

    }

    public String maKhoa() throws SQLException {

        String sql = "select MAKH from KHOA";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("MAKH");
        } else {

            return null;
        }

    }

}
