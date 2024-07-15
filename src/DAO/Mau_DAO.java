package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DTO.Mau_DTO;

/**
 *
 * @author DoHuy
 */
public class Mau_DAO {
    
     Connection con=ConnectionDataBase.conn;

    
     public ArrayList<Mau_DTO> layDanhSachMau() {
        try {
            String sql = "SELECT * FROM Mau";
            Statement st = ConnectionDataBase.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Mau_DTO> dsMau = new ArrayList<>();

            while (rs.next()) {
                Mau_DTO mau = new Mau_DTO();
                mau.setMaMau(rs.getString(1));
                mau.setTenMau(rs.getString(2));
                mau.setTrangThai(rs.getString(3));
                dsMau.add(mau);
            }
            return dsMau;
        } catch (SQLException e) {
             Logger.getLogger(Mau_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    //--------------------------------------------------
    //tìm kiếm khách hàng
//     

}
