/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import core.SinhVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DBConnection.DBConnection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Pro
 */
public class SinhVienDAO {

    DBConnection db = new DBConnection();

    public SinhVien timSinhVienTheoMaSV(String maSV) throws SQLException {

        String sql = "SELECT * from SINHVIEN where MASV ='" + maSV + "'";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            SinhVien sinhVien = new SinhVien(rs);

            return sinhVien;
        } else {
            return null;
        }

    }

    public ArrayList<SinhVien> timSinhVienTheoLop(String maLop) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_TimSinhVienTheoLop (?)}");
        command.setString(1, maLop);
        ResultSet rs = command.executeQuery();
        ArrayList<SinhVien> studentList = new ArrayList<SinhVien>();
        while (rs.next()) {

            SinhVien student = new SinhVien(rs);
            studentList.add(student);
        }
        return studentList;

    }

    public void themSinhVienPROC(SinhVien sinhvien) throws SQLException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ThemSinhVien (?,?,?,?,?,?,?,?,?,?)}");
        command.setString(1, sinhvien.getMASV());
        command.setString(2, sinhvien.getHO());
        command.setString(3, sinhvien.getTEN());
        command.setString(4, sinhvien.getMALOP());
        command.setBoolean(5, sinhvien.isPHAI());
        command.setString(6, sdf.format(sinhvien.getNGAYSINH()));
        command.setString(7, sinhvien.getNOISINH());
        command.setString(8, sinhvien.getDIACHI());
        command.setString(9, sinhvien.getGHICHU());
        command.setBoolean(10, sinhvien.isNGHIHOC());

        command.execute();

    }

    public void capNhatSinhVienPROC(SinhVien sinhvien) throws SQLException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_CapNhatSinhVien (?,?,?,?,?,?,?,?,?,?)}");
        command.setString(1, sinhvien.getMASV());
        command.setString(2, sinhvien.getHO());
        command.setString(3, sinhvien.getTEN());
        command.setString(4, sinhvien.getMALOP());
        command.setBoolean(5, sinhvien.isPHAI());
        command.setString(6, sdf.format(sinhvien.getNGAYSINH()));
        command.setString(7, sinhvien.getNOISINH());
        command.setString(8, sinhvien.getDIACHI());
        command.setString(9, sinhvien.getGHICHU());
        command.setBoolean(10, sinhvien.isNGHIHOC());

        command.execute();

    }

    public void xoaSinhVienPROC(String maSV) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_XoaSinhVien (?)}");
        command.setString(1, maSV);
        command.execute();

    }

}
