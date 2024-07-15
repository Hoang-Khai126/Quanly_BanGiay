package GUI;

import GUI.SanPham_GUI;
import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import GUI.KhachHang_GUI;
import GUI.NhanVien_GUI;
import GUI.HoaDonBan_GUI;
import GUI.Mau_GUI;
import GUI.Loai_GUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;


/**
 *
 * @author ADMIN
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        but_SanPham = new javax.swing.JButton();
        but_BanHang = new javax.swing.JButton();
        but_HoaDon = new javax.swing.JButton();
        but_KhachHang = new javax.swing.JButton();
        but_NhanVien = new javax.swing.JButton();
        but_NhaCC = new javax.swing.JButton();
        but_PhieuNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        but_SanPham.setText("Sản phẩm");
        but_SanPham.setPreferredSize(new java.awt.Dimension(150, 60));
        but_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_SanPhamActionPerformed(evt);
            }
        });

        but_BanHang.setText("Bán hàng");
        but_BanHang.setPreferredSize(new java.awt.Dimension(150, 60));
        but_BanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_BanHangActionPerformed(evt);
            }
        });

        but_HoaDon.setText("Hoá đơn");
        but_HoaDon.setPreferredSize(new java.awt.Dimension(150, 60));
        but_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_HoaDonActionPerformed(evt);
            }
        });

        but_KhachHang.setText("Khách hàng");
        but_KhachHang.setPreferredSize(new java.awt.Dimension(150, 60));
        but_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_KhachHangActionPerformed(evt);
            }
        });

        but_NhanVien.setText("Nhân viên");
        but_NhanVien.setPreferredSize(new java.awt.Dimension(150, 60));
        but_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_NhanVienActionPerformed(evt);
            }
        });

        but_NhaCC.setText("Nhà cung cấp");
        but_NhaCC.setPreferredSize(new java.awt.Dimension(150, 60));
        but_NhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_NhaCCActionPerformed(evt);
            }
        });

        but_PhieuNhap.setText("Phiếu nhập");
        but_PhieuNhap.setPreferredSize(new java.awt.Dimension(150, 60));
        but_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_PhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(but_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_NhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(but_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_NhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void but_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_SanPhamActionPerformed
        // TODO add your handling code here:
        SanPham_GUI spGUI=new SanPham_GUI();
        spGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_SanPhamActionPerformed

    private void but_BanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_BanHangActionPerformed
        // TODO add your handling code here:
        BanHang_GUI bhGUI=new BanHang_GUI();
        bhGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_BanHangActionPerformed

    private void but_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_HoaDonActionPerformed
        // TODO add your handling code here:
        HoaDonBan_GUI hdGUI=new HoaDonBan_GUI();
        hdGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_HoaDonActionPerformed

    private void but_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_KhachHangActionPerformed
        KhachHang_GUI khGUI=new KhachHang_GUI();
        khGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_but_KhachHangActionPerformed

    private void but_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_NhanVienActionPerformed
        // TODO add your handling code here:
        NhanVien_GUI nvGUI=new NhanVien_GUI();
        nvGUI.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_but_NhanVienActionPerformed

    private void but_NhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_NhaCCActionPerformed
        // TODO add your handling code here:
//        Mau_GUI mauGUI=new Mau_GUI();
//        mauGUI.setVisible(true);
//        this.setVisible(false);
        
//        Loai_GUI loaiGUI=new Loai_GUI();
//        loaiGUI.setVisible(true);
//        this.setVisible(false);
         new frmNhaCC().setVisible(true);

    }//GEN-LAST:event_but_NhaCCActionPerformed

    private void but_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_PhieuNhapActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            new frmPhieuNhap().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_but_PhieuNhapActionPerformed
    
    public void showMainGUI()
    {
        this.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_BanHang;
    private javax.swing.JButton but_HoaDon;
    private javax.swing.JButton but_KhachHang;
    private javax.swing.JButton but_NhaCC;
    private javax.swing.JButton but_NhanVien;
    private javax.swing.JButton but_PhieuNhap;
    private javax.swing.JButton but_SanPham;
    // End of variables declaration//GEN-END:variables
}
