package GUI;

import javax.swing.text.*;
import javax.swing.*;

import GUI.SanPham_GUI;
import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import BUS.LoaiSP_BUS;
import DTO.LoaiSP_DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import javax.swing.*;
import java.awt.*;

public class ThemSP_GUI extends javax.swing.JFrame {

    private SanPham_BUS sanPhamBus = new SanPham_BUS();
    private LoaiSP_BUS loaiSPBUS = new LoaiSP_BUS();
    private ButtonGroup group_TrangThai = new ButtonGroup();
    private String linkAnh="";
    public ThemSP_GUI() {
        initComponents();
        group_TrangThai.add(rdBut_Hoatdong);
        group_TrangThai.add(rdBut_KoHD);

        sanPhamBus.docDanhSachSanPham();
        ArrayList<LoaiSP_DTO> loaiSP = loaiSPBUS.layDanhSachLoai();
        loadDataLenComboBoxLoaiSanPham(loaiSP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_MoTa = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        rdBut_Hoatdong = new javax.swing.JRadioButton();
        rdBut_KoHD = new javax.swing.JRadioButton();
        cb_Loai = new javax.swing.JComboBox<>();
        but_ThemSP = new javax.swing.JButton();
        but_DatLai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm sản phẩm");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã SP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên SP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số lượng");

        txt_MaSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_TenSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_LoaiSP.setPreferredSize(new java.awt.Dimension(64, 26));

        txt_slSP.setPreferredSize(new java.awt.Dimension(64, 26));
        txt_slSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_slSPKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Giá bán");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nhà cung cấp");

        txt_donGiaBan.setPreferredSize(new java.awt.Dimension(60, 26));
        txt_donGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_donGiaBanKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giá nhập");

        txt_donGiaNhap.setPreferredSize(new java.awt.Dimension(60, 26));
        txt_donGiaNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_donGiaNhapKeyTyped(evt);
            }
        });

        txt_NhaCCSP.setPreferredSize(new java.awt.Dimension(64, 26));

        label_Anh.setBackground(new java.awt.Color(0, 0, 0));
        label_Anh.setToolTipText("");
        label_Anh.setOpaque(true);
        label_Anh.setPreferredSize(new java.awt.Dimension(150, 150));

        but_chonAnh.setText("Chọn ảnh");
        but_chonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_chonAnhActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mô tả");

        txt_MoTa.setColumns(20);
        txt_MoTa.setRows(5);
        jScrollPane1.setViewportView(txt_MoTa);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        rdBut_Hoatdong.setText("Hoạt động");

        rdBut_KoHD.setText("Không hoạt động");

        cb_Loai.setToolTipText("");
        cb_Loai.setName(""); // NOI18N
        cb_Loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LoaiActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_slSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdBut_Hoatdong)
                                .addGap(41, 41, 41)
                                .addComponent(rdBut_KoHD))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txt_donGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_donGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_NhaCCSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_chonAnh)
                        .addGap(47, 47, 47))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cb_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_slSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_donGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_donGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_chonAnh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NhaCCSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdBut_Hoatdong)
                            .addComponent(rdBut_KoHD)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        cb_Loai.getAccessibleContext().setAccessibleName("");

        but_ThemSP.setText("Thêm");
        but_ThemSP.setPreferredSize(new java.awt.Dimension(100, 50));
        but_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ThemSPActionPerformed(evt);
            }
        });

        but_DatLai.setText("Đặt lại");
        but_DatLai.setPreferredSize(new java.awt.Dimension(100, 50));
        but_DatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_DatLaiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM SẢN PHẨM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(but_ThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(but_DatLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(178, 178, 178))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_DatLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_ThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showThemSP_GUI() {

        this.setVisible(true);
    }

    private void loadDataLenComboBoxLoaiSanPham(ArrayList<LoaiSP_DTO> loaiSP) {

        for (LoaiSP_DTO loai : loaiSP) {
            cb_Loai.addItem(loai.getMaLoai());
        }

    }
    private void but_DatLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_DatLaiActionPerformed
        txt_MaSP.setText("");
        txt_TenSP.setText("");
        txt_slSP.setText("");
        txt_donGiaBan.setText("");
        txt_donGiaNhap.setText("");
        txt_LoaiSP.setText("");
        txt_NhaCCSP.setText("");
        txt_MoTa.setText("");
        group_TrangThai.clearSelection();
        label_Anh.setIcon(null);
    }//GEN-LAST:event_but_DatLaiActionPerformed

    private void txt_slSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_slSPKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_slSPKeyTyped

    private void txt_donGiaBanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_donGiaBanKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String text = txt_donGiaBan.getText();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        if (c == '.' && text.contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_donGiaBanKeyTyped

    private void txt_donGiaNhapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_donGiaNhapKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String text = txt_donGiaNhap.getText();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        if (c == '.' && text.contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_donGiaNhapKeyTyped

    private void cb_LoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LoaiActionPerformed
        // TODO add your handling code here:
        String selectItem = (String) cb_Loai.getSelectedItem();
        txt_LoaiSP.setText(selectItem);
    }//GEN-LAST:event_cb_LoaiActionPerformed

    private void but_chonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_chonAnhActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        File newfile=new File("src\\image");
        fileChooser.setCurrentDirectory(newfile);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            linkAnh=selectedFile.getAbsolutePath();

            // Hiển thị hình ảnh trong JLabel
            ImageIcon anhSP = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = anhSP.getImage(); // Chuyển đổi về đối tượng Image
            Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
            anhSP = new ImageIcon(scaledImage); // Chuyển đổi về ImageIcon
            label_Anh.setIcon(anhSP);
        }
    }//GEN-LAST:event_but_chonAnhActionPerformed

    private void but_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ThemSPActionPerformed
        // TODO add your handling code here:
        String trangThai="";
        if(rdBut_Hoatdong.isSelected())
            trangThai="0";
        else
            trangThai="1";
        
        if(sanPhamBus.themSanPham(txt_MaSP.getText(), txt_TenSP.getText(), txt_slSP.getText(), txt_donGiaNhap.getText(),txt_donGiaBan.getText(), linkAnh, txt_LoaiSP.getText(), txt_NhaCCSP.getText(), txt_MoTa.getText(), trangThai))
        {
            but_DatLai.doClick();
            GUI.SanPham_GUI guisp=new GUI.SanPham_GUI();
            guisp.setVisible(false);guisp.setVisible(true);
        }
    }//GEN-LAST:event_but_ThemSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_DatLai;
    private javax.swing.JButton but_ThemSP;
    private javax.swing.JButton but_chonAnh;
    private javax.swing.JComboBox<String> cb_Loai;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Anh;
    private javax.swing.JRadioButton rdBut_Hoatdong;
    private javax.swing.JRadioButton rdBut_KoHD;
    private javax.swing.JTextField txt_LoaiSP;
    private javax.swing.JTextField txt_MaSP;
    private javax.swing.JTextArea txt_MoTa;
    private javax.swing.JTextField txt_NhaCCSP;
    private javax.swing.JTextField txt_TenSP;
    private javax.swing.JTextField txt_donGiaBan;
    private javax.swing.JTextField txt_donGiaNhap;
    private javax.swing.JTextField txt_slSP;
    // End of variables declaration//GEN-END:variables
}
