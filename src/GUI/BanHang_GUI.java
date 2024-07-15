package GUI;

import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import BUS.LoaiSP_BUS;
import DTO.NhanVien_DTO;
import BUS.NhanVien_BUS;
import BUS.KhachHang_BUS;
import DTO.KhachHang_DTO;
import BUS.Mau_BUS;
import BUS.ChiTietHoaDon_BUS;
import DTO.ChiTietSP_DTO;
import DTO.Mau_DTO;
import DTO.HoaDon_DTO;
import BUS.HoaDon_BUS;
import BUS.ChiTietSP_BUS;
import BUS.Size_BUS;
import DAO.SanPham_DAO;
import MyCustom.MyDialog;

import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BanHang_GUI extends javax.swing.JFrame {

    private SanPham_BUS sanPhamBus = new SanPham_BUS();
    private LoaiSP_BUS loaiSPBUS = new LoaiSP_BUS();
    private NhanVien_BUS dsNVBUS = new NhanVien_BUS();
    private KhachHang_BUS dsKHBUS = new KhachHang_BUS();
    private HoaDon_BUS hdBUS = new HoaDon_BUS();
    private Mau_BUS mauBus = new Mau_BUS();
    private Size_BUS sizeBUS = new Size_BUS();
    private ChiTietSP_BUS ctsp_BUS = new ChiTietSP_BUS();
    private ChiTietHoaDon_BUS cthdbus = new ChiTietHoaDon_BUS();
    private ChiTietSP_DTO ctsp = new ChiTietSP_DTO();
    String linkAnh = "";
    SpinnerNumberModel spinModel = new SpinnerNumberModel(0, 0, 100, 1);

    public BanHang_GUI() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jspin_SLMua.setModel(spinModel);
        loadDataLenTableSanPham();
        table_SanPham.setDefaultEditor(Object.class, null);

        ArrayList<DTO.NhanVien_DTO> dsNhanVien = dsNVBUS.getDanhSachNhanVien();
        loadDataLenComboBoxNhanVien(dsNhanVien);
        cb_nv.setSelectedIndex(1);

        ArrayList<DTO.KhachHang_DTO> dsKhachHang = dsKHBUS.getDanhSachKhachHang();
        loadDataLenComboBoxKhachHang(dsKhachHang);
        cb_kh.setSelectedIndex(1);
    }

    private void loadDataLenComboBoxNhanVien(ArrayList<DTO.NhanVien_DTO> NhanVien) {
        for (NhanVien_DTO nv : NhanVien) {
            cb_nv.addItem(nv.getMaNV() + " -  " + nv.getTenNV());
        }
    }

    private void loadDataLenComboBoxKhachHang(ArrayList<DTO.KhachHang_DTO> KhachHang) {
        for (KhachHang_DTO kh : KhachHang) {
            cb_kh.addItem(kh.getMaKH() + " -  " + kh.getTenKH());
        }
    }

    private void loadDataLenComboBoxMaCTSP(ArrayList<DTO.ChiTietSP_DTO> CTSP) {
        DefaultComboBoxModel newCB = new DefaultComboBoxModel();
        for (ChiTietSP_DTO ct : CTSP) {
            newCB.addElement(ct.getMaCTSP());
        }
        cb_maCTSP.setModel(newCB);
    }

    private void loadDataLenTableSanPham() {
        sanPhamBus.docDanhSachSanPham();
        ArrayList<SanPham_DTO> dssp = sanPhamBus.getListSanPham();
        loadDataLenTableSanPham(dssp);
    }

    private void loadDataLenTableSanPham(ArrayList<SanPham_DTO> dssp) {
        String[] hearder = {"Mã SP", "Tên SP", "Đơn giá", "Còn lại", "Loại"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (SanPham_DTO m : dssp) {
            if (m.getTrangThai().equals("0")) {
                Object[] o = {m.getMaSP(), m.getTenSP(), m.getGiaBan(), m.getSoLuong(), m.getMaLoai()};
                model.addRow(o);
            }
        }
        table_SanPham.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_GioHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_MaSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jspin_SLMua = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        cb_nv = new javax.swing.JComboBox<>();
        label_Anh = new javax.swing.JLabel();
        but_XuatHoaDon = new javax.swing.JButton();
        themGH_But = new javax.swing.JButton();
        but_Xoa = new javax.swing.JButton();
        but_TroVe = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_kh = new javax.swing.JComboBox<>();
        txt_timNV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_SLCon = new javax.swing.JTextField();
        txt_timKH1 = new javax.swing.JTextField();
        txt_TongTien = new javax.swing.JTextField();
        txt_TenSP = new javax.swing.JTextField();
        cb_maCTSP = new javax.swing.JComboBox<>();
        txt_timKiem = new javax.swing.JTextField();
        txt_Mau = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("GIỎ HÀNG");

        table_GioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã Màu", "Mã Size", "Số lượng ", "Mã CTSP", "Thành tiền"
            }
        ));
        table_GioHang.setGridColor(new java.awt.Color(255, 255, 255));
        table_GioHang.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table_GioHang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("CHI TIẾT SẢN PHẨM");

        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Còn lại", "Loại"
            }
        ));
        table_SanPham.setGridColor(new java.awt.Color(255, 255, 255));
        table_SanPham.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_SanPham);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("DANH SÁCH SẢN PHẨM");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã SP");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã CTSP");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Màu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("SL mua");

        txt_MaSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaSP.setPreferredSize(new java.awt.Dimension(64, 26));
        txt_MaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaSPActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Size");

        jspin_SLMua.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nhân viên");

        cb_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_nv.setMinimumSize(new java.awt.Dimension(72, 26));
        cb_nv.setPreferredSize(new java.awt.Dimension(72, 26));

        label_Anh.setBackground(new java.awt.Color(0, 0, 0));
        label_Anh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_Anh.setForeground(new java.awt.Color(255, 255, 255));
        label_Anh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Anh.setToolTipText("");
        label_Anh.setOpaque(true);
        label_Anh.setPreferredSize(new java.awt.Dimension(150, 150));

        but_XuatHoaDon.setText("Xuất hoá đơn");
        but_XuatHoaDon.setPreferredSize(new java.awt.Dimension(150, 50));
        but_XuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_XuatHoaDonActionPerformed(evt);
            }
        });

        themGH_But.setText("Thêm vào giỏ");
        themGH_But.setPreferredSize(new java.awt.Dimension(150, 50));
        themGH_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themGH_ButActionPerformed(evt);
            }
        });

        but_Xoa.setText("Xoá");
        but_Xoa.setPreferredSize(new java.awt.Dimension(150, 50));
        but_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_XoaActionPerformed(evt);
            }
        });

        but_TroVe.setText("Trở về");
        but_TroVe.setPreferredSize(new java.awt.Dimension(150, 50));
        but_TroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_TroVeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Khách hàng");

        cb_kh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_kh.setMinimumSize(new java.awt.Dimension(72, 26));
        cb_kh.setPreferredSize(new java.awt.Dimension(72, 26));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("SL Còn");

        txt_SLCon.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_SLCon.setEnabled(false);
        txt_SLCon.setPreferredSize(new java.awt.Dimension(60, 26));

        cb_maCTSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_maCTSP.setMinimumSize(new java.awt.Dimension(72, 26));
        cb_maCTSP.setPreferredSize(new java.awt.Dimension(72, 26));
        cb_maCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maCTSPActionPerformed(evt);
            }
        });

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Đơn giá");

        txt_DonGia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_DonGia.setPreferredSize(new java.awt.Dimension(60, 26));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Tên SP");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Tổng tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(cb_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_timNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_kh, 0, 140, Short.MAX_VALUE)
                                    .addComponent(txt_TongTien))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_timKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)
                                .addComponent(txt_SLCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_MaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Mau)
                                    .addComponent(txt_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TenSP)
                                    .addComponent(cb_maCTSP, 0, 97, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(4, 4, 4)
                                        .addComponent(jspin_SLMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(26, 26, 26))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(themGH_But, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(but_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_TroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_maCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(txt_Mau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jspin_SLMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SLCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_timNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themGH_But, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_TroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(0, 636, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamMouseClicked
        // TODO add your handling code here:
        label_Anh.setIcon(null);
        int row = table_SanPham.rowAtPoint(evt.getPoint());
        txt_MaSP.setText(table_SanPham.getValueAt(row, 0) + "");
        txt_TenSP.setText(table_SanPham.getValueAt(row, 1) + "");
        txt_DonGia.setText(table_SanPham.getValueAt(row, 2) + "");
        txt_SLCon.setText(table_SanPham.getValueAt(row, 3) + "");

        ArrayList<ChiTietSP_DTO> ctsp_DTO = ctsp_BUS.LayDanhSachCTSP_TheoMa(txt_MaSP.getText());
        loadDataLenComboBoxMaCTSP(ctsp_DTO);
        ctsp = ctsp_BUS.LayCTSPTHeoMaCTSP((String) cb_maCTSP.getSelectedItem());

        txt_Mau.setText(mauBus.layMaVaTenMau(ctsp.getMaMau()));
        txt_Size.setText(sizeBUS.layMaVaTenSize(ctsp.getMaSize()));
        txt_SLCon.setText(Integer.toString(ctsp.getSoLuong()));

        //linkAnh=sanPhamB
        File file = new File(linkAnh);
        if (file.exists()) {
            ImageIcon anhSP = new ImageIcon(linkAnh);
            Image image = anhSP.getImage(); // Chuyển đổi về đối tượng Image
            Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
            anhSP = new ImageIcon(scaledImage); // Chuyển đổi về ImageIcon
            label_Anh.setIcon(anhSP);
        } else {
            label_Anh.setText("NO");
        }
    }//GEN-LAST:event_table_SanPhamMouseClicked

    private void but_TroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_TroVeActionPerformed
        // TODO add your handling code here:
        MainGUI mgui = new MainGUI();
        mgui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_TroVeActionPerformed

    private void themGH_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themGH_ButActionPerformed
        // TODO add your handling code here:
        if ( Integer.parseInt(jspin_SLMua.getValue().toString())<=0 || Integer.parseInt(jspin_SLMua.getValue().toString())>Integer.parseInt(txt_SLCon.getText())) {
            new MyDialog("Số lượng không hợp lệ", MyDialog.ERROR_DIALOG);
            return;
        }
        float tongTien = 0;
        String[] hearder = {"Mã SP", "Mã Màu", "Mã Size", "Số lượng", "Mã CTSP", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        if (table_GioHang.getModel().getRowCount() != 0) {
            for (int i = 0; i < table_GioHang.getModel().getRowCount(); i++) {
                Object[] rowdata = {table_GioHang.getValueAt(i, 0), table_GioHang.getValueAt(i, 1), table_GioHang.getValueAt(i, 2), table_GioHang.getValueAt(i, 3), table_GioHang.getValueAt(i, 4), table_GioHang.getValueAt(i, 5)};
                String thanhTien = table_GioHang.getValueAt(i, 5).toString();
                Float tien = Float.parseFloat(thanhTien);
                String soLuong = table_GioHang.getValueAt(i, 3).toString();
                Float sl = Float.parseFloat(soLuong);
                tongTien += sl * tien;
                model.addRow(rowdata);
            }
        }
        String size = txt_Size.getText().split("-")[0];
        String mau = txt_Mau.getText().split("-")[0];
        Object[] newRow = {txt_MaSP.getText(), mau, size, jspin_SLMua.getValue().toString(), cb_maCTSP.getSelectedItem(), txt_DonGia.getText()};
        model.addRow(newRow);
        Float tien = Float.parseFloat(txt_DonGia.getText());
        Float sl = Float.parseFloat(jspin_SLMua.getValue().toString());
        tongTien += sl * tien;
        table_GioHang.setModel(model);
        txt_TongTien.setText(Float.toString(tongTien));
    }//GEN-LAST:event_themGH_ButActionPerformed

    private void cb_maCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maCTSPActionPerformed
        ctsp = ctsp_BUS.LayCTSPTHeoMaCTSP((String) cb_maCTSP.getSelectedItem());

        txt_Mau.setText(mauBus.layMaVaTenMau(ctsp.getMaMau()));
        txt_TongTien.setText(sizeBUS.layMaVaTenSize(ctsp.getMaSize()));
        txt_SLCon.setText(Integer.toString(ctsp.getSoLuong()));
    }//GEN-LAST:event_cb_maCTSPActionPerformed

    private void txt_MaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaSPActionPerformed

    }//GEN-LAST:event_txt_MaSPActionPerformed

    private void but_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_XoaActionPerformed
        // TODO add your handling code here:
        int rowDel = table_GioHang.getSelectedRow();

        float tongTien = 0;
        String[] hearder = {"Mã SP", "Mã Màu", "Mã Size", "Số lượng", "Mã CTSP", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        if (table_GioHang.getModel().getRowCount() != 0) {
            for (int i = 0; i < table_GioHang.getModel().getRowCount(); i++) {
                if (i == rowDel) {
                    String thanhTien = table_GioHang.getValueAt(i, 5).toString();
                    Float tien = Float.parseFloat(thanhTien);
                    String soLuong = table_GioHang.getValueAt(i, 3).toString();
                    Float sl = Float.parseFloat(soLuong);
                } else {
                    Object[] rowdata = {table_GioHang.getValueAt(i, 0), table_GioHang.getValueAt(i, 1), table_GioHang.getValueAt(i, 2), table_GioHang.getValueAt(i, 3), table_GioHang.getValueAt(i, 4), table_GioHang.getValueAt(i, 5)};
                    String thanhTien = table_GioHang.getValueAt(i, 5).toString();
                    Float tien = Float.parseFloat(thanhTien);
                    String soLuong = table_GioHang.getValueAt(i, 3).toString();
                    Float sl = Float.parseFloat(soLuong);
                    tongTien += sl * tien;
                    model.addRow(rowdata);
                }
            }
        }
        table_GioHang.setModel(model);
        txt_TongTien.setText(Float.toString(tongTien));
    }//GEN-LAST:event_but_XoaActionPerformed

    private void but_XuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_XuatHoaDonActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String date2 = null;

        LocalDate currentDate = LocalDate.now();

        // Định dạng ngày theo định dạng yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        String MaHD = "";
        try {
            MaHD = hdBUS.phatSinhMa();
        } catch (SQLException ex) {
            Logger.getLogger(BanHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        hdBUS.themHoaDon(MaHD, cb_kh.getSelectedItem().toString(), cb_kh.getSelectedItem().toString(), formattedDate, txt_TongTien.getText());
        
        
    }//GEN-LAST:event_but_XuatHoaDonActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
        SanPham_DAO sp=new SanPham_DAO();
        if (txt_timKiem.getText() != null) {
            ArrayList<SanPham_DTO> dssp = sp.TimKiemSP(txt_timKiem.getText());
            loadDataLenTableSanPham(dssp);
        }
    }//GEN-LAST:event_txt_timKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_TroVe;
    private javax.swing.JButton but_Xoa;
    private javax.swing.JButton but_XuatHoaDon;
    private javax.swing.JComboBox<String> cb_kh;
    private javax.swing.JComboBox<String> cb_maCTSP;
    private javax.swing.JComboBox<String> cb_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jspin_SLMua;
    private javax.swing.JLabel label_Anh;
    private javax.swing.JTable table_GioHang;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JButton themGH_But;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaSP;
    private javax.swing.JTextField txt_Mau;
    private javax.swing.JTextField txt_SLCon;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_TenSP;
    private javax.swing.JTextField txt_TongTien;
    private javax.swing.JTextField txt_timKH1;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_timNV;
    // End of variables declaration//GEN-END:variables
}
