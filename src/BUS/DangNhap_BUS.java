/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DangNhap_DAO;
import DTO.TaiKhoan_DTO;
import DAO.ConnectionDataBase;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.*;
import MyCustom.MyDialog;
/**
 *
 * @author ADMIN
 */
public class DangNhap_BUS {
    
    private final static int EMPTY_ERROR = 1;
    private final static int WRONG_ERROR = 2;
    public static TaiKhoan_DTO taiKhoanLogin = null;
    
    public TaiKhoan_DTO getTaiKhoanDangNhap(String tenDN, String matKhau) {
        if (kiemTraDangNhap(tenDN, matKhau) == EMPTY_ERROR) {
            new MyDialog("Không được để trống thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }
        TaiKhoan_DTO tk = new TaiKhoan_DTO();
        tk.setTenDangNhap(tenDN);
        tk.setMatKhau(matKhau);

        DangNhap_DAO dangNhapDAO = new DangNhap_DAO();
        TaiKhoan_DTO account = dangNhapDAO.dangNhap(tk);
        taiKhoanLogin = account;

        if (account == null) {
            new MyDialog("Sai thông tin đăng nhập hoặc tài khoản đã bị khoá!", MyDialog.ERROR_DIALOG);
        } else {
            new MyDialog("Đăng nhập thành công!", MyDialog.SUCCESS_DIALOG);
        }
        return account;
        
    }
    
    private int kiemTraDangNhap(String tenDN, String matKhau) {
        tenDN = tenDN.replaceAll("\\s+", "");
        matKhau = matKhau.replaceAll("\\s+", "");
        int result = 0;

        TaiKhoan_DTO tk = new TaiKhoan_DTO();
        tk.setTenDangNhap(tenDN);
        tk.setMatKhau(matKhau);

        DangNhap_DAO dangNhapDAO = new DangNhap_DAO();
        TaiKhoan_DTO taikhoan = dangNhapDAO.dangNhap(tk);

        if (tenDN.length() <= 0 || matKhau.length() <= 0) {
            result = EMPTY_ERROR;
        } else if (taikhoan == null) {
            result = WRONG_ERROR;
        }
        return result;
    }
}
