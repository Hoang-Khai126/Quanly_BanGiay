package BUS;

import DAO.ChiTietSP_DAO;
import DAO.ConnectionDataBase;
import DTO.ChiTietSP_DTO;

import MyCustom.MyDialog;

import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class ChiTietSP_BUS {
    private ArrayList<ChiTietSP_DTO> listCTSP = null;
    private ChiTietSP_DAO ctsp_DAO = new ChiTietSP_DAO();
    private ChiTietSP_DTO ctsp_DTO=new ChiTietSP_DTO();

    public void docDanhSach_TheoMa(String maSP) {
        this.listCTSP = ctsp_DAO.LayDanhSachCTSPTHeoMa(maSP);
    }

    public ArrayList<ChiTietSP_DTO> LayDanhSachCTSP_TheoMa(String maSP) {

        return ctsp_DAO.LayDanhSachCTSPTHeoMa(maSP);
    }
    
    public void docCTSPT_TheoMaCTSP(String maCTSP) {
        this.ctsp_DTO = ctsp_DAO.LayCTSPTHeoMaCTSP(maCTSP);
    }

    public ChiTietSP_DTO LayCTSPTHeoMaCTSP(String maCTSP) {
        docCTSPT_TheoMaCTSP(maCTSP);
        return ctsp_DTO;
    }
    
}
