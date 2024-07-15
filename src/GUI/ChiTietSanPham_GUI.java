/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ChiTietSP_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DoHuy
 */
public class ChiTietSanPham_GUI extends javax.swing.JFrame {

    ChiTietSP_DAO dao;
    ArrayList<DTO.ChiTietSP_DTO> dsctsp;
    int vitri = 0;
    private JComboBox<String> cbbMaSanPham1; // Khai báo biến cbbMaSanPham
    private JComboBox<String> cbbMaMau1; // Đổi tên của một biến thành cbbMaMau1 hoặc tên khác phù hợp// Khai báo biến cbbMaMau
    private JComboBox<String> cbbMaSize1; // Khai báo biến cbbMaSize
    private JTextField txtSoLuong1; // Khai báo biến txtSoLuong
    private JComboBox<String> cbbTrangthai1; // Khai báo biến cbbTrangthai

    /**
     * Creates new form ChiTietSanPham
     */
    public ChiTietSanPham_GUI() {
        initComponents();
        setLocationRelativeTo(null);
        dao = new ChiTietSP_DAO();
        dsctsp = dao.LayDanhSachCTSP();
        if (!dsctsp.isEmpty()) {
            HienThiTextBox(vitri);
            HienThiTabale();
        } else {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu để hiển thị", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        AnHienTextBox(false);
        AnHienButton(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cbbTrangthai.addItem("1");
        cbbTrangthai.addItem("0");
        loadMaSPToComboBox();
        tblCTSP.setDefaultEditor(Object.class, null);
    }

    private void loadMaSPToComboBox() {
        try {
            ArrayList<DTO.ChiTietSP_DTO> maSPList = dao.LayMaSP();
            cbbMaSanPham.removeAllItems(); // Xóa tất cả các mục hiện tại
            for (DTO.ChiTietSP_DTO chiTietSP : maSPList) {
                // Chuyển đổi đối tượng ChiTietSP_DTO thành chuỗi và thêm vào combobox
                String maSP = chiTietSP.getMaSP(); // Đây là một ví dụ, hãy thay thế phương thức phù hợp
                cbbMaSanPham.addItem(maSP);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadMaMauToComboBox() {
        try {
            ArrayList<DTO.ChiTietSP_DTO> maMauList = dao.LayMaMau();
            cbbMaMau.removeAllItems(); // Xóa tất cả các mục hiện tại
            for (DTO.ChiTietSP_DTO chiTietSP : maMauList) {
                String maMau = chiTietSP.getMaMau();
                cbbMaMau.addItem(maMau);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadMaSizeToComboBox() {
        try {
            ArrayList<DTO.ChiTietSP_DTO> maSizeList = dao.LayMaSize();
            cbbMaSize.removeAllItems(); // Xóa tất cả các mục hiện tại
            for (DTO.ChiTietSP_DTO chiTietSP : maSizeList) {
                String maSize = chiTietSP.getMaSize();
                cbbMaSize.addItem(maSize);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void HienThiTextBox(int vitri) {
//        DTO.ChiTietSP_DTO m = dsctsp.get(vitri);
//        cbbMaSanPham.setSelectedItem(m.getMaSP());
//        cbbMaMau.setSelectedItem(m.getMaMau());
//        cbbMaSize.setSelectedItem(m.getMaSize());
//        txtSoLuong.setText(String.valueOf(m.getSoLuong()));
//        txtMaCTSP.setText(m.getMaCTSP());
//
//        String trangThaiStr = String.valueOf(m.getTrangThai());
//        cbbTrangthai.setSelectedItem(trangThaiStr);
        DTO.ChiTietSP_DTO m = dsctsp.get(vitri);

        // Chọn mã sản phẩm
        String maSP = m.getMaSP();
        for (int i = 0; i < cbbMaSanPham.getItemCount(); i++) {
            if (cbbMaSanPham.getItemAt(i).equals(maSP)) {
                cbbMaSanPham.setSelectedIndex(i);
                break;
            }
        }

        // Chọn mã màu
        String maMau = m.getMaMau();
        for (int i = 0; i < cbbMaMau.getItemCount(); i++) {
            if (cbbMaMau.getItemAt(i).equals(maMau)) {
                cbbMaMau.setSelectedIndex(i);
                break;
            }
        }

        // Chọn mã size
        String maSize = m.getMaSize();
        for (int i = 0; i < cbbMaSize.getItemCount(); i++) {
            if (cbbMaSize.getItemAt(i).equals(maSize)) {
                cbbMaSize.setSelectedIndex(i);
                break;
            }
        }

        // Thiết lập số lượng
        txtSoLuong.setText(String.valueOf(m.getSoLuong()));

        // Thiết lập mã CTSP
        txtMaCTSP.setText(m.getMaCTSP());

        // Thiết lập trạng thái
        String trangThaiStr = String.valueOf(m.getTrangThai());
        cbbTrangthai.setSelectedItem(trangThaiStr);

    }

    private void HienThiTabale() {
        String[] header = {"Mã SP", "Mã Màu", "Mã Size", "Số lượng", "Mã CTSP"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (DTO.ChiTietSP_DTO m : dsctsp) {
            Object[] o = {m.getMaSP(), m.getMaMau(), m.getMaSize(), m.getSoLuong(), m.getMaCTSP()};
            model.addRow(o);
        }
        tblCTSP.setModel(model);

        try {
            if (vitri >= 0 && vitri < tblCTSP.getRowCount()) {
                tblCTSP.setRowSelectionInterval(vitri, vitri);
            } else {
                throw new IllegalArgumentException("Chỉ số hàng không hợp lệ: " + vitri);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AnHienTextBox(boolean t) {
//        txtMaCTSP.setEnabled(!t);
//        cbbMaSanPham.setEnabled(t);
//        cbbMaMau.setEnabled(t);
//        cbbMaSize.setEnabled(t);
//        txtSoLuong.setEnabled(t);
//        cbbTrangthai.setEnabled(t);
    }

    private void AnHienButton(boolean t) {
//        btnLuu.setEnabled(!t);
//        btnSua.setEnabled(t);
//        btnXoa.setEnabled(t);
//        btnThem.setEnabled(t);
//        btnXoaMat.setEnabled(t);
    }
    int flag = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtMaCTSP = new javax.swing.JTextField();
        cbbTrangthai = new javax.swing.JComboBox<>();
        cbbMaSanPham = new javax.swing.JComboBox<>();
        cbbMaMau = new javax.swing.JComboBox<>();
        cbbMaSize = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        btnXoaMat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimfKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã Sản Phẩm");

        jLabel3.setText("Mã màu");

        jLabel4.setText("Mã size");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Mã CTSP");

        jLabel7.setText("Trang thái");

        cbbTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangthaiActionPerformed(evt);
            }
        });

        cbbMaSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaSanPhamActionPerformed(evt);
            }
        });

        cbbMaMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaMauActionPerformed(evt);
            }
        });

        cbbMaSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong)
                    .addComponent(txtMaCTSP)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DS Chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTSP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnXoaMat.setText("Xóa CSDL");
        btnXoaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnXoaMat)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnLuu)
                .addGap(18, 18, 18)
                .addComponent(btnDong)
                .addGap(119, 119, 119))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnDong)
                    .addComponent(btnXoaMat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Tìm kiếm");

        txtTimfKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimfKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimfKiem)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimfKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangthaiActionPerformed

    }//GEN-LAST:event_cbbTrangthaiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed

        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnXoaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMatActionPerformed
        // TODO add your handling code here:
        AnHienTextBox(false);
        AnHienButton(false);
        flag = 4;
    }//GEN-LAST:event_btnXoaMatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        AnHienTextBox(true);
        AnHienButton(false);
