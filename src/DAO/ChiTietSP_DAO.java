package DAO;

import DTO.ChiTietSP_DTO;
import DAO.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ChiTietSP_DAO {

    Connection con = ConnectionDataBase.conn;

    public DTO.ChiTietSP_DTO LayCTSPTHeoMaCTSP(String maCTSP) {
        DTO.ChiTietSP_DTO ctsp = new DTO.ChiTietSP_DTO();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call proc_LayCTSanPhamTheoMaSP(?)}");
                st.setString(1, maCTSP);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    ctsp.setMaSP(rs.getString("MaSP"));
                    ctsp.setMaMau(rs.getString("MaMau"));
                    ctsp.setMaSize(rs.getString("MaSize"));
                    ctsp.setSoLuong(Integer.parseInt(rs.getString("SoLuong")));
                    ctsp.setMaCTSP(rs.getString("MaCTSP"));
                    ctsp.setTrangThai(rs.getString("TrangThai"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ctsp;
    }
    
    public ArrayList<DTO.ChiTietSP_DTO> LayDanhSachCTSPTHeoMa(String maSP) {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhsachchitietsptheoma(?)}");
                st.setString(1, maSP);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.ChiTietSP_DTO ctsp = new DTO.ChiTietSP_DTO();
                    ctsp.setMaSP(rs.getString("MaSP"));
                    ctsp.setMaMau(rs.getString("MaMau"));
                    ctsp.setMaSize(rs.getString("MaSize"));
                    ctsp.setSoLuong(rs.getInt("SoLuong"));
                    ctsp.setMaCTSP(rs.getString("MaCTSP"));
                    ctsp.setTrangThai(rs.getString("TrangThai"));
                    ds.add(ctsp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, "Lỗi khi gọi thủ tục DanhSachCTSP", ex);
            }

        }
        return ds;
    }

    public ArrayList<DTO.ChiTietSP_DTO> LayDanhSachCTSP() {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        CallableStatement st = null;
        ResultSet rs = null;
        if (con != null) {
            try {
                st = con.prepareCall("{call DanhSachCTSP}");
                rs = st.executeQuery();

                while (rs.next()) {
                    DTO.ChiTietSP_DTO ctsp = new DTO.ChiTietSP_DTO();
                    ctsp.setMaSP(rs.getString("MaSP"));
                    ctsp.setMaMau(rs.getString("maMau"));
                    ctsp.setMaSize(rs.getString("maSize"));
                    ctsp.setSoLuong(rs.getInt("soLuong")); // Sử dụng getInt để lấy giá trị số nguyên
                    ctsp.setMaCTSP(rs.getString("maCTSP"));
                    ctsp.setTrangThai(rs.getString("trangThai"));

                    ds.add(ctsp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, "Lỗi khi gọi thủ tục DanhSachCTSP", ex);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, "Lỗi khi đóng tài nguyên", ex);
                }
            }
        } else {
            Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.WARNING, "Không có kết nối cơ sở dữ liệu");
        }

        return ds;
    }

    //tìm kiếm khách hàng
    public ArrayList<DTO.ChiTietSP_DTO> TimKiemCTSP(String giatri) {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call TimKiemCTSP(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.ChiTietSP_DTO ctsp = new DTO.ChiTietSP_DTO();
                    ctsp.setMaSP(rs.getString("MaSP"));
                    ctsp.setMaMau(rs.getString("maMau"));
                    ctsp.setMaSize(rs.getString("maSize"));
                    ctsp.setSoLuong(rs.getInt("soLuong")); // Sử dụng getInt để lấy giá trị số nguyên
                    ctsp.setMaCTSP(rs.getString("maCTSP"));
                    ctsp.setTrangThai(rs.getString("trangThai"));
                    ds.add(ctsp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.ChiTietSP_DTO> LayMaSP() {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select MaSP from SanPham where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.ChiTietSP_DTO kh = new DTO.ChiTietSP_DTO();
                    kh.setMaSP(rs.getString("MaSP"));
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.ChiTietSP_DTO> LayMaMau() {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select MaMau from Mau where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.ChiTietSP_DTO kh = new DTO.ChiTietSP_DTO();
                    kh.setMaMau(rs.getString("MaMau"));
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<DTO.ChiTietSP_DTO> LayMaSize() {
        ArrayList<DTO.ChiTietSP_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select MaSize from Size where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    DTO.ChiTietSP_DTO kh = new DTO.ChiTietSP_DTO();
                    kh.setMaSize(rs.getString("MaSize"));
                    ds.add(kh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

  
    public void ThemCTSP(DTO.ChiTietSP_DTO m) throws SQLException {
    try {
        // Kiểm tra xem giá trị khóa chính đã tồn tại chưa
        if (!KiemTraTonTai(m.getMaSP(), m.getMaMau(), m.getMaSize())) {
            // Kiểm tra các giá trị không phải là NULL trước khi chèn vào cơ sở dữ liệu
            if (m.getMaSP() != null && m.getMaMau() != null && m.getMaSize() != null && m.getMaCTSP() != null) {
                CallableStatement st = con.prepareCall("{call ThemCTSP(?, ?, ?, ?, ?)}");
                st.setString(1, m.getMaCTSP());
                st.setString(2, m.getMaSP());
                st.setNString(3, m.getMaMau());
                st.setNString(4, m.getMaSize());
                st.setInt(5, m.getSoLuong());
                
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công !");
            } else {
                JOptionPane.showMessageDialog(null, "Các giá trị không được phép là NULL!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bản ghi đã tồn tại trong cơ sở dữ liệu!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Đóng kết nối
        if (con != null) {
            con.close();
        }
    }
    }

// Phương thức kiểm tra xem bản ghi đã tồn tại hay chưa
    private boolean KiemTraTonTai(String maSP, String maMau, String maSize) throws SQLException {
        String sql = "SELECT * FROM ChiTiet_SanPham WHERE MaSP = ? AND MaMau = ? AND MaSize = ?";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maSP);
        ps.setString(2, maMau);
        ps.setString(3, maSize);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Trả về true nếu tồn tại bản ghi, ngược lại trả về false
    }
    
        // Xóa khách hàng
    public void XoaCTSP(DTO.ChiTietSP_DTO m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaCTSP(?)}");
            st.setString(1, m.getMaCTSP());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
