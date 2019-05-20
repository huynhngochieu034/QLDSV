/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DiemDAO;
import core.SinhVien;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class DiemTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int MASV_COL = 0;
    private static final int HO_COL = 1;
    private static final int TEN_COL = 2;
    private static final int DIEM_COL = 3;

    DiemDAO diemDAO = new DiemDAO();

    private String[] columnNames = {"MÃ SV", "HỌ", "TÊN", "ĐIỂM"};
    private List<SinhVien> listSV;

    public DiemTableModel(List<SinhVien> list) {
        this.listSV = list;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return listSV.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SinhVien svRow = listSV.get(rowIndex);
        switch (columnIndex) {
            case MASV_COL:
                return svRow.getMASV();
            case HO_COL:
                return svRow.getHO();
            case TEN_COL:

                return svRow.getTEN();
            case DIEM_COL: {
                try {

                    return diemDAO.timDiemPROC(svRow.getMASV(), DiemUPDATE.maMH, DiemUPDATE.lan);
                } catch (SQLException ex) {
                    Logger.getLogger(DiemTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case OBJECT_COL:
                return svRow;
            default:
                return svRow.getTEN();

        }

    }

}
