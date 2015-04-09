package mpd.model;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Hilman Farid
 * @version 1.0
 * @created 19-Mar-2015 13:23:34
 */
public class CustAccTrans{
    private int t_cust_acc_dtl_trans_id;
    private String service_desc;
    private Date trans_date;
    private String description;
    private String bill_no;
    private double service_charge;
    private double vat_charge;
    private int p_vat_type_dtl_id;
    private int p_vat_type_dtl_cls_id;
    private String updated_by;
    private Date updated_date;

    public int getT_cust_acc_dtl_trans_id() {
        return t_cust_acc_dtl_trans_id;
    }

    public void setT_cust_acc_dtl_trans_id(int t_cust_acc_dtl_trans_id) {
        this.t_cust_acc_dtl_trans_id = t_cust_acc_dtl_trans_id;
    }

    public String getService_desc() {
        return service_desc;
    }

    public void setService_desc(String service_desc) {
        this.service_desc = service_desc;
    }

    public Date getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(Date trans_date) {
        this.trans_date = trans_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public double getService_charge() {
        return service_charge;
    }

    public void setService_charge(double service_charge) {
        this.service_charge = service_charge;
    }

    public double getVat_charge() {
        return vat_charge;
    }

    public void setVat_charge(double vat_charge) {
        this.vat_charge = vat_charge;
    }

    public int getP_vat_type_dtl_id() {
        return p_vat_type_dtl_id;
    }

    public void setP_vat_type_dtl_id(int p_vat_type_dtl_id) {
        this.p_vat_type_dtl_id = p_vat_type_dtl_id;
    }

    public int getP_vat_type_dtl_cls_id() {
        return p_vat_type_dtl_cls_id;
    }

    public void setP_vat_type_dtl_cls_id(int p_vat_type_dtl_cls_id) {
        this.p_vat_type_dtl_cls_id = p_vat_type_dtl_cls_id;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
    
    public HashMap getRow(){
        HashMap data = new HashMap<>();
        Field[] allFields = this.getClass().getDeclaredFields();
        for (int i = 0; i < allFields.length; i++) {
            try {
                data.put(allFields[i].getName(),allFields[i].get(this));
            } catch (    IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(CustAccTrans.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }
}