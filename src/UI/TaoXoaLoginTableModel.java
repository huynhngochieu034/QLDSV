/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DiemDAO;
import core.GiangVien;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TaoXoaLoginTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int MAGV_COL = 0;
    private static final int HO_COL = 1;
    private static final int TEN_COL = 2;
    private static final int MAKH_COL = 3;

    private String[] columnNames = {"MÃ GV", "HỌ", "TÊN", "MÃ KHOA"};
    private List<GiangVien> listGV;

    public TaoXoaLoginTableModel(List<GiangVien> list) {
        this.listGV = list;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return listGV.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GiangVien svRow = listGV.get(rowIndex);
        switch (columnIndex) {
            case MAGV_COL:
                return svRow.getMAGV();
            case HO_COL:
                return svRow.getHO();
            case TEN_COL:

                return svRow.getTEN();
            case MAKH_COL:
                return svRow.getMAKH();

            case OBJECT_COL:
                return svRow;
            default:
                return svRow.getTEN();

        }

    }

}
