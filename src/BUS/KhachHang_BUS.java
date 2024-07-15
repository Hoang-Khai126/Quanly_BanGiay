package BUS;

import DTO.KhachHang_DTO;
import java.util.ArrayList;

import DAO.KhachHang_DAO;


/**
 *
 * @author ADMIN
 */
public class KhachHang_BUS {
     private ArrayList<KhachHang_DTO> listKH = null;
    private KhachHang_DAO kh_DAO = new KhachHang_DAO();
    
    public KhachHang_BUS(){
        docDanhSachKH();
    }
    public void docDanhSachKH(){
        this.listKH = kh_DAO.LayDanhSachProc();
    }
    
    public ArrayList<KhachHang_DTO> getDanhSachKhachHang() {
        if (listKH == null) {
            docDanhSachKH();
        }
        return listKH;
    }
}
