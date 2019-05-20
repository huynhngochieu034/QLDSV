/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import core.HocPhi;
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
public class HocPhiDAO {

    DBConnection db = new DBConnection();

    public String tongTienTheoLop(String maLop, String nienKhoa, int hocKi) throws SQLException {

        String sql = "select SOTIENDADONG from HOCPHI,SINHVIEN where "
                + "SINHVIEN.MALOP = '" + maLop + "' and NIENKHOA='" + nienKhoa + "' and HOCKY=" + hocKi + "\n"
                + "and SINHVIEN.MASV = HOCPHI.MASV  ";
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String tongTien = "";
        long b = 0L;
        while (rs.next()) {
            b += rs.getInt("SOTIENDADONG");
        }
        tongTien = String.valueOf(b);
        System.out.println("" + tongTien);
        return tongTien;

    }

    public ArrayList<HocPhi> timHocPhi(String maSV) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ISHOCPHI(?)}");
        command.setString(1, maSV);
        ResultSet rs = command.executeQuery();
        ArrayList<HocPhi> list = new ArrayList<>();

        while (rs.next()) {
            HocPhi hocPhi = new HocPhi(rs);
            list.add(hocPhi);
        }

        return list;

    }

    public String kiemTraMaSVhocPhi(String maSV) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_ISHOCPHI(?)}");
        command.setString(1, maSV);
        ResultSet rs = command.executeQuery();
        if (rs.next()) {
            return rs.getString("MASV");
        } else {
            return null;
        }

    }

    public void capNhatHocPhiPROC(HocPhi hocPhi) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_CapNhatHocPhi (?,?,?,?,?)}");
        command.setString(1, hocPhi.getMASV());
        command.setString(2, hocPhi.getNIENKHOA());
        command.setInt(3, hocPhi.getHOCKY());
        command.setInt(4, hocPhi.getHOCPHI());
        command.setInt(5, hocPhi.getSOTIENDADONG());

        command.execute();

    }

}
