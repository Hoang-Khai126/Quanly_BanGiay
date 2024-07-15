package DAO;

import DTO.NhanVien_DTO;
import DAO.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Types;
import javax.print.attribute.Size2DSyntax;
import javax.swing.JOptionPane;


/**
 *
 * @author DoHuy
 */
public class NhanVien_DAO {

    Connection con=ConnectionDataBase.conn;


    //Lấy danh sách nhân viên
    public ArrayList<DTO.NhanVien_DTO> LayDanhSachNV() {
        ArrayList<DTO.NhanVien_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select * from nhanvien where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.NhanVien_DTO nv = new DTO.NhanVien_DTO();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSDT(rs.getString("SDT"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setTrangThai(rs.getString("TrangThai"));
                    nv.setLuong(Float.parseFloat(rs.getString("Luong")));
                    ds.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }
    public ArrayList<DTO.NhanVien_DTO> LayDanhSachProcNV() {
        ArrayList<DTO.NhanVien_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhsachnhanvien1}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.NhanVien_DTO nv = new DTO.NhanVien_DTO();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSDT(rs.getString("SDT"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setTrangThai(rs.getString("TrangThai"));
                    nv.setLuong(Float.parseFloat(rs.getString("Luong")));
                    ds.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.NhanVien_DTO> LayDanhSachProcNVkhoiPhuc() {
        ArrayList<DTO.NhanVien_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call dsNhanVien02}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.NhanVien_DTO nv = new DTO.NhanVien_DTO();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSDT(rs.getString("SDT"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setTrangThai(rs.getString("TrangThai"));
                    nv.setLuong(Float.parseFloat(rs.getString("Luong")));
                    ds.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }
    //Tìm kiếm khách hàng
    public ArrayList<DTO.NhanVien_DTO> TimKiemNV(String giatri) {
        ArrayList<DTO.NhanVien_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call TimKiemNV(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.NhanVien_DTO nv = new DTO.NhanVien_DTO();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSDT(rs.getString("SDT"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setTrangThai(rs.getString("TrangThai"));
                    nv.setLuong(Float.parseFloat(rs.getString("Luong")));
                    ds.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

//cập nhật thêm code---------------------------------------------------------------------------------------------------------
//    // Thêm nhân viên
//    public void ThemNhanVien(DTO.NhanVien_DTO m) {
//        KetNoi();
//        try {
//            
//  
//            
//            CallableStatement st = con.prepareCall("{call themnhanvien(?,?,?,?,?,?)}");
//            st.setString(1,m.MaNV);
//            st.setString(2,m.TenNV);
//            st.setString(3,m.DiaChi);
//            st.setString(4,m.GioiTinh);
//            st.setString(5,m.SDT);
//            st.setString(6,m.Email);
//            st.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Thêm thành công !");
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    public String phatSinhMa() throws SQLException {
        String maNV = "";
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call sinhmaNhanVien}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("MaNV");

                    String so = ma.substring(2, ma.length()).trim();
                    if (Integer.parseInt(so) >= 0 && Integer.parseInt(so) < 9) {
                        maNV = "NV" + "000" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 9 && Integer.parseInt(so) < 99) {
                        maNV = "NV" + "00" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 99 && Integer.parseInt(so) < 999) {
                        maNV = "NV" + "0" + (Integer.parseInt(so) + 1);
                    } else {
                        maNV = "NV" + (Integer.parseInt(so) + 1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maNV;
    }

    // Thêm nhân viên
    public void ThemNhanVien(DTO.NhanVien_DTO m) throws SQLException {
          String maNV = phatSinhMa();
        try {
            CallableStatement st = con.prepareCall("{call themnhanvien(?,?,?,?,?,?,?)}");
            st.setString(1, maNV);
            st.setString(2, m.getTenNV());
            st.setString(3, m.getDiaChi());
            st.setString(4, m.getGioiTinh());
            st.setString(5, m.getSDT());
            st.setString(6, m.getEmail());
            st.setString(7, m.getLuong().toString());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//---------------------------------------------------------------------------------------------------------    
      // Sửa Nhân viên theo mã nhân viên
    public void SuaNhanVien(DTO.NhanVien_DTO nv,String trangThai) {
        try {
            CallableStatement st = con.prepareCall("{call SuaNhanVien(?,?,?,?,?,?,?,?)}");
            // Set parameters using proper methods
            st.setString(1, nv.getMaNV());
            st.setString(2, nv.getTenNV());
            st.setString(3, nv.getDiaChi());
            st.setString(4, nv.getGioiTinh());
            st.setString(5, nv.getSDT());
            st.setString(6, nv.getEmail());
            st.setString(7, nv.getLuong().toString());
            st.setString(8, trangThai);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Xóa khách hàng
    public void XoaNhanVien(DTO.NhanVien_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaNhanVien(?)}");
            st.setString(1, m.getMaNV());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void XoaNhanVienMat(DTO.NhanVien_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaMatNV(?)}");
            st.setString(1, m.getMaNV());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
