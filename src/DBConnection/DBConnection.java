package DBConnection;

import UI.DangNhapGUI;
import UI.Program;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private Connection conn;

    public static String User = "";
    public static String Password = "";
    public static String SVName = "";

    public DBConnection() {
        super();

    }

    public void changeSite() {
        if (Program.changeSite.equals("Change") && !Program.serverName.equals(DangNhapGUI.serverNow)) {
            User = Program.remoteUserName;
            Password = Program.remotePassword;
            SVName = Program.serverName;
        } else {
            User = Program.userName;
            Password = Program.password;
            SVName = Program.serverName;
        }
    }

    public Connection getConnection() {
        changeSite();
        System.out.println("" + User + Password + SVName);
        String url = "jdbc:sqlserver://" + Program.serverName + ";databaseName=" + Program.databaseName + "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, User, Password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            return null;
        }
        return conn;
    }

    public Connection getConnectionAdmin() {

        String url = "jdbc:sqlserver://" + Program.serverNameAdmin + ";databaseName=" + Program.databaseName + "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, Program.userNameAdmin, Program.passwordAdmin);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            return null;
        }
        return conn;
    }

}
