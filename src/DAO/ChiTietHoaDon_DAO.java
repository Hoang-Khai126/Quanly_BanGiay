package DAO;

import DTO.ChiTietHD_DTO;
import DAO.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon_DAO {

    Connection con = ConnectionDataBase.conn;

    public ArrayList<DTO.ChiTietHD_DTO> danhSachChiTietHD() {
        ArrayList<DTO.ChiTietHD_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhSachChiTietHD}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.ChiTietHD_DTO cthd = new DTO.ChiTietHD_DTO();
                    cthd.setMaCTSP(rs.getString("MaCTSP"));
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setSoLuong(Integer.parseInt(rs.getString("SoLuong")));
                    cthd.setThanhTien(Float.parseFloat(rs.getString("ThanhTien")));
                    cthd.setTrangThai(rs.getString("TrangThai"));
                    ds.add(cthd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHD_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.ChiTietHD_DTO> layChiTietHD_TheoMaHD(String maHD) {
        ArrayList<DTO.ChiTietHD_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhSachChiTietHDTheoMa(?)}");
                st.setString(1, maHD);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.ChiTietHD_DTO cthd = new DTO.ChiTietHD_DTO();
                    cthd.setMaCTSP(rs.getString("MaCTSP"));
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setSoLuong(Integer.parseInt(rs.getString("SoLuong")));
                    cthd.setThanhTien(Float.parseFloat(rs.getString("ThanhTien")));
                    cthd.setTrangThai(rs.getString("TrangThai"));
                    ds.add(cthd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHD_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }
    
    public boolean themCTHoaDon(ChiTietHD_DTO sp) {
        boolean result = false;      
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call ThemCTHoaDon(?,?,?,?)}");
            prep.setString(1, sp.getMaCTSP());
            prep.setString(2, sp.getMaHD());
            prep.setInt(3, sp.getSoLuong());
            prep.setFloat(4, sp.getThanhTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
}
