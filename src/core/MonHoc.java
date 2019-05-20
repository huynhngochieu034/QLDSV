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
public final class MonHoc {

    private String MAMH;
    private String TENMH;

    public MonHoc() {
    }

    public MonHoc(String MAMH, String TENMH) {
        this.MAMH = MAMH;
        this.TENMH = TENMH;
    }

    public MonHoc(ResultSet resultSet) throws SQLException {
        this.setMAMH(resultSet.getString("MAMH"));
        this.setTENMH(resultSet.getString("TENMH"));

    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String TENMH) {
        this.TENMH = TENMH;
    }

}
