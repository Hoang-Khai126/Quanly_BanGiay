package GUI;

import BUS.HoaDon_BUS;
import DTO.HoaDon_DTO;
import BUS.ChiTietHoaDon_BUS;
import DTO.ChiTietHD_DTO;
import DAO.ConnectionDataBase;

import java.time.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.api.tree.TryTree;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import javax.swing.ButtonGroup;
import javax.swing.WindowConstants;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HoaDonBan_GUI extends javax.swing.JFrame {

    private HoaDon_BUS hdBus = new HoaDon_BUS();
    private ChiTietHoaDon_BUS cthdBUS = new ChiTietHoaDon_BUS();
    public HoaDonBan_GUI() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadDataLenTableHoaDOn();
        loadDataLenTableChiTietHoaDOn();
        loadDataLenTableChiTietHoaDOn();

        table_HD.setDefaultEditor(Object.class, null);
        table_CTHD.setDefaultEditor(Object.class, null);
        unsetEnabled_HoaDon();
        unsetEnabled_ChiTietHoaDon();
    }

    private void loadDataLenTableHoaDOn() {
        hdBus.docDanhSachHoaDon();
        ArrayList<HoaDon_DTO> dshd = hdBus.LayDanhSachHD();
        loadDataLenTableHoaDOn(dshd);
    }

    private void loadDataLenTableHoaDOn(ArrayList<HoaDon_DTO> dshd) {
        String[] hearder = {"Mã HD", "Mã KH", "Mã NV", "Ngày lập", "Tổng tiền"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (HoaDon_DTO m : dshd) {
            Object[] o = {m.getMaHD(), m.getMaKH(), m.getMaNV(), m.getNgayLap(), m.getTongTien()};
            model.addRow(o);
        }
        table_HD.setModel(model);
    }

    private void loadDataLenTableChiTietHoaDOn() {
        cthdBUS.docDanhSachChiTietHoaDon();
        ArrayList<ChiTietHD_DTO> dscthd = cthdBUS.LayDanhSachCTHD();
        loadDataLenTableChiTietHoaDOn(dscthd);
    }

    private void loadDataLenTableChiTietHoaDOn(ArrayList<ChiTietHD_DTO> dsCTHD) {
        String[] hearder = {"Mã CTSP", "Mã HD", "Số lượng", "Thành tiền", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (ChiTietHD_DTO m : dsCTHD) {
            Object[] o = {m.getMaCTSP(), m.getMaHD(), m.getSoLuong(), m.getThanhTien(), m.getTrangThai()};
            model.addRow(o);
        }
        table_CTHD.setModel(model);
    }

    private void loadDataLenTableChiTietHoaDon_TheoMa(String maHD) {
        cthdBUS.docDanhSachChiTietHoaDon_TheoMa(maHD);
        ArrayList<ChiTietHD_DTO> dscthd = cthdBUS.LayChiTietHoaDon_TheoMa(maHD);
        loadDataLenTableChiTietHoaDOn(dscthd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_MaCTSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_MaDH_CTHD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_ThanhTien = new javax.swing.JTextField();
        themCTHD_But = new javax.swing.JButton();
        SuaCTHD_But = new javax.swing.JButton();
        xoaCTHD_But = new javax.swing.JButton();
        LuuCTHD_But = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_MaHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TongTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        themHD_But = new javax.swing.JButton();
        Sua_But = new javax.swing.JButton();
        xoaHD_But = new javax.swing.JButton();
        LuuHD_But = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_CTHD = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HD = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1350, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết hoá đơn"));

        txt_MaCTSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaCTSP.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã CTSP");

        txt_MaDH_CTHD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaDH_CTHD.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã HĐ");

        txt_SoLuong.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_SoLuong.setPreferredSize(new java.awt.Dimension(64, 26));
        txt_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoLuongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Số lượng");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Thành tiền");

        txt_ThanhTien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_ThanhTien.setPreferredSize(new java.awt.Dimension(64, 26));

        themCTHD_But.setText("Thêm ");
        themCTHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        themCTHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themCTHD_ButActionPerformed(evt);
            }
        });

        SuaCTHD_But.setText("Sửa");
        SuaCTHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        SuaCTHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaCTHD_ButActionPerformed(evt);
            }
        });

        xoaCTHD_But.setText("Xoá");
        xoaCTHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        xoaCTHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaCTHD_ButActionPerformed(evt);
            }
        });

        LuuCTHD_But.setText("Lưu");
        LuuCTHD_But.setEnabled(false);
        LuuCTHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        LuuCTHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuuCTHD_ButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_MaCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_MaDH_CTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(themCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SuaCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LuuCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoaCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_MaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_MaDH_CTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LuuCTHD_But, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(xoaCTHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hoá đơn"));

        txt_MaHD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaHD.setEnabled(false);
        txt_MaHD.setPreferredSize(new java.awt.Dimension(64, 26));
        txt_MaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaHDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã HD");

        txt_MaKH.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaKH.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã KH");

        txt_MaNV.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaNV.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã NV");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày lập");

        txt_TongTien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_TongTien.setEnabled(false);
        txt_TongTien.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền");

        date.setDateFormatString("yyyy-mm-dd");
        date.setMinSelectableDate(new java.util.Date(-62135791103000L));

        themHD_But.setText("Thêm ");
        themHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        themHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themHD_ButActionPerformed(evt);
            }
        });

        Sua_But.setText("Sửa");
        Sua_But.setPreferredSize(new java.awt.Dimension(150, 50));
        Sua_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sua_ButActionPerformed(evt);
            }
        });

        xoaHD_But.setText("Xoá");
        xoaHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        xoaHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaHD_ButActionPerformed(evt);
            }
        });

        LuuHD_But.setText("Lưu");
        LuuHD_But.setEnabled(false);
        LuuHD_But.setPreferredSize(new java.awt.Dimension(150, 50));
        LuuHD_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuuHD_ButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_MaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txt_MaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_MaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(themHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sua_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(xoaHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LuuHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoaHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LuuHD_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("DANH SÁCH HOÁ ĐƠN");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hoá đơn"));

        table_CTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CTSP", "Mã HD", "Số lượng", "Thành tiền", "Trạng thái"
            }
        ));
        table_CTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_CTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_CTHD);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá đơn"));

        table_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã KH", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ));
        table_HD.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_HD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_HD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(636, 636, 636)
                    .addComponent(jLabel3)
                    .addContainerGap(502, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addContainerGap(623, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setEnabled_HoaDon() {
        txt_MaKH.setEnabled(true);
        txt_MaNV.setEnabled(true);
        date.setEnabled(true);
        
    }

    private void setEnabled_CTHoaDon() {
        txt_MaCTSP.setEnabled(true);
        txt_MaDH_CTHD.setEnabled(true);
        txt_SoLuong.setEnabled(true);
        txt_ThanhTien.setEnabled(true);
    }
    
    private void unsetEnabled_HoaDon() {
        txt_MaCTSP.setEnabled(false);
        txt_MaDH_CTHD.setEnabled(false);
        txt_SoLuong.setEnabled(false);
        txt_ThanhTien.setEnabled(false);
    }

    private void setEnabled_ChiTietHoaDon() {
        txt_MaDH_CTHD.setEnabled(true);
        txt_MaCTSP.setEnabled(true);
        txt_SoLuong.setEnabled(true);
        txt_ThanhTien.setEnabled(true);
    }

    private void unsetEnabled_ChiTietHoaDon() {
        txt_MaDH_CTHD.setEnabled(false);
        txt_MaCTSP.setEnabled(false);
        txt_SoLuong.setEnabled(false);
        txt_ThanhTien.setEnabled(false);
    }

    private void themHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themHD_ButActionPerformed
        setEnabled_HoaDon();
        Sua_But.setEnabled(false);
        xoaHD_But.setEnabled(false);
        LuuHD_But.setEnabled(true);
        txt_TongTien.setText("0");
        try {
            txt_MaHD.setText(hdBus.phatSinhMa());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_themHD_ButActionPerformed

    private void Sua_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sua_ButActionPerformed

        setEnabled_HoaDon();
        themHD_But.setEnabled(false);
        xoaHD_But.setEnabled(false);
        LuuHD_But.setEnabled(true);
    }//GEN-LAST:event_Sua_ButActionPerformed

    private void xoaHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaHD_ButActionPerformed

    }//GEN-LAST:event_xoaHD_ButActionPerformed

    private void LuuHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuuHD_ButActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String date2 = null;
        Date date1 = date.getDate();

        if (themHD_But.isEnabled()) {
            if (hdBus.themHoaDon(txt_MaHD.getText(), txt_MaKH.getText(), txt_MaNV.getText(), sdf.format(date1), txt_TongTien.getText())) {
                loadDataLenTableHoaDOn();
            }
        }
        else if(Sua_But.isEnabled())
        {
            if(hdBus.suaHoaDon(txt_MaHD.getText(), txt_MaKH.getText(), txt_MaNV.getText(), sdf.format(date1)));
        }
    }//GEN-LAST:event_LuuHD_ButActionPerformed

    private void table_HDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HDMouseClicked
        // TODO add your handling code here:
        int row = table_HD.rowAtPoint(evt.getPoint());
        txt_MaHD.setText(table_HD.getValueAt(row, 0) + "");
        txt_MaKH.setText(table_HD.getValueAt(row, 1) + "");
        txt_MaNV.setText(table_HD.getValueAt(row, 2) + "");
        String ngay = table_HD.getValueAt(row, 3) + "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date1 = sdf.parse(ngay);
            date.setDate(date1);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
        }

        txt_TongTien.setText(table_HD.getValueAt(row, 4) + "");
        loadDataLenTableChiTietHoaDon_TheoMa(txt_MaHD.getText());
    }//GEN-LAST:event_table_HDMouseClicked

    private void themCTHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themCTHD_ButActionPerformed
        // TODO add your handling code here:
        setEnabled_ChiTietHoaDon();
        SuaCTHD_But.setEnabled(false);
        xoaCTHD_But.setEnabled(false);
        LuuCTHD_But.setEnabled(true);

    }//GEN-LAST:event_themCTHD_ButActionPerformed

    private void SuaCTHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaCTHD_ButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaCTHD_ButActionPerformed

    private void xoaCTHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaCTHD_ButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xoaCTHD_ButActionPerformed

    private void LuuCTHD_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuuCTHD_ButActionPerformed
        // TODO add your handling code here:

        if (themCTHD_But.isEnabled()) {
            if (cthdBUS.themCTHoaDon(txt_MaCTSP.getText(),txt_MaHD.getText(), txt_SoLuong.getText(),txt_ThanhTien.getText())) {
                loadDataLenTableChiTietHoaDOn();
            }
        }
        else if(Sua_But.isEnabled())
        {
//            if(hdBus.suaHoaDon(txt_MaHD.getText(), txt_MaKH.getText(), txt_MaNV.getText(), sdf.format(date1)));
        }
    }//GEN-LAST:event_LuuCTHD_ButActionPerformed

    private void txt_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoLuongActionPerformed

    private void table_CTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_CTHDMouseClicked
        // TODO add your handling code here:
        int row = table_CTHD.rowAtPoint(evt.getPoint());
        txt_MaCTSP.setText(table_CTHD.getValueAt(row, 0) + "");
        txt_MaDH_CTHD.setText(table_CTHD.getValueAt(row, 1) + "");
        txt_SoLuong.setText(table_CTHD.getValueAt(row, 2) + "");
        txt_ThanhTien.setText(table_HD.getValueAt(row, 4) + "");
    }//GEN-LAST:event_table_CTHDMouseClicked

    private void txt_MaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LuuCTHD_But;
    private javax.swing.JButton LuuHD_But;
    private javax.swing.JButton SuaCTHD_But;
    private javax.swing.JButton Sua_But;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_CTHD;
    private javax.swing.JTable table_HD;
    private javax.swing.JButton themCTHD_But;
    private javax.swing.JButton themHD_But;
    private javax.swing.JTextField txt_MaCTSP;
    private javax.swing.JTextField txt_MaDH_CTHD;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_ThanhTien;
    private javax.swing.JTextField txt_TongTien;
    private javax.swing.JButton xoaCTHD_But;
    private javax.swing.JButton xoaHD_But;
    // End of variables declaration//GEN-END:variables

}
