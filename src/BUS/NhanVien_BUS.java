package BUS;

import DTO.NhanVien_DTO;
import java.util.ArrayList;

import DTO.NhanVien_DTO;
import DAO.NhanVien_DAO;

/**
 *
 * @author ADMIN
 */
public class NhanVien_BUS {
    private ArrayList<NhanVien_DTO> listNV = null;
    private NhanVien_DAO nv_DAO = new NhanVien_DAO();
    
    public NhanVien_BUS(){
        docDanhSachNV();
    }
    public void docDanhSachNV(){
        this.listNV = nv_DAO.LayDanhSachProcNV();
    }
    
    public ArrayList<NhanVien_DTO> getDanhSachNhanVien() {
        if (listNV == null) {
            docDanhSachNV();
        }
        return listNV;
    }

}

