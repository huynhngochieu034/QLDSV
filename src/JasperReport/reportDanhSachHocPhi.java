/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReport;

import DAO.HocPhiDAO;
import DBConnection.DBConnection;
import NumberConverterString.NewClass;
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
public class reportDanhSachHocPhi {

    public String rptName;
    private HocPhiDAO hocPhiDAO;

    /**
     *
     * @param maLop
     * @param NienKhoa
     * @param hocKi
     */
    public reportDanhSachHocPhi(String maLop, String NienKhoa, int hocKi) throws SQLException, JRException {

     
        hocPhiDAO = new HocPhiDAO();
        String soTien = hocPhiDAO.tongTienTheoLop(maLop, NienKhoa, hocKi);
        String tongTien = NewClass.ChuyenSo(soTien) + ")";
        System.out.println("" + tongTien);
        rptName = "reportDanhSachDongHocPhi";
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        Hashtable hashtable = new Hashtable();
        hashtable.put("tongTienString", tongTien);
        hashtable.put("maLop", maLop);
        hashtable.put("nienKhoa", NienKhoa);
        hashtable.put("hocKi", hocKi);

        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Pro\\Documents\\NetBeansProjects\\QLDSV\\src\\JasperReport\\" + rptName + ".jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jr, hashtable, conn);

        JasperViewer.viewReport(jasperPrint, false);

    }
}
