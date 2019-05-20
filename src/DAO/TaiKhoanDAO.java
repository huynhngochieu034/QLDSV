/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pro
 */
public class TaiKhoanDAO {

    DBConnection db = new DBConnection();

    public void taoTaiKhoanPROC(String LGName, String Pass, String UserName, String Role) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_TAOLOGIN(?,?,?,?)}");
        command.setString(1, LGName);
        command.setString(2, Pass);
        command.setString(3, UserName);
        command.setString(4, Role);

        command.execute();

    }

    public void xoaTaiKhoanPROC(String LGName, String UserName) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call Xoa_Login(?,?)}");
        command.setString(1, LGName);
        command.setString(2, UserName);

        command.execute();

    }

    public String getLGName(String userName) throws SQLException {

        Connection conn = db.getConnection();
        CallableStatement command = conn.prepareCall("{call SP_INFORLOGINNAME(?)}");
        command.setString(1, userName);
        ResultSet resultSet = command.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("LGNAME");
        } else {
            return null;
        }

    }

}
