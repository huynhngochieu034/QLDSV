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
public class Diem {

    private String MASV;
    private String MAMH;
    private int LAN;
    private float DIEM;

    public Diem(String MASV, String MAMH, int LAN, float DIEM) {
        this.MASV = MASV;
        this.MAMH = MAMH;
        this.LAN = LAN;
        this.DIEM = DIEM;
    }

    public Diem() {
    }

    public Diem(ResultSet resultSet) throws SQLException {
        this.setMASV(resultSet.getString("MASV"));
        this.setMAMH(resultSet.getString("MAMH"));
        this.setLAN(resultSet.getInt("LAN"));
        this.setDIEM(resultSet.getFloat("DIEM"));
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }

    public int getLAN() {
        return LAN;
    }

    public void setLAN(int LAN) {
        this.LAN = LAN;
    }

    public float getDIEM() {
        return DIEM;
    }

    public void setDIEM(float DIEM) {
        this.DIEM = DIEM;
    }

}
