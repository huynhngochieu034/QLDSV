/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pro
 */
public final class SinhVien {

    private String MASV;
    private String HO;
    private String TEN;
    private String MALOP;
    private boolean PHAI;
    private Date NGAYSINH;
    private String NOISINH;
    private String DIACHI;
    private String GHICHU;
    private boolean NGHIHOC;

    public SinhVien() {
        super();
    }

    public SinhVien(String MASV, String HO, String TEN, String MALOP, boolean PHAI, Date NGAYSINH, String NOISINH, String DIACHI, String GHICHU, boolean NGHIHOC) {
        this.MASV = MASV;
        this.HO = HO;
        this.TEN = TEN;
        this.MALOP = MALOP;
        this.PHAI = PHAI;
        this.NGAYSINH = NGAYSINH;
        this.NOISINH = NOISINH;
        this.DIACHI = DIACHI;
        this.GHICHU = GHICHU;
        this.NGHIHOC = NGHIHOC;
    }

    public SinhVien(ResultSet resultSet) throws SQLException {
        this.setMASV(resultSet.getString("MASV"));
        this.setHO(resultSet.getString("HO"));
        this.setTEN(resultSet.getString("TEN"));
        this.setMALOP(resultSet.getString("MALOP"));
        this.setPHAI(resultSet.getBoolean("PHAI"));
        this.setNGAYSINH(resultSet.getDate("NGAYSINH"));
        this.setNOISINH(resultSet.getString("NOISINH"));
        this.setDIACHI(resultSet.getString("DIACHI"));
        this.setGHICHU(resultSet.getString("GHICHU"));
        this.setNGHIHOC(resultSet.getBoolean("NGHIHOC"));
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getMALOP() {
        return MALOP;
    }

    public void setMALOP(String MALOP) {
        this.MALOP = MALOP;
    }

    public boolean isPHAI() {
        return PHAI;
    }

    public void setPHAI(boolean PHAI) {
        this.PHAI = PHAI;
    }

    public String getDobString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(NGAYSINH);
    }

    public void setDobString(String NGAYSINH) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            this.NGAYSINH = (Date) sdf.parse(NGAYSINH);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getNOISINH() {
        return NOISINH;
    }

    public void setNOISINH(String NOISINH) {
        this.NOISINH = NOISINH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }

    public boolean isNGHIHOC() {
        return NGHIHOC;
    }

    public void setNGHIHOC(boolean NGHIHOC) {
        this.NGHIHOC = NGHIHOC;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "MASV=" + MASV + ", HO=" + HO + ", TEN=" + TEN + ", MALOP=" + MALOP + ", PHAI=" + PHAI + ", NGAYSINH=" + NGAYSINH + ", NOISINH=" + NOISINH + ", DIACHI=" + DIACHI + ", GHICHU=" + GHICHU + ", NGHIHOC=" + NGHIHOC + '}';
    }

}
