/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mpd.dao.daoCustLegalDoc;
import mpd.lib.PaginationCustLegalDoc;
import mpd.model.CustLegalDoc;

/**
 *
 * @author Admin
 */
public final class ViewUploadDokumen extends javax.swing.JInternalFrame {
    private final NewJFrame frame;
    private final InputDataPembayaran inDataPem;
    public final int t_customer_order_id;
    private PaginationCustLegalDoc cust_doc_pagination;
    /**
     * Creates new form NewJInternalFrame
     */
    public ViewUploadDokumen(NewJFrame frame,InputDataPembayaran inDataPem,int t_customer_order_id) {
        this.frame = frame;
        this.inDataPem = inDataPem;
        this.t_customer_order_id = t_customer_order_id;
        initComponents();
        this.cust_doc_pagination=null;
        daoCustLegalDoc cust_doc = new daoCustLegalDoc();
        cust_doc.t_customer_order_id_search = this.t_customer_order_id;
        cust_doc_pagination = new PaginationCustLegalDoc(cust_doc);
        cust_doc.size_per_page=10;
        this.setDataTable();
        CustLegalTable.removeColumn(CustLegalTable.getColumnModel().getColumn(0));
    }
    public void setDataTable(){
        daoCustLegalDoc dao =cust_doc_pagination.getDao();
        DefaultTableModel dtm = (DefaultTableModel) this.CustLegalTable.getModel();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        List<CustLegalDoc> res = dao.getALL(1,dao.size_per_page, "t_cust_order_legal_doc_id", "DESC");
        int total_row= dao.size_per_page;
        int i_row=1;
        for (CustLegalDoc temp : res) {
                Object[] row = new Object[]{
                    temp.getT_cust_order_legal_doc_id(),
                    temp.getDoc_code(),
                    temp.getFile_name(),
                    temp.getLegal_doc_desc()
                };
                System.out.println(row);
                dtm.addRow(row);
                i_row++;
	}
        while(i_row <= dao.size_per_page){
            dtm.addRow(new Object[]{null, null, null, null});
            i_row++;
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
        CustLegalTable = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        num_of_pages = new javax.swing.JLabel();
        num_data_pages = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_first3 = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();

        CustLegalTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustLegalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "t_cust_order_legal_doc_id", "Tipe Dokumen", "Nama File", "Deskripsi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CustLegalTable.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        CustLegalTable.setMinimumSize(new java.awt.Dimension(825, 350));
        CustLegalTable.setPreferredSize(new java.awt.Dimension(825, 350));
        CustLegalTable.setRowHeight(35);
        jScrollPane1.setViewportView(CustLegalTable);
        CustLegalTable.getColumnModel().getColumn(0).setMinWidth(2);
        CustLegalTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        CustLegalTable.getColumnModel().getColumn(0).setMaxWidth(2);
        CustLegalTable.getColumnModel().getColumn(1).setMinWidth(200);
        CustLegalTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        CustLegalTable.getColumnModel().getColumn(2).setMinWidth(250);
        CustLegalTable.getColumnModel().getColumn(2).setPreferredWidth(250);

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jButton1.setText("Tambah Dokumen Pendukung");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        num_of_pages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        num_of_pages.setText("Halaman 1 dari 10");

        num_data_pages.setText("Menampilkan 1 s.d 2 dari 10 Data");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(num_of_pages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num_data_pages)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_of_pages)
                    .addComponent(num_data_pages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frame.getContentPane().add(this.inDataPem);
        frame.setContentPane(this.inDataPem);
        this.inDataPem.setVisible(true);
    }//GEN-LAST:event_back_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UploadDokumenForm upForm = new UploadDokumenForm(this.frame,this, true);
        upForm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_first3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_first3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.CustLegalTable.getModel();
        List<CustLegalDoc> res = cust_doc_pagination.firstPage();
        if(res == null){
            return;
        }
        int total_row= cust_doc_pagination.getDao().size_per_page;
        int i_row=1;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (CustLegalDoc temp : res) {
            Object[] row = new Object[]{
                temp.getT_cust_order_legal_doc_id(),
                temp.getDoc_code(),
                temp.getFile_name(),
                temp.getLegal_doc_desc()
            };
            System.out.println(row);
            dtm.addRow(row);
            i_row++;
        }
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+cust_doc_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)cust_doc_pagination.total_data/cust_doc_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((cust_doc_pagination.getCurrentPage()-1)*cust_doc_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(cust_doc_pagination.getDao().size_per_page*(cust_doc_pagination.getCurrentPage()-1)))+" dari "+cust_doc_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_first3ActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.CustLegalTable.getModel();
        List<CustLegalDoc> res = cust_doc_pagination.prevPage();
        if(res == null){
            return;
        }
        int total_row= cust_doc_pagination.getDao().size_per_page;
        int i_row=1;
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (CustLegalDoc temp : res) {
            Object[] row = new Object[]{
                temp.getT_cust_order_legal_doc_id(),
                temp.getDoc_code(),
                temp.getFile_name(),
                temp.getLegal_doc_desc()
            };
            System.out.println(row);
            dtm.addRow(row);
            i_row++;
        }
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+cust_doc_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)cust_doc_pagination.total_data/cust_doc_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((cust_doc_pagination.getCurrentPage()-1)*cust_doc_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(cust_doc_pagination.getDao().size_per_page*(cust_doc_pagination.getCurrentPage()-1)))+" dari "+cust_doc_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.CustLegalTable.getModel();
        List<CustLegalDoc> res = cust_doc_pagination.nextPage();
        if(res == null){
            return;
        }
        int total_row= cust_doc_pagination.getDao().size_per_page;
        int i_row=1;
        int data_till_now = dtm.getRowCount();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (CustLegalDoc temp : res) {
            Object[] row = new Object[]{
                temp.getT_cust_order_legal_doc_id(),
                temp.getDoc_code(),
                temp.getFile_name(),
                temp.getLegal_doc_desc()
            };
            System.out.println(row);
            dtm.addRow(row);
            i_row++;
        }
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+cust_doc_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)cust_doc_pagination.total_data/cust_doc_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((cust_doc_pagination.getCurrentPage()-1)*cust_doc_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(cust_doc_pagination.getDao().size_per_page*(cust_doc_pagination.getCurrentPage()-1)))+" dari "+cust_doc_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) this.CustLegalTable.getModel();
        List<CustLegalDoc> res = cust_doc_pagination.lastPage();
        if(res == null){
            return;
        }
        int total_row= cust_doc_pagination.getDao().size_per_page;
        int i_row=1;
        int data_till_now = dtm.getRowCount();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
        for (CustLegalDoc temp : res) {
            Object[] row = new Object[]{
                temp.getT_cust_order_legal_doc_id(),
                temp.getDoc_code(),
                temp.getFile_name(),
                temp.getLegal_doc_desc()
            };
            System.out.println(row);
            dtm.addRow(row);
            i_row++;
        }
        while(i_row <= total_row){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null, null});
            i_row++;
        }
        num_of_pages.setText("Halaman "+cust_doc_pagination.getCurrentPage()+" dari "+(int)Math.ceil((float)cust_doc_pagination.total_data/cust_doc_pagination.getDao().size_per_page));
        num_data_pages.setText("Menampilkan "+(((cust_doc_pagination.getCurrentPage()-1)*cust_doc_pagination.getDao().size_per_page)+1)+" s.d "+((int)res.size()+(cust_doc_pagination.getDao().size_per_page*(cust_doc_pagination.getCurrentPage()-1)))+" dari "+cust_doc_pagination.total_data+" Data");
    }//GEN-LAST:event_btn_lastActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustLegalTable;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton btn_first3;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num_data_pages;
    private javax.swing.JLabel num_of_pages;
    // End of variables declaration//GEN-END:variables
}