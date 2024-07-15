package DAO;

import DTO.PhieuNhap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author HP
 */
public class dao_PhieuNhap {
    Connection con=ConnectionDataBase.conn;
    public String phatSinhMa() throws SQLException{
        String mapn = "";
        if(con!=null){
            try{
                CallableStatement st = con.prepareCall("{call phieuNhapLonNhat}");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    String ma = rs.getString("mapn");
                    String so = ma.substring(2, ma.length()).trim();
                    if(Integer.parseInt(so)>=0 && Integer.parseInt(so)<9)
                        mapn = "PN" + "000" + (Integer.parseInt(so) + 1);
                    else if(Integer.parseInt(so)>=9 && Integer.parseInt(so)<99)
                        mapn = "PN" + "00" + (Integer.parseInt(so) + 1);
                    else if(Integer.parseInt(so)>=99 && Integer.parseInt(so)<999)
                        mapn = "PN" + "0" + (Integer.parseInt(so) + 1);
                    else
                        mapn = "PN" + (Integer.parseInt(so) + 1);
                }
            }
            catch(SQLException ex){
                Logger.getLogger(dao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mapn;
    }
    public void ThemPhieuNhap(PhieuNhap m, String tenNV, String tenNCC) throws SQLException{
        String mapn = phatSinhMa();
        PreparedStatement stmt = null;
        try{
            String maNV = timMaNhanVienTheoTen(con, tenNV);
            String maNCC = timMaNhaCungCapTheoTen(con, tenNCC);

            CallableStatement st = con.prepareCall("{call ThemPhieuNhap(?,?,?,?,?)}");
            st.setString(1, mapn);
            st.setString(2, maNCC);
            st.setString(3, maNV);
            st.setString(4, m.getNgayLap());
            st.setFloat(5, m.getTongtTien());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
        }
        catch(SQLException ex){
          Logger.getLogger(dao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    private String timMaNhaCungCapTheoTen(Connection conn, String tenNCC) throws SQLException {
        String maNCC = "";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT MaNCC FROM NhaCC WHERE TenNCC = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenNCC);
            rs = stmt.executeQuery();
            if (rs.next()) {
                maNCC = rs.getString("MaNCC");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return maNCC;
    }
    private String timMaNhanVienTheoTen(Connection conn, String tenNV) throws SQLException {
        String maNV = "";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT MaNV FROM NhanVien WHERE TenNV = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenNV);
            rs = stmt.executeQuery();
            if (rs.next()) {
                maNV = rs.getString("MaNV");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return maNV;
    }
    private float tinhTongThanhTien(String maPhieuNhap) {
        float tongTien = 0;
        String sql = "SELECT ThanhTien FROM ChiTiet_PhieuNhap WHERE MaPN = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tongTien += rs.getFloat("ThanhTien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(dao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongTien;
    }
    
    private void capNhatTongTienPhieuNhap(String maPhieuNhap, float tongTien) {
        String sql = "UPDATE PhieuNhap SET TongTien = ? WHERE MaPN = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setFloat(1, tongTien);
            stmt.setString(2, maPhieuNhap);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void capNhatTongTienVaLoadTextBox(String maPhieuNhap, javax.swing.JTextField txtTongTien) {
        float tongTien = tinhTongThanhTien(maPhieuNhap);

        capNhatTongTienPhieuNhap(maPhieuNhap, tongTien);

        txtTongTien.setText(String.valueOf(tongTien));
    }
}
