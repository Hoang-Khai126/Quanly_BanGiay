package DTO;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author HP
 */
public class cmb_TenNV {
    private String maNV;
    private String tenNV;
    private String diaChi;
    private String gioiTinh;
    private String sdt;
    private String email;

    public cmb_TenNV(String maNV, String tenNV, String diaChi, String gioiTinh, String sdt, String email) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
    }

    public cmb_TenNV(String maNV, String tenNV, String diaChi, String gioiTinh, String gioiTinh0, String sdt, String email) {
        
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return tenNV;
    }
}
