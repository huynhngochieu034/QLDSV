/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pro
 */
public class HocPhi {

    private String MASV;
    private String NIENKHOA;
    private int HOCKY;
    private int HOCPHI;
    private int SOTIENDADONG;

    public HocPhi() {
    }

    public HocPhi(String MASV, String NIENKHOA, int HOCKY, int HOCPHI, int SOTIENDADONG) {
        this.MASV = MASV;
        this.NIENKHOA = NIENKHOA;
        this.HOCKY = HOCKY;
        this.HOCPHI = HOCPHI;
        this.SOTIENDADONG = SOTIENDADONG;
    }

    public HocPhi(ResultSet resultSet) throws SQLException {
        this.setMASV(resultSet.getString("MASV"));
        this.setNIENKHOA(resultSet.getString("NIENKHOA"));
        this.setHOCKY(resultSet.getInt("HOCKY"));
        this.setHOCPHI(resultSet.getInt("HOCPHI"));
        this.setSOTIENDADONG(resultSet.getInt("SOTIENDADONG"));
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getNIENKHOA() {
        return NIENKHOA;
    }

    public void setNIENKHOA(String NIENKHOA) {
        this.NIENKHOA = NIENKHOA;
    }

    public int getHOCKY() {
        return HOCKY;
    }

    public void setHOCKY(int HOCKY) {
        this.HOCKY = HOCKY;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    public int getSOTIENDADONG() {
        return SOTIENDADONG;
    }

    public void setSOTIENDADONG(int SOTIENDADONG) {
        this.SOTIENDADONG = SOTIENDADONG;
    }

}
