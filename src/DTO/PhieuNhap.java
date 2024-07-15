package DTO;


/**
 *
 * @author HP
 */
public class PhieuNhap {
    String MaPN;
    String MaNCC;
    String MaNV;
    String NgayLap;
    float TongtTien;
    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public float getTongtTien() {
        return TongtTien;
    }

    public void setTongtTien(float TongtTien) {
        this.TongtTien = TongtTien;
    }

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, String NgayLap, float TongtTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.TongtTien = TongtTien;
    }

    public PhieuNhap() {
    }
    
    
}
