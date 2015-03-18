/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class InputDataPembayaran extends javax.swing.JInternalFrame {
    private final NewJFrame frame;
    public Integer t_cust_account_id;
    public String npwd;
    public String company_name;
    public Integer p_vat_type_id;
    public String vat_code;
    public Integer p_vat_type_dtl_id;
    public String vat_code_dtl;
    
    public DBConnection dbConn;
    /**
     * Creates new form InputDataPembayaran
     */
    public InputDataPembayaran(NewJFrame frame, String user_name) {
        this.frame = frame;
        initComponents();
        dbConn = new DBConnection();
        this.initUserVars(user_name);
    }

    private void initUserVars(String user_name) {
        
        try {
            Connection con = dbConn.openConnection();
            Statement st = con.createStatement();
            String query = "select ty_lov_npwd as t_cust_account_id, npwd, company_name,\n" +
                            "p_vat_type_id, vat_code, p_vat_type_dtl_id, vat_code_dtl\n" +
                            "from f_get_npwd_by_username('"+user_name+"') AS tbl (ty_lov_npwd)";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                this.t_cust_account_id = rs.getInt("t_cust_account_id");
                this.npwd = rs.getString("npwd");
                this.company_name = rs.getString("company_name");
                this.p_vat_type_id = rs.getInt("p_vat_type_id");
                this.vat_code = rs.getString("vat_code");
                this.p_vat_type_dtl_id = rs.getInt("p_vat_type_dtl_id");
                this.vat_code = rs.getString("vat_code");
            }
            
            con.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(InputDataPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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
        tblPelaporan = new javax.swing.JTable();
        btnTambahPembayaran = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSubmitLaporanPajak = new javax.swing.JButton();
        cmbNpwpd = new javax.swing.JComboBox();
        btnLogout = new javax.swing.JButton();

        tblPelaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NPWPD", "Status Pembayaran", "Periode", "Total Transaksi", "Pajak", "Denda", "Total yang harus dibayar", "No Pembayaran", "Jatuh Tempo Pelaporan", "Batas Waktu Pembayaran"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPelaporan);

        btnTambahPembayaran.setText("Tambah Data Pembayaran");
        btnTambahPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPembayaranActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");

        btnSubmitLaporanPajak.setText("Kirim Laporan Pajak");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambahPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubmitLaporanPajak, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbNpwpd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmitLaporanPajak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambahPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbNpwpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPembayaranActionPerformed
        // TODO add your handling code here:
        //Tampilkan Form Input Pembayaran
        FormInputDataPembayaran formInputDataPembayaran = new FormInputDataPembayaran(this.frame, true);
        formInputDataPembayaran.setVisible(true);
    }//GEN-LAST:event_btnTambahPembayaranActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        LoginPage thisPanel = new LoginPage(this.frame);
        this.frame.setContentPane(thisPanel);
        this.frame.invalidate();
        this.frame.validate();
               
        this.dispose();
        
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSubmitLaporanPajak;
    private javax.swing.JButton btnTambahPembayaran;
    private javax.swing.JComboBox cmbNpwpd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPelaporan;
    // End of variables declaration//GEN-END:variables
}
