/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReport;

import DBConnection.DBConnection;
import UI.Program;
import java.sql.Connection;
import java.util.Date;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pro
 */
public class reportDiem {

    public String rptName;

    public reportDiem(String tenLop, String tenMH, String maMH, Date ngayThi, int Lan, String maLop) throws JRException {

        System.out.println("" + maLop);
        System.out.println("" + Lan);
        System.out.println("" + ngayThi);
        System.out.println("" + maMH);
        if (Program.serverName.equals("DESKTOP-BE43UO7\\HIEU_1")) {
            rptName = "reportDiemCNTT";
        } else {
            rptName = "reportDiemVT";
        }
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        Hashtable hashtable = new Hashtable();
        hashtable.put("tenLop", tenLop);
        hashtable.put("tenMH", tenMH);
        hashtable.put("maMH", maMH);
        hashtable.put("ngayThi", ngayThi);
        hashtable.put("maLop", maLop);
        hashtable.put("Lan", Lan);
        hashtable.put("chuKy", " ");
        hashtable.put("soTo", 1);

        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Pro\\Documents\\NetBeansProjects\\QLDSV\\src\\JasperReport\\" + rptName + ".jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jr, hashtable, conn);
        JasperViewer.viewReport(jasperPrint, false);

    }

}
