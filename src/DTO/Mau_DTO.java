package DTO;

public class Mau_DTO {

    public String maMau;
    public String tenMau;
    public String trangThai;

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Mau_DTO(String maMau, String tenMau, String trangThai) {
        this.maMau = maMau;
        this.tenMau = tenMau;
        this.trangThai = trangThai;
    }
    
    public Mau_DTO()
    {
    }
}
