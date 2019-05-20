/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Pro
 */
public class Program {

    public static String serverNameAdmin = "DESKTOP-BE43UO7\\HIEU";
    public static String userNameAdmin = "sa";
    public static String passwordAdmin = "123456";

    public static String serverNamePKT = "DESKTOP-BE43UO7\\HIEU_3";
    public static String userNamePKT = "sa";
    public static String passwordPKT = "123456";

    public static String serverName = "";
    public static String userName = "";
    public static String password = "";
    public static String databaseName = "QLDSV";
    public static String changeSite = "";

    public static String remoteUserName = "HTKN";
    public static String remotePassword = "123456";

    public Program() {

    }

    Program(String serverName, String userName, String password) {
        this.serverName = serverName;
        this.userName = userName;
        this.password = password;
    }

}
