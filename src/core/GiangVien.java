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
public class GiangVien {

    private String MAGV;
    private String HO;
    private String TEN;
    private String MAKH;

    public GiangVien(String MAGV, String HO, String TEN, String MAKH) {
        this.MAGV = MAGV;
        this.HO = HO;
        this.TEN = TEN;
        this.MAKH = MAKH;
    }

    public GiangVien() {
    }

    public GiangVien(ResultSet resultSet) throws SQLException {
        this.setMAGV(resultSet.getString("MAGV"));
        this.setHO(resultSet.getString("HO"));
        this.setTEN(resultSet.getString("TEN"));
        this.setMAKH(resultSet.getString("MAKH"));
    }

    public String getMAGV() {
        return MAGV;
    }

    public void setMAGV(String MAGV) {
        this.MAGV = MAGV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

}
