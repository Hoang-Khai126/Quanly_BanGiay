package DTO;

/**
 *
 * @author Administrator
 */
public class NhaCC {
    String MaNCC;
    String TenNCC;
    String DiaChi;
    String Sdt;
    String Email;
    
    public NhaCC(String MaNCC, String TenNCC, String DiaChi, String Sdt, String Email) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.Email = Email;
    }

    public NhaCC() {
    }
    
    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