//        CbbTrangThai.setEnabled(true);
        flag = 2;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        AnHienTextBox(false);
        AnHienButton(false);
        flag = 3;
    }//GEN-LAST:event_btnXoaActionPerformed
    private DTO.ChiTietSP_DTO chuyenDoi() {
        DTO.ChiTietSP_DTO m = new DTO.ChiTietSP_DTO();
        m.setMaSP((String) cbbMaSanPham.getSelectedItem());
        m.setMaMau((String) cbbMaMau.getSelectedItem());
        m.setMaSize((String) cbbMaSize.getSelectedItem());

        try {
            m.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ. Vui lòng nhập một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            m.setSoLuong(0);
        }

        return m;
    }
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        DTO.ChiTietSP_DTO m = chuyenDoi();
        if (flag == 1) {
//            da.ThemKhachHang(m);
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm chi tiet san pham?", "Thêm chi tiet san pham", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    dao.ThemCTSP(m);
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
           if (flag == 3) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng?", "Xóa khách hàng", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                dao.XoaCTSP(m);
            }
        }
        vitri = 0;
        dao = new DAO.ChiTietSP_DAO(); // You may not need to create a new instance here if it's already instantiated earlier
        dsctsp = dao.LayDanhSachCTSP();
        HienThiTextBox(vitri);
        HienThiTabale();
        AnHienButton(true);
        AnHienTextBox(false);

    }//GEN-LAST:event_btnLuuActionPerformed

    private void cbbMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaSanPhamActionPerformed
