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
public class Lop {

    private String MALOP;
    private String TENLOP;
    private String MAKHOA;

    public Lop() {
        super();
    }

    public Lop(String MALOP, String TENLOP, String MAKHOA) {
        this.MALOP = MALOP;
        this.TENLOP = TENLOP;
        this.MAKHOA = MAKHOA;
    }

    public Lop(ResultSet resultSet) throws SQLException {
        this.setMALOP(resultSet.getString("MALOP"));
        this.setTENLOP(resultSet.getString("TENLOP"));
        this.setMAKHOA(resultSet.getString("MAKH"));
    }

    public String getMALOP() {
        return MALOP;
    }

    public void setMALOP(String MALOP) {
        this.MALOP = MALOP;
    }

    public String getTENLOP() {
        return TENLOP;
    }

    public void setTENLOP(String TENLOP) {
        this.TENLOP = TENLOP;
    }

    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String MAKHOA) {
        this.MAKHOA = MAKHOA;
    }

}
