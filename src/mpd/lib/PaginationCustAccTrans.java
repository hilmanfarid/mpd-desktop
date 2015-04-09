/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpd.lib;

import java.util.List;
import mpd.dao.daoCustAccTrans;
import mpd.model.CustAccTrans;

/**
 *
 * @author Admin
 */
public class PaginationCustAccTrans {
    private daoCustAccTrans dao;
    private int page_now;
    public int total_data;
    public PaginationCustAccTrans(daoCustAccTrans thisdao){
        this.page_now=1;
        this.dao = thisdao;
        this.total_data = dao.getCount();
    }
    public List<CustAccTrans> nextPage(){
        if(page_now >= Math.ceil((float)total_data/(float)this.dao.size_per_page)){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now+1;
        List<CustAccTrans> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_acc_dtl_trans_id", "DESC");
        //List<CustAccTrans> rs_vat_setllement = this.dao.getALL(0, 15, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustAccTrans> lastPage(){
        if(page_now >= Math.ceil((float)total_data/(float)this.dao.size_per_page)){
            System.out.println(page_now);
            return null;
        }
        page_now=(int)Math.ceil((float)total_data/getDao().size_per_page);
        List<CustAccTrans> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_acc_dtl_trans_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustAccTrans> prevPage(){
        if(page_now <= 1){
            System.out.println(page_now);
            return null;
        }
        page_now=page_now-1;
        List<CustAccTrans> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_acc_dtl_trans_id", "DESC");
        //List<CustAccTrans> rs_vat_setllement = this.dao.getALL(0, 15, "t_cust_order_legal_doc_id", "DESC");
        return rs_vat_setllement;
    }
    public List<CustAccTrans> firstPage(){
        if(page_now <= 1){
            System.out.println(page_now);
            return null;
        }
        page_now=1;
        List<CustAccTrans> rs_vat_setllement = this.dao.getALL(this.page_now, this.dao.size_per_page, "t_cust_acc_dtl_trans_id", "DESC");
        return rs_vat_setllement;
    }
    public daoCustAccTrans getDao(){
        return this.dao;
    }
    public int getCurrentPage(){
        return this.page_now;
    }
}
