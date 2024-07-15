package GUI;

import DAO.NhanVien_DAO;
import DTO.NhanVien_DTO;
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
public class NhanVien_GUI extends javax.swing.JFrame {

    /**
     * Creates new form KhachHang
     */
    DAO.NhanVien_DAO da;
    ArrayList<DTO.NhanVien_DTO> dsnv;
    int vitri = 0;

    public NhanVien_GUI() {
        initComponents();
        setLocationRelativeTo(null);
        da = new DAO.NhanVien_DAO();
        dsnv = da.LayDanhSachNV();
//        dsnv = da.LayDanhSachProc();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienTextBox(false);
        AnHienButton(true);
        txtMaNV.setEnabled(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cbbTrangThai.addItem("1");
        cbbTrangThai.addItem("0");

    }

    private void HienThiTextBox(int vitri) {

        // Kiểm tra xem danh sách có phần tử không trước khi truy cập vào
        if (!dsnv.isEmpty() && vitri >= 0 && vitri < dsnv.size()) {
            DTO.NhanVien_DTO m = dsnv.get(vitri);
            txtMaNV.setText(m.getMaNV());
            txtTenNV.setText(m.getTenNV());
            txtSDT.setText(m.getSDT());
            txtLuong.setText(Float.toString(m.getLuong()));
            // Convert TrangThai to String and set the selected item in the ComboBox
            String trangThaiStr = String.valueOf(m.getTrangThai());
            cbbTrangThai.setSelectedItem(trangThaiStr);
            String gioiTinh = m.getGioiTinh();
            if (gioiTinh != null && gioiTinh.equals("Nam")) {
                rdoNam.setSelected(true);
                rdoNu.setSelected(false);
            } else {
                rdoNam.setSelected(false);
                rdoNu.setSelected(true);
            }

            txtDiaChi.setText(m.getDiaChi());
            txtEmail.setText(m.getEmail());
        } else {
            // Xử lý trường hợp danh sách rỗng hoặc chỉ mục không hợp lệ ở đây
            // Ví dụ:
            System.out.println("Danh sách nhân viên rỗng hoặc chỉ mục không hợp lệ.");
        }

    }

    private void HienThiTabale() {
        String[] hearder = {"Mã Nhân viên", "Tên NV", "Giới tính", "SDT", "Địa chỉ", "Email", "Lương"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (DTO.NhanVien_DTO m : dsnv) {
            Object[] o = {m.getMaNV(), m.getTenNV(), m.getGioiTinh(), m.getSDT(), m.getDiaChi(), m.getEmail(), m.getLuong()};
            model.addRow(o);
        }
        tblDanhSachNV.setModel(model);
        tblDanhSachNV.setRowSelectionInterval(vitri, vitri);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        btnDong = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimNV = new javax.swing.JTextField();
        btnXoaMat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNV = new javax.swing.JTable();
        btnTroVe = new javax.swing.JButton();
        btnKhoiPhuc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHÂN VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NHÂN VIÊN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên nhân viên:");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

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
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giới tính");

        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("* Mã nhân viên sẽ được tự cập nhật");

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });
        txtLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLuongKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Lương");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                .addComponent(txtMaNV)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtSDT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(18, 32, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(18, 32, Short.MAX_VALUE)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLuu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 153, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TÌM KIẾM ");

        txtTimNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnXoaMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaMat.setText("Xoá mất");
        btnXoaMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoaMat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addGap(23, 23, 23)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaMat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDong)
                    .addComponent(btnXoaMat))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH NHÂN VIÊN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblDanhSachNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachNV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTroVe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTroVe.setText("Trở về");
        btnTroVe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTroVe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnTroVe)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhoiPhuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnDongActionPerformed

    int flag = 0;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtTenNV.requestFocus();
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMaNV.setText("");
        txtSDT.setText("");
        txtTenNV.setText("");
        txtTimNV.setText("");
        txtMaNV.setEnabled(false);
        try {
            txtMaNV.setText(da.phatSinhMa());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Xóa lựa chọn của radio button
        rdoNam.setSelected(false);
        rdoNu.setSelected(false);

        flag = 1;
        AnHienTextBox(true);
        AnHienButton(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblDanhSachNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNVMouseClicked
        // TODO add your handling code here:
        vitri = tblDanhSachNV.getSelectedRow();
        HienThiTextBox(vitri);
    }//GEN-LAST:event_tblDanhSachNVMouseClicked

    private void txtTimNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimNVActionPerformed
        if (txtTimNV.getText() != null) {
            dsnv = da.TimKiemNV(txtTimNV.getText());
            HienThiTabale();
            vitri = 0;
            HienThiTextBox(vitri);
        }
    }//GEN-LAST:event_txtTimNVActionPerformed
    private DTO.NhanVien_DTO chuyenDoi() {
        DTO.NhanVien_DTO m = new DTO.NhanVien_DTO();
        m.setMaNV(txtMaNV.getText());
        m.setTenNV(txtTenNV.getText());

// Kiểm tra xem người dùng đã chọn giới tính nào
        if (rdoNam.isSelected()) {
            m.setGioiTinh("Nam");
        } else if (rdoNu.isSelected()) {
            m.setGioiTinh("Nữ");
        }
        m.setSDT(txtSDT.getText());
        m.setEmail(txtEmail.getText());
        m.setDiaChi(txtDiaChi.getText());
        m.setLuong(Float.parseFloat(txtLuong.getText()));
        return m;
    }


    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

