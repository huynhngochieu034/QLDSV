/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import core.SinhVien;

/**
 *
 * @author Admin
 */
public class SinhVienTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    private static final int MASV_COL = 0;
    private static final int HO_COL = 1;
    private static final int TEN_COL = 2;
    private static final int MALOP_COL = 3;
    private static final int PHAI_COL = 4;
    private static final int NGAYSINH_COL = 5;
    private static final int NOISINH_COL = 6;
    private static final int DIACHI_COL = 7;
    private static final int GHICHU_COL = 8;
    private static final int NGHIHOC_COL = 9;

    private String[] columnNames = {"MÃ SV", "HỌ", "TÊN", "MÃ LỚP", "PHÁI", "NGÀY SINH", "NƠI SINH", "ĐỊA CHỈ", "GHI CHÚ", "NGHỈ HỌC"};
    private List<SinhVien> students;

    public SinhVienTableModel(List<SinhVien> sinhvienList) {
        this.students = sinhvienList;
    }

    public String getColumnName(int col) {
        return columnNames[col];

    }

    public Class getComnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SinhVien student = students.get(rowIndex);
        switch (columnIndex) {
            case MASV_COL:
                return student.getMASV();
            case HO_COL:
                return student.getHO();
            case TEN_COL:
                return student.getTEN();
            case MALOP_COL:
                return student.getMALOP();
            case PHAI_COL:
                if (student.isPHAI()) {
                    return "Nam";
                } else {
                    return "Nữ";
                }
            case NGAYSINH_COL:
                return student.getDobString();
            case NOISINH_COL:
                return student.getNOISINH();
            case DIACHI_COL:
                return student.getDIACHI();
            case GHICHU_COL:
                return student.getGHICHU();
            case NGHIHOC_COL:
                if (student.isNGHIHOC()) {
                    return "Có";
                } else {
                    return "Không";
                }
            case OBJECT_COL:
                return student;
            default:
                return student.getTEN();

        }

    }

}
