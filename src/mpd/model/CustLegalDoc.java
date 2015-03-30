package mpd.model;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Hilman Farid
 * @version 1.0
 * @created 19-Mar-2015 13:23:34
 */
public class CustLegalDoc{
    private int t_cust_order_legal_doc_id;
    private int t_customer_order_id;
    private int p_legal_doc_type_id;
    private String legal_doc_desc;
    private String origin_file_name;
    private String file_folder;
    private String file_name;
    private String description;
    private Date creation_date;
    private String created_by;
    private Date updated_date;
    private String updated_by;
    private String doc_code;

    public String getDoc_code() {
        return doc_code;
    }

    public void setDoc_code(String doc_code) {
        this.doc_code = doc_code;
    }
    
    public int getT_cust_order_legal_doc_id() {
        return t_cust_order_legal_doc_id;
    }

    public void setT_cust_order_legal_doc_id(int t_cust_order_legal_doc_id) {
        this.t_cust_order_legal_doc_id = t_cust_order_legal_doc_id;
    }

    public int getT_customer_order_id() {
        return t_customer_order_id;
    }

    public void setT_customer_order_id(int t_customer_order_id) {
        this.t_customer_order_id = t_customer_order_id;
    }

    public int getP_legal_doc_type_id() {
        return p_legal_doc_type_id;
    }

    public void setP_legal_doc_type_id(int p_legal_doc_type_id) {
        this.p_legal_doc_type_id = p_legal_doc_type_id;
    }

    public String getLegal_doc_desc() {
        return legal_doc_desc;
    }

    public void setLegal_doc_desc(String legal_doc_desc) {
        this.legal_doc_desc = legal_doc_desc;
    }

    public String getOrigin_file_name() {
        return origin_file_name;
    }

    public void setOrigin_file_name(String origin_file_name) {
        this.origin_file_name = origin_file_name;
    }

    public String getFile_folder() {
        return file_folder;
    }

    public void setFile_folder(String file_folder) {
        this.file_folder = file_folder;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
    
    public HashMap getRow(){
        HashMap data = new HashMap<String,String>();
        Field[] allFields = this.getClass().getDeclaredFields();
        for (int i = 0; i < allFields.length; i++) {
            try {
                data.put(allFields[i].getName(),allFields[i].get(this));
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CustLegalDoc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CustLegalDoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }
}