//        AnHienTextBox(false);
//        txtMaNV.setEnabled(false);
//
//        String maNV = txtMaNV.getText().trim();
//
//        // Kiểm tra xem chuỗi có bắt đầu bằng 'nv' không
//        if (!maNV.startsWith("nv")) {
//            JOptionPane.showMessageDialog(null, "Mã nhân viên phải bắt đầu bằng 'nv'");
//            return;
//        }
//
//        // Kiểm tra xem chuỗi có đúng 7 ký tự không
//        if (maNV.length() != 7) {
//            JOptionPane.showMessageDialog(null, "Mã nhân viên phải có đúng 7 ký tự");
//            return;
//        }
//
//        // Lấy nội dung từ trường nhập
//        String maNV1 = txtMaNV.getText().trim();
//        // Kiểm tra xem trường nhập có rỗng không
//        if (maNV1.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Mã nhân viên là thông tin bắt buộc, vui lòng nhập thông tin.");
//            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
//        }
// Lấy nội dung từ trường nhập
        String tenNV = txtTenNV.getText().trim();
        // Kiểm tra xem trường nhập có rỗng không
        if (tenNV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        // Lấy nội dung từ trường nhập
        String diachi = txtDiaChi.getText().trim();
        // Kiểm tra xem trường nhập có rỗng không
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        // Lấy nội dung từ trường nhập
        String sdt = txtSDT.getText().trim();

        // Kiểm tra xem trường nhập có rỗng không
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        // Lấy nội dung từ trường nhập
        String email = txtEmail.getText().trim();
        // Kiểm tra xem trường nhập có rỗng không
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }

        // Kiểm tra xem người dùng đã chọn giới tính chưa
        if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính của nhân viên.");
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
        DTO.NhanVien_DTO m = chuyenDoi();

        if (flag == 1) {

//            da.ThemNhanVien(m);
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm nhân viên?", "Thêm nhân viên", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    da.ThemNhanVien(m);
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == 2) {
//            da.SuaNhanVien(m);
            if (cbbTrangThai.getSelectedItem().toString().equals("0")) {
                JOptionPane.showMessageDialog(null, "Bạn vừa khôi phục");
            }
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thay đổi thông tin nhân viên này?", "Thay đổi thông tin", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {

                String selectedTrangThai = cbbTrangThai.getSelectedItem().toString();
                da.SuaNhanVien(m, selectedTrangThai);
//                da.SuaKhachHang(m, selectedTrangThai);
            }
        }
        if (flag == 3) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                da.XoaNhanVien(m);
            }
        }
        if (flag == 4) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này khỏi cơ sở dữ liệu không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                da.XoaNhanVienMat(m);
            }
        }

        vitri = 0;
        da = new DAO.NhanVien_DAO(); // You may not need to create a new instance here if it's already instantiated earlier
        dsnv = da.LayDanhSachNV();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienButton(true);
        AnHienTextBox(true);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void AnHienTextBox(boolean t) {
        txtMaNV.setEnabled(false);
        txtTenNV.setEnabled(t);
        txtEmail.setEnabled(t);
        txtDiaChi.setEnabled(t);
        txtLuong.setEditable(t);
        txtSDT.setEnabled(t);
        rdoNam.setEnabled(t);
        rdoNu.setEnabled(t);

    }

    private void AnHienButton(boolean t) {
        btnLuu.setEnabled(!t);
        btnSua.setEnabled(t);
        btnXoa.setEnabled(t);
        btnThem.setEnabled(t);

        btnXoaMat.setEnabled(t);
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        AnHienTextBox(false);
        AnHienButton(false);
        txtMaNV.setEnabled(false);
        flag = 3;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        AnHienTextBox(true);
        AnHienButton(false);
        txtMaNV.setEnabled(false);
        flag = 2;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        rdoNam.setSelected(false);
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        rdoNu.setSelected(false);
    }//GEN-LAST:event_rdoNamActionPerformed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped

    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

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

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed

    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // Lấy nội dung từ trường nhập
        String tenNV = txtTenNV.getText().trim();
        // Kiểm tra xem trường nhập có rỗng không
        if (tenNV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên là thông tin bắt buộc, vui lòng nhập thông tin.");
            return; // Dừng thực hiện phương thức nếu thông tin không hợp lệ
        }
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed

        String maNV = txtMaNV.getText().trim();

        // Kiểm tra xem chuỗi có bắt đầu bằng 'nv' không
        if (!maNV.startsWith("nv")) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên phải bắt đầu bằng 'nv'");
            return;
        }

        // Kiểm tra xem chuỗi có đúng 7 ký tự không
        if (maNV.length() != 7) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên phải có đúng 7 ký tự");
            return;
        }
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtLuongActionPerformed

    private void txtLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongKeyTyped

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        // TODO add your handling code here:
        MainGUI mgui = new MainGUI();
        mgui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnXoaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMatActionPerformed
        // TODO add your handling code here:
        AnHienTextBox(false);
        AnHienButton(false);
        txtMaNV.setEnabled(false);
        flag = 4;
    }//GEN-LAST:event_btnXoaMatActionPerformed

    private void btnKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        dsnv = da.LayDanhSachProcNVkhoiPhuc();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienTextBox(false);
//        AnHienButton(true);
        txtMaNV.setEnabled(false);
        cbbTrangThai.setEnabled(true);
        btnSua.setEnabled(true);
    }//GEN-LAST:event_btnKhoiPhucActionPerformed
// Phương thức kiểm tra định dạng email

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVien_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaMat;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDanhSachNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimNV;
    // End of variables declaration//GEN-END:variables
}
