/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReport;

import DBConnection.DBConnection;
import UI.Program;
import java.sql.Connection;
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
public class reportBangDiemTongKet {

    public String rptName;

    public reportBangDiemTongKet(String tenLop, String maLop) throws JRException {
        System.out.println("" + maLop);

        if (Program.serverName.equals("DESKTOP-BE43UO7\\HIEU_1")) {
            rptName = "reportBangDiemTongKetCNTT";
        } else {
            rptName = "reportBangDiemTongKetVT";
        }
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        Hashtable hashtable = new Hashtable();
        hashtable.put("maLop", maLop);
        hashtable.put("tenLop", tenLop);
        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Pro\\Documents\\NetBeansProjects\\QLDSV\\src\\JasperReport\\" + rptName + ".jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jr, hashtable, conn);
        JasperViewer.viewReport(jasperPrint, false);

    }

}
