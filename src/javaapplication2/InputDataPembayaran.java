/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mpd.dao.daoVatSettlement;
import mpd.lib.PaginationVatSettlement;
import mpd.model.Pembayaran;
import mpd.model.VatSettlement;

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
    public String user_name;
    private PaginationVatSettlement sett_pagination;
    public DBConnection dbConn;
    private Pembayaran pembayaran;
    public int t_customer_order_id;
    private int t_vat_setllement_id;
    /**
     * Creates new form InputDataPembayaran
     */
    public InputDataPembayaran(NewJFrame frame, String user_name) {
        this.frame = frame;
        initComponents();
        dbConn = new DBConnection();
        this.initUserVars(user_name);
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        daoVatSettlement sett = new daoVatSettlement();
        sett.t_cust_account_id_search = this.t_cust_account_id;
        sett_pagination = new PaginationVatSettlement(sett);
        sett.size_per_page=10;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        
        List<VatSettlement> res = sett.getALL(1,sett.size_per_page, "t_vat_setllement_id", "DESC");
        int total_row= sett.size_per_page;
        int i_row=1;
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= sett.size_per_page){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null,null,null,null});
            i_row++;
        }
        tblPelaporan.removeColumn(tblPelaporan.getColumnModel().getColumn(10));
        tblPelaporan.removeColumn(tblPelaporan.getColumnModel().getColumn(10));
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+dtm.getRowCount()+" dari "+sett_pagination.total_data+" Data");
        //Object[] row = {"tes", null, null, null, null, null, null, null, null, null};
        //dtm.addRow(row);
    }

    private void initUserVars(String user_name) {
        
        try {
            Connection con = dbConn.openConnection();
            Statement st = con.createStatement();
            String query = "select ty_lov_npwd as t_cust_account_id, npwd, company_name,\n" +
                            "tbl.p_vat_type_id,  tbl.vat_code, tbl.p_vat_type_dtl_id, vat_code_dtl,typ_dtl.vat_pct\n" +
                            "from f_get_npwd_by_username('"+user_name+"') AS tbl (ty_lov_npwd)"+
                            "left join p_vat_type_dtl typ_dtl on typ_dtl.p_vat_type_dtl_id = tbl.p_vat_type_dtl_id;";
            ResultSet rs = st.executeQuery(query);
            pembayaran = new Pembayaran();
            while(rs.next()) {
                this.t_cust_account_id = rs.getInt("t_cust_account_id");
                this.npwd = rs.getString("npwd");
                this.company_name = rs.getString("company_name");
                this.p_vat_type_id = rs.getInt("p_vat_type_id");
                this.vat_code = rs.getString("vat_code");
                this.p_vat_type_dtl_id = rs.getInt("p_vat_type_dtl_id");
                this.vat_code_dtl = rs.getString("vat_code_dtl");
                
                this.frame.t_cust_account_id = rs.getInt("t_cust_account_id");
                this.frame.npwd = rs.getString("npwd");
                this.frame.company_name = rs.getString("company_name");
                this.frame.p_vat_type_id = rs.getInt("p_vat_type_id");
                this.frame.vat_code = rs.getString("vat_code");
                this.frame.p_vat_type_dtl_id = rs.getInt("p_vat_type_dtl_id");
                this.frame.vat_code_dtl = rs.getString("vat_code_dtl");

                pembayaran.setT_cust_account_id(this.t_cust_account_id);
                pembayaran.setNpwd(this.npwd);
                pembayaran.setCompany_name(this.company_name);
                pembayaran.setP_vat_type_id(this.p_vat_type_id);
                pembayaran.setVat_code(this.vat_code);
                pembayaran.setP_vat_type_dtl_id(this.p_vat_type_dtl_id);
                pembayaran.setVat_code(this.vat_code_dtl);
                pembayaran.setVat_pct(rs.getDouble("vat_pct"));
            }
            this.user_name = user_name;
            this.frame.user_name = user_name;
            pembayaran.setUser_name(this.user_name);
            
            con.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(InputDataPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            int dialogButton = JOptionPane.CLOSED_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this,"Koneksi Gagal!\n Menutup Aplikasi......","Info",dialogButton);
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
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_first3 = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        num_of_pages = new javax.swing.JLabel();
        num_data_pages = new javax.swing.JLabel();
        btn_upload = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        tblPelaporan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblPelaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NPWPD", "Status Pembayaran", "Periode", "Total Transaksi", "Pajak", "Denda", "Total yang harus dibayar", "No Pembayaran", "Jatuh Tempo Pelaporan", "Batas Waktu Pembayaran", "t_customer_order_id", "t_vat_setllement_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPelaporan.setMaximumSize(new java.awt.Dimension(2147483647, 267));
        tblPelaporan.setRowHeight(35);
        tblPelaporan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPelaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelaporanMouseClicked(evt);
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
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSubmitLaporanPajak.setText("Kirim Laporan Pajak");
        btnSubmitLaporanPajak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitLaporanPajakActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btn_first3.setText("|<");
        btn_first3.setMaximumSize(new java.awt.Dimension(70, 40));
        btn_first3.setMinimumSize(new java.awt.Dimension(70, 40));
        btn_first3.setName("btn_first"); // NOI18N
        btn_first3.setPreferredSize(new java.awt.Dimension(70, 40));
        btn_first3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_first3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_first3);

        btn_prev.setText("<");
        btn_prev.setMaximumSize(new java.awt.Dimension(70, 40));
        btn_prev.setMinimumSize(new java.awt.Dimension(70, 40));
        btn_prev.setName("btn_prev"); // NOI18N
        btn_prev.setPreferredSize(new java.awt.Dimension(70, 40));
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });
        jPanel2.add(btn_prev);

        btn_next.setText(">");
        btn_next.setMaximumSize(new java.awt.Dimension(70, 40));
        btn_next.setMinimumSize(new java.awt.Dimension(70, 40));
        btn_next.setName("btn_next"); // NOI18N
        btn_next.setPreferredSize(new java.awt.Dimension(70, 40));
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        jPanel2.add(btn_next);

        btn_last.setText(">|");
        btn_last.setMaximumSize(new java.awt.Dimension(70, 40));
        btn_last.setMinimumSize(new java.awt.Dimension(70, 40));
        btn_last.setName("btn_last"); // NOI18N
        btn_last.setPreferredSize(new java.awt.Dimension(70, 40));
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });
        jPanel2.add(btn_last);

        num_of_pages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        num_of_pages.setText("Halaman 1 dari 10");

        num_data_pages.setText("Menampilkan 1 s.d 2 dari 10 Data");

        btn_upload.setText("Upload");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });

        jButton1.setText("Selanjutnya");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(btnTambahPembayaran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmitLaporanPajak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_upload, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(num_of_pages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num_data_pages)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambahPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubmitLaporanPajak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_upload, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_of_pages)
                    .addComponent(num_data_pages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPembayaranActionPerformed
        // TODO add your handling code here:
        //Tampilkan Form Input Pembayaran
        FormInputDataPembayaran formInputDataPembayaran = new FormInputDataPembayaran(this.frame, true, pembayaran);
        formInputDataPembayaran.setVisible(true);
        formInputDataPembayaran.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                sett_pagination.total_data =sett_pagination.getDao().getCount();
                refreshTable();
            }
        });

    }//GEN-LAST:event_btnTambahPembayaranActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this,"Apakah Anda Ingin Logout?","Info",dialogButton);
        
        if(dialogResult == 0) { // if yes
            LoginPage thisPanel = new LoginPage(this.frame);
            this.frame.setContentPane(thisPanel);
            this.frame.invalidate();
            this.frame.validate();
            
            this.dispose();
        }else{
            
        }
        
        
        
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this,"Apakah Anda Yakin Ingin Menghapus data tersebut?","Info",dialogButton);
        
        if(dialogResult == 0) { // if yes
            //do hapus
            if(t_vat_setllement_id == 0){
                int warningButton = JOptionPane.OK_OPTION;
                int GagalResult = JOptionPane.showConfirmDialog(this,"Data Belum Dipilih","Info",warningButton);
                return;
            }
            daoVatSettlement dao = new daoVatSettlement();
            dao.t_cust_account_id_search = this.t_cust_account_id;
            dao.delete(t_vat_setllement_id);
            sett_pagination.total_data = dao.getCount();
            refreshTable();
            t_vat_setllement_id=0;
        }else {
            //do nothing
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSubmitLaporanPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitLaporanPajakActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this,"Apakah Anda Yakin Ingin Mengirim Laporan Pajak Tersebut?","Info",dialogButton);
        
        if(dialogResult == 0) { // if yes
            //do hapus
            
            
        }else {
            //do nothing
        }
    }//GEN-LAST:event_btnSubmitLaporanPajakActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        List<VatSettlement> res = sett_pagination.lastPage();
        if(res == null){
           return;
        }
        int total_row= sett_pagination.getDao().size_per_page;
        int i_row=1;
        int data_till_now = dtm.getRowCount();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null,null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(sett_pagination.getDao().size_per_page*(sett_pagination.getCurrentPage()-1)))+" dari "+sett_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        List<VatSettlement> res = sett_pagination.nextPage();
        if(res == null){
           return;
        }
        int total_row= sett_pagination.getDao().size_per_page;
        int i_row=1;
        int data_till_now = dtm.getRowCount();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null,null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(sett_pagination.getDao().size_per_page*(sett_pagination.getCurrentPage()-1)))+" dari "+sett_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        List<VatSettlement> res = sett_pagination.prevPage();
        if(res == null){
           return;
        }
        int total_row= sett_pagination.getDao().size_per_page;
        int i_row=1;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null,null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(sett_pagination.getDao().size_per_page*(sett_pagination.getCurrentPage()-1)))+" dari "+sett_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_first3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_first3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        List<VatSettlement> res = sett_pagination.firstPage();
        if(res == null){
           return;
        }
        int total_row= sett_pagination.getDao().size_per_page;
        int i_row=1;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null,null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(sett_pagination.getDao().size_per_page*(sett_pagination.getCurrentPage()-1)))+" dari "+sett_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_first3ActionPerformed

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ViewUploadDokumen viewDocUpload = new ViewUploadDokumen(frame,this,this.t_customer_order_id);
        viewDocUpload.pack();
            
        frame.getContentPane().add(viewDocUpload);
        frame.setContentPane(viewDocUpload);
        viewDocUpload.setVisible(true);
    }//GEN-LAST:event_btn_uploadActionPerformed

    private void tblPelaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelaporanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPelaporanMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ViewCustAccTrans view_cust_trans = new ViewCustAccTrans(frame,this,this.t_customer_order_id);
        view_cust_trans.pack();
            
        frame.getContentPane().add(view_cust_trans);
        frame.setContentPane(view_cust_trans);
        view_cust_trans.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPelaporanMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        int idx = tblPelaporan.getSelectedRow();
        this.t_vat_setllement_id  = (int) tblPelaporan.getModel().getValueAt(tblPelaporan.getSelectedRow(), 11);
        this.t_customer_order_id = (int) tblPelaporan.getModel().getValueAt(idx, 10);
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSubmitLaporanPajak;
    private javax.swing.JButton btnTambahPembayaran;
    private javax.swing.JButton btn_first3;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_upload;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num_data_pages;
    private javax.swing.JLabel num_of_pages;
    private javax.swing.JTable tblPelaporan;
    // End of variables declaration//GEN-END:variables
    public void refreshTable(){
        DefaultTableModel dtm = (DefaultTableModel) this.tblPelaporan.getModel();
        List<VatSettlement> res = sett_pagination.getDao().getALL(sett_pagination.getCurrentPage(), sett_pagination.getDao().size_per_page, title, title);
        if(res == null){
           return;
        }
        int total_row= sett_pagination.getDao().size_per_page;
        int i_row=1;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (VatSettlement temp : res) {
                Object[] row = temp.getRow();
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null,null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+sett_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)sett_pagination.total_data/sett_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((sett_pagination.getCurrentPage()-1)*sett_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(sett_pagination.getDao().size_per_page*(sett_pagination.getCurrentPage()-1)))+" dari "+sett_pagination.total_data+" Data");
    }
}
