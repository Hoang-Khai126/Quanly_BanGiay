package DAO;

import DAO.ConnectionDataBase;
import DTO.NhaCC;
import GUI.frmPhieuNhap;
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
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class daoNhaCC {

    Connection con = ConnectionDataBase.conn;

    public ArrayList<NhaCC> LayDanhSach() {
        ArrayList<NhaCC> ds = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "select * from NhaCC where TrangThai = 0";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    NhaCC m = new NhaCC();
                    m.setMaNCC(rs.getString("MaNCC"));
                    m.setTenNCC(rs.getString("TenNCC"));
                    m.setDiaChi(rs.getString("DiaChi"));
                    m.setSdt(rs.getString("Sdt"));
                    m.setEmail(rs.getString("Email"));
                    ds.add(m);
                }
            } catch (SQLException ex) {
                Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public ArrayList<NhaCC> TimKiemTheoNhaCC(String giatri) {
        ArrayList<NhaCC> ds = new ArrayList<>();
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call TimKiemTheoNhaCC(?)}");
                st.setString(1, giatri);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    NhaCC m = new NhaCC();
                    m.setMaNCC(rs.getString("MaNCC"));
                    m.setTenNCC(rs.getString("TenNCC"));
                    m.setDiaChi(rs.getString("DiaChi"));
                    m.setSdt(rs.getString("Sdt"));
                    m.setEmail(rs.getString("Email"));
                    ds.add(m);
                }
            } catch (SQLException ex) {
                Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;
    }

    public String phatSinhMa() throws SQLException {
        String manhacc = "";
        if (con != null) {
            try {
                CallableStatement st = con.prepareCall("{call nhaCCLonNhat}");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("mancc");
                    String so = ma.substring(3, ma.length()).trim();
                    if (Integer.parseInt(so) >= 0 && Integer.parseInt(so) <= 9) {
                        manhacc = "NCC" + "000" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 10 && Integer.parseInt(so) <= 99) {
                        manhacc = "NCC" + "00" + (Integer.parseInt(so) + 1);
                    } else if (Integer.parseInt(so) >= 100 && Integer.parseInt(so) <= 999) {
                        manhacc = "NCC" + "0" + (Integer.parseInt(so) + 1);
                    } else {
                        manhacc = "NCC" + (Integer.parseInt(so) + 1);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return manhacc;
    }
    private static frmPhieuNhap phieuNhapForm;

    public static void setPhieuNhapForm(frmPhieuNhap form) {
        phieuNhapForm = form;
    }

    public void ThemNhaCC(NhaCC m) throws SQLException {
        String manhacc = phatSinhMa();
        try {
            CallableStatement st = con.prepareCall("{call ThemNhaCC(?,?,?,?,?)}");
            st.setString(1, manhacc);
            st.setString(2, m.getTenNCC());
            st.setString(3, m.getDiaChi());
            st.setString(4, m.getSdt());
            st.setString(5, m.getEmail());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
            phieuNhapForm.capNhatDuLieuNhaCungCapMoi(m);
        } catch (SQLException ex) {
            Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SuaNhaCC(NhaCC m) {
        try {
            CallableStatement st = con.prepareCall("{call SuaNhaCC(?,?,?,?,?)}");
            st.setString(1, m.getMaNCC());
            st.setString(2, m.getTenNCC());
            st.setString(3, m.getDiaChi());
            st.setString(4, m.getSdt());
            st.setString(5, m.getEmail());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void XoaNhaCC(NhaCC m) {
        try {
            CallableStatement st = con.prepareCall("{call XoaNhaCC(?)}");
            st.setString(1, m.getMaNCC());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(daoNhaCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NhaCC findBySdt(String sdt) {
        String sql = "SELECT * FROM nhacc WHERE sdt = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sdt);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new NhaCC(
                        rs.getString("MaNCC"),
                        rs.getString("TenNCC"),
                        rs.getString("DiaChi"),
                        rs.getString("Sdt"),
                        rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
