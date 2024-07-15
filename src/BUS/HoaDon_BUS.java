package BUS;

import DAO.HoaDon_DAO;
import DAO.ConnectionDataBase;
import DTO.HoaDon_DTO;

import MyCustom.MyDialog;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Locale;


/**
 *
 * @author ADMIN
 */
public class HoaDon_BUS {
    private ArrayList<HoaDon_DTO> listHD = null;
    private HoaDon_DAO hd_DAO = new HoaDon_DAO();

    public void docDanhSachHoaDon() {
        this.listHD = hd_DAO.LayDanhSachHD();
    }

    public ArrayList<HoaDon_DTO> LayDanhSachHD() {
        if (listHD == null) {
            docDanhSachHoaDon();
        }
        return listHD;
    }
    
    public boolean themHoaDon(String maHD, String maKH, String maNV, String ngayLap, String tongTien) {
        if (maHD.trim().equals("")) {
            new MyDialog("Không được để trống mã hoá đơn", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maKH.trim().equals("")) {
            new MyDialog("Không được để trống mã khách hàng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maNV.trim().equals("")) {
            new MyDialog("Không được để trống mã nhân viên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ngayLap.trim().equals("")) {
            new MyDialog("Không được để trống ngày lập!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (tongTien.trim().equals("")) {
            new MyDialog("Không được để trống tổng tiền!", MyDialog.ERROR_DIALOG);
            return false;
        }

        HoaDon_DTO sp = new HoaDon_DTO();
        sp.setMaHD(maHD);
        sp.setMaKH(maKH);
        sp.setMaNV(maNV);
        sp.setNgayLap(ngayLap);
        sp.setTongTien(Float.parseFloat(tongTien));

        boolean flag = hd_DAO.themHoaDon(sp);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    public String phatSinhMa() throws SQLException
    {
        return hd_DAO.phatSinhMa();
    }
    
    public boolean suaHoaDon(String maHD, String maKH, String maNV, String ngayLap) {
        if (maHD.trim().equals("")) {
            new MyDialog("Không được để trống mã hoá đơn", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maKH.trim().equals("")) {
            new MyDialog("Không được để trống mã khách hàng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maNV.trim().equals("")) {
            new MyDialog("Không được để trống mã nhân viên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ngayLap.trim().equals("")) {
            new MyDialog("Không được để trống ngày lập!", MyDialog.ERROR_DIALOG);
            return false;
        }
        HoaDon_DTO sp = new HoaDon_DTO();
        sp.setMaHD(maHD);
        sp.setMaKH(maKH);
        sp.setMaNV(maNV);
        sp.setNgayLap(ngayLap);

        boolean flag = hd_DAO.SuaHoaDon(sp);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    
}
