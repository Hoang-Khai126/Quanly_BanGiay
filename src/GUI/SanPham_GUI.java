package GUI;

import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import DAO.ConnectionDataBase;
import GUI.ThemSP_GUI;
import BUS.ChiTietSP_BUS;
import DTO.ChiTietSP_DTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
import javax.swing.ButtonGroup;
/**
 *
 * @author ADMIN
 */
public class SanPham_GUI extends javax.swing.JFrame {

    private String linkAnh="";
    private ButtonGroup group_TrangThai = new ButtonGroup();
    private ChiTietSP_BUS chiTietSPBus = new ChiTietSP_BUS();      
    private SanPham_BUS sanPhamBus = new SanPham_BUS();
    
    public SanPham_GUI() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadDataLenTableSanPham();
        table_SanPham.setDefaultEditor(Object.class, null);
        
        group_TrangThai.add(rdBut_Hoatdong);
        group_TrangThai.add(rdBut_KoHD);
        
        loadDataLenTableCTSanPham(txt_MaSP.getText());

    }

    private void loadDataLenTableCTSanPham(String maSP) {
        chiTietSPBus.docDanhSach_TheoMa(maSP);
        ArrayList<ChiTietSP_DTO> dsctsp = chiTietSPBus.LayDanhSachCTSP_TheoMa(maSP);
        loadDataLenTableCTSanPham(dsctsp);
    }

    private void loadDataLenTableCTSanPham(ArrayList<ChiTietSP_DTO> dsCTSP) {
        String[] hearder = {"Mã SP", "Mã màu", "Mã size", "Số lượng", "Mã CTSP","Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (ChiTietSP_DTO m : dsCTSP) {
            Object[] o = {m.getMaSP(), m.getMaMau(), m.getMaSize(), m.getSoLuong(),m.getMaCTSP(),m.getTrangThai()};
            model.addRow(o);
        }
        table_ctsp.setModel(model);
    }

    private void loadDataLenTableSanPham() {
        sanPhamBus.docDanhSachSanPham();
        ArrayList<SanPham_DTO> dssp = sanPhamBus.getListSanPham();
        loadDataLenTableSanPham(dssp);
    }

    private void loadDataLenTableSanPham(ArrayList<SanPham_DTO> dssp) {
        String[] hearder = {"Mã SP", "Tên SP", "Số lượng", "Giá nhập", "Giá bán", "Hình ảnh", "Mã loại", "Mã NCC", "Mô tả", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (SanPham_DTO m : dssp) {
            Object[] o = {m.getMaSP(), m.getTenSP(), m.getSoLuong(), m.getGiaNhap(), m.getGiaBan(), m.getHinhSP(),m.getMaLoai(),m.getMaNCC(),m.getMoTa(),m.getTrangThai()};
            model.addRow(o);
        }
        table_SanPham.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_SanPham = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        but_tcCTSP = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        but_ThemSP = new javax.swing.JButton();
        but_SuaSP = new javax.swing.JButton();
        but_LuuSP = new javax.swing.JButton();
        but_TroVeSP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_MaSP = new javax.swing.JTextField();
        txt_TenSP = new javax.swing.JTextField();
        txt_LoaiSP = new javax.swing.JTextField();
        txt_slSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_donGiaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_donGiaNhap = new javax.swing.JTextField();
        txt_NhaCCSP = new javax.swing.JTextField();
        label_Anh = new javax.swing.JLabel();
        but_chonAnh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Mota = new javax.swing.JTextPane();
        jLabel17 = new javax.swing.JLabel();
        rdBut_Hoatdong = new javax.swing.JRadioButton();
        rdBut_KoHD = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        but_tkSP1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_ctsp = new javax.swing.JTable();
        txt_TimKiem = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 650));

        panel_SanPham.setBackground(new java.awt.Color(255, 255, 255));
        panel_SanPham.setForeground(new java.awt.Color(255, 204, 153));
        panel_SanPham.setPreferredSize(new java.awt.Dimension(1350, 650));
        panel_SanPham.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        panel_SanPham.add(jLabel1);
        jLabel1.setBounds(630, 0, 200, 27);

        but_tcCTSP.setText("Tuỳ chỉnh CTSP");
        but_tcCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_tcCTSPActionPerformed(evt);
            }
        });
        panel_SanPham.add(but_tcCTSP);
        but_tcCTSP.setBounds(1190, 350, 130, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        but_ThemSP.setText("Thêm");
        but_ThemSP.setPreferredSize(new java.awt.Dimension(100, 50));
        but_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ThemSPActionPerformed(evt);
            }
        });
        jPanel1.add(but_ThemSP);

        but_SuaSP.setText("Sửa");
        but_SuaSP.setPreferredSize(new java.awt.Dimension(100, 50));
        but_SuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SuaSPActionPerformed(evt);
            }
        });
        jPanel1.add(but_SuaSP);

        but_LuuSP.setText("Lưu");
        but_LuuSP.setEnabled(false);
        but_LuuSP.setPreferredSize(new java.awt.Dimension(100, 50));
        but_LuuSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_LuuSPActionPerformed(evt);
            }
        });
        jPanel1.add(but_LuuSP);

        but_TroVeSP.setText("Trờ vê");
        but_TroVeSP.setPreferredSize(new java.awt.Dimension(100, 50));
        but_TroVeSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_TroVeSPActionPerformed(evt);
            }
        });
        jPanel1.add(but_TroVeSP);

        panel_SanPham.add(jPanel1);
        jPanel1.setBounds(130, 340, 530, 60);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã SP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên SP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số lượng");

        txt_MaSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_MaSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_TenSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_TenSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_LoaiSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_LoaiSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_slSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_slSP.setPreferredSize(new java.awt.Dimension(64, 26));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Giá bán");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nhà cung cấp");

        txt_donGiaBan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_donGiaBan.setPreferredSize(new java.awt.Dimension(60, 26));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giá nhập");

        txt_donGiaNhap.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_donGiaNhap.setPreferredSize(new java.awt.Dimension(60, 26));

        txt_NhaCCSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_NhaCCSP.setPreferredSize(new java.awt.Dimension(64, 26));

        label_Anh.setBackground(new java.awt.Color(0, 0, 0));
        label_Anh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_Anh.setForeground(new java.awt.Color(255, 255, 255));
        label_Anh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Anh.setToolTipText("");
        label_Anh.setOpaque(true);
        label_Anh.setPreferredSize(new java.awt.Dimension(150, 150));

        but_chonAnh.setText("Chọn ảnh");
        but_chonAnh.setEnabled(false);
        but_chonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_chonAnhActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Mô tả");

        jScrollPane1.setViewportView(txt_Mota);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Trạng thái");

        rdBut_Hoatdong.setText("Hoạt động");

        rdBut_KoHD.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_NhaCCSP, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_chonAnh)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdBut_Hoatdong)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdBut_KoHD)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_slSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_donGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_donGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_chonAnh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txt_slSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_donGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txt_donGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NhaCCSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(rdBut_Hoatdong)
                            .addComponent(rdBut_KoHD))
                        .addGap(18, 18, 18))))
        );

        panel_SanPham.add(jPanel2);
        jPanel2.setBounds(120, 30, 570, 310);

        jScrollPane2.setAutoscrolls(true);

        table_SanPham.setBackground(new java.awt.Color(204, 204, 204));
        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng ", "Giá nhập", "Giá bán", "Hình ảnh", "Mã loại", "Mã NCC", "Mô tả", "Trạng thái"
            }
        ));
        table_SanPham.setShowHorizontalLines(true);
        table_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_SanPham);

        panel_SanPham.add(jScrollPane2);
        jScrollPane2.setBounds(0, 400, 1350, 250);

        but_tkSP1.setText("Tìm kiếm");
        panel_SanPham.add(but_tkSP1);
        but_tkSP1.setBounds(760, 350, 77, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setAutoscrolls(true);

        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setColumnHeaderView(null);

        table_ctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã màu", "Mã size", "Số lượng", "Mã CTSP", "Trạng thái"
            }
        ));
        jScrollPane3.setViewportView(table_ctsp);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        panel_SanPham.add(jPanel3);
        jPanel3.setBounds(760, 30, 560, 310);

        txt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimKiemActionPerformed(evt);
            }
        });
        panel_SanPham.add(txt_TimKiem);
        txt_TimKiem.setBounds(850, 350, 280, 40);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ThemSPActionPerformed
        // TODO add your handling code here:
        ThemSP_GUI guiThemSP = new ThemSP_GUI();
        
        guiThemSP.showThemSP_GUI();
        
    }//GEN-LAST:event_but_ThemSPActionPerformed

    private void table_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamMouseClicked
        // TODO add your handling code here:
        label_Anh.setIcon(null);
        int row = table_SanPham.rowAtPoint(evt.getPoint());
        txt_MaSP.setText(table_SanPham.getValueAt(row, 0) + "");
        txt_TenSP.setText(table_SanPham.getValueAt(row, 1) + "");
        txt_slSP.setText(table_SanPham.getValueAt(row, 2) + "");
        txt_donGiaNhap.setText(table_SanPham.getValueAt(row, 3) + "");
        txt_donGiaBan.setText(table_SanPham.getValueAt(row, 4) + "");
        linkAnh=table_SanPham.getValueAt(row, 5) + "";
        txt_LoaiSP.setText(table_SanPham.getValueAt(row, 6) + "");
        txt_NhaCCSP.setText(table_SanPham.getValueAt(row, 7) + "");
        txt_Mota.setText(table_SanPham.getValueAt(row, 8) + "");
        File file=new File(linkAnh);
        if(file.exists())
        {
            ImageIcon anhSP = new ImageIcon(linkAnh);
            Image image = anhSP.getImage(); // Chuyển đổi về đối tượng Image
            Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
            anhSP = new ImageIcon(scaledImage); // Chuyển đổi về ImageIcon
            label_Anh.setIcon(anhSP);
        }
        else
        {
            label_Anh.setText("NO");
        }
        
        if((table_SanPham.getValueAt(row,9)+"").equals("0"))
            rdBut_Hoatdong.setSelected(true);
        else
            rdBut_KoHD.setSelected(true);
        
        loadDataLenTableCTSanPham(txt_MaSP.getText());
    }//GEN-LAST:event_table_SanPhamMouseClicked

    private void but_SuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SuaSPActionPerformed
        // TODO add your handling code here:
        this.but_LuuSP.setEnabled(true);
        this.but_chonAnh.setEnabled(true);
    }//GEN-LAST:event_but_SuaSPActionPerformed

    private void but_LuuSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_LuuSPActionPerformed
        // TODO add your handling code here:
        String trangThai="";
        if(rdBut_Hoatdong.isSelected())
            trangThai="0";
        else
            trangThai="1";
        BUS.SanPham_BUS spBus=new SanPham_BUS();
        spBus.suaSanPham(txt_MaSP.getText(), txt_TenSP.getText(), txt_slSP.getText(), txt_donGiaNhap.getText(),txt_donGiaBan.getText(), linkAnh, txt_LoaiSP.getText(), txt_NhaCCSP.getText(), txt_Mota.getText(), trangThai);
        loadDataLenTableSanPham();
    }//GEN-LAST:event_but_LuuSPActionPerformed

    private void but_chonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_chonAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        File newfile=new File("src\\image\\icon");
        fileChooser.setCurrentDirectory(newfile);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            linkAnh=selectedFile.getAbsolutePath();

            // Hiển thị hình ảnh trong JLabel
            ImageIcon anhSP = new ImageIcon(linkAnh);
            Image image = anhSP.getImage(); // Chuyển đổi về đối tượng Image
            Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
            anhSP = new ImageIcon(scaledImage); // Chuyển đổi về ImageIcon
            label_Anh.setIcon(anhSP);
        }
    }//GEN-LAST:event_but_chonAnhActionPerformed

    private void but_TroVeSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_TroVeSPActionPerformed
        // TODO add your handling code here:
        MainGUI mgui=new MainGUI();
        mgui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_TroVeSPActionPerformed

    private void txt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimKiemActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void but_tcCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_tcCTSPActionPerformed
        // TODO add your handling code here:
        ChiTietSanPham_GUI guiCTSP = new ChiTietSanPham_GUI();
        guiCTSP.setVisible(true);
    }//GEN-LAST:event_but_tcCTSPActionPerformed
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_LuuSP;
    private javax.swing.JButton but_SuaSP;
    private javax.swing.JButton but_ThemSP;
    private javax.swing.JButton but_TroVeSP;
    private javax.swing.JButton but_chonAnh;
    private javax.swing.JButton but_tcCTSP;
    private javax.swing.JButton but_tkSP1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_Anh;
    private javax.swing.JPanel panel_SanPham;
    private javax.swing.JRadioButton rdBut_Hoatdong;
    private javax.swing.JRadioButton rdBut_KoHD;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JTable table_ctsp;
    private javax.swing.JTextField txt_LoaiSP;
    private javax.swing.JTextField txt_MaSP;
    private javax.swing.JTextPane txt_Mota;
    private javax.swing.JTextField txt_NhaCCSP;
    private javax.swing.JTextField txt_TenSP;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_donGiaBan;
    private javax.swing.JTextField txt_donGiaNhap;
    private javax.swing.JTextField txt_slSP;
    // End of variables declaration//GEN-END:variables
}
