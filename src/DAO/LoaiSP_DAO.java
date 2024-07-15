package DAO;

import DTO.LoaiSP_DTO;
import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaiSP_DAO {

    public ArrayList<LoaiSP_DTO> layDanhSachLoai() {
        try {
            String sql = "SELECT * FROM LoaiSP";
            Statement st = ConnectionDataBase.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<LoaiSP_DTO> dsLoai = new ArrayList<>();

            while (rs.next()) {
                LoaiSP_DTO loai = new LoaiSP_DTO();
                loai.setMaLoai(rs.getString(1));
                loai.setTenLoai(rs.getString(2));
                loai.setTrangThai(rs.getString(3));
                dsLoai.add(loai);
            }
            return dsLoai;
        } catch (SQLException e) {
            Logger.getLogger(LoaiSP_DTO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public String layLoaiTheoMa(String MaLoai) {
        String Loai = "";
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call LayLoaiSanPham(?)}");
            prep.setString(1, MaLoai);
            ResultSet rs = prep.executeQuery();
            Loai = rs.getString("TenLoai");
        } catch (Exception e) {
             Logger.getLogger(LoaiSP_DTO.class.getName()).log(Level.SEVERE, null, e);
        }
        return Loai;

    }
    
    

//    public boolean themLoai(LoaiSP loai) {
//        try {
//            String sql = "insert into loai(TenLoai) "
//                    + "values ("
//                    + "'" + loai.getTenLoai() + "')";
//            Statement st = MyConnect.conn.createStatement();
//            int x = st.executeUpdate(sql);
//            return x > 0 ? true : false;
//        } catch (SQLException ex) {
//            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return false;
//    }
//
//    public boolean xoaLoai(int maLoai) {
//        try {
//            String sql = "DELETE FROM Loai WHERE MaLoai=" + maLoai;
//            Statement st = MyConnect.conn.createStatement();
//            int x = st.executeUpdate(sql);
//            return x > 0 ? true : false;
//        } catch (SQLException e) {
//        }
//        return false;
//    }
//
//    public boolean suaLoai(int maLoai, String ten) {
//        try {
//            String sql = "UPDATE Loai SET TenLoai='" + ten + "' WHERE MaLoai=" + maLoai;
//            Statement st = MyConnect.conn.createStatement();
//            int x = st.executeUpdate(sql);
//            return x > 0 ? true : false;
//        } catch (SQLException e) {
//        }
//        return false;
//    }
}
