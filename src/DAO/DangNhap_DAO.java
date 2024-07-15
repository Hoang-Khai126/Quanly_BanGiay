/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoan_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import DAO.ConnectionDataBase;
/**
 *
 * @author ADMIN
 */
public class DangNhap_DAO {
 
    public TaiKhoan_DTO dangNhap(TaiKhoan_DTO tk){
    try{
        String query="{CALL LayTaiKhoan(?,?)}";
        CallableStatement pre=ConnectionDataBase.conn.prepareCall(query);
        pre.setString(1, tk.getTenDangNhap());
        pre.setString(2, tk.getMatKhau());
        ResultSet rs=pre.executeQuery();
        
        TaiKhoan_DTO tkLogin=null;
        if(rs.next())
        {
            tkLogin =tk;
            tkLogin.setMaNhanVien(rs.getString("MaNV"));
            tkLogin.setChucVu(rs.getString("ChucVu"));
        }
        return tkLogin;
    } catch(SQLException e)
    {
        e.printStackTrace();
    }
    return tk;
    }
            
}
