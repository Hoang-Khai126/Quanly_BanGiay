/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DoHuy
 */
//    CREATE TABLE Size (
//    MaSize CHAR(10),
//    TenSize VARCHAR(20),
//    SoLuong INT,
//    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
//    CONSTRAINT pk_Size PRIMARY KEY (MaSize)
//);
//GO
public class Size_DTO {

    public String MaSize;
    public String TenSize;
    public String SoLuong;
    public String TrangThai;

    public Size_DTO() {
    }

    public Size_DTO(String MaSize, String TenSize, String SoLuong, String TrangThai) {
        this.MaSize = MaSize;
        this.TenSize = TenSize;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public String getMaSize() {
        return MaSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

}
