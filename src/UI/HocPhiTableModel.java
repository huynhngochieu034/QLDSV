/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import core.HocPhi;
import core.Lop;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class HocPhiTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int NIENKHOA_COL = 0;
    private static final int HOCKY_COL = 1;
    private static final int HOCPHI_COL = 2;
    private static final int SOTIENDADONG_COL = 3;

    private String[] columnNames = {"NIÊN KHÓA", "HỌC KỲ", "HỌC PHÍ", "SỐ TIỀN ĐÃ ĐÓNG"};
    private List<HocPhi> listHP;

    public HocPhiTableModel(List<HocPhi> list) {
        this.listHP = list;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return listHP.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HocPhi hocphiRow = listHP.get(rowIndex);
        switch (columnIndex) {
            case NIENKHOA_COL:
                return hocphiRow.getNIENKHOA();
            case HOCKY_COL:
                return Integer.toString(hocphiRow.getHOCKY());
            case HOCPHI_COL:
                return Integer.toString(hocphiRow.getHOCPHI());
            case SOTIENDADONG_COL:
                return Integer.toString(hocphiRow.getSOTIENDADONG());

            case OBJECT_COL:
                return hocphiRow;
            default:
                return hocphiRow.getHOCKY();

        }

    }

}
