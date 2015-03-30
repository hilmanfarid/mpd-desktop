package mpd.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Hilman Farid
 * @version 1.0
 * @created 19-Mar-2015 13:23:34
 */
public class VatSettlement{

    private int t_vat_setllement_id;
    private int t_customer_order_id;
    private Date settlement_date;
    private int p_finance_period_id;
    private int t_cust_account_id;
    private String npwd;
    private float total_trans_amount;
    private float total_vat_amount;
    private int p_settlement_type_id;
    private String finance_periode_code;
    private float total_penalty_amount;
    private String payment_key;
    private String is_settled;
    private Date due_date;
    private Date payment_due_day;
    private String order_no;
    private Date creation_date;
    private String created_by;
    private Date updated_date;
    private String updated_by;

    public VatSettlement(){

    }

    public void finalize() throws Throwable {

    }

    public int gett_vat_setllement_id(){
            return t_vat_setllement_id;
    }

    /**
     * 
     * @param newVal
     */
    public void sett_vat_setllement_id(int newVal){
            t_vat_setllement_id = newVal;
    }

    public int gett_customer_order_id(){
            return t_customer_order_id;
    }

    /**
     * 
     * @param newVal
     */
    public void sett_customer_order_id(int newVal){
            t_customer_order_id = newVal;
    }

    public Date getsettlement_date(){
            return settlement_date;
    }

    /**
     * 
     * @param newVal
     */
    public void setsettlement_date(Date newVal){
            settlement_date = newVal;
    }

    public int getp_finance_period_id(){
            return p_finance_period_id;
    }

    /**
     * 
     * @param newVal
     */
    public void setp_finance_period_id(int newVal){
            p_finance_period_id = newVal;
    }

    public int gett_cust_account_id(){
            return t_cust_account_id;
    }

    /**
     * 
     * @param newVal
     */
    public void sett_cust_account_id(int newVal){
            t_cust_account_id = newVal;
    }

    public String getnpwd(){
            return npwd;
    }

    /**
     * 
     * @param newVal
     */
    public void setnpwd(String newVal){
            npwd = newVal;
    }

    public float gettotal_trans_amount(){
            return total_trans_amount;
    }

    /**
     * 
     * @param newVal
     */
    public void settotal_trans_amount(float newVal){
            total_trans_amount = newVal;
    }

    public float gettotal_vat_amount(){
            return total_vat_amount;
    }

    /**
     * 
     * @param newVal
     */
    public void settotal_vat_amount(float newVal){
            total_vat_amount = newVal;
    }

    public int getp_settlement_type_id(){
            return p_settlement_type_id;
    }

    /**
     * 
     * @param newVal
     */
    public void setp_settlement_type_id(int newVal){
            p_settlement_type_id = newVal;
    }

    public String getfinance_periode_code(){
            return finance_periode_code;
    }

    /**
     * 
     * @param newVal
     */
    public void setfinance_periode_code(String newVal){
            finance_periode_code = newVal;
    }

    public float gettotal_penalty_amount(){
            return total_penalty_amount;
    }

    /**
     * 
     * @param newVal
     */
    public void settotal_penalty_amount(float newVal){
            total_penalty_amount = newVal;
    }

    public String getpayment_key(){
            return payment_key;
    }

    /**
     * 
     * @param newVal
     */
    public void setpayment_key(String newVal){
            payment_key = newVal;
    }

    public String getis_settled(){
            return is_settled;
    }

    /**
     * 
     * @param newVal
     */
    public void setis_settled(String newVal){
            is_settled = newVal;
    }

    public Date getdue_date(){
            return due_date;
    }

    /**
     * 
     * @param newVal
     */
    public void setdue_date(Date newVal){
            due_date = newVal;
    }

    public Date getpayment_due_day(){
            return payment_due_day;
    }

    /**
     * 
     * @param newVal
     */
    public void setpayment_due_day(Date newVal){
            payment_due_day = newVal;
    }

    public String getorder_no(){
            return order_no;
    }

    /**
     * 
     * @param newVal
     */
    public void setorder_no(String newVal){
            order_no = newVal;
    }

    public Date getcreation_date(){
            return creation_date;
    }

    /**
     * 
     * @param newVal
     */
    public void setcreation_date(Date newVal){
            creation_date = newVal;
    }

    public String getcreated_by(){
            return created_by;
    }

    /**
     * 
     * @param newVal
     */
    public void setcreated_by(String newVal){
            created_by = newVal;
    }

    public Date getupdated_date(){
            return updated_date;
    }

    /**
     * 
     * @param newVal
     */
    public void setupdated_date(Date newVal){
            updated_date = newVal;
    }

    public String getupdated_by(){
            return updated_by;
    }

    /**
     * 
     * @param newVal
     */
    public void setupdated_by(String newVal){
            updated_by = newVal;
    }
    public Object[] getRow(){
        String is_settled;
        if(this.getis_settled().contains("Y")){
            is_settled = "Sudah Dibayar";
        }else{
            is_settled = "Belum Dibayar";
        }
        Object[] data = { 
            this.getnpwd(), 
            is_settled, 
            this.getfinance_periode_code(), 
            this.gettotal_trans_amount(),
            this.gettotal_vat_amount(), 
            this.gettotal_penalty_amount(),
            this.gettotal_vat_amount()+this.gettotal_penalty_amount(), 
            this.getpayment_key(), 
            this.getdue_date(), 
            this.getpayment_due_day(),
            this.gett_customer_order_id()
        };   
        return data;
    }
}