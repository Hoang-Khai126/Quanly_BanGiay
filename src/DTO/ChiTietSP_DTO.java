
package DTO;

public class ChiTietSP_DTO {
    private String maSP;
    private String maMau;
    private String maSize;
    private int soLuong;
    private String maCTSP;
    private String trangThai;
    
    public ChiTietSP_DTO(){
        
    }

    public ChiTietSP_DTO(String maSP, String maMau, String maSize, int soLuong, String maCTSP) {
        this.maSP = maSP;
        this.maMau = maMau;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.maCTSP = maCTSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
