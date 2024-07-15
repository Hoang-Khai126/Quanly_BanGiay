package BUS;

import DAO.ChiTietHoaDon_DAO;
import DTO.ChiTietHD_DTO;
import DAO.ConnectionDataBase;

import MyCustom.MyDialog;

import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon_BUS {
    private ArrayList<ChiTietHD_DTO> listCTHD = null;
    private ChiTietHoaDon_DAO cthd_DAO = new ChiTietHoaDon_DAO();
    private ChiTietHD_DTO cthd_dto=new ChiTietHD_DTO();

    public void docDanhSachChiTietHoaDon() {
        this.listCTHD = cthd_DAO.danhSachChiTietHD();
    }

    public ArrayList<ChiTietHD_DTO> LayDanhSachCTHD() {
        if (listCTHD == null) {
            docDanhSachChiTietHoaDon();
        }
        return listCTHD;
    }
    
    public void docDanhSachChiTietHoaDon_TheoMa(String maHD) {
        this.listCTHD = cthd_DAO.layChiTietHD_TheoMaHD(maHD);
    }
     
    public ArrayList<ChiTietHD_DTO> LayChiTietHoaDon_TheoMa(String maHD) {
        if (listCTHD == null) {
            docDanhSachChiTietHoaDon_TheoMa(maHD);
        }
        return listCTHD;
    }
    
    public boolean themCTHoaDon(String maCTSP, String maHD, String soLuong, String thanhTien) {
        if (maCTSP.trim().equals("")) {
            new MyDialog("Không được để trống mã hoá đơn", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maHD.trim().equals("")) {
            new MyDialog("Không được để trống mã khách hàng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (soLuong.trim().equals("")) {
            new MyDialog("Không được để trống mã nhân viên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (thanhTien.trim().equals("")) {
            new MyDialog("Không được để trống ngày lập!", MyDialog.ERROR_DIALOG);
            return false;
        }

        ChiTietHD_DTO sp = new ChiTietHD_DTO();
        sp.setMaCTSP(maCTSP);
        sp.setMaHD(maHD);
        sp.setSoLuong(Integer.parseInt(soLuong));
        sp.setThanhTien(Float.parseFloat(thanhTien));

        boolean flag = cthd_DAO.themCTHoaDon(sp);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
}
