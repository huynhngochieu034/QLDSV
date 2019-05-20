/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import core.Lop;
import core.MonHoc;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class MonHocTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int MAMH_COL = 0;
    private static final int TENMH_COL = 1;

    private String[] columnNames = {"MÃ MÔN HỌC", "TÊN MÔN HỌC"};
    private List<MonHoc> monHocs;

    public MonHocTableModel(List<MonHoc> list) {
        this.monHocs = list;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return monHocs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonHoc monHocRow = monHocs.get(rowIndex);
        switch (columnIndex) {
            case MAMH_COL:
                return monHocRow.getMAMH();
            case TENMH_COL:
                return monHocRow.getTENMH();

            case OBJECT_COL:
                return monHocRow;
            default:
                return monHocRow.getTENMH();

        }

    }

}