//        loadMaSPToComboBox();
        // Lưu trữ mục được chọn hiện tại
        Object selectedItem = cbbMaSanPham.getSelectedItem();

        // Tải lại dữ liệu cho cbbMaSanPham
        loadMaSPToComboBox();

        // Khôi phục mục được chọn nếu có
        if (selectedItem != null) {
            cbbMaSanPham.setSelectedItem(selectedItem);
        }
    }//GEN-LAST:event_cbbMaSanPhamActionPerformed

    private void cbbMaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaMauActionPerformed
        // TODO add your handling code here:
//        loadMaMauToComboBox();
// Lưu trữ mục được chọn hiện tại
        Object selectedItem = cbbMaMau.getSelectedItem();

        // Tải lại dữ liệu cho cbbMaSanPham
        loadMaMauToComboBox();

        // Khôi phục mục được chọn nếu có
        if (selectedItem != null) {
            cbbMaMau.setSelectedItem(selectedItem);
        }
    }//GEN-LAST:event_cbbMaMauActionPerformed

    private void cbbMaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaSizeActionPerformed
        // TODO add your handling code here:
        // Lưu trữ mục được chọn hiện tại
        Object selectedItem = cbbMaSize.getSelectedItem();

        // Tải lại dữ liệu cho cbbMaSanPham
        loadMaSizeToComboBox();

        // Khôi phục mục được chọn nếu có
        if (selectedItem != null) {
            cbbMaSize.setSelectedItem(selectedItem);
        }
    }//GEN-LAST:event_cbbMaSizeActionPerformed

    private void txtTimfKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimfKiemActionPerformed
        if (txtTimfKiem.getText() != null) {
            dsctsp = dao.TimKiemCTSP(txtTimfKiem.getText());
            HienThiTabale();
            vitri = 0;
            HienThiTextBox(vitri);
        }
    }//GEN-LAST:event_txtTimfKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        AnHienTextBox(true);
        AnHienButton(false);
        cbbMaSanPham.requestFocus();
        cbbMaMau.setSelectedItem(null);
        cbbMaSize.setSelectedItem(null);
        txtSoLuong.setText("");

        flag = 1;

//        try {
//            txtMaKH.setText(da.phatSinhMa());
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHangGUI1.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSPMouseClicked
        // TODO add your handling code here:
        vitri = tblCTSP.getSelectedRow();
        HienThiTextBox(vitri);
    }//GEN-LAST:event_tblCTSPMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaMat;
    private javax.swing.JComboBox<String> cbbMaMau;
    private javax.swing.JComboBox<String> cbbMaSanPham;
    private javax.swing.JComboBox<String> cbbMaSize;
    private javax.swing.JComboBox<String> cbbTrangthai;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimfKiem;
    // End of variables declaration//GEN-END:variables
}
