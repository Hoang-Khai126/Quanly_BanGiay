package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class TaiKhoan_DTO {
    private String maNhanVien;
    private String tenDangNhap;
    private String matKhau;
    private String chucVu;
    
    public TaiKhoan_DTO()
    {
    }
    
    public TaiKhoan_DTO(String maNhanVien,String tenDangNhap, String matKhau, String chucVu)
    {
        this.maNhanVien = maNhanVien;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    
}
