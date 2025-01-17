/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.KhachHang_DAO;
import DTO.KhachHang_DTO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DoHuy
 */
public class KhachHang_GUI extends javax.swing.JFrame {

    /**
     * Creates new form KhachHang
     */
    DAO.KhachHang_DAO da;
    ArrayList<DTO.KhachHang_DTO> dskh;
    int vitri = 0;

    public KhachHang_GUI() {
        initComponents();
        setLocationRelativeTo(null);
        da = new DAO.KhachHang_DAO();
        dskh = da.LayDanhSach();
//        dskh = da.LayDanhSachProc();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienTextBox(false);
        AnHienButton(true);
        txtMaKH.setEnabled(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CbbTrangThai.addItem("1");
        CbbTrangThai.addItem("0");
    }

    private void HienThiTextBox(int vitri) {
        DTO.KhachHang_DTO m = dskh.get(vitri);
        txtMaKH.setText(m.getMaKH());
        txtTenKH.setText(m.getTenKH());
        txtSDT.setText(m.getSdt());
        txtDiaChi.setText(m.getDiaChi());
        txtEmail.setText(m.getEmail());

        // Convert TrangThai to String and set the selected item in the ComboBox
        String trangThaiStr = String.valueOf(m.getTrangThai());
        CbbTrangThai.setSelectedItem(trangThaiStr);
    }
//-------------------------------------------------------------------------------------------------------------------------------------

//    private void HienThiTabale() {
//        String[] hearder = {"Mã KH", "Tên KH", "SDT", "Địa chỉ", "Email"};
//        DefaultTableModel model = new DefaultTableModel(hearder, 0);
//        for (DTO.KhachHang_DTO m : dskh) {
//            Object[] o = {m.getMaKH(), m.getTenKH(), m.getSdt(), m.getDiaChi(), m.getEmail()};
//            model.addRow(o);
//        }
//        tblDanhSach.setModel(model);
//        tblDanhSach.setRowSelectionInterval(vitri, vitri);
//    }
    private void HienThiTabale() {
        String[] header = {"Mã KH", "Tên KH", "SDT", "Địa chỉ", "Email"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (DTO.KhachHang_DTO m : dskh) {
            Object[] o = {m.getMaKH(), m.getTenKH(), m.getSdt(), m.getDiaChi(), m.getEmail()};
            model.addRow(o);
        }
        tblDanhSach.setModel(model);

        try {
            // Kiểm tra xem `vitri` có nằm trong phạm vi hợp lệ không
            if (vitri >= 0 && vitri < tblDanhSach.getRowCount()) {
                tblDanhSach.setRowSelectionInterval(vitri, vitri);
            } else {
                throw new IllegalArgumentException("Chỉ số hàng không hợp lệ: " + vitri);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CbbTrangThai = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        btnDong = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnXoaMat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTimKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnTroVe = new javax.swing.JButton();
        btnKhoiPhuc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHÁCH HÀNG");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÁCH HÀNG", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên khách hàng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Email:          ");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("* Mã khách hàng sẽ tự cập nhật");

        CbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtDiaChi)
                            .addComponent(txtEmail)
                            .addComponent(txtMaKH)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSDT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnDong.setBackground(new java.awt.Color(102, 255, 204));
        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(102, 255, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(102, 255, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(102, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(102, 255, 204));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLuu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(102, 255, 204));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnXoaMat.setBackground(new java.awt.Color(102, 255, 204));
        btnXoaMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaMat.setText("Xóa mất");
        btnXoaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaMat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDong))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaMat))
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKHActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TÌM KIẾM KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKH, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTroVe.setBackground(new java.awt.Color(102, 255, 204));
        btnTroVe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTroVe.setText("Trở về");
        btnTroVe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTroVe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        btnKhoiPhuc.setBackground(new java.awt.Color(102, 255, 204));
        btnKhoiPhuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhoiPhuc.setText("Khôi phục");
        btnKhoiPhuc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKhoiPhuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnTroVe)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhoiPhuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
//            System.exit(0);
            this.dispose();
        }
    }//GEN-LAST:event_btnDongActionPerformed

    int flag = 0;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        AnHienTextBox(true);
        AnHienButton(false);
        txtMaKH.requestFocus();
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMaKH.setText("");
        txtSDT.setText("");
        txtTenKH.setText("");
        txtTimKH.setText("");
        flag = 1;

        try {
            txtMaKH.setText(da.phatSinhMa());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed

    }//GEN-LAST:event_txtSDTActionPerformed
