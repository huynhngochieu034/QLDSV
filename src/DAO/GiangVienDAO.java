/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import core.GiangVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class GiangVienDAO {

    DBConnection db = new DBConnection();

    public ArrayList<GiangVien> findAll() throws SQLException {

        String sql = "select * from GIANGVIEN";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<GiangVien> list = new ArrayList<GiangVien>();
        while (rs.next()) {
            GiangVien giangVien = new GiangVien(rs);
            list.add(giangVien);
        }
        return list;

    }

}
