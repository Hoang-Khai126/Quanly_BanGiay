package GUI;

import DAO.daoNhaCC;
import DTO.NhaCC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class frmNhaCC extends javax.swing.JFrame {

    /**
     * Creates new form frmNhaCC
     */
    daoNhaCC da;
    ArrayList<NhaCC> dsNhaCC;
    int vitri = 0;
    public frmNhaCC() {
        initComponents();
        setLocationRelativeTo(null);
        da = new daoNhaCC();
        dsNhaCC = da.LayDanhSach();
        HienThiTextBox(vitri);
        HienThiTabale();
        btnLuu.setEnabled(false);
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        
        txtMaNCC.setEnabled(false);
        txtTenNCC.setEnabled(false);
        txtDiachi.setEnabled(false);
        txtSdt.setEnabled(false);
        txtEmail.setEnabled(false);
    }
    private void HienThiTextBox(int vitri){
        NhaCC m = dsNhaCC.get(vitri);
        txtMaNCC.setText(m.getMaNCC());
        txtTenNCC.setText(m.getTenNCC());
        txtDiachi.setText(m.getDiaChi());
        txtSdt.setText(m.getSdt());
        txtEmail.setText(m.getEmail());
    }
    private void HienThiTabale(){
        String []hearder = {"Mã NCC", "Tên NCC", "Địa chỉ", "Sdt", "Email"};
        DefaultTableModel model = new DefaultTableModel(hearder, 0);
        for (NhaCC m: dsNhaCC){
            Object []o = {m.getMaNCC(), m.getTenNCC(), m.getDiaChi(), m.getSdt(), m.getEmail()};
            model.addRow(o);
        }
        tblDanhSach.setModel(model);
        tblDanhSach.setRowSelectionInterval(vitri, vitri);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDanhSach = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Nhập Nhà Cung Cấp");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("Email: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("Mã NCC: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Tên NCC: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel4.setText("Địa chỉ: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel5.setText("Sdt: ");

        txtSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSdtKeyTyped(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(txtMaNCC))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                            .addComponent(txtSdt)
                            .addComponent(txtDiachi)
                            .addComponent(txtTenNCC))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setText("Danh sách NCC: ");

        txtDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDanhSachActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tblDanhSach);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
        vitri = tblDanhSach.getSelectedRow();
        HienThiTextBox(vitri);
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void txtDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDanhSachActionPerformed
        // TODO add your handling code here:
        if (txtDanhSach.getText() != null){
            dsNhaCC = da.TimKiemTheoNhaCC(txtDanhSach.getText());
            HienThiTabale();
            vitri = 0;
            HienThiTextBox(vitri);
        }
    }//GEN-LAST:event_txtDanhSachActionPerformed
    int flag = 0;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        try {
            txtMaNCC.setText(da.phatSinhMa());
        } catch (SQLException ex) {
            Logger.getLogger(frmNhaCC.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTenNCC.setText("");
        txtDiachi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtMaNCC.requestFocus();
        
        txtMaNCC.setEnabled(false);
        txtTenNCC.setEnabled(true);
        txtDiachi.setEnabled(true);
        txtSdt.setEnabled(true);
        txtEmail.setEnabled(true);
        flag = 1;
    }//GEN-LAST:event_btnThemActionPerformed
    private NhaCC chuyenDoi(){
        NhaCC m = new NhaCC();
        m.setMaNCC(txtMaNCC.getText());
        m.setTenNCC(txtTenNCC.getText());
        m.setDiaChi(txtDiachi.getText());
        m.setSdt(txtSdt.getText());
        m.setEmail(txtEmail.getText());
        return m;
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaNCC.requestFocus();
        flag = 3;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        NhaCC m = chuyenDoi();
        if (flag == 1){
            try {
                String EmailKH1 = txtEmail.getText().trim();
                String email1 = txtEmail.getText().trim();
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail\\.com)$";
                if (EmailKH1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email là thông tin bắt buộc, vui lòng nhập thông tin.");
                    return;
                }
                else if (email1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ email.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (!email1.matches(emailRegex)) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ email Gmail hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return; // Dừng thực hiện phương thức nếu email không hợp lệ
                }
                else{
                    da.ThemNhaCC(m);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmNhaCC.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnLuu.setEnabled(false);
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            txtMaNCC.setEnabled(false);
            txtTenNCC.setEnabled(false);
            txtDiachi.setEnabled(false);
            txtSdt.setEnabled(false);
            txtEmail.setEnabled(false);
        }
        if (flag == 2){
            da.SuaNhaCC(m);
            btnLuu.setEnabled(false);
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            txtMaNCC.setEnabled(false);
            txtTenNCC.setEnabled(false);
            txtDiachi.setEnabled(false);
            txtSdt.setEnabled(false);
            txtEmail.setEnabled(false);
        }
        if(flag == 3){
            da.XoaNhaCC(m);
            btnLuu.setEnabled(false);
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            txtMaNCC.setEnabled(false);
            txtTenNCC.setEnabled(false);
            txtDiachi.setEnabled(false);
            txtSdt.setEnabled(false);
            txtEmail.setEnabled(false);
        }
        
        vitri = 0;
        da = new daoNhaCC();
        dsNhaCC = da.LayDanhSach();
        HienThiTextBox(vitri);
        HienThiTabale();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaNCC.requestFocus();
        txtMaNCC.setEnabled(false);
        txtTenNCC.setEnabled(true);
        txtDiachi.setEnabled(true);
        txtSdt.setEnabled(true);
        txtEmail.setEnabled(true);
        flag = 2;
    }//GEN-LAST:event_btnSuaActionPerformed
    public String getSoDienThoai() {
        return txtSdt.getText();
    }
    public String getTenNhaCC() {
        return txtTenNCC.getText();
    }
    public String getDiaChiNhaCC() {
        return txtDiachi.getText();
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtSdtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSdtKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();
        String currentText = txtSdt.getText();
        // Kiểm tra xem ký tự được nhập có phải là số không
        if (!Character.isDigit(c)) {
            evt.consume(); // Nếu không phải số, tiêu thụ sự kiện (không cho phép nhập ký tự)
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
    }//GEN-LAST:event_txtSdtKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtDanhSach;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}