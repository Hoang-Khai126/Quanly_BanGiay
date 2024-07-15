package BUS;

import DAO.SanPham_DAO;
import DTO.SanPham_DTO;
import MyCustom.MyDialog;

import java.util.ArrayList;
import java.util.Locale;

public class SanPham_BUS {

    private ArrayList<SanPham_DTO> listSP = null;
    private SanPham_DAO sanPham_DAO = new SanPham_DAO();

    public void docDanhSachSanPham() {
        this.listSP = sanPham_DAO.getListSanPham();
    }

    public ArrayList<SanPham_DTO> getListSanPham() {
        if (listSP == null) {
            docDanhSachSanPham();
        }
        return listSP;
    }

    public boolean themSanPham(String maSP, String tenSP, String soLuong, String giaNhap, String giaBan, String hinh, String maLoai, String maNCC, String moTa, String trangThai) {
        if (maSP.trim().equals("")) {
            new MyDialog("Không được để trống mã sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (tenSP.trim().equals("")) {
            new MyDialog("Không được để trống tên sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (soLuong.trim().equals("")) {
            new MyDialog("Không được để trống số lượng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (giaNhap.trim().equals("")) {
            new MyDialog("Không được để trống giá nhập!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (giaBan.trim().equals("")) {
            new MyDialog("Không được để trống giá bán!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (hinh.trim().equals("")) {
            new MyDialog("Vui lòng chọn hình ảnh cho sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maLoai.trim().equals("")) {
            new MyDialog("Không được để trống mã loại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maNCC.trim().equals("")) {
            new MyDialog("Không được để trống mã NCC!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (moTa.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (trangThai.trim().equals("")) {
            new MyDialog("Vui lòng chọn trạng thái!", MyDialog.ERROR_DIALOG);
            return false;
        }
        SanPham_DTO sp = new SanPham_DTO();
        sp.setMaSP(maSP);
        sp.setTenSP(tenSP);
        sp.setSoLuong(Integer.parseInt(soLuong));
        sp.setGiaNhap(Float.parseFloat(giaNhap));
        sp.setGiaBan(Float.parseFloat(giaBan));
        sp.setHinhSP(hinh);
        sp.setMaLoai(maLoai);
        sp.setMaNCC(maNCC);
        sp.setMoTa(moTa);
        sp.setTrangThai(trangThai);

        boolean flag = sanPham_DAO.themSanPham(sp);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean suaSanPham(String maSP, String tenSP, String soLuong, String giaNhap, String giaBan, String hinh, String maLoai, String maNCC, String moTa, String trangThai) {
        if (maSP.trim().equals("")) {
            new MyDialog("Không được để trống mã sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (tenSP.trim().equals("")) {
            new MyDialog("Không được để trống tên sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (soLuong.trim().equals("")) {
            new MyDialog("Không được để trống số lượng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (giaNhap.trim().equals("")) {
            new MyDialog("Không được để trống giá nhập!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (giaBan.trim().equals("")) {
            new MyDialog("Không được để trống giá bán!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (hinh.trim().equals("")) {
            new MyDialog("Vui lòng chọn hình ảnh cho sản phẩm!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maLoai.trim().equals("")) {
            new MyDialog("Không được để trống mã loại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (maNCC.trim().equals("")) {
            new MyDialog("Không được để trống mã NCC!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (moTa.trim().equals("")) {
            new MyDialog("Không được để trống mô tả!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (trangThai.trim().equals("")) {
            new MyDialog("Vui lòng chọn trạng thái!", MyDialog.ERROR_DIALOG);
            return false;
        }
        SanPham_DTO sp = new SanPham_DTO();
        sp.setMaSP(maSP);
        sp.setTenSP(tenSP);
        sp.setSoLuong(Integer.parseInt(soLuong));
        sp.setGiaNhap(Float.parseFloat(giaNhap));
        sp.setGiaBan(Float.parseFloat(giaBan));
        sp.setHinhSP(hinh);
        sp.setMaLoai(maLoai);
        sp.setMaNCC(maNCC);
        sp.setMoTa(moTa);
        sp.setTrangThai(trangThai);

        boolean flag = sanPham_DAO.SuaSanPham(sp);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    

}
