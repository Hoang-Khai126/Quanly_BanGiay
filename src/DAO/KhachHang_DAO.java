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
import DTO.KhachHang_DTO;

/**
 *
 * @author DoHuy
 */
public class KhachHang_DAO {

    Connection con = ConnectionDataBase.conn;

    public ArrayList<DTO.KhachHang_DTO> LayDanhSach() {
        ArrayList<DTO.KhachHang_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select * from KhachHang where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.KhachHang_DTO kh = new DTO.KhachHang_DTO();
                    kh.MaKH = rs.getString("MaKH");
                    kh.TenKH = rs.getString("TenKH");
                    kh.Sdt = rs.getString("Sdt");
                    kh.DiaChi = rs.getString("DiaChi");
                    kh.Email = rs.getString("Email");
                    kh.TrangThai = rs.getString("TrangThai");
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.KhachHang_DTO> LayDanhSachProc() {
        ArrayList<DTO.KhachHang_DTO> ds = new ArrayList<>();

        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhsachKH01}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.KhachHang_DTO kh = new DTO.KhachHang_DTO();
                    kh.MaKH = rs.getString("MaKH");
                    kh.TenKH = rs.getString("TenKH");
                    kh.Sdt = rs.getString("Sdt");
                    kh.DiaChi = rs.getString("DiaChi");
                    kh.Email = rs.getString("Email");
                    kh.TrangThai = rs.getString("TrangThai");
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    //tìm kiếm khách hàng
    public ArrayList<DTO.KhachHang_DTO> TimKiemTheoMau(String giatri) {
        ArrayList<DTO.KhachHang_DTO> ds = new ArrayList<>();

        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call TimKiemKH(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.KhachHang_DTO kh = new DTO.KhachHang_DTO();
                    kh.MaKH = rs.getString("MaKH");
                    kh.TenKH = rs.getString("TenKH");
                    kh.Sdt = rs.getString("Sdt");
                    kh.DiaChi = rs.getString("DiaChi");
                    kh.Email = rs.getString("Email");
                    kh.TrangThai = rs.getString("TrangThai");
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.KhachHang_DTO> KhoiPhucLayDanhSachProc() {
        ArrayList<DTO.KhachHang_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhsachKH02}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.KhachHang_DTO kh = new DTO.KhachHang_DTO();
                    kh.MaKH = rs.getString("MaKH");
                    kh.TenKH = rs.getString("TenKH");
                    kh.Sdt = rs.getString("Sdt");
                    kh.DiaChi = rs.getString("DiaChi");
                    kh.Email = rs.getString("Email");
                    kh.TrangThai = rs.getString("TrangThai");
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public String phatSinhMa() throws SQLException {
        String matk = "";
        //con = 
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call sinhmaKhachHang}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("MaKH");

                    String so = ma.substring(2, ma.length()).trim();
                    if (Integer.parseInt(so) >= 0 && Integer.parseInt(so) < 9) {
                        matk = "KH" + "000" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 9 && Integer.parseInt(so) < 99) {
                        matk = "KH" + "00" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 99 && Integer.parseInt(so) < 999) {
                        matk = "KH" + "0" + (Integer.parseInt(so) + 1);
                    } else {
                        matk = "KH" + (Integer.parseInt(so) + 1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return matk;
    }

    public void ThemKhachHang(DTO.KhachHang_DTO m) throws SQLException {
        String maKH = phatSinhMa();

        try {
            CallableStatement st = con.prepareCall("{call ThemKH(?, ?, ?, ?, ?)}");
            st.setString(1, maKH);
            st.setNString(2, m.TenKH);
            st.setNString(3, m.DiaChi);
            st.setString(4, m.Sdt);
            st.setString(5, m.Email);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//---------------------------------------------------------------------------------------------------------------------------    

    // sửa khách hàng theo mã khách hàng
    public void SuaKhachHang(DTO.KhachHang_DTO kh, String trangThai) {
        try {
            CallableStatement st = con.prepareCall("{call SuaKhachHang(?,?,?,?,?,?)}");
            // Set parameters using proper methods
            st.setString(1, kh.getMaKH());
            st.setNString(2, kh.getTenKH());
            st.setNString(3, kh.getDiaChi());
            st.setString(4, kh.getSdt());
            st.setString(5, kh.getEmail());
            st.setString(6, trangThai);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Xóa khách hàng

    public void XoaKhachHang(DTO.KhachHang_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaKhachHang(?)}");
            st.setString(1, m.MaKH);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void XoaKhachHangMat(DTO.KhachHang_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaMat(?)}");
            st.setString(1, m.MaKH);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SuaKhachHang(KhachHang_DTO m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
