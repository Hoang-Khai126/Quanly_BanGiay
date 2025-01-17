
package DTO;

/**
 *
 * @author ADMIN
 */
public class GioHang_DTO {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private float donGia;
    private float thanhTien;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien() {
        this.thanhTien = soLuong*donGia;
    }

    public GioHang_DTO(String maSP, String tenSP, int soLuong, float donGia, float thanhTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    public GioHang_DTO(){
    };
    
}
