/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReport;

import DAO.SinhVienDAO;
import DBConnection.DBConnection;
import UI.Program;
import core.SinhVien;
import java.sql.Connection;
import java.sql.SQLException;
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
public class reportPhieuDiem {

    public String rptName;
    

    public reportPhieuDiem(String maSV,String tenSV, String hoSV) throws JRException {
        if (Program.serverName.equals("DESKTOP-BE43UO7\\HIEU_1")) {
            rptName = "reportPhieuDiemCNTT";
        } else {
            rptName = "reportPhieuDiemVT";
        }
       
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        Hashtable hashtable = new Hashtable();
        hashtable.put("maSV", maSV);
        hashtable.put("hoSV", hoSV);
        hashtable.put("tenSV", tenSV);
        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Pro\\Documents\\NetBeansProjects\\QLDSV\\src\\JasperReport\\" + rptName + ".jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jr, hashtable, conn);
        JasperViewer.viewReport(jasperPrint, false);
    }

}
