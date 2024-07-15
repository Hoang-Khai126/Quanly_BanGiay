/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import DTO.Size_DTO;
import DAO.ConnectionDataBase;

/**
 *
 * @author DoHuy
 */
public class Size_DAO {

    Connection con = ConnectionDataBase.conn;

    public ArrayList<DTO.Size_DTO> LayDanhSachSize() {
        ArrayList<DTO.Size_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select * from Size where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.Size_DTO s = new DTO.Size_DTO();
                    s.MaSize = rs.getString("MaSize");
                    s.TenSize = rs.getString("TenSize");
                    s.SoLuong = rs.getString("SoLuong");
                    ds.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    //--------------------------------------------------
    //tìm kiếm khách hàng
    public ArrayList<DTO.Size_DTO> TimKiemSize(String giatri) {
        ArrayList<DTO.Size_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call TimSize(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.Size_DTO size = new DTO.Size_DTO();
                    size.MaSize = rs.getString("MaSize");
                    size.TenSize = rs.getString("TenSize");
                    size.SoLuong = rs.getString("SoLuong");
                    ds.add(size);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    // thêm khách hàng
//    public void ThemSize(DTO.Size_DTO m) {
//        KetNoi();
//        try {
//            CallableStatement st = con.prepareCall("{call ThemSize(?, ?, ?)}");
//            st.setString(1,m.MaSize);
//            st.setNString(2,m.TenSize);
//            st.setNString(3,m.SoLuong);
//            st.executeUpdate();
////            JOptionPane.showMessageDialog(null, "Thêm thành công !");
//        } catch (SQLException ex) {
//            Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    public String phatSinhMaSize() throws SQLException {
        String maSize = "";
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call sinhmaSizeGiay}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("MaSize");

                    String so = ma.substring(1, ma.length()).trim();
                    if (Integer.parseInt(so) >= 0 && Integer.parseInt(so) < 9) {
                        maSize = "s" + "000" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 9 && Integer.parseInt(so) < 99) {
                        maSize = "s" + "00" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 99 && Integer.parseInt(so) < 999) {
                        maSize = "s" + "0" + (Integer.parseInt(so) + 1);
                    } else {
                        maSize = "s" + (Integer.parseInt(so) + 1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maSize;
    }

    public void ThemSize(DTO.Size_DTO m) throws SQLException {
//    if (kiemTraMatKhauTrung(m.getMatKhau())) {
//        JOptionPane.showMessageDialog(null, "Mật khẩu đã tồn tại!");
//        return;
//    }

        String maSize1 = phatSinhMaSize();
        try {
            CallableStatement st = con.prepareCall("{call ThemSize(?, ?, ?)}");
            st.setString(1, maSize1);
            st.setNString(2, m.TenSize);
            st.setNString(3, m.SoLuong);
            st.executeUpdate();
//        JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SuaSize(DTO.Size_DTO kh) {
        try {
            CallableStatement st = con.prepareCall("{call SuaSize(?,?,?)}");
            // Set parameters using proper methods
            st.setString(1, kh.getMaSize());
            st.setNString(2, kh.getTenSize());
            st.setNString(3, kh.getSoLuong());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void XoaSize(DTO.Size_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaSize(?)}");
            st.setString(1, m.MaSize);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(Size_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
