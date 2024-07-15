package DAO;


import DTO.HoaDon_DTO;
import DAO.ConnectionDataBase;
import DAO.SanPham_DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon_DAO {
    Connection con=ConnectionDataBase.conn;
    public ArrayList<DTO.HoaDon_DTO> LayDanhSachHD() {
        ArrayList<DTO.HoaDon_DTO> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call danhsachhoadon}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    DTO.HoaDon_DTO nv = new DTO.HoaDon_DTO();
                    nv.setMaHD(rs.getString("MaHD"));
                    nv.setMaKH(rs.getString("MaKH"));
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setNgayLap(rs.getString("NgayLap"));
                    nv.setTongTien(Float.parseFloat(rs.getString("TongTien")));
                    nv.setTrangThai(rs.getString("TrangThai"));
                    ds.add(nv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }
    
    public String phatSinhMa() throws SQLException {
        String maHD = "";
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call sinhmaHoaDon}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("MaHD");

                    String so = ma.substring(2, ma.length()).trim();
                    if (Integer.parseInt(so) >= 0 && Integer.parseInt(so) < 9) {
                        maHD = "HD" + "000" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 9 && Integer.parseInt(so) < 99) {
                        maHD = "HD" + "00" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 99 && Integer.parseInt(so) < 999) {
                        maHD = "HD" + "0" + (Integer.parseInt(so) + 1);
                    } else {
                        maHD = "HD" + (Integer.parseInt(so) + 1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maHD;
    }
    
    public boolean themHoaDon(HoaDon_DTO sp) {
        boolean result = false;      
        
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call ThemHoaDon(?,?,?,?,?)}");
            prep.setString(1, sp.getMaHD());
            prep.setString(2, sp.getMaKH());
            prep.setString(3, sp.getMaNV());
            prep.setString(4, sp.getNgayLap());
            prep.setFloat(5, 0);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean SuaHoaDon(HoaDon_DTO sp) {
        boolean result = false;
        try {
            CallableStatement prep = ConnectionDataBase.conn.prepareCall("{call SuaHoaDon(?,?,?,?)}");
            prep.setString(1, sp.getMaHD());
            prep.setString(2, sp.getMaKH());
            prep.setString(3, sp.getMaNV());
            prep.setString(4, sp.getNgayLap());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            result = false;
        }
        return result;
    }
}
