package BUS;

import DAO.Mau_DAO;
import DTO.Mau_DTO;
import MyCustom.MyDialog;

import java.util.ArrayList;

public class Mau_BUS {
    private Mau_DAO mauSP_DAO = new Mau_DAO();
    private ArrayList<Mau_DTO> listMauSP=null;
    
    public Mau_BUS(){
        docDanhSachMau();
    }
    public void docDanhSachMau(){
        this.listMauSP = mauSP_DAO.layDanhSachMau();
    }
    
    public ArrayList<Mau_DTO> layDanhSachMau() {
//        if (listMauSP == null) {
//            docDanhSachMau();
//        }
        docDanhSachMau();
        return this.listMauSP;
    }
    
    public String layMaVaTenMau(String ma) {
        for (Mau_DTO mau : listMauSP) {
            if (mau.getMaMau().equals(ma)) {
                return mau.getMaMau()+ "-" + mau.getTenMau();
            }
        }
        return "";
    }
    
}
