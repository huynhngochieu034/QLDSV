/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import core.Lop;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class LopTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int MALOP_COL = 0;
    private static final int TENLOP_COL = 1;
    private static final int MAKH_COL = 2;

    private String[] columnNames = {"MÃ LỚP", "TÊN LỚP", "MÃ KHOA"};
    private List<Lop> lops;

    public LopTableModel(List<Lop> list) {
        this.lops = list;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return lops.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lop lopRow = lops.get(rowIndex);
        switch (columnIndex) {
            case MALOP_COL:
                return lopRow.getMALOP();
            case TENLOP_COL:
                return lopRow.getTENLOP();
            case MAKH_COL:
                return lopRow.getMAKHOA();

            case OBJECT_COL:
                return lopRow;
            default:
                return lopRow.getTENLOP();

        }

    }

}
