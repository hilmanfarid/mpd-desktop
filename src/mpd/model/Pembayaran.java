/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.model;

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
    private String vat_code_dtl;
    private String user_name;
    
    public Pembayaran() {
        
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
