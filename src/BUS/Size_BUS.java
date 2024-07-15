package BUS;
import DTO.Size_DTO;
import DAO.Size_DAO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Size_BUS {
    private Size_DAO sizeSP_DAO = new Size_DAO();
    private ArrayList<Size_DTO> listSizeSP=null;
    
    public Size_BUS(){
        docDanhSachSize();
    }
    public void docDanhSachSize(){
        this.listSizeSP = sizeSP_DAO.LayDanhSachSize();
    }
    
    public ArrayList<Size_DTO> layDanhSachSize() {
//        if (listSizeSP == null) {
//            docDanhSachSize();
//        }
        docDanhSachSize();
        return this.listSizeSP;
    }
    
    public String layMaVaTenSize(String ma) {
        for (Size_DTO mau : listSizeSP) {
            if (mau.getMaSize().equals(ma)) {
                return mau.getMaSize()+ "-" + mau.getTenSize();
            }
        }
        return "";
    }
    
    
}
