/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.DBConnection;
import javaapplication2.FormInputDataPembayaran;

/**
 *
 * @author toshiba
 */
public class Pembayaran {
    
    private Integer t_cust_account_id;
    private String npwd;
    private String company_name;
    private Integer p_vat_type_id;
    private String vat_code;
    private Integer p_vat_type_dtl_id;
    private Integer p_vat_type_dtl_cls_id;
    private String vat_code_dtl;
    private String user_name;
    private Integer p_finance_period_id;
    private String start_period;
    private String end_period;
    private Integer total_trans_amount;
    private Integer total_vat_amount;
    
    private String noPembayaran;
    private double nilaiPenalty;
    
    public Pembayaran() {
        noPembayaran = "";
        nilaiPenalty = 0;
    }
    
    public String getNoPembayaran() {
        return noPembayaran;
    }

    public double getNilaiPenalty() {
        return nilaiPenalty;
    }
    
    
    public void doInsert() throws SQLException {
        
        Connection con = DBConnection.openConnection();
        Statement st = con.createStatement();
                
        String query = "select o_mess,o_pay_key from f_vat_settlement_manual_wp("+ this.getT_cust_account_id() +",\n" +
                        ""+ this.getP_finance_period_id() +",\n" +
                        "'"+ this.getNpwd() +"',\n" +
                        "'"+ this.getStart_period() +"',\n" +
                        "'"+ this.getEnd_period() +"',\n" +
                        "null,\n" +
                        ""+this.getTotal_trans_amount()+",\n" +
                        ""+this.getTotal_vat_amount()+",\n" +
                        ""+this.getP_vat_type_dtl_id()+",\n" +
                        ""+this.getP_vat_type_dtl_cls_id()+",\n" +
                        "'"+this.getUser_name()+"')";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            this.noPembayaran = rs.getString("o_pay_key");
        }
        
        st.close();
        rs.close();
        
        this.setPenaltyAmount();
    }
    
    private void setPenaltyAmount() throws SQLException {
        Connection con = DBConnection.openConnection();
        Statement st = con.createStatement();
        
        String query = "select f_get_penalty_amt("+this.getTotal_vat_amount()+","+this.getP_finance_period_id()+","+this.getP_vat_type_dtl_id()+") as nilai_penalty";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            this.nilaiPenalty = rs.getInt("nilai_penalty");
        }
        st.close();
        rs.close();
    }
    
    public Integer getP_vat_type_dtl_cls_id() {
        return p_vat_type_dtl_cls_id;
    }

    public void setP_vat_type_dtl_cls_id(Integer p_vat_type_dtl_cls_id) {
        this.p_vat_type_dtl_cls_id = p_vat_type_dtl_cls_id;
    }

    public Integer getP_finance_period_id() {
        return p_finance_period_id;
    }

    public void setP_finance_period_id(Integer p_finance_period_id) {
        this.p_finance_period_id = p_finance_period_id;
    }

    public Integer getTotal_trans_amount() {
        return total_trans_amount;
    }

    public void setTotal_trans_amount(Integer total_trans_amount) {
        this.total_trans_amount = total_trans_amount;
    }

    public Integer getTotal_vat_amount() {
        return total_vat_amount;
    }

    public void setTotal_vat_amount(Integer total_vat_amount) {
        this.total_vat_amount = total_vat_amount;
    }
    
    public String getStart_period() {
        return start_period;
    }

    public void setStart_period(String start_period) {
        this.start_period = start_period;
    }

    public String getEnd_period() {
        return end_period;
    }

    public void setEnd_period(String end_period) {
        this.end_period = end_period;
    }
    
    public Integer getT_cust_account_id() {
        return t_cust_account_id;
    }

    public void setT_cust_account_id(Integer t_cust_account_id) {
        this.t_cust_account_id = t_cust_account_id;
    }

    public String getNpwd() {
        return npwd;
    }

    public void setNpwd(String npwd) {
        this.npwd = npwd;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Integer getP_vat_type_id() {
        return p_vat_type_id;
    }

    public void setP_vat_type_id(Integer p_vat_type_id) {
        this.p_vat_type_id = p_vat_type_id;
    }

    public String getVat_code() {
        return vat_code;
    }

    public void setVat_code(String vat_code) {
        this.vat_code = vat_code;
    }

    public Integer getP_vat_type_dtl_id() {
        return p_vat_type_dtl_id;
    }

    public void setP_vat_type_dtl_id(Integer p_vat_type_dtl_id) {
        this.p_vat_type_dtl_id = p_vat_type_dtl_id;
    }

    public String getVat_code_dtl() {
        return vat_code_dtl;
    }

    public void setVat_code_dtl(String vat_code_dtl) {
        this.vat_code_dtl = vat_code_dtl;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
}
