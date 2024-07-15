package DTO;



/**
 *
 * @author HP
 */
public class CT_PhieuNhap {
    String  MaCTSP;
    String MaPN;
    int SoLuong;
    float GiaNhap;
    float ThanhTien;
    
    public CT_PhieuNhap() {
    }

    public CT_PhieuNhap(String MaCTSP, String MaPN, int SoLuong, float GiaNhap, float ThanhTien) {
        this.MaCTSP = MaCTSP;
        this.MaPN = MaPN;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }   
}
