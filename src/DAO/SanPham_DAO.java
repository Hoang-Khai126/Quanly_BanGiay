package DAO;

import DTO.SanPham_DTO;
import DAO.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class SanPham_DAO {

    public ArrayList<SanPham_DTO> getListSanPham() {
        try {
            String sql = "select * from SanPham";
            Statement st = ConnectionDataBase.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<SanPham_DTO> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham_DTO sp = new SanPham_DTO();

                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setGiaNhap(rs.getFloat("GiaNhap"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setHinhSP(rs.getString("Hinh"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setMaNCC(rs.getString("MaNCC"));
                sp.setMoTa(rs.getString("Mota"));
                sp.setTrangThai(rs.getString("TrangThai"));
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public boolean themSanPham(SanPham_DTO sp) {
        boolean result = false;
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call ThemSanPham(?,?,?,?,?,?,?,?,?,?)}");
            prep.setString(1, sp.getMaSP());
            prep.setNString(2, sp.getTenSP());
            prep.setInt(3, sp.getSoLuong());
            prep.setFloat(4, sp.getGiaNhap());
            prep.setFloat(5, sp.getGiaBan());
            prep.setString(6, sp.getHinhSP());
            prep.setString(7, sp.getMaLoai());
            prep.setString(8, sp.getMaNCC());
            prep.setNString(9, sp.getMoTa());
            prep.setNString(10, sp.getTrangThai());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean SuaSanPham(SanPham_DTO sp) {
        boolean result = false;
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call SuaSanPham(?,?,?,?,?,?,?,?,?,?)}");
            // Set parameters using proper methods
            prep.setString(1, sp.getMaSP());
            prep.setNString(2, sp.getTenSP());
            prep.setInt(3, sp.getSoLuong());
            prep.setFloat(4, sp.getGiaNhap());
            prep.setFloat(5, sp.getGiaBan());
            prep.setString(6, sp.getHinhSP());
            prep.setString(7, sp.getMaLoai());
            prep.setString(8, sp.getMaNCC());
            prep.setNString(9, sp.getMoTa());
            prep.setNString(10, sp.getTrangThai());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            result = false;
        }
        return result;
    }

    public boolean XoaSanPham(DTO.SanPham_DTO sp) {
        boolean result = false;
        try {
            CallableStatement st = ConnectionDataBase.conn.prepareCall("{call XoaNhanVien(?)}");
            st.setString(1, sp.getMaSP());
            st.executeUpdate();
            result = false;
        } catch (SQLException ex) {
            result = false;
        }
        return result;
    }

    public String layAnhTheoMa(String Masp) {
        String anh = "";
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call LayAnhSanPham(?)}");
            prep.setString(1, Masp);
            ResultSet rs = prep.executeQuery();
            anh = rs.getString("Hinh");
        } catch (Exception e) {
            return anh;
        }
        return anh;

    }

    public ArrayList<DTO.SanPham_DTO> TimKiemSP(String giatri) {
        ArrayList<DTO.SanPham_DTO> ds = new ArrayList<>();
        if (ConnectionDataBase.conn != null) {
            try {
                CallableStatement st = ConnectionDataBase.conn.prepareCall("{call TimKiemSP(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.SanPham_DTO sp = new DTO.SanPham_DTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                    sp.setGiaNhap(rs.getFloat("GiaNhap"));
                    sp.setGiaBan(rs.getFloat("GiaBan"));
                    sp.setHinhSP(rs.getString("Hinh"));
                    sp.setMaLoai(rs.getString("MaLoai"));
                    sp.setMaNCC(rs.getString("MaNCC"));
                    sp.setMoTa(rs.getString("Mota"));
                    sp.setTrangThai(rs.getString("TrangThai"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }
}
