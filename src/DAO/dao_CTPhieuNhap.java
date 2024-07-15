package DAO;

import DTO.CT_PhieuNhap;
import DTO.SanPham_DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class dao_CTPhieuNhap {
    Connection con=ConnectionDataBase.conn;
    public SanPham_DTO findByMaSP(String masp) {
    String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
    try {
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, masp);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new SanPham_DTO(
                rs.getString("MaSP"),
                rs.getString("TenSP"),
                rs.getInt("Soluong"),
                rs.getFloat("GiaNhap"),
                rs.getFloat("GiaBan"),    
                rs.getString("Hinh"),
                rs.getString("MaLoai"),
                rs.getString("MaNCC"),
                rs.getString("MoTa"),
                rs.getString("TrangThai")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }
    public ArrayList<CT_PhieuNhap> LayDanhSach(String giatri ){
        ArrayList<CT_PhieuNhap> ds = new ArrayList<>();
        if(con != null){
            try{
                CallableStatement st = con.prepareCall("{call LayDanhSach_CT_PhieuNhap(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    CT_PhieuNhap m = new CT_PhieuNhap();
                    m.setMaCTSP(rs.getString("MaCTSP"));
                    m.setMaPN(rs.getString("MaPN"));
                    m.setSoLuong(rs.getInt("SoLuong"));
                    m.setGiaNhap(rs.getFloat("GiaNhap"));
                    m.setThanhTien(rs.getFloat("ThanhTien"));
                    ds.add(m);        
                }
            }catch(SQLException ex){
                Logger.getLogger(dao_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return ds;
    }
    private void capNhatSoLuong(String mactsp, String mapn) {
        String sql = "UPDATE ChiTiet_SanPham " +
                     "SET SoLuong = SoLuong + (SELECT SoLuong FROM ChiTiet_PhieuNhap WHERE MaCTSP = ? and MaPN = ?) " +
                     "WHERE MaCTSP IN (SELECT MaCTSP FROM ChiTiet_PhieuNhap WHERE MaCTSP = ? and MaPN = ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, mactsp);
            stmt.setString(2, mapn);
            stmt.setString(3, mactsp);
            stmt.setString(4, mapn);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void themCTPhieuNhap(CT_PhieuNhap m) throws SQLException{
        try{
            CallableStatement st = con.prepareCall("{call ThemCTPhieuNhap(?,?,?,?,?)}");
            st.setString(1, m.getMaPN());
            st.setString(2, m.getMaCTSP());
            st.setInt(3, m.getSoLuong());
            st.setFloat(4, m.getGiaNhap());
            st.setFloat(5, m.getThanhTien());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
            capNhatSoLuong(m.getMaCTSP(), m.getMaPN());
        }
        catch(SQLException ex){
          Logger.getLogger(dao_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
}