//
    private void txtSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyTyped
        char c = evt.getKeyChar();

        // Kiểm tra xem ký tự được nhập có phải là số không
        if (!Character.isDigit(c)) {
            evt.consume(); // Nếu không phải số, tiêu thụ sự kiện (không cho phép nhập ký tự)
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy nội dung hiện tại của JTextField
        String currentText = txtSDT.getText();

//        // Nếu số 0 đã được nhập vào và độ dài vượt quá 10 ký tự
//        if (currentText.startsWith("0") && currentText.length() >= 10) {
//            evt.consume(); // Tiêu thụ sự kiện (không cho phép nhập thêm ký tự)
//            JOptionPane.showMessageDialog(null, "Số lượng số đã đạt tối đa (10 số) và bắt đầu bằng số 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        // Nếu độ dài vượt quá 10 ký tự
//        if (currentText.length() >= 10) {
//            evt.consume(); // Tiêu thụ sự kiện (không cho phép nhập thêm ký tự)
//            JOptionPane.showMessageDialog(null, "Số lượng số đã đạt tối đa (10 số).", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
// Kiểm tra nếu chuỗi hiện tại rỗng hoặc độ dài vượt quá 10 ký tự
        if (currentText.length() == 0 && evt.getKeyChar() != '0') {
            evt.consume(); // Tiêu thụ sự kiện (không cho phép nhập thêm ký tự)
            JOptionPane.showMessageDialog(null, "Chuỗi phải bắt đầu bằng số 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Nếu độ dài chuỗi đã đạt 10 ký tự
        if (currentText.length() >= 10) {
            evt.consume(); // Tiêu thụ sự kiện (không cho phép nhập thêm ký tự)
            JOptionPane.showMessageDialog(null, "Số lượng số đã đạt tối đa (10 số).", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_txtSDTKeyTyped

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
        vitri = tblDanhSach.getSelectedRow();
        HienThiTextBox(vitri);
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void txtTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKHActionPerformed
        if (txtTimKH.getText() != null) {
            dskh = da.TimKiemTheoMau(txtTimKH.getText());
            HienThiTabale();
            vitri = 0;
            HienThiTextBox(vitri);
        }
    }//GEN-LAST:event_txtTimKHActionPerformed
    private DTO.KhachHang_DTO chuyenDoi() {
        DTO.KhachHang_DTO m = new DTO.KhachHang_DTO();
        m.MaKH = txtMaKH.getText();
        m.TenKH = txtTenKH.getText();
        m.Sdt = txtSDT.getText();
        m.Email = txtEmail.getText();
        m.DiaChi = txtDiaChi.getText();

        return m;
    }

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        txtMaKH.setEnabled(false);
        String tenKH1 = txtTenKH.getText().trim();
        if (tenKH1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }
        String diachiKH1 = txtDiaChi.getText().trim();
        if (diachiKH1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ khách hàng là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        String masdt = txtSDT.getText().trim();
        if (masdt.length() != 10) {
            JOptionPane.showMessageDialog(null, "Số điển thoại phải nhập đủ 10 ký tự");
            return;
        }

        String sdtKH1 = txtSDT.getText().trim();
        if (sdtKH1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        String EmailKH1 = txtEmail.getText().trim();
        if (EmailKH1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        String email1 = txtEmail.getText().trim(); // Lấy nội dung của trường email và loại bỏ các khoảng trắng
        // Kiểm tra xem email có rỗng không
        if (email1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ email.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Dừng thực hiện phương thức nếu email trống
        }

        // Biểu thức chính quy kiểm tra định dạng email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail\\.com)$";

        // Kiểm tra xem email có khớp với định dạng email Gmail không
        if (!email1.matches(emailRegex)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ email Gmail hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Dừng thực hiện phương thức nếu email không hợp lệ
        }

        DTO.KhachHang_DTO m = chuyenDoi();
        if (flag == 1) {
//            da.ThemKhachHang(m);
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm Khách hàng?", "Thêm khách hàng", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    da.ThemKhachHang(m);
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == 2) {

            if (CbbTrangThai.getSelectedItem().toString().equals("0")) {
                JOptionPane.showMessageDialog(null, "Bạn vừa khôi phục");
            }
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn thay đổi thông tin khách hàng?", "Thay đổi thông tin khách hàng", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                String selectedTrangThai = CbbTrangThai.getSelectedItem().toString();
                da.SuaKhachHang(m, selectedTrangThai);
            }
        }
        if (flag == 3) {
//            da.XoaKhachHang(m);
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng?", "Xóa khách hàng", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                da.XoaKhachHang(m);
            }
        }
        if (flag == 4) {
//            da.XoaKhachHang(m);
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng khỏi cơ sở dữ liệu không?", "Xóa khách hàng", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                da.XoaKhachHangMat(m);
            }
        }

        vitri = 0;
        da = new DAO.KhachHang_DAO(); // You may not need to create a new instance here if it's already instantiated earlier
        dskh = da.LayDanhSach();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienButton(true);
        AnHienTextBox(false);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        AnHienTextBox(false);
        AnHienButton(false);
        flag = 3;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        AnHienTextBox(true);
        AnHienButton(false);
        CbbTrangThai.setEnabled(true);
        flag = 2;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose(); // Đóng cửa sổ hiện tại

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang_GUI().setVisible(true); // Tạo và hiển thị cửa sổ mới
            }
        });
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed

    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        // TODO add your handling code here:
        MainGUI mgui = new MainGUI();
        mgui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnXoaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMatActionPerformed
        AnHienTextBox(false);
        AnHienButton(false);
        flag = 4;
    }//GEN-LAST:event_btnXoaMatActionPerformed

    private void CbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbTrangThaiActionPerformed
        CbbTrangThai.setEnabled(false);
    }//GEN-LAST:event_CbbTrangThaiActionPerformed

    private void btnKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
//---------------------------------------
        dskh = da.KhoiPhucLayDanhSachProc();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienTextBox(false);
//        AnHienButton(true);
        txtMaKH.setEnabled(false);
        CbbTrangThai.setEnabled(true);
        btnSua.setEnabled(true);
    }//GEN-LAST:event_btnKhoiPhucActionPerformed

    private void AnHienTextBox(boolean t) {
//        txtMaKH.setEnabled(!t);
        txtTenKH.setEnabled(t);
        txtEmail.setEnabled(t);
        txtDiaChi.setEnabled(t);
        txtSDT.setEnabled(t);
    }

    private void AnHienButton(boolean t) {
        btnLuu.setEnabled(!t);
        btnSua.setEnabled(t);
        btnXoa.setEnabled(t);
        btnThem.setEnabled(t);
        btnKhoiPhuc.setEnabled(t);
        btnXoaMat.setEnabled(t);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbTrangThai;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKH;
    // End of variables declaration//GEN-END:variables
}
