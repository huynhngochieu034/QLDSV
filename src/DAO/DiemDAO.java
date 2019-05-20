/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import core.Diem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class DiemDAO {

    DBConnection db = new DBConnection();

    public String timDiemPROC(String maSV, String maMH, int lan) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_INDIEMSV(?,?,?)}");
        command.setString(1, maSV);
        command.setString(2, maMH);
        command.setInt(3, lan);

        ResultSet rs = command.executeQuery();
        if (rs.next()) {
            float kq = rs.getFloat("DIEM");
            return Float.toString(kq);
        } else {
            return null;
        }

    }

    public ArrayList<Diem> findAll() throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_INDIEM}");
        ResultSet rs = command.executeQuery();
        ArrayList<Diem> list = new ArrayList<Diem>();

        while (rs.next()) {
            Diem diem = new Diem(rs);
            list.add(diem);
        }

        return list;

    }

    public void themDiemPROC(Diem diem) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ThemDiem(?,?,?,?)}");
        command.setString(1, diem.getMASV());
        command.setString(2, diem.getMAMH());
        command.setInt(3, diem.getLAN());
        command.setFloat(4, diem.getDIEM());
        command.execute();

    }

    public void capNhatDiemPROC(Diem diem) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_CapNhatDiem (?,?,?,?)}");
        command.setString(1, diem.getMASV());
        command.setString(2, diem.getMAMH());
        command.setInt(3, diem.getLAN());
        command.setFloat(4, diem.getDIEM());

        command.execute();

    }

    public void xoaDiemPROC(String maSV, String maMH, int lan) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_XoaDiem (?,?,?)}");
        command.setString(1, maSV);
        command.setString(2, maMH);
        command.setInt(3, lan);
        command.execute();

    }

}
