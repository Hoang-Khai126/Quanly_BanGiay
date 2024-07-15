package DTO;

/**
 *
 * @author ADMIN
 */
public class ChiTietHD_DTO {
    private String maCTSP;
    private String maHD ;
    private int soLuong ;
    private float thanhTien ;
    private String trangThai ;

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ChiTietHD_DTO(String maCTSP, String maHD, int soLuong, float thanhTien, String trangThai) {
        this.maCTSP = maCTSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }
    
    public ChiTietHD_DTO(){
    }
}
