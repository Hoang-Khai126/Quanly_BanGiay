
package BUS;

import DAO.LoaiSP_DAO;
import DTO.LoaiSP_DTO;
import MyCustom.MyDialog;

import java.util.ArrayList;

public class LoaiSP_BUS {
    private LoaiSP_DAO loaiSP_DAO = new LoaiSP_DAO();
    private ArrayList<LoaiSP_DTO> listLoaiSP=null;
    
    public LoaiSP_BUS(){
        docDanhSachLoai();
    }
    public void docDanhSachLoai(){
        this.listLoaiSP = loaiSP_DAO.layDanhSachLoai();
    }
    
    public ArrayList<LoaiSP_DTO> layDanhSachLoai() {
        if (listLoaiSP == null) {
            docDanhSachLoai();
        }
        return this.listLoaiSP;
    }
    
    public String layTenLoai(String ma) {
        for (LoaiSP_DTO loai : listLoaiSP) {
            if (loai.getMaLoai().equals(ma)) {
                return loai.getMaLoai() + " - " + loai.getTenLoai();
            }
        }
        return "";
    }
    
}